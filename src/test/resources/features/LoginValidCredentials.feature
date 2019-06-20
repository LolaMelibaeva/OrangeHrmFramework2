

Feature: Login to OrangeHRM
  

  Scenario: Login to OrangHRM with Valid Credentials
  
    Given I want to navigate to OrangeHRM 
    When I enter valid username 
    And I enter valid password
    And I click submit button
    Then I validate the outcomes
    Then I quit browser
   
 