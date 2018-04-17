Feature: Access to the Contacts Orchestrator Solution's (COS) Landing Page
  As a user
  I want to search users by name or Guid
  So that I can find a specific user

  Scenario: Search a valid User
    Given I am on the Contact List page
    When i type "Joao " on the input box
    Then the result should be "3" users
  
  Scenario: Search an invalid User
    Given I am on the Contact List page
    When i type "Joooooo" on the input box
    Then the result should be "No matching records found" error message
