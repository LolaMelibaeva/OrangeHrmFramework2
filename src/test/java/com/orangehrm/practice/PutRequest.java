package com.orangehrm.practice;

import static io.restassured.RestAssured.given;

import java.util.LinkedHashMap;
import java.util.Map;

import org.junit.Test;

import io.restassured.RestAssured;
import io.restassured.http.ContentType;
import io.restassured.response.Response;

public class PutRequest {
	
	@Test
	
	public void putRequest() {

Map <String, Object> map=new LinkedHashMap<>();
		map.put("id", "354");
		map.put("firstName","Francesco");
		map.put("lastName","Sala");
		map.put("age","43");
		map.put("batch","5");		
		map.put("batchEndDate","2020-03-01");
		map.put("batchStartDate", "2019-09-15");
		map.put("attendanceNature","NJ");
		map.put("course","Selenium");	
		map.put("city", "Baltimore");
		map.put("state","MD");
		map.put("streetAddress","123 Test");
		map.put("zipCode","21704");
		RestAssured.baseURI = "http://pure-ravine-92491.herokuapp.com/syntax";
		
		Response rsp=
		given().
			accept(ContentType.JSON).
			header("Content-Type", "application/json").
			body(map).
		when().
			put("/api/updateStudentProfile");
		
		rsp.then().statusCode(200);


	}
	
}
