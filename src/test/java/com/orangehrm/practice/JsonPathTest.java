package com.orangehrm.practice;

import static io.restassured.RestAssured.baseURI;
import static io.restassured.RestAssured.given;
import static org.hamcrest.Matchers.equalTo;

import java.util.List;
import java.util.Map;

import org.junit.Test;

import io.restassured.path.json.JsonPath;
import io.restassured.response.Response;

public class JsonPathTest {
	
/*
 * Retrive value of specific key from JSON object
 * 
 */
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