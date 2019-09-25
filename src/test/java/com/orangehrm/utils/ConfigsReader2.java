package com.orangehrm.utils;

import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.util.Properties;

public class ConfigsReader2 {

	static Properties prop;
	
	public static void readProperties (String filepath) {
		
		
		try {
			FileInputStream fis=new FileInputStream(filepath);
			prop=new Properties();
			prop.load(fis);
		} catch (FileNotFoundException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
		
	}
	
	public static String getProperty (String key) {
		
		return prop.getProperty(key);
	}
//	public static void readProperties( String filepath) {
//	FileInputStream fis=new FileInputStream(filepath);
//	Properties prop=new Properties();
//	prop.load(fis);
//	
//	}
//	
//	public static String getProperty(String key) {
//		return prop.getProperty(key);
	}
