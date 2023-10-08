package package1;

import static io.restassured.RestAssured.*;
import static io.restassured.matcher.RestAssuredMatchers.*;
import static org.hamcrest.Matchers.*;
import org.testng.annotations.Test;


//https://reqres.in/api/users?page=2&id=5
		// https://reqres.in   == domain name
		// /api/users == path
		// page=2 == after ? is query parameter

public class pathandqueryparameter {
	
	@Test
	void testqueryandpathpara(){
		
		given()
		   .pathParam("mypath", "user") // for path we can customise the name
		   .queryParam("page", 2)  // for query we need to give exact name of parameter
		   .queryParam("id", 5)
		.when()
		   .get("https://reqres.in/api/{mypath}") // query parameter no need to mention it go through req
		.then()
		   .statusCode(200)
		   .log().all();
	}

}
