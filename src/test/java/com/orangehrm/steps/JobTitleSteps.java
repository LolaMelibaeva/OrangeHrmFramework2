package com.orangehrm.steps;

import java.util.ArrayList;
import java.util.LinkedHashMap;
import java.util.List;
import java.util.Map;

import org.junit.Assert;

import org.openqa.selenium.WebElement;

import com.orangehrm.pages.HomePage;
import com.orangehrm.pages.JobTitlePage;
import com.orangehrm.pages.LoginPage;
import com.orangehrm.utils.CommonMethods;
import com.orangehrm.utils.DbUtils;

import cucumber.api.java.en.Given;
import cucumber.api.java.en.Then;
import cucumber.api.java.en.When;

public class JobTitleSteps extends CommonMethods{

	LoginPage lp;
	HomePage hp;
	JobTitlePage jp;
	List<Map<String, String>> uiResults;
	List<Map<String, String>> dbResults;

	

	@Given("I am on Job Titles Page")
	public void i_am_on_Job_Titles_Page() {
		hp = new HomePage();
		jp = new JobTitlePage();
		hp.jobTitle();
		String actualTitle = jp.verifyPageTitle();
		Assert.assertEquals("Job Titles", actualTitle);

	}

	@When("I provide {string},{string} and upload file with job {string}")

	public void i_provide_and_upload_file_with_job(String string, String string2, String string3) throws InterruptedException {

	    jp.addTitle(string, string2, string3);
	}

	@Then("I see job title is added successfully")
	public void i_see_job_title_is_added_successfully() {
		
		String actualTitle = jp.verifyTitleAdded("SDET");
		String expectedTitle = "SDET";
		System.out.println(actualTitle);
		Assert.assertEquals(expectedTitle, actualTitle);
	}
	

@Given("I click on Admin link")
public void i_click_on_Admin_link() {
	hp = new HomePage();
    click(hp.adminTab);
}

@Given("I click on job")
public void i_click_on_job() {
    hp=new HomePage();
    click(hp.jobTab);
}

@Given("I click on jobtitle")
public void i_click_on_jobtitle() {
	 hp=new HomePage();
	 click(hp.jobTitlesTab);
}

@When("I get all job titles from UI")
public void i_get_all_job_titles_from_UI() {
    jp=new JobTitlePage();
	uiResults = new ArrayList<>();

	for (WebElement row : jp.jobTitleTableRows) {
		
		Map<String, String> uiDataMap = new LinkedHashMap<>();

		String rowText = row.getText().replace("ohrm_edit", "").trim();

		uiDataMap.put("JOB_TITLE", rowText);

		uiResults.add(uiDataMap);
		
	}
	
	System.out.println(uiResults);
}

@When("I execute {string} from Database")
public void i_execute_from_Database(String sqlQuery) {
	System.out.println("------Printing Job Titles from DB------");
	sqlQuery=("select job_title from jobs order by 1");
	dbResults= DbUtils.getResultSetData(sqlQuery);
	 
System.out.println(dbResults);
    
}

@Then("Job titles are matched")
public void job_titles_are_matched() {
   Assert.assertTrue(uiResults.equals(dbResults));
}


}
