package com.orangehrm.practice;

import org.junit.Assert;
import org.junit.Test;

import static io.restassured.RestAssured.*;
import io.restassured.response.Response;
import static org.hamcrest.Matchers.*;

public class HamcrestTest {
	
	/*
	 * Retrive quote of specific character and verify that response code is 200 and response contains
	 *  "Power resides where men believe it resides"
	 * 
	 */
	//1 way using JUnit assertions
//	@Test
	public void verifyResponse() {
		
		baseURI="https://got-quotes.herokuapp.com";
		Response rsp =
				given().
				queryParam("char", "varys").when().get("/quotes");
		int code=rsp.statusCode();
		Assert.assertEquals(200, code);
		String responseBody=rsp.asString();
		System.out.println(responseBody);
		
	//2	way to complete request * assertion
		
	}
	//@Test
	public void verifyResponse2() {
		
		baseURI="https://got-quotes.herokuapp.com";
		given().
			queryParam("char", "varys").
		when().
			get("/quotes").
		then().
			assertThat().statusCode(200).
		and().
			assertThat().body("character", equalTo("Varys"));		
		
		
	}
	//3 way
	//@Test
	public void verifyResponse3() {
		
		baseURI="https://got-quotes.herokuapp.com";
		Response rsp1=
		given().
			queryParam("char", "varys").
		when().
			get("/quotes");
		rsp1.then().
			assertThat().statusCode(200).
		and().
			assertThat().body("character", equalTo("Varys"));
	
	

}
	//retrive student with id 123 @verify that response status code is 200 
	//and firstName of s student is "Vladimir".
	
	
	@Test 
	public void verifyStudent() {
		baseURI="http://pure-ravine-92491.herokuapp.com/syntax";
		Response rsp=
				given().
					pathParam("studentId", "123").
				when().
					get("api/getStudentProfile/{studentId}");
	
		
		rsp.then().assertThat().statusCode(200).and().assertThat().body("firstName", equalTo("Vladimir"));
		rsp.prettyPrint();
		
	}
	
}