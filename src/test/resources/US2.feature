Feature: Access to the Profile Page of a contact
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


  Scenario Outline: Check Given Name
    Given I am on the Contact List page
    When i click in the first more info button
    Then the field "<field>" should exits
    Examples:
    |field|
    |contact_name|
    |given_name_value|
    |surname_value  |
    |occupation_value|
    |street_address_value|
    |city_value|
    |company_value|



  Scenario: Check Photo Url
    Given I am on the Contact List page
    When i click in the first more info button
    Then the field "photourl" should be in the right format