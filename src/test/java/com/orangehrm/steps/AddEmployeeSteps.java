package com.orangehrm.steps;


import java.util.ArrayList;
import java.util.List;


import org.junit.Assert;
import org.openqa.selenium.WebElement;

import com.orangehrm.pages.AddEmployeePage;
import com.orangehrm.pages.HomePage;
import com.orangehrm.pages.LoginPage;
import com.orangehrm.utils.CommonMethods;
import com.orangehrm.utils.ConfigsReader;
import com.orangehrm.utils.Constants;
import com.orangehrm.utils.ExcelUtility;

import cucumber.api.java.en.Given;
import cucumber.api.java.en.Then;
import cucumber.api.java.en.When;
import io.cucumber.datatable.DataTable;

public class AddEmployeeSteps extends CommonMethods {
	HomePage home;
	AddEmployeePage addEmp;
	LoginPage login;

	@Given("I logged in into OrangeHrm")
	public void i_logged_in_into_OrangeHrm() {
		LoginPage login = new LoginPage();
		login.login(ConfigsReader.getProperty("username"), ConfigsReader.getProperty("password"));
	}

	@When("I click on PIM link")
	public void i_click_on_PIM_link() {
		home = new HomePage();
		CommonMethods.waitForElementBeClickable(home.PIM, 20);
		CommonMethods.click(home.PIM);
	}

	@When("I click on  Add Employee link")
	public void i_click_on_Add_Employee_link() {
		home = new HomePage();
		CommonMethods.click(home.addEmployee);
	}

	@When("I provide Employee details {string}, {string}, {string} and {string}")
	public void i_provide_Employee_details(String fName, String mName, String lName, String location) {
		addEmp = new AddEmployeePage();
		CommonMethods.sendText(addEmp.firstName, fName);
		CommonMethods.sendText(addEmp.middleName, mName);
		CommonMethods.sendText(addEmp.lastName, lName);
		CommonMethods.click(addEmp.location);
		CommonMethods.selectList(addEmp.locationList, location);

	}

	@When("I provide  {string}, {string}, {string} and {string}")
	public void i_provide_and(String fName, String mName, String lName, String location) {
		addEmp = new AddEmployeePage();
		CommonMethods.sendText(addEmp.firstName, fName);
		CommonMethods.sendText(addEmp.middleName, mName);
		CommonMethods.sendText(addEmp.lastName, lName);
		CommonMethods.click(addEmp.location);
		CommonMethods.selectList(addEmp.locationList, location);

	}

	@When("I click on create login details")
	public void i_click_on_create_login_details() {
		CommonMethods.click(addEmp.createBtn);
	}

	@When("I provide all mandatory fields {string}, {string} and {string}")
	public void i_provide_all_mandatory_fields_and(String fName, String lName, String password) throws Exception {
		addEmp = new AddEmployeePage();
		CommonMethods.sendText(addEmp.loginUsername, fName + lName);
		CommonMethods.sendText(addEmp.loginPassword, password);
		CommonMethods.sendText(addEmp.loginConfirmPass, (password));
		CommonMethods.click(addEmp.essRole);
		CommonMethods.selectList(addEmp.essRoleList, "Default ESS");
		CommonMethods.click(addEmp.defSup);
		CommonMethods.selectList(addEmp.defSupList, "Default Supervisor");
		CommonMethods.click(addEmp.adminRole);
		CommonMethods.selectList(addEmp.adminRoleList, "Global Admin");
	}

	@Then("I see employee  {string} and {string} is added successfully")
	public void i_see_employee_is_added_successfully(String fName, String lName) {
		addEmp = new AddEmployeePage();
		CommonMethods.waitForElementBeClickable(addEmp.empCheck, 10);
		String verifText = addEmp.empCheck.getText();
		System.out.println(verifText);
		Assert.assertEquals(verifText, fName + " " + lName);
	}

	@When("I click on login save button")
	public void i_click_on_login_save_button() {
		addEmp = new AddEmployeePage();
		CommonMethods.waitForElementBeClickable(addEmp.loginSaveBtn, 10);
		CommonMethods.click(addEmp.loginSaveBtn);
	}

	@When("I click on save button")
	public void i_click_on_save_button() {
		addEmp = new AddEmployeePage();
		CommonMethods.waitForElementBeClickable(addEmp.loginSaveBtn, 10);
		CommonMethods.click(addEmp.saveBtn);

	}

	@Then("I see employee {string} and {string} is added successfully")
	public void i_see_employee_and_is_added_successfully(String fName, String lName) {
		addEmp = new AddEmployeePage();
		CommonMethods.waitForElementBeClickable(addEmp.empCheck, 10);
		String verifText = addEmp.empCheck.getText();
		System.out.println(verifText);
		Assert.assertEquals(verifText, fName + " " + lName);
	}

	@Then("I see following labels")
//variable addEmpLabels holds all the values of data table from feature file
	public void i_see_following_labels(DataTable addEmpLabels) {
		addEmp = new AddEmployeePage();

		// printing all the expected labels we have
		System.out.println("----Printing expected labels from cucumber dataTable----");
		List<String> expectedLabels = addEmpLabels.asList();

		for (String label : expectedLabels) {
			System.out.println(label);
		}

		// create an empty array list where we store labels text
		List<String> actualLabels = new ArrayList<String>();

		// get all label elements
		List<WebElement> labelList = addEmp.addEmpLabels;

		for (WebElement label : labelList) {
			String labeltxt = label.getText();

			if (!labeltxt.isEmpty()) {
				actualLabels.add(labeltxt.replace("*", ""));
				System.out.println(labeltxt);
			}
			//
		}
		// printing all actual values we have in the application
		System.out.println("----Printing actual labels text from the application----");

		// the most easiest way
		Assert.assertTrue(actualLabels.equals(expectedLabels));

	}

	@When("I provide employee details from {string}")
	public void i_provide_employee_details(String EmployeeDetails) throws Exception {
		addEmp = new AddEmployeePage();
		home = new HomePage();

		ExcelUtility xl = new ExcelUtility();
		xl.openExcel(Constants.XL_ORANGE_HRM_DATA_FILEPATH, "EmployeeDetails");
		int rows = xl.getRowNum();
		int cols = xl.getColNum(0);

		for (int i = 1; i < rows; i++) {
			for (int j = 0; j < cols; j++) {
				
				
				String fName = xl.getCellData(i, j);
				String mName = xl.getCellData(i, ++j);
				String lName = xl.getCellData(i, ++j);
				String location = xl.getCellData(i, ++j);

				sendText(addEmp.firstName, fName);
				sendText(addEmp.middleName, mName);
				sendText(addEmp.lastName, lName);
				click(addEmp.location);
				selectList(addEmp.locationList, location);

				click(addEmp.saveBtn);
				waitForElementBeClickable(addEmp.empCheck, 5);
				Assert.assertEquals(fName + " " + lName, addEmp.empCheck.getText());
				
			}
			// Prevent ElementClickInterceptedException
			waitForInvisibilityOfElementLocated(addEmp.loader, 5);
			click(home.addEmployee);
			
		}
		
	}

	@Then("I see employee is added successfully")
	public void i_see_employee_is_added_successfully() {
		System.out.println("Employee is added successfully");
	}

}