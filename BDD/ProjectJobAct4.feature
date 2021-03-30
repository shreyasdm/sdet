@ProjectJob4
Feature: Posting a job using parameterization


Scenario Outline: Post a job using details passed from the Feature file
    Given EUser is on Alchemy Job page
    When EGo to Post a Job page
    And ExampleEnter "<YourEmail>" and "<JobTitle>" and "<Description>" and "<CompanyEmail>" and "<CompanyMail>"
    And EClick on Submit
    And EGo to the Jobs page
    Then EConfirm job listing is shown on page
    And EGenerate HTML report
    
    Examples:
    |YourEmail 						   |JobTitle 	    |Description  |CompanyEmail       |CompanyMail|
    |NewTestEmail12@gmail.com|SDET SR Tester|Hello Test	  |appURl123@gmail.com|New Company|
    