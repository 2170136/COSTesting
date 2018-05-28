Feature: Search Contacts at the Contacts Orchestrator Solution's (COS) Landing Page
  As a user
  I want to search users by name or Guid
  So that I can find a specific user

  Scenario: Search a valid User
    Given I am on the Contact List page -3US
    When i type "Joao" on the input box -3US
    Then the result names should contains "Joao" -3US
  
  Scenario: Search an invalid User
    Given I am on the Contact List page -3US
    When i type "Joooooo" on the input box -3US
    Then the result should be "No matching records found" error message -3US
