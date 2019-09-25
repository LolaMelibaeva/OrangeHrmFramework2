package com.orangehrm.practice;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;

import org.junit.Test;

public class JdbcDemo {

	
	String dbUrl="jdbc:oracle:thin:@syntaxdatabase.cdjflmucstpo.us-east-1.rds.amazonaws.com:1521:orcl";
	
	String dbUsername="Syntax";
	
	String dbPassword="syntax123";
	
	@Test
	public void  dbConnection() throws SQLException {
		//creating connection
		
		Connection connection=DriverManager.getConnection(dbUrl, dbUsername, dbPassword);
		
		//create a statement
		Statement statement=connection.createStatement();
		
		//execute query and store results from database in ResultSet object
		ResultSet resultSet=statement.executeQuery("select * from (select * from countries order by country_id) where rownum<=2");
		
		//get values from resultSet
//		
//		resultSet.next()		;
//		String columnData=resultSet.getString("Country_Name");
//		System.out.println(columnData);
//		
		
		System.out.println("----Printing values using loop------");
		while(resultSet.next()) {
		String columnData=resultSet.getString("Country_Name");
		String columnData1=resultSet.getString("Country_id");
			System.out.println(columnData1+"-"+columnData);
		}
		//close all db connections
		
		resultSet.close();
		statement.close();
		connection.close();	
		
		
	}
	
	@Test
	public void  dbConnection2() throws SQLException {
		
		Connection connection=DriverManager.getConnection(dbUrl, dbUsername, dbPassword);
		Statement statement=connection.createStatement();
		ResultSet resultSet=statement.executeQuery("Select department_id, department_name  from Departments");
		
		while(resultSet.next()) {
			String columnData=resultSet.getString("Department_id");
			String columData2=resultSet.getString("Department_name");
			
				System.out.println(columnData+" "+columData2);
				;
	}
		resultSet.close();
		statement.close();
		connection.close();	
}
}