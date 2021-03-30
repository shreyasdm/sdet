@ProjectJob2
Feature: Searching for jobs using XPath


Scenario: Searching for jobs and applying to them using XPath
    Given User is on Alchemy Job page and navigate to Jobs page
    When User inputs SDET Tester to search for jobs
    And Filter the list to Full Time jobs
    And Find a job listing using XPath and it to see job details
    And Find the title of the job listing using XPath and print it to the console
    Then Click on the Apply for job button
    And Quit the browser