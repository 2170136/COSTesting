Feature: Manage contacts list pages at the Contacts Orchestrator Solution's (COS) Landing Page
  As a user
  I want to change number of entries per page
  So that I can define the number of entries that i want to see

  Scenario: The default numbers or users per page
    Given I am on the Contact list page
    Then  the list contain "10" contacts

  Scenario: When i change numbers per page to 50
    Given I am on the Contact list page
    When I Change the users per page to 50
    Then the list contain "50" contacts

  Scenario: When i change numbers per page to 25
    Given I am on the Contact list page
    When I Change the users per page to 25
    Then the list contain "25" contacts

  Scenario: When i change numbers per page to 100
    Given I am on the Contact list page
    When I Change the users per page to 100
    Then the list contain "100" contacts