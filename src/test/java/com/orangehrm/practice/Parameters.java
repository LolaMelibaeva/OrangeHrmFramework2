package com.orangehrm.practice;

import static io.restassured.RestAssured.baseURI;
import static io.restassured.RestAssured.given;
import static org.hamcrest.Matchers.*;

import org.junit.Assert;
import org.junit.Test;


import io.restassured.response.Response;

public class Parameters {
	
	//@Test
	public void queryParameters() {
		
		baseURI="https://reqres.in/";
		Response resp=
				given().
						queryParam("page", "2").
				
				when().
						get("/api/users");
		Assert.assertEquals(200, resp.getStatusCode());
		
		Assert.assertTrue(resp.asString().contains("Tracey"));
	}

	//@Test
	public void PathParameters() {
		
		baseURI="https://reqres.in";
		
		
		given().pathParam("id", "2").
		when().get("/api/users/{id}").
		then().statusCode(200);
		
		
	}
	
	//@Test
		public void queryParameterTest() {
			
			baseURI="https://got-quotes.herokuapp.com";
			
					given().
							queryParam("char", "tyrion").					
							
					when().
							get("/quotes").
							prettyPrint();
		}
	
	
	//@Test
		public void PathParametersTest() {
			
			baseURI="https://pure-ravine-92491.herokuapp.com/syntax";
			
			
			given().pathParam("studentId", "86").
			when().get("/api/getStudentProfile/{studentId}").
			prettyPrint();
			
			
		}
		@Test
		public void getWithAssertion1() {
		baseURI="https://pure-ravine-92491.herokuapp.com/syntax";
		given().
		pathParam("studentId", "81").
		when().get("/api/getStudentProfile/{studentId}").
		then().assertThat().
		body("firstName", equalTo("James"));
		}

}
