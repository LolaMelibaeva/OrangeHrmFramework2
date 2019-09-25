package com.orangehrm.practice;

import static io.restassured.RestAssured.*;
import static org.hamcrest.Matchers.equalTo;

import org.junit.Test;

import io.restassured.RestAssured;
import io.restassured.response.Response;

public class HeaderTest {
	
	/*
	 * When I send GET request to the "/api/getAllStudentProfiles"
	 * Then repsonse status code is200
	 * And response header "Content-Type" contains "application/json"
	 * 
	 * 
	 */

	@Test
	public void getAllStduents() {
		baseURI = "http://pure-ravine-92491.herokuapp.com/syntax";
		Response rsp = given().when().get("api/getAllStudentProfiles");
		
		rsp.then().assertThat().statusCode(200).and().header("Content-Type", equalTo("application/json;charset=UTF-8"));
		

	}

}