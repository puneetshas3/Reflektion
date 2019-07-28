package application.reflektion;

import org.hamcrest.Matchers;
import org.testng.Assert;
import org.testng.Reporter;

import io.restassured.http.ContentType;
import io.restassured.module.jsv.JsonSchemaValidator;
import io.restassured.response.Response;
import io.restassured.response.ValidatableResponse;



/**
 * ApiAutomation implements all the test case actions and validates is the results are expected.
 *This class inherits BaseClass where all the request URLs are defined.
 */
public class ApiAutomation extends BaseClass
{
  
	/**
	 * getRequest validates the get request by validating the status code,Json schema and size of result.
	 */
	public void getRequest() {
		Response response = httpRequest.get("/posts");
		Assert.assertEquals(response.getStatusCode(), 200);
		response.then().assertThat().body(JsonSchemaValidator.matchesJsonSchemaInClasspath("././resources/get.json"));
		response.then().assertThat().body("size()", Matchers.greaterThanOrEqualTo(100));
    }
	
	
	/**
	 * geParticularRequest validates only single results are returned when particular id is sent in request.
	 * Request is validated against status code. json schema and result count is 1.
	 */
	public void geParticularRequest() {
		Response response = httpRequest.get("/posts/1");
		Assert.assertEquals(response.getStatusCode(), 200);
		Reporter.log(response.asString());
		response.then().assertThat().body(JsonSchemaValidator.matchesJsonSchemaInClasspath("././resources/getParticular.json"));
		Assert.assertEquals(response.body().jsonPath().getInt("id"), 1);
	}
	

	/**
	 * notFoundRequest validates specified page is not found.
	 * Request is validated against status code 404.
	 * Logs the response for verification
	 */
	public void notFoundRequest() {
		Response response = httpRequest.get("/invalidposts");
		Assert.assertEquals(response.getStatusCode(), 404);
		Reporter.log("Logs are printed on the console");
		System.out.println("Logs for Page not found error - Test case invalidRequestTest");
		System.out.println(response.then().log().all());
	}
	
	

	/**
	 * postRequest validates post by sending body string in request.
	 * Response contains new id generated out of post.
	 * Validation included are status code check, Json schema.
	 */
	public void postRequest() {
		String bodyString="{\"title\": \"foo\",\"body\": \"bar\",\"userId\": 1}";
		Response response = httpRequest.contentType(ContentType.JSON).body(bodyString).post("/posts");
		response.then().assertThat().body(JsonSchemaValidator.matchesJsonSchemaInClasspath("././resources/postSchema.json"));
		Assert.assertEquals(response.getStatusCode(), 201);
		int id = response.jsonPath().get("id");
		Reporter.log("response from postRequest "+response.asString());
		Reporter.log("Generated id from post is "+id);
		
	}

	/**
	 * putService validates put request. It sends the request in body as json
	 * response is validated against each individual attributes, Json schema and status code.
	 */
	public void putService() {
		String requestBody = "{\r\n" + 
				"\"id\": 1,\r\n" + 
				"\"title\": \"abc\",\r\n" + 
				"\"body\": \"xyz\",\r\n" + 
				"\"userId\": 1\r\n" + 
				"}";
		Response response = httpRequest.contentType(ContentType.JSON).body(requestBody).put("/posts/1");
		response.then().assertThat().body(JsonSchemaValidator.matchesJsonSchemaInClasspath("././resources/put.json"));
		Reporter.log("response from putService "+response.asString());
		Assert.assertEquals(response.getStatusCode(), 200);
		Assert.assertEquals(response.jsonPath().getInt("id"), 1);
		Assert.assertEquals(response.jsonPath().getString("title"),"abc");
		Assert.assertEquals(response.jsonPath().getString("body"), "xyz");
		Assert.assertEquals(response.jsonPath().getInt("userId"), 1);
	}
	
	
	/**
	 * deleteService validates delete request.
	 * status code is validated and the response will be null
	 */
	public void deleteService() {
		Response response = httpRequest.delete("/posts/1");
		Assert.assertEquals(response.getStatusCode(), 200);
		
	}
	
	
	
}
