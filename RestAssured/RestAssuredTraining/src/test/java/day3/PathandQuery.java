package day3;
import org.json.JSONObject;
import org.json.JSONTokener;
import org.testng.annotations.Test;

import groovy.util.logging.Log;

import static io.restassured.RestAssured.*;
import static io.restassured.matcher.RestAssuredMatchers.*;
import static org.hamcrest.Matchers.*;

public class PathandQuery {
//	https://reqres.in/api/users?page=2&id=5
//	https://reqres.in/-> This is called domain, Users-> Path, page=2&id=5 -> Query parameter
	@Test
	void verifyPathAndQueryParamters() {
		given()
			.pathParam("mypath", "users")
			.queryParam("page", 2)
			.queryParam("id", 5)
		
		.when()
			.get("https://reqres.in/api/{mypath}")
		.then()
			.statusCode(200)
			.log().all();	
	}
	

}
