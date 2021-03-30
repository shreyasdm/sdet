@ProjectHRMAct3
Feature: Add multiple employees


Scenario Outline: Add multiple employees using an the Examples table
    Given users Logins OrangeHRM application and with valid Credentials
    When Navigate to the PIM Option and click on the it
    And  Click the Add button to add a new Employee
    And Make sure the Create Login Details checkbox is checked
    And Enter "<FirstName>" and "<LastName>" and "<UserName>"
    Then Verify that the employees have been created
    And Closes the browserss
    
    Examples:
    |FirstName  |LastName |UserName|
    |Rajat5		  |Kumar1   |User0079  | 
    |Rajat6		  |Kumar2   |User0080  | 
    