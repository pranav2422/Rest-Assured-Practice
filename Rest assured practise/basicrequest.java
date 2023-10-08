package package1;

import static io.restassured.RestAssured.*;
import static io.restassured.matcher.RestAssuredMatchers.*;
import static org.hamcrest.Matchers.*;

import java.util.HashMap;

import org.testng.annotations.Test;

public class basicrequest {
	
	@Test(priority = 1)
	void getuser() {
		
		given()
		
		.when()
		    .get("https://reqres.in/api/users?page=2")
		
		.then()
		     .statusCode(200)
		     .body("page", equalTo(2))
		     .log().all();
	}
//	
//	@Test
//    void postrequesr() {
//    	
//    	HashMap hm = new HashMap();
//    	hm.put("pranav", "op");
//    	hm.put("Disale", "ok");
//    	
//    	given()
//    	    .contentType("application/json")
//    	    .body(hm)
//    	    
//        .when()
//            .post("https://reqres.in/api/users")
//            
//        .then()
//            .statusCode(201)
//            .and().log().all();
//	
//}
	
	int id;
	
	@Test(priority = 2)
	void postuser() {
		
		HashMap hm = new HashMap();
    	hm.put("pranav", "op");
    	hm.put("Disale", "ok");
   	
   	   id= given()
   	        .contentType("application/json")
    	    .body(hm)
    	    
        .when()
            .post("https://reqres.in/api/users")
            .jsonPath().getInt("id");
   	   System.out.println("user created with id :"+ id);
  
		
	}
	
	@Test(priority = 3,dependsOnMethods = {"postuser"})
	void updateuser() {
		
		HashMap hm = new HashMap();
    	hm.put("pranav", "op");
    	hm.put("Disale", "ok");
   	
   	    given()
   	        .contentType("application/json")
    	    .body(hm)
    	    
        .when()
            .post("https://reqres.in/api/users"+id)
           
            
        .then()
            .statusCode(201)
            .log().all();
   	 System.out.println("user updated with id :"+ id);
		
	}
	
	
	@Test(priority = 4)
	void deleteuser() {
		
		when()
		  .delete("https://reqres.in/api/users/"+id)
		  
		  .then()
		     .statusCode(204)
		     .log().all();
		System.out.println("user deleted with id :"+ id);
	}

}
