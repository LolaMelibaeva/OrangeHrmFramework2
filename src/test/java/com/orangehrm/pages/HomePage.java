package com.orangehrm.pages;


import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import com.orangehrm.utils.BaseClass;
import com.orangehrm.utils.CommonMethods;

public class HomePage extends BaseClass {



	
	@FindBy(xpath="//span[@class='left-menu-title'][contains(text(),'Admin')]")
	public WebElement adminTab;
	
	@FindBy(xpath="//a[@class='collapsible-header waves-effect waves-orange']//span[@class='left-menu-title'][contains(text(),'Job')]")
	public WebElement jobTab;
	
	@FindBy(xpath="//span[contains(text(),'Job Titles')]")
	public WebElement jobTitlesTab;
	
	@FindBy(xpath="//*[@id=\"menu_pim_viewPimModule\"]/a/span[2]")
    public WebElement PIM;
	
    @FindBy(partialLinkText="Add Employee")
    public WebElement addEmployee;
    
	@FindBy(xpath = "//span[text()='Employee List']")
	public WebElement empList;

	@FindBy(xpath = "//div[@class='angucomplete-holder']/input")
	public WebElement empName;

	@FindBy(xpath = "//*[@id=\"employee_name_quick_filter_employee_list_dropdown\"]/div[3]")
	public WebElement empListDD;

	@FindBy(css = "#employee_name_quick_filter_employee_list_value")
	public WebElement empSearchBox;

	// @FindBy(xpath="//a[@ng-click='navbar.search()']")
	// public WebElement empSearchBtn;

	@FindBy(xpath = "//*[@id='quick_search_icon']")
	public WebElement empSearchBtn;

	@FindBy(xpath = "//i[text()='ohrm_filter']")
	public WebElement filterBtn;

	@FindBy(xpath = "//a[text()='Reset']")
	public WebElement resetBtn;
	
	
	@FindBy(xpath="//li[@id='menu_admin_viewAdminModule']/a/span[2]")
	public WebElement admin;
	
	@FindBy(xpath="//li[@id='menu_admin_Organization']/a/span[2]")
	public WebElement organization;
	
	@FindBy(xpath="//a[@id='menu_admin_viewLocations']/span[2]")
	public WebElement locations;
	
	@FindBy(xpath="//i[text()='add']")
	public WebElement addLocation;
	

	@FindBy(xpath="//li[@id='menu_admin_Qualifications']/a/span[2]")
	public WebElement qualification;
	
	@FindBy(xpath="//span[text()='Languages']")
	public WebElement languages;


//	@FindBy(xpath="//span[text()='Qualifications']")
//	public WebElement qualification;

	@FindBy(xpath="//td[@name='listField.name'][3]")
	public WebElement verifyLoc;
	
	
	@FindBy(xpath="//*[@id='menu_admin_viewSkills']/span[2]")
	public WebElement skills;
	
	@FindBy(xpath="//*[@id='skillDiv']/div/a/i")
	public WebElement addSkillBtn;
	
	@FindBy(xpath="//*[@id='name']")
	public WebElement nameSkill;
	
	@FindBy (xpath="//*[@id='description']")
	public WebElement descriptionSkill;	
	
	@FindBy (xpath="//*[@id='modal1']/form/div[2]/a[1]")
	public WebElement saveSkillBtn;	

	 @FindBy(id="preloader")
	 public WebElement loader;

		@FindBy(xpath="//li[text()='Dashboard']")
		public WebElement dashboardText;

	

	public JobTitlePage jobTitle() {
		CommonMethods.click(adminTab);
		CommonMethods.click(jobTab);
		CommonMethods.click(jobTitlesTab);
		return new JobTitlePage();
	}
	 
	
	public HomePage() {
		PageFactory.initElements(driver, this);
	}

}
