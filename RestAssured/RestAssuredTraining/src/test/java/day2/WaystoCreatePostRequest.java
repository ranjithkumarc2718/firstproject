package day2;

import org.json.JSONObject;
import org.json.JSONTokener;
import org.testng.annotations.Test;

import groovy.util.logging.Log;

import static io.restassured.RestAssured.*;
import static io.restassured.matcher.RestAssuredMatchers.*;
import static org.hamcrest.Matchers.*;

import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.util.*;

public class WaystoCreatePostRequest {
	int id;
//	Using Hashmap
//	@Test
	void testPostRequest() {
		
		HashMap data =new HashMap();
		data.put("name","Ranjith");
		data.put("job","Teacher");
		
		
		given()
			.contentType("application/json")
			.body(data)
		.when()
			.post("https://reqres.in/api/users")
			
		.then()
			.statusCode(201)
			.body("name", equalTo("Ranjith"))
			.body("job", equalTo("Teacher"))
			.header("Content-type","application/json; charset=utf-8")
			.log().all();
	}

	@Test(priority=1)
	void deleteRquest() {
		given()
		.when()
			.delete("https://reqres.in/api/users/4")
		.then()
			.statusCode(204)
			.log().all();
	}
	//Using Json object
//	@Test
	void testPostusingJson() {
		
		JSONObject data =new JSONObject();
		data.put("name","Ranjith");
		data.put("job","Engineer");		
		
		given()
			.contentType("application/json")
			.body(data.toString())// required for  JSON request
		.when()
			.post("https://reqres.in/api/users")
			
		.then()
			.statusCode(201)
			.body("name", equalTo("Ranjith"))
			.body("job", equalTo("Engineer"))
			.header("Content-type","application/json; charset=utf-8")
			.log().all();
	}

//	To get the data using Post Old Java Object using encapsulation(Getter qand setter method)
//	@Test 
	void testPostusingPOJO() {
		PojoClass data = new PojoClass();	
		data.setName("Ranjith");
		data.setJob("Engineer");
		
		given()
			.contentType("application/json")
			.body(data)
		.when()
			.post("https://reqres.in/api/users")
			
		.then()
			.statusCode(201)
			.body("name", equalTo("Ranjith"))
			.body("job", equalTo("Engineer"))
			.header("Content-type","application/json; charset=utf-8")
			.log().all();
	}
	
	//To get the data from external data file
	@Test
	void testPostusingExternalJsonFile() throws FileNotFoundException {
			
		File f =new File("C:\\Users\\Ranjith\\eclipse-workspace\\RestAssured\\RestAssuredTraining\\body.json");
		FileReader fr = new FileReader(f);
		JSONTokener jt = new JSONTokener(fr);
		JSONObject data = new JSONObject(jt);
		
		given()
			.contentType("application/json")
			.body(data.toString())
		.when()
			.post("https://reqres.in/api/users")
			
		.then()
			.statusCode(201)
			.body("name", equalTo("Ranjith"))
			.body("job", equalTo("leader"))
			.header("Content-type","application/json; charset=utf-8")
			.log().all();
	}
}
