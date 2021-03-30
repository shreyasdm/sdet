@ProjectHRMAct4
Feature: Creating multiple vacancies


Scenario Outline: Creating multiple vacancies using data from an Examples table
    Given users Logins OrangeHRM application and with Credentials
    When Navigate to Recruitment and Click vacancies
    And  Click the Add button to get Add Job Vacancy page
    And Enter all details "<JobTitle>" and "<VacancyName>" and "<HiringManager>"
    And Click Save Btn
    Then Verify that all the "<VacancyName>" have been successfully created
    And Closes the browsersss
    
    Examples:
    |JobTitle  |VacancyName |HiringManager|
    |DevOps Engineer		  |DevOpsEngineer1   |orange hrm  | 
    |DevOps Engineer		  |DevOpsEngineerSr1   |orange hrm | 
    