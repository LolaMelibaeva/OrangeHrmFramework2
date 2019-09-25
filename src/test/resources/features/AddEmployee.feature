#Author: syntax team     //john.smith@wellfargo.com
Feature: Add Employee

  Background: 
    Given I logged in into OrangeHrm
    And I click on PIM link
    And I click on  Add Employee link

  @smoke
  Scenario Outline: Add Employee to OrangeHrm
    When I provide Employee details <fName>, <mName>, <lName>" and <location>
    And I click on save button
    Then I see employee <fName> and <lName> is added successfully

    Examples: 
      | fName | mName  | lName   | location     |
      | Jane  | Maria  | Legend  | HQ           |
      | Linda | Sophia | Stewart | North Office |
      | Diane | Angel  | Windsor | West Office  |

  @loginDetails
  Scenario Outline: Add Employee and Create Login Details
    When I provide  "<fName>", "<mName>", "<lName>" and "<location>"
    And I click on create login details
    And I provide all mandatory fields "<fName>", "<lName>" and "<password>"
    And I click on save button
    Then I see employee  "<fName>" and "<lName>" is added successfully

    Examples: 
      | fName    | mName  | lName   | location     | password   |
      | Miguels   | Martin | Morales | HQ           | Syntax@123 |
      | Jennifers | Sophia | Afleck  | North Office | Syntax@456 |
      | Sandras   | Angel  | Morales | West Office  | Syntax@789 |

  @temp1
  Scenario: Add Employee Labels Verification
    Then I see following labels
      | First Names          |
      | Middle Name          |
      | Last Name            |
      | Employee Id          |
      | Location             |
      | Create Login Details |
      
       @ReadingDataFromExcel
  Scenario: Add Employee and Create Login Details
    When I provide employee details from "EmployeeDetails"  
    Then I see employee is added successfully
