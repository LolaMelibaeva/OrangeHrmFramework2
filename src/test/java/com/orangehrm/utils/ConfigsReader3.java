package com.orangehrm.utils;

import java.io.FileInputStream;
import java.io.IOException;
import java.util.Properties;

public class ConfigsReader3 {
	
	public static Properties prop;
	
	public static void readProperties (String filepath) {
		try {
		FileInputStream fis=new FileInputStream(filepath);
		prop=new Properties();		
		prop.load(fis);
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}
	
	public static String getProperties(String key) {
		
		return prop.getProperty(key);
	}

}
