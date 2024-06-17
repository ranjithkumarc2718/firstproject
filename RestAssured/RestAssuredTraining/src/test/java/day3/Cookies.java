package day3;


import org.testng.annotations.Test;

import groovy.util.logging.Log;
import io.restassured.response.Response;

import static io.restassured.RestAssured.*;
import static io.restassured.matcher.RestAssuredMatchers.*;
import static org.hamcrest.Matchers.*;

import java.util.Map;

public class Cookies {
	
//	@Test
	void verifycookies() {
		given()
			
		
		.when()
			.get("https://www.google.co.in/webhp?emsg=NCSR&noj=1&ei=NZjlT_KMMoHS-gaWr7GhCg")
		.then()
			.cookie("AEC","AUEFqZcXAgqJ05UQnm5rrKDn4gFemeRT3aG4dPcBjEs6crZC4BOlUnJhAw")//cookie will not match , it will generate different every time
			
		.log().all();	
	}
	
	@Test
	void verifyAllCookies() {
	Response res=given()
			
		
		.when()
			.get("https://www.google.co.in/webhp?emsg=NCSR&noj=1&ei=NZjlT_KMMoHS-gaWr7GhCg");
	
			String cookie =res.getCookie("AEC");
			System.out.println("Cookie name: "+cookie);
	
			Map<String, String>cookies_value=res.getCookies();
			
			System.out.println("All cookies : "+cookies_value.keySet());
			
			for(String k:cookies_value.keySet()) {
				String cookie_vaule =res.getCookie(k);
				System.out.println(k+"  "+cookie_vaule);
			}
		
	}

}
