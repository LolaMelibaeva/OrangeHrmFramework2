package com.orangehrm.practice;

import java.sql.Connection;
import java.sql.DatabaseMetaData;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.ResultSetMetaData;
import java.sql.SQLException;
import java.sql.Statement;

import org.junit.Test;

public class MetaDataDemo {


	String dbUrl="jdbc:oracle:thin:@syntaxdatabase.cdjflmucstpo.us-east-1.rds.amazonaws.com:1521:orcl";
	
	String dbUsername="Syntax";
	
	String dbPassword="syntax123";
	
	@Test
	public void getMetaData() throws SQLException {
		
		Connection conn=DriverManager.getConnection(dbUrl, dbUsername, dbPassword);
		//print database name
		DatabaseMetaData dbMetaData=conn.getMetaData();
		
		String dbName=dbMetaData.getDatabaseProductName();
		System.out.println(dbName);
		
		//print database version
		
		String dbVersion=dbMetaData.getDatabaseProductVersion();
		System.out.println(dbVersion);
		
		Statement st=conn.createStatement();
		
		ResultSet rs=st.executeQuery("select * from employees where job_id='IT_PROG'");
		ResultSetMetaData rsMetaData=rs.getMetaData();
		//get total # of cols
		int colNum=rsMetaData.getColumnCount();
		System.out.println(colNum);
		//get name of specified column
		String colName=rsMetaData.getColumnName(1);
		System.out.println(colName);
		System.out.println("---------All the Column Names----------");
		for(int i=1; i<=colNum; i++) {
			System.out.println(rsMetaData.getColumnName(i));
		}
		
		rs.close();
		st.close();
		conn.close();
		
		
	}
}
