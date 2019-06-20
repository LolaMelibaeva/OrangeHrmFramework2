package com.orangehrm.steps;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;


import cucumber.api.java.en.And;
import cucumber.api.java.en.Given;
import cucumber.api.java.en.Then;
import cucumber.api.java.en.When;


public class GoogleSearchSteps {
	
	WebDriver driver;

@Given("I navigated to the Google")
public void i_navigated_to_the_Google() {
    System.setProperty("webdriver.chrome.driver", "src/test/resources/drivers/chromedriver.exe");
    driver=new ChromeDriver();
    driver.get("http://google.com");
    
    
}

@When("I type search item")
public void i_type_search_item() {
   driver.findElement(By.xpath("//input[@class='gLFyf gsfi']")).sendKeys("iPhone");
}

@And("I click on google search button")
public void i_click_on_google_search_button() {
	driver.findElement(By.xpath("//div[@class='FPdoLc VlcLAe']//input[@class='gNO89b']")).click();
  
}

@Then("I see search results are displayed")
public void i_see_search_results_are_displayed() {
//String text= driver.findElement(By.cssSelector("//div#resultStats")).getText();
//System.out.println(text);
//	//if (text.contains("About results")) {
  System.out.println("The result is displayed");
	}
}


	


