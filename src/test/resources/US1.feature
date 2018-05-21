Feature: Access to the Contacts Orchestrator Solution's (COS) Landing Page
  As a user
  I want to access to the URL address provided for the landing page
  So that I can see the list of the contacts available
  Scenario: Landing page's title and text contains "Contacts Orchestrator Solution"
    Given I access the landing page of COS -1US
    Then the title of the page should be "Contacts Orchestrator Solution" -1US
    And I can see the text "Contacts Orchestrator Solution" -1US


 Scenario: Check Guid exits
    Given I am on the Contact List page -1US
    Then the field "Guid" should exist -1US

  Scenario: Check Name exits
    Given I am on the Contact List page -1US
    Then the field "Name" should exist -1US



  Scenario: Check Actions exits
    Given I am on the Contact List page -1US
    Then the field "Actions" should exist -1US

  Scenario: From the contacts list open a profile page
    Given I am on the Contact List page -1US
    Then I click on the button more info -1US
    And I can see the profile page -1US

  Scenario: From the contacts list open a profile page
    Given I am on the Contact List page -1US
    Then I click on the button more info -1US
    And The field "Guid" should be valid -1US

  Scenario: From the contacts list verify guid
    Given I am on the Contact List page -1US
    Then The fields "Guid" should be valid -1US

  Scenario: Landing page's and contact list returned is empty
    Given I access the landing page of contacts -1US
    Then the title of the page should be "Contacts not available" -1US
    And the "Error in access Rest Contacts API" message should be displayed -1US


  Scenario: Check Name exits
    Given I am on the Contact List page -1US
    Then the field "Source" should exist -1US

