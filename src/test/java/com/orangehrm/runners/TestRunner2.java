package com.orangehrm.runners;

import org.junit.runner.RunWith;

import cucumber.api.CucumberOptions;
import cucumber.api.junit.Cucumber;

@RunWith(Cucumber.class)
@CucumberOptions(
		features="src/test/resources/features/LoginValidCredentials.feature",
		glue="com/orangehrm/steps2")




public class TestRunner2 {

}
