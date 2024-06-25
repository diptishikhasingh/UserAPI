package body;

import java.util.Map;

import payloads.UserPOJO;
import utils.ExcelReader;
import utils.ReuseUtils;

public class RequestBody extends ReuseUtils {

	//post body
	public static UserPOJO postBody(String ScenarioName,String SheetName) throws Exception {
				
		Map<String,String>excelDataMap;
		excelDataMap=ExcelReader.getData(ScenarioName,SheetName);
		
		userPOJO.setUser_first_name(excelDataMap.get("user_first_name"));
		userPOJO.setUser_last_name(excelDataMap.get("user_last_name"));
		userPOJO.setUser_contact_number(excelDataMap.get("user_contact_number"));
		userPOJO.setUser_email_id(excelDataMap.get("user_email_id"));
		
		userPOJO.getUserAddress();

		userAddressPOJO.setPlotNumber(excelDataMap.get("plotNumber"));
		userAddressPOJO.setState(excelDataMap.get("state"));
		userAddressPOJO.setStreet(excelDataMap.get("street"));
		userAddressPOJO.setCountry(excelDataMap.get("country"));
		userAddressPOJO.setZipCode(excelDataMap.get("zipCode"));

		userPOJO.setUserAddress(userAddressPOJO);
				
		return userPOJO;
			
		}
}
