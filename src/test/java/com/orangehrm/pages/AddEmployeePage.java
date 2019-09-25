package com.orangehrm.pages;

import java.util.List;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import com.orangehrm.utils.BaseClass;

public class AddEmployeePage extends BaseClass {
	
	@FindBy(id="firstName")
    public WebElement firstName;
    
    @FindBy(id="middleName")
    public WebElement middleName;
    
    @FindBy(id="lastName")
    public WebElement lastName;
    
    @FindBy(id="employeeId")
    public WebElement employeeId;
    
    @FindBy(xpath="//div[@id='location_inputfileddiv']//input")
    public WebElement location;
    
    @FindBy(xpath="//div[@id='location_inputfileddiv']//ul")
    public WebElement locationList;
    
    @FindBy(xpath="//input[@id='chkLogin']")
    public WebElement createLoginDetails;
    
    @FindBy(xpath="//a[@id='systemUserSaveBtn']")
    public WebElement saveBtn;
    
    @FindBy(xpath="//button[@type='submit']")
    public WebElement saveBtn2;
    
    @FindBy(xpath="//span[@id='pim.navbar.employeeName']")
    public WebElement empCheck;
    
    
    @FindBy(id="preloader")
    public WebElement loader;
    
    @FindBy(xpath="//form[@id='pimAddEmployeeForm']//label")
    public List<WebElement> addEmpLabels;
    
    @FindBy(xpath="//*[@id=\"pimAddEmployeeForm\"]/div[1]/div/materializecss-decorator[3]/div/sf-decorator/div/label")
    public WebElement createBtn;
    
    @FindBy(css="input#username")
    public WebElement loginUsername;
    
    @FindBy(xpath="(//div[@class='select-wrapper initialized']//ul)[2]")
    public WebElement statusDD;
    
    @FindBy(css="input#password")
    public WebElement loginPassword;
    
    @FindBy(css="input#confirmPassword")
    public WebElement loginConfirmPass;
    
    
    
    @FindBy(xpath="//*[@id=\"adminRoleId_inputfileddiv\"]//ul")
    public WebElement adminRoleList;
    
        
    @FindBy(xpath="//div[@id=\"adminRoleId_inputfileddiv\"]//input")
    public WebElement adminRole;
    
    @FindBy(xpath="//a[@id='systemUserSaveBtn']")
    public WebElement loginSaveBtn;
    
    @FindBy(xpath="//div[@id='essRoleId_inputfileddiv']//input")
    public WebElement essRole;
    
    @FindBy(xpath="//div[@id='essRoleId_inputfileddiv']//ul")
    public WebElement essRoleList;
    
    @FindBy(xpath="//div[@id='supervisorRoleId_inputfileddiv']//input")
    public WebElement defSup;
    
    @FindBy(xpath="//div[@id='supervisorRoleId_inputfileddiv']//ul")
    public WebElement defSupList;
    
    @FindBy(xpath="//span[@id='pim.navbar.employeeName']")
    public WebElement empNameDisplay;
    
    public AddEmployeePage() {
        PageFactory.initElements(driver,this);
    
}
}
