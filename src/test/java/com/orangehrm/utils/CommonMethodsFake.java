package com.orangehrm.utils;

import java.io.File;
import java.io.IOException;
import java.util.List;
import java.util.concurrent.TimeUnit;

import org.apache.commons.io.FileUtils;
import org.openqa.selenium.Alert;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.Select;

public class CommonMethodsFake extends BaseClass{

	
	public static void selectCellDataFromWebTable(List<WebElement> rows, String expectedValue) {
		
		boolean isSelected=true;
		
		for (WebElement row: rows) {
			String rowText=row.getText();
			if(rowText.equals(expectedValue)){
				row.click();
				isSelected=true;
				break;
			}
		}if(!isSelected){
		System.out.println(expectedValue+" is NOT selected");
	
	}
}
	public static String takesScreenshot (String filename) {
		
		TakesScreenshot ts=(TakesScreenshot)driver;
		File src=ts.getScreenshotAs(OutputType.FILE);
		String dest=System.getProperty("user.dir")+"/target/screenshot/"+filename+".png";
		try {
		FileUtils.copyFile (src, new File (dest));
		}catch (IOException e) {
			e.printStackTrace();
		}		
		return dest;
					
		}	
	
		public static void setUP () {
			
			System.setProperty("webdriver.chromedriver.driver", "chromedriver.exe");
			WebDriver driver=new ChromeDriver();
			
			driver.manage().timeouts().pageLoadTimeout(30, TimeUnit.SECONDS);
			driver.manage().timeouts().implicitlyWait(20, TimeUnit.SECONDS);
			driver.manage().window().fullscreen();
			
			driver.get("url");
					
		}
		
		public static void tearDown() {
			driver.quit();
		}
		
		public static void switchToFrame (String IdorName) {
			try {
				driver.switchTo().frame(IdorName);
			}catch (Exception e) {
				e.printStackTrace();
			}
		}
		public static void switchToFrame(WebElement element) {
			try {
				driver.switchTo().frame(element);
			}catch(Exception e) {
				e.printStackTrace();
			}
		}
		
		public static void switchToFrame(int index) {
			try {
				driver.switchTo().frame(index);
				
			}catch(Exception e) {
				e.printStackTrace();
			}
		}
		
		public static void selectDateFromCalendar (List<WebElement> rows, String date) {
			
			boolean isSelected=true;
			for (WebElement row: rows) {
				String rowText=row.getText();
				if(rowText.equals(date)) {
					row.click();
					System.out.println(date+ " is Selected");
					isSelected=true;
					break;
				}
			}if (!isSelected) {
				System.out.println(date +" is NOT selected");
			
				
			}
			
		}
		
		public static void selectRadioButton (List<WebElement> radio, String expValue) {
			boolean isSelected=true;
			for(WebElement button: radio) {
				String buttonValue=button.getAttribute("value");
				if(buttonValue.equals(expValue) && button.isDisplayed() && button.isEnabled()) {
					button.click();
					isSelected=true;
					break;
				}
			}if(isSelected) {
				System.out.println(expValue+ " is NOT selected");
			}
		}
		
		public static void javascriptClick (WebElement element) {
			JavascriptExecutor js=(JavascriptExecutor)driver;
			js.executeScript("arguments[0].click();", element);
			
		}
		
		public static void jsScrollByUp(int pixel) {
			JavascriptExecutor js=(JavascriptExecutor)driver;
			js.executeScript("window.scrollBy(0; +"+pixel+")");
		}

		public static void selectValueFromDropDown (WebElement element, String txt) {
			boolean isSelected=true;
			Select select=new Select(element);
			List<WebElement> options=select.getOptions();
			for(WebElement option: options) {
				String optiontxt=option.getText();
				if(optiontxt.equals(txt)) {
					select.selectByValue(txt);
					System.out.println(txt +" is selected");
					isSelected=true;
					break;
				}
			}if(!isSelected) {
				System.out.println(txt+" is NOT selected from Drop Down");
			}
		}
			
			public static String getTextAlert() {
				
			Alert alert=driver.switchTo().alert();

				return alert.getText();
				
				
			
		}
}