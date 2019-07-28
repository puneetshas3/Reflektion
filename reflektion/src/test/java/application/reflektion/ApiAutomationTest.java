package application.reflektion;

import org.testng.annotations.BeforeTest;
import org.testng.annotations.Test;


/**
 * ApiAutomationTest is the place where all the test cases are called.
 * Each method with @Test defines test case.
 */

public class ApiAutomationTest 
{
	ApiAutomation api;
	
	/**
	 * beforeTest initializes the ApiAutomation class where all the implementation of the test cases are defined.
	 */
	@BeforeTest
	public void beforeTest() {
		api = new ApiAutomation();
		api.initialize();
		
	}
 
	
	/**
	 * getRequestTest validates the get request.
	 */
	
	@Test
	public void getRequestTest() {
		api.getRequest();
	}
	
	/**
	 * geParticularRequestTest validates the get request by specifying the particular ID.
	 */
	@Test
	public void geParticularRequestTest() {
		api.geParticularRequest();
	}
	
	/**
	 * invalidRequestTest validates the page not found 404 error.
	 */
	@Test
	public void invalidRequestTest() {
		api.notFoundRequest();
	}
	
	/**
	 * postRequestTest validates the post request by sending string in the body.
	 */
	@Test
	public void postRequestTest() {
		api.postRequest();
	}
	
	/**
	 * putRequestTest validates the put request by updating the current record.
	 */
	@Test
	public void putRequestTest() {
		api.putService();
	}
	
	/**
	 * deleteRequestTest validates the delete service.
	 */
	@Test
	public void deleteRequestTest() {
		api.deleteService();
	}
	
	
	
}
