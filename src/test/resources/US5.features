Feature: Change contacts list page at the Contacts Orchestrator Solution's (COS) Landing Page
  As a user
  I want to change the page number
  So that I can see other users

  Scenario: Check Next Page
    Given I am on the Contact List page -5US
    When i click in the next page -5US
    Then the text users per page should contain "Showing 11 to 20 of" -5US
    And contacts off the page have to be different from the contacts off the first page -5US

  Scenario: Check last page
    Given I am on the Contact List page -5US
    When i click in the last page -5US
    Then the text users per page should contain the last users -5US
    And contacts off the page have to be different from the contacts off the first page -5US

  Scenario: if on the first page the previous button must be disabled
    Given I am on the Contact List page -5US
    When i click in the first page -5US
    Then the button previous must be disabled -5US

  Scenario: if on the last page the next button must be disabled
    Given I am on the Contact List page -5US
    When i click in the last page -5US
    Then the button next must be disabled -5US
    And contacts off the page have to be different from the contacts off the first page -5US