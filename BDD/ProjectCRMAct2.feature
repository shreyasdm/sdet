@ProjectCRmAct2
Feature: Create leads using parameterization


Scenario Outline: Open the Leads page and add multiple lead accounts using values
    Given User logs in Achemy CRM page
    When User Navigates to Create Lead page
    And Enter "<FirstName>" and "<LastName>"
    And Click Save to finish
    Then Navigate to the View Leads page and confirm Lead "<FirstName>" and "<LastName>" are created
    And Exist the currentBrowser
    
    Examples:
    |FirstName 						   |LastName 	   |
    |MadhuThree						  |LeadGaurThree|
    |MadhuFour							 |LeadGaurFour|
    