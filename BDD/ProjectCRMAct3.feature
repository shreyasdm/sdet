@ProjectCRmAct3
Feature: Schedule a meeting and invite members


Scenario Outline: To schedule a meeting and include at least 3 invitees
    Given User logs in Achemy CRM page with Valid Cred
    When User Navigates to schedule Meeting thorugh activities and Meeting
    And Enter the details of the meeting
    And Search for "<recipient1>" and "<recipient2>" and "<recipient2>" and add them to the meeting
    And Click save meeting
    Then Navigate to View Meeting and check  "<recipient1>" and "<recipient2>" is added
    And Exit the Browser created for meeting
    
    Examples:
    |recipient1 						   |recipient2 	     |recipient3 	   |
    |MadhuThree						     |MadhuFour        |Madhu |

    