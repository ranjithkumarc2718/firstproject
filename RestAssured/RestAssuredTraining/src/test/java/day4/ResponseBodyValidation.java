package day4;


import org.testng.Assert;
import org.testng.annotations.Test;

import groovy.util.logging.Log;
import io.restassured.response.Response;

import static io.restassured.RestAssured.*;
import static io.restassured.matcher.RestAssuredMatchers.*;
import static org.hamcrest.Matchers.*;

public class ResponseBodyValidation {

	
	@Test
	void verifyResponseBody() {
	Response res=	given()
			
		.when()
			.get("https://reqres.in/api/users");
		
		Assert.assertEquals(res.getStatusCode(), 200);
		Assert.assertEquals(res.header("Content-Type"), "application/json; charset=utf-8");
	}
	


}
