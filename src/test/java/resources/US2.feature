Feature: Access to the Contacts Orchestrator Solution's (COS) Landing Page
  As a user
  I want to access to the detail page of a specific user
  So that I can see the details about this user

  Scenario: Check Email Format
    Given I am on the Contact List page
    When i click in the first more info button
    Then the field "email" should be in the right format

  Scenario: Check Phone Format
    Given I am on the Contact List page
    When i click in the first more info button
    Then the field "phone" should be in the right format