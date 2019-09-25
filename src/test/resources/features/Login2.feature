#Author: lolameli007@gmail.com
#Feature: Login to gmail.com
Feature: Login to gmail.com

  Background: Login to gmail
    Given I see gmail.com

  @smoke2
  Scenario: Valid Login to gmail.com
    When I enter valid "<username>" and press Next button
    And I enter  "<password>" and press Next button
    And I click signin button
    Then I see Gmail logo

  @smoke2
  Scenario Outline: Invalid Login to gmail.com
    When I enter invalid "<username>" and "<password>"
    And I click signin button
    Then I see "<error message>"

    Examples: 
      | username | password  | error message                                                   |
      | admin    | Tech@123  | Wrong password. Try again or click Forgot password to reset it. |
      | admin123 | Tech@1234 | Wrong password. Try again or click Forgot password to reset it. |
