package com.orangehrm.pages;

import java.util.List;

import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import com.orangehrm.utils.BaseClass;
import com.orangehrm.utils.CommonMethods;

public class JobTitlePage extends BaseClass {

	@FindBy(xpath="//li[@class='page-title']")
	public WebElement pageTitle;
	
	@FindBy(xpath="//i[@class='large material-icons']")
	public WebElement addButton;
	
	@FindBy(xpath="//input[@id='jobTitleName']")
	public WebElement jobTitleBox;
	
	@FindBy(xpath="//textarea[@id='jobDescription']")
	public WebElement jobDescriptionBox;
	
	@FindBy(xpath="//input[@id='jobSpecification']")
	public WebElement jobSpecificationButton;
	
	@FindBy(xpath="//textarea[@id='note']")
	public WebElement noteBox;
	
	@FindBy(xpath="//a[@class='modal-action modal-close waves-effect waves-green btn']")
	public WebElement cancelButton;
	
	@FindBy(xpath="//a[@class='modal-action waves-effect waves-green btn primary-btn']")
	public WebElement saveButton;
	
	@FindBy(xpath="//div[@id='wrapper']//tr//td[2]")
	public List<WebElement> titles;
	
	public JobTitlePage() {
		PageFactory.initElements(driver, this);
	}
	
	public String verifyPageTitle() {
		return pageTitle.getText();
	}
	
	@FindBy(xpath = "//table[@class='highlight bordered']/tbody/tr")
	   public List<WebElement> jobTitleTableRows;
	
	public void addTitle(String jobT, String jobDescrp,String filePath) throws InterruptedException  {
		
		CommonMethods.click(addButton);
		CommonMethods.sendText(jobTitleBox, jobT);
		CommonMethods.sendText(jobDescriptionBox, jobDescrp);
		CommonMethods.sendText(jobSpecificationButton, filePath);
		CommonMethods.click(saveButton);
	}
	
	public String verifyTitleAdded(String str) {
		
		String actualTitle = null;
		int size = titles.size();
		
		for(int i = 1; i < size; i++) {
			
			actualTitle = driver.findElement(By.xpath("//div[@id='wrapper']//tr["+i+"]//td[2]")).getText();
			
			if(actualTitle.equalsIgnoreCase(str)) {
				break;
			}
		}
		
		return actualTitle;
	}
	

	public void getAllJobTitles() {
		int size=titles.size();
		String jobTitles=null;
		for (int i=1; i<=size; i++) {
		 jobTitles=driver.findElement(By.xpath("//div[@id='wrapper']//tr["+i+"]//td[2]")).getText();
		 System.out.println(jobTitles);
		}
		
	}
	
}
