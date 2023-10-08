package package1;

import static io.restassured.RestAssured.given;
import static org.hamcrest.Matchers.equalTo;

import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileReader;

import org.json.JSONObject;
import org.json.JSONTokener;
import org.testng.annotations.Test;


public class PostRequestMultWays {
	
	// ways to create post request
	// 1. post request body using hashmap
	// 1. post request body creation using org.jason
	// 1. post request body creation using pojo class
	// 1. post request body jason file data
	
	
	
	// 1. post request body using hashmap
	
//	@Test
//	public void hashmapway() {
//		HashMap h = new HashMap();
//		h.put("id", 0);
//		h.put("title", "Brown");
//		h.put("dueDate", "2023-08-28T13:06:48.34Z");
//		h.put("completed", true);
//		
//		
//		 given()
//	        .contentType("application/json")
// 	        .body(h)
// 	    
//     .when()
//         .post("https://fakerestapi.azurewebsites.net/api/v1/Activities")
//        
//     .then()
//        .statusCode(200)
//        .body("title", equalTo("Brown"))
//        .body("completed", equalTo(true))
//        .log().all();		
//	}



//2. post request body creation using org.jason

	@Test
	public void orgjson() {
		
		JSONObject data = new JSONObject();
		data.put("id", 0);
		data.put("title", "Brown");
		data.put("dueDate", "2023-08-28T13:06:48.34Z");
		data.put("completed", true);
	
		
		 given()
	        .contentType("application/json")
	        .body(data.toString())
	    
  .when()
      .post("https://fakerestapi.azurewebsites.net/api/v1/Activities")
     
  .then()
     .statusCode(200)
     .body("title", equalTo("Brown"))
     .body("completed", equalTo(true))
     .log().all();		
	}

	
	
	//2. post request body creation using external file jsonfile

		@Test
		public void jsonfile() throws FileNotFoundException {
			
			File f = new File(".\\body.json");
			FileReader fr = new FileReader(f); 
			JSONTokener jt = new JSONTokener(fr);
			
			JSONObject data = new JSONObject(jt);
		
			
			 given()
		        .contentType("application/json")
		        .body(data.toString())
		    
	  .when()
	      .post("https://fakerestapi.azurewebsites.net/api/v1/Activities")
	     
	  .then()
	     .statusCode(200)
	     .body("title", equalTo("string"))
	     .body("completed", equalTo(true))
	     .log().all();		
		}
	}
