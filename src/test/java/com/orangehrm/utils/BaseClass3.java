package com.orangehrm.utils;

import java.util.concurrent.TimeUnit;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;

public class BaseClass3 {

	public static WebDriver driver;
	
	public static void setUp () {
		
		ConfigsReader.readProperties(Constants.CREDENTIALS_FILEPATH);
		String browser=ConfigsReader.getProperty("browser");
		
		
		System.setProperty("webdriver.chrome.driver", "src/driver/chromedriver.exe");
		driver=new ChromeDriver();
		driver.manage().timeouts().pageLoadTimeout(20, TimeUnit.SECONDS);
		driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
		driver.manage().window().fullscreen();
		driver.get(ConfigsReader.getProperty("url"));
	}
	
	public static void tearDown() {
		
		driver.quit();
	}

	

}
