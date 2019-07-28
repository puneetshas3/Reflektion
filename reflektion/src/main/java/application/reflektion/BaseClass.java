package application.reflektion;

import io.restassured.RestAssured;
import io.restassured.specification.RequestSpecification;

/**
 * BaseClass contains the base URL
 * content type is set in this class
 */

public class BaseClass {
	public static RequestSpecification httpRequest;
	
	/**
	 * initialize initializes the base URL and sets the content type
	 */
	public void initialize(){
		RestAssured.baseURI = "https://jsonplaceholder.typicode.com";
		httpRequest = RestAssured.given().contentType("application/json,charset=UTF-8");
	}
	
	
	
	
}
