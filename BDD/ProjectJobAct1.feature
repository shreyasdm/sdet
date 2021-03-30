@ProjectJob
Feature: Create a User


Scenario: Visit the site backend and create a new user
    Given User is on Job log in page 
    When User enteres user name and Password 
    And Locates left hand menu and click the menu item that says Users
    And Locate the Add New button and click it.
    And Fill in the necessary details.
    And Click the Add New User button
    Then Verify that the user was created.
    And Close the browser.
