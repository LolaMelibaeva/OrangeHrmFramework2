package com.orangehrm.practice;

import org.junit.Test;
import org.junit.*;

import io.restassured.RestAssured;
import io.restassured.response.Response;


public class APIGetDemo {
	//@Test
	public void getWeather() {
		
		//get method will give you back response
		
		Response response=RestAssured.when().get("http://restapi.demoqa.com/utilities/weather/city/Fairfax");
		response.prettyPrint();
		int code=response.getStatusCode();
		System.out.println("Status code "+code);
		
		
		
		
	}
	
	//get status and print response from country api
	@Test
	public void getCountry() {
		
		//get method will give you back response
		
		Response response=RestAssured.when().get("http://restcountries.eu/rest/v1/name/Spain");
		//response.prettyPrint();
		int code=response.getStatusCode();
		System.out.println("Status code "+code);
		Assert.assertEquals(200, code);
		//retrieve body as String
		String body = response.asString();
		System.out.print(body);
		Assert.assertTrue(body.contains("Madrid"));
		
		//retrieve body header date as String
		System.out.println();
		String header= response.getHeader("Date");
		System.out.println(header);
		
		
		
		
	}

}
