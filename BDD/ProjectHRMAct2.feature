@ProjectHRMAct2
Feature: Creating a job vacancy


Scenario: To create a job vacancy for DevOps Engineer
    Given users Logins OrangeHRM application
    When Navigate to the Recruitment page and click on the Add button
    And  Fill in the details of the candidate
    And Upload a resume docx or pdf to the form and Save
    Then Navigate back to the Recruitments page to confirm candidate entry
    And Closes the browsers