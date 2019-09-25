package com.orangehrm.practice;

import static io.restassured.RestAssured.baseURI;
import static io.restassured.RestAssured.given;
import static org.hamcrest.Matchers.equalTo;

import org.junit.Test;

import io.restassured.response.Response;

public class DeleteRequest {
	
	
	@Test 
	public void deleteStudent() {
		baseURI="http://pure-ravine-92491.herokuapp.com/syntax";
		Response rsp=
				given().
					pathParam("studentId", "354").
				when().
					delete("/api/deleteStudentProfile/{studentId}");
	
		
		rsp.then().assertThat().statusCode(200);
		rsp.prettyPrint();

}
}