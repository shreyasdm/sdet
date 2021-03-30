@ProjecCRMAct1
Feature: Counting Dashlets


Scenario Outline: Open the homepage and count the number of the dashlets on the page
    Given users Logins Alchemy CRM application
    When User enters valid Credentials
    And Count the number of Dashlets on the homepage
    Then Print the number and title of each Dashlet into the console
    And Exit the browser
    