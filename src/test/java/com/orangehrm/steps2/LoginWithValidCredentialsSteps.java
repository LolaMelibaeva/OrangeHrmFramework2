package com.orangehrm.steps2;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.Assert;

import cucumber.api.java.en.Given;
import cucumber.api.java.en.Then;
import cucumber.api.java.en.When;

public class LoginWithValidCredentialsSteps {
	WebDriver driver;

@Given("I want to navigate to OrangeHRM")
public void i_want_to_navigate_to_OrangeHRM() {
	System.setProperty("webdriver.chrome.driver", "src/test/resources/drivers/chromedriver.exe");
    driver=new ChromeDriver();
    driver.get("https://lolahon23-trials65.orangehrmlive.com");
}

@When("I enter valid username")
public void i_enter_valid_username() {
	 driver.findElement(By.id("txtUsername")).sendKeys("Admin");
}

@When("I enter valid password")
public void i_enter_valid_password() {
    driver.findElement(By.id("txtPassword")).sendKeys("xV9D@Q2Hbv");
    
}


@When("I click submit button")
public void i_click_submit_button() {
    driver.findElement(By.id("btnLogin")).click();
}


@Then("I validate the outcomes")
public void i_validate_the_outcomes() {
    boolean flag=driver.findElement(By.xpath("//li[text()='Dashboard']")).isDisplayed();
    Assert.assertTrue(flag);
	System.out.println("The dashboard is displayed");
}


@Then("I quit browser")
public void i_quit_browser() {
    driver.close();
}

}
