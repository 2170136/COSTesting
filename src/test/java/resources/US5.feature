Feature: Access to the Contacts Orchestrator Solution's (COS) Landing Page
  As a user
  I want to change the page number
  So that I can see other users

  Scenario: Check Next Page
    Given I am on the Contact List page
    When i click in the next page
    Then the text users per page should be "Showing 11 to 20 of 200 entries"

  Scenario: Check Page 2
    Given I am on the Contact List page
    When i click in the page 2
    Then the text users per page should be "Showing 11 to 20 of 200 entries"