package com.orangehrm.practice;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.ResultSetMetaData;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.LinkedHashMap;
import java.util.List;
import java.util.Map;

import org.junit.Test;

public class Task {
	

	String dbUrl="jdbc:oracle:thin:@syntaxdatabase.cdjflmucstpo.us-east-1.rds.amazonaws.com:1521:orcl";
	
	String dbUsername="Syntax";
	
	String dbPassword="syntax123";
	
	@Test
	public void  retriveData() throws SQLException {
		//creating connection
		
		Connection conn=DriverManager.getConnection(dbUrl, dbUsername, dbPassword);
		Statement st=conn.createStatement();
		ResultSet rs=st.executeQuery(
				"select street_address, city, c.country_name from locations l join countries c on c.country_id=l.country_id");
			List<Map<String, String>> rsList=new ArrayList<>();
		
		
			while(rs.next()) {
			Map<String, String> rsMap=new LinkedHashMap<>();
			rsMap.put("STREET_ADDRESS", rs.getString("STREET_ADDRESS"));
			rsMap.put("CITY", rs.getString("CITY"));
			rsMap.put("COUNTRY_NAME", rs.getString("COUNTRY_NAME"));
			rsList.add(rsMap);
			
			
			
		}
		
		System.out.println(rsList+" ");
		rs.close();
		st.close();
		conn.close();
		
}

	//@Test
	public void  retriveData2() throws SQLException {
		//creating connection
		
		Connection conn=DriverManager.getConnection(dbUrl, dbUsername, dbPassword);
		Statement st=conn.createStatement();
		ResultSet rs=st.executeQuery(
				"select * from JOBS");
		ResultSetMetaData rsMetaData=rs.getMetaData();
		
		
			List<Map<String, String>> rsList=new ArrayList<>();
		
		
			while(rs.next()) {
			Map<String, String> rsMap=new HashMap<>();
			
			for (int i=1; i<=rsMetaData.getColumnCount(); i++) {
				
				rsMap.put(rsMetaData.getColumnName(i), rs.getObject(i).toString());
				
			}
			rsList.add(rsMap);
			
		}
		
		System.out.println(rsList+" ");
		rs.close();
		st.close();
		conn.close();
		

	}
}
