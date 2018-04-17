Feature: Access to the Contacts Orchestrator Solution's (COS) Landing Page
  As a user
  I want to change the page number
  So that I can see other users

  Scenario: Check Next Page
    Given I am on the Contact List page
    When i click in the next page
    Then the text users per page should contain "Showing 11 to 20 of"

  Scenario: Check last page
    Given I am on the Contact List page
    When i click in the last page
    Then the text users per page should contain the last users

  Scenario: if on the first page the previous button must be disabled
    Given I am on the Contact List page
    When i click in the first page
    Then the button previous must be disabled

  Scenario: if on the last page the next button must be disabled
    Given I am on the Contact List page
    When i click in the last page
    Then the button next must be disabled