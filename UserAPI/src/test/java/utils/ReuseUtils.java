package utils;

import java.io.File;
import java.util.ResourceBundle;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import io.restassured.response.Response;
import payloads.UserPOJO;
import payloads.UserAddressPOJO;


public class ReuseUtils {

	public static Response response;
	public static ResourceBundle Config=ResourceBundle.getBundle("config");
	public static Logger log = LogManager.getLogger();
	public static ExcelReader er=new ExcelReader(Config.getString("xlpath"));
	public static XLUtils xlutils=new XLUtils(Config.getString("xlpath"));
	
	//schema
	
	public static File PostJson=xlutils.getJSONFile(Config.getString("PostJson"));
	public static File PutJson=xlutils.getJSONFile(Config.getString("PutJson"));
	
	//Payload object

	public static UserPOJO userPOJO=new UserPOJO();
	public static UserAddressPOJO userAddressPOJO = new UserAddressPOJO();
	
}
