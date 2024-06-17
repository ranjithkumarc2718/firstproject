package day3;


import org.testng.annotations.Test;

import groovy.util.logging.Log;
import io.restassured.response.Response;

import static io.restassured.RestAssured.*;
import static io.restassured.matcher.RestAssuredMatchers.*;
import static org.hamcrest.Matchers.*;

import java.util.Map;

public class Headers {
	
	@Test
	void verifyHeaders() {
		given()
			
		
		.when()
			.get("https://www.google.co.in/webhp?emsg=NCSR&noj=1&ei=NZjlT_KMMoHS-gaWr7GhCg")
		.then()
//			.cookie("AEC","AUEFqZcXAgqJ05UQnm5rrKDn4gFemeRT3aG4dPcBjEs6crZC4BOlUnJhAw")//cookie will not match , it will generate different every time
//		.log().headers()// to print all headers
		.log().body();
//		.log().all();	
	}
	
	

}
