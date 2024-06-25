package stepDefinitions;

import body.RequestBody;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import io.restassured.RestAssured;
import method.methodRequest;
import utils.ReuseUtils;

public class userSD extends ReuseUtils{
	public static String baseURL;
	public static String Username;
	public static String Password;
	 
	@Given("User sets Basic Authorization")
	public void user_sets_basic_authorization() {	
	    baseURL=Config.getString("baseurl");
	    Username=Config.getString("username");
	    Password=Config.getString("password");
	    
	    RestAssured.baseURI=baseURL;
		RestAssured.authentication=RestAssured.basic(Username,Password);
	    log.info("******************* User sets Basic Auth ********************");
	}
	 
	//GET All Request
	@Given("User creates GET Request")
	public void user_creates_get_request() {
	}

	@When("User sends HTTPS request with valid endpoint")
	public void user_sends_https_request_with_valid_endpoint() {
		
		response=RestAssured.given().when().get(Config.getString("GETALLendpoint"));
	}

	@Then("User receives status {int} OK with response body")
	public void user_receives_status_ok_with_response_body(Integer int1) {
		if(int1==200)
		{
			response.then().assertThat().statusCode(int1);
			
			log.info("The response body is "+response.getBody().asPrettyString());
			log.info("The response time is "+response.getTime());
			log.info("The status code is "+response.getStatusCode());
			log.info("The status line is "+response.getStatusLine());
		}
		else
			log.info("*********** Request Failed **************");
	}

	//POST Request
	@Given("User creates POST request with valid endpoint and request body")
	public void user_creates_post_request_with_valid_endpoint_and_request_body() {	    
	}
	
	@When("User sends HTTPS Request with endpoint from given {string} and  {string}")
	public void user_sends_https_request_with_endpoint_from_given_and(String ScenarioName, String SheetName) {
				
		try {
			userPOJO=RequestBody.postBody(ScenarioName,SheetName);
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}		
		response=methodRequest.postUserRequest(userPOJO);
	}
	

@Then("User receives {int} with response body")
public void user_receives_with_response_body(Integer int1) {
		if(int1==201)
		{
			response.then().assertThat().statusCode(int1);
			log.info("The response body is "+response.getBody().asPrettyString());
			log.info("The response time is "+response.getTime());
			log.info("The status code is "+response.getStatusCode());
			log.info("The status line is "+response.getStatusLine());
		}
		else {
			//log.info(" AssertionError in Create user: " + response.);
			log.info("*********** Request Failed **************");
		}
			
	}
	
	@Given("User creates POST request with valid endpoint and invalid request body")
	public void user_creates_post_request_with_valid_endpoint_and_invalid_request_body() {
	    // Write code here that turns the phrase above into concrete actions
	    throw new io.cucumber.java.PendingException();
	}
	
	@When("User sends HTTPS Request with endpoint from  given {string} and  {string}")
	public void user_sends_https_request_with_endpoint_from_given_and1(String string, String string2) {
	    // Write code here that turns the phrase above into concrete actions
	    throw new io.cucumber.java.PendingException();
	}
	
	@Then("User receives {string} and {string} for corresponding Post Negative Scenarios")
	public void user_receives_and_for_corresponding_post_negative_scenarios(String string, String string2) {
	    // Write code here that turns the phrase above into concrete actions
	    throw new io.cucumber.java.PendingException();
	}
	
	@Given("User creates POST request with valid URL and invalid endpoint")
	public void user_creates_post_request_with_valid_url_and_invalid_endpoint() {
	    // Write code here that turns the phrase above into concrete actions
	    throw new io.cucumber.java.PendingException();
	}
	
	@When("User sends HTTPS Request with invalid endpoint with request body")
	public void user_sends_https_request_with_invalid_endpoint_with_request_body() {
	    // Write code here that turns the phrase above into concrete actions
	    throw new io.cucumber.java.PendingException();
	}
	
	@Then("User should get the  Status Code {int} Not Found")
	public void user_should_get_the_status_code_not_found(Integer int1) {
	    // Write code here that turns the phrase above into concrete actions
	    throw new io.cucumber.java.PendingException();
	}
	
	@Given("User creates POST request with valid endpoint and invalid method")
	public void user_creates_post_request_with_valid_endpoint_and_invalid_method() {
	    // Write code here that turns the phrase above into concrete actions
	    throw new io.cucumber.java.PendingException();
	}
	
	@When("User send invalid HTTPS Request with endpoint and request body")
	public void user_send_invalid_https_request_with_endpoint_and_request_body() {
	    // Write code here that turns the phrase above into concrete actions
	    throw new io.cucumber.java.PendingException();
	}
	
	@Then("User should get the Status Code {int} Method Not Allowed")
	public void user_should_get_the_status_code_method_not_allowed(Integer int1) {
	    // Write code here that turns the phrase above into concrete actions
	    throw new io.cucumber.java.PendingException();
	}

}
