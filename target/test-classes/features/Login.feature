#Author: syntax team //lola.meli@wellsfargo.com
Feature: Login

  Background: 
    Given I see OrangeHrm logo

  @smoke @login @test @jenkins
  Scenario: Valid login
    When I enter valid username and password
    And I click login button
    Then I successfully logged in

  @regression @login
  Scenario: Invalid login
    When I enter invalid username and password
    And I click login button
    Then I see error message is displayed

@temp @regression
  Scenario: Error message Validation
    When I enter invalid username and password I see errorMessage
      | UserName | Password   | ErrorMessage        |
      | Admin    | Admin123   | Invalid Credentials1|
      | Admin1   | Syntax123! | Invalid Credentials |
      