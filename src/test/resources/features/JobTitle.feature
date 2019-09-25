#Author: instructor@syntaxtechs.co
@jobtitle
Feature: Job Title
  Valiation for job title functionality

  Background: 
    Given I logged in into OrangeHrm
    And I click on Admin link
    And I click on job
    And I click on jobtitle

  @smoke @sprint5 @test
  
  @db
  Scenario Outline: Job Title Validation
    When I get all job titles from UI
    And I execute "<Query>" from Database
    Then Job titles are matched

    Examples: 
      | Query                                 |
      | SELECT JOB_TITLE FROM JOBS ORDER BY 1 |