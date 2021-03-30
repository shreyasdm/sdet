@ProjectJob3
Feature: Posting a job using parameterization


Scenario: Post a job using details passed from the Feature file
    Given User is on Alchemy Job page
    When Go to Post a Job page
    And Enter "Emailaqw3s@gmail.com" and "SDET SR Tester" and "Hello Test" and "appURl123@gmail.com" and "New Company"
    And Click on Submit
    And Go to the Jobs page
    Then Confirm job listing is shown on page
    And Generate HTML report