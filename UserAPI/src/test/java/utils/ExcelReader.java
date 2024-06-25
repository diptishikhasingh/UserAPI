package utils;

import java.io.File;
import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.IOException;
import java.util.HashMap;
import java.util.Map;
import java.util.ResourceBundle;
import org.apache.poi.ss.usermodel.CellStyle;
import org.apache.poi.ss.usermodel.CellType;
import org.apache.poi.ss.usermodel.DataFormatter;
import org.apache.poi.ss.usermodel.Row;
import org.apache.poi.xssf.usermodel.XSSFCell;
import org.apache.poi.xssf.usermodel.XSSFRow;
import org.apache.poi.xssf.usermodel.XSSFSheet;
import org.apache.poi.xssf.usermodel.XSSFWorkbook;

public class ExcelReader {

	public static ResourceBundle Config = ResourceBundle.getBundle("config");
    public static FileInputStream fi;
    public FileOutputStream fo;
    public static XSSFWorkbook workbook;
    public static XSSFSheet sheet;
    public XSSFRow row;
    public static XSSFCell cell;
    public CellStyle style;
    public File jsonFile;
    String path;
 
    public ExcelReader(String path)
    {
    this.path=path;
    }
    
    public File getJSONFile (String jsonPath)
    
    {
    jsonFile= new File(jsonPath);
    return jsonFile;
    }

    // data driven through feature file
    private static int getDataRow(String dataKey, int dataColumn) {
        int rowCount = sheet.getLastRowNum();
        for (int row = 0; row <= rowCount; row++) {
            if (ExcelReader.getCellData(row, dataColumn).equalsIgnoreCase(dataKey)) {
                return row;
            }
        }
        return 0;
    }
    
    private static String getCellData(int rowNumb, int colNumb) {
        cell = sheet.getRow(rowNumb).getCell(colNumb);
        if (cell.getCellType() == CellType.NUMERIC) {
            cell.setCellType(CellType.STRING);
        }
        String cellData = cell.getStringCellValue();
        return cellData;
    }

//    public String getCellData(String sheetName, int rownum, int colnum) throws IOException {
//		fi = new FileInputStream(path);
//		workbook = new XSSFWorkbook(fi);
//		sheet = workbook.getSheet(sheetName);
//		row = sheet.getRow(rownum);
//		cell = row.getCell(colnum);
//
//		DataFormatter formatter = new DataFormatter();
//		String data;
//		try {
//			data = formatter.formatCellValue(cell); // Returns the formatted value of a cell as a String regardless of
//													// the cell type.
//		} catch (Exception e) {
//			data = "";
//		}
//		workbook.close();
//		fi.close();
//		return data;
//	}
    
    public static Map<String, String> getData(String dataKey, String sheetName) throws Exception {
        
    	Map<String, String> dataMap = new HashMap<String, String>();
    	// Accessing xlpath from config.properties
        fi = new FileInputStream(Config.getString("xlpath"));
        workbook = new XSSFWorkbook(fi);
        sheet = workbook.getSheet(sheetName);
        int dataRow = getDataRow(dataKey.trim(), 0);
        
        if (dataRow == 0) {
            throw new Exception("NO DATA FOUND for dataKey: " + dataKey);
        }
        int columnCount = sheet.getRow(dataRow).getLastCellNum();
        for (int i = 0; i < columnCount; i++) 
        {
            cell = sheet.getRow(dataRow).getCell(i);
            String cellData = null;
            if (cell != null) 
            {
                if (cell.getCellType() == CellType.NUMERIC) 
                {
                    cell.setCellType(CellType.STRING);
                }
                cellData = cell.getStringCellValue();
            }
            dataMap.put(sheet.getRow(0).getCell(i).getStringCellValue(), cellData);
        }
        return dataMap;
    }
}
