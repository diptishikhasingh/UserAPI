package method;

import static io.restassured.RestAssured.given;

import io.restassured.http.ContentType;
import io.restassured.response.Response;
import payloads.UserPOJO;
import utils.ReuseUtils;

public class methodRequest extends ReuseUtils{

	//Post Request
		 public static Response postUserRequest(UserPOJO payload) {
		       
		        try {
		            response = given()
		                .contentType(ContentType.JSON)
		                .accept(ContentType.JSON)
		                .body(payload)
		                .log().all()
		            .when()
		                .post(Config.getString("POSTendpoint"));
		        } catch (Exception e) {
		            e.printStackTrace();
		        }
		        return response;
		    }
	
	//Put Request
}
