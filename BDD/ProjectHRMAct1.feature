@ProjectHRMAct1
Feature: Creating a job vacancy


Scenario: To create a job vacancy for DevOps Engineer
    Given users Logins HRM application
    When Navigate to the Recruitment page 
    And Click on the Vacancies menu
    And Click on the Add button to navigate to the Add Job Vacancy form
    And Fills out the necessary details and Clicks save
    Then Verify that the vacancy was created
    And Closes the browser
