package com.orangehrm.practice;

import static io.restassured.RestAssured.baseURI;
import static io.restassured.RestAssured.given;
import static org.hamcrest.Matchers.equalTo;

import java.util.LinkedHashMap;
import java.util.List;
import java.util.Map;

import org.junit.Test;

import io.restassured.RestAssured;
import io.restassured.http.ContentType;
import io.restassured.path.json.JsonPath;
import io.restassured.response.Response;

public class PostRequest {
	
	@Test
	
	public void crateStudent() {
		
		Map <String, Object> map=new LinkedHashMap<>();
		
		map.put("firstName","Francesca");
		map.put("lastName","Sala");
		map.put("age","33");
		map.put("batch","5");		
		map.put("batchEndDate","2020-03-01");
		map.put("batchStartDate", "2019-09-15");
		map.put("attendanceNature","online");
		map.put("course","Selenium");	
		map.put("city", "Frederick");
		map.put("state","MD");
		map.put("streetAddress","33 Main Street");
		map.put("zipCode","21704");
		
		RestAssured.baseURI = "http://pure-ravine-92491.herokuapp.com/syntax";
		
		Response rsp=
		given().
			accept(ContentType.JSON).
			header("Content-Type", "application/json").
			body(map).
		when().
			post("/api/createStudentProfile");
		
		rsp.then().assertThat().statusCode(201);
		
		rsp.prettyPrint();
		
		JsonPath jpath=rsp.jsonPath();
		int studentId=jpath.get("id");
		System.out.println(studentId);
		
		Map<String, Object>responseMap=rsp.as(Map.class);
		System.out.println(responseMap);
		//automate put and delete request
	}
		 @Test 
		public void test1() {
			baseURI="http://pure-ravine-92491.herokuapp.com/syntax";
			Response rsp=
					given().
						pathParam("studentId", "123").
					when().
						get("api/getStudentProfile/{studentId}");
		
			
			rsp.then().assertThat().statusCode(200).and().assertThat().body("firstName", equalTo("Vladimir"));
			rsp.prettyPrint();
			
			JsonPath jPath=rsp.jsonPath();
			String fname=jPath.get("firstName");
			System.out.println(fname);
			
			String lname=jPath.get("lastName");
			System.out.println(lname);
			
			
		}
		@Test 
		public void getAllStduents() {
			baseURI="http://pure-ravine-92491.herokuapp.com/syntax";
			Response rsp=
					given().					
					when().
						get("api/getAllStudentProfiles");
			
		
		JsonPath jPath=rsp.jsonPath();
		String lName=jPath.get("lastName[2]");
		System.out.println(lName);
		 List<String> fName= jPath.get("firstName");
		 for (String name: fName) {
			 System.out.println(name);
		 }
		 
	 Map<String, String> allStudents=(Map<String, String>) rsp.jsonPath();
	for(Map.Entry<String, String> names: allStudents.entrySet()) {
		System.out.println(names.getKey()+":"+names.getValue());		
		}
		 
		 //Retrive all the students
		 rsp.prettyPrint();
		 rsp.then().assertThat().statusCode(200);
		 
		 //* and retrieve first name of a second student
		 
		 String firstName2=jPath.get("firstName[1]");
		 System.out.println("2nd student's name: "+firstName2);
		 
		 List<String> lname= jPath.get("lastName");
		 for (String lastName: lname) {
			 System.out.println(lastName);
		 }
		 
		

	 
		

}
}