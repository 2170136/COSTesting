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

  Scenario: Check Birthday Format
    Given I am on the Contact List page
    When i click in the first more info button
    Then the field "Birthday" should be in the right format

  Scenario: Check Guid Format
    Given I am on the Contact List page
    When i click in the first more info button
    Then the field "Guid" should be in the right format

  Scenario: Check Guid Format
    Given I am on the Contact List page
    When i click in the first more info button
    Then the field "Guid" should be in the right format

  Scenario: Check Contact Name
    Given I am on the Contact List page
    When i click in the first more info button
    Then the field "contact_name" should exits

  Scenario: Check Given Name
    Given I am on the Contact List page
    When i click in the first more info button
    Then the field "giveName" should exits

  Scenario: Check Sur Name
    Given I am on the Contact List page
    When i click in the first more info button
    Then the field "surName" should exits

  Scenario: Check Occupation
    Given I am on the Contact List page
    When i click in the first more info button
    Then the field "occupation" should exits

  Scenario: Check Street Address
    Given I am on the Contact List page
    When i click in the first more info button
    Then the field "streetAddress" should exits

  Scenario: Check City Address
    Given I am on the Contact List page
    When i click in the first more info button
    Then the field "city" should exits

  Scenario: Check Company
    Given I am on the Contact List page
    When i click in the first more info button
    Then the field "company" should exits

  Scenario: Check Photo Url
    Given I am on the Contact List page
    When i click in the first more info button
    Then the field "photourl" should be in the right format