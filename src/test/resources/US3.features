Feature: Search Contacts at the Contacts Orchestrator Solution's (COS) Landing Page
  As a user
  I want to search users by name or Guid
  So that I can find a specific user

  Scenario Outline: Search a valid User
    Given I am on the Contact List page -3US
    When i type "<ValueSearch>" on the input box -3US
    Then the result "<FieldToSearch>" should contains "<ValueSearch>" -3US
  Examples:
  |ValueSearch|FieldToSearch|
  |Joao|name|
  |d4f8d88d-afe1-4c63-821a-27as83d6bb49|GUID|
  |LinkedIn|Source|
  
  Scenario: Search an invalid User
    Given I am on the Contact List page -3US
    When i type "Joooooo" on the input box -3US
    Then the result should be "No matching records found" error message -3US
