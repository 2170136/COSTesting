Feature: Access to the Contacts Orchestrator Solution's (COS) Landing Page
  As a user
  I want to change number of entries per page
  So that I can define the number of entries that i want to see

  Scenario: The default numbers or users per page
    Given I am on the Contact List page
    Then the users per page should be "Showing 1 to 10 of 200 entries"

  Scenario: When i change numbers per page to 50
    Given I am on the Contact List page
    When I Change the users per page to 50
    Then the users per page should be "Showing 1 to 50 of 200 entries"