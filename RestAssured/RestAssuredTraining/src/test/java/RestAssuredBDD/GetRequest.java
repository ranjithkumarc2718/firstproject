package RestAssuredBDD;

import org.testng.annotations.Test;
import static io.restassured.RestAssured.*;
import static org.hamcrest.Matchers.*;

public class GetRequest {
	
	@Test
	public void getWeatherDetails() {
		given()
		.when().get("https://weather.visualcrossing.com/VisualCrossingWebServices/rest/services/timeline/Salem?unitGroup=metric&key=8AA9WFAU535SMPKVQ2GLKDDBC&contentType=json")
		.then().statusCode(200)
		.assertThat().body("address", equalToIgnoringCase("Salem"))
		.contentType("application/json")
		.log().all();
		
	}
	
	
}
