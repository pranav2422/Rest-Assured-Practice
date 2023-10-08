package package1;

import static io.restassured.RestAssured.given;

import java.util.Map;

import io.restassured.response.Response;

public class cookiesandheader {
   
//		@Test
//		void testcookies() {
//		
//			given()
//			
//			.when()
//			   .get("https://www.google.com")
//			   
//			.then()
//			  .log().cookies();
//	}
		
		void testcookiesqq() {
			
			Response res = given()
			
			.when()
			   .get("https://www.google.com");
			
			String cokkinm = res.getCookie("AEC");
			System.out.println(cokkinm);
			
			// to get all cookies
			  Map<String,String> aa = res.getCookies();
			
	System.out.println(aa.keySet());
	for(String k:aa.keySet()){
		String val = res.getCookie(k);
		System.out.println(val);
	}
}
}
