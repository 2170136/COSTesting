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
    Then the field "Guid" should exists -1US

  Scenario: Check Name exits
    Given I am on the Contact List page -1US
    Then the field "Name" should exists -1US

  Scenario: Check Actions exits
    Given I am on the Contact List page -1US
    Then the field "Actions" should exists -1US

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

#  Scenario: Landing page's and contact list returned is empty
#    Given I access the landing page of contacts -1US
#    Then the title of the page should be "Contacts not available" -1US
#    And the "Error in access Rest Contacts API" message should be displayed -1US


  Scenario: Check field Source exists
    Given I am on the Contact List page -1US
    Then the field "Source" should exists -1US

  Scenario Outline: Check if source labels change state when click on switch buttons
    Given I am on the Contact List page -1US
    When I switch the "<SwitchButton>" button -1US
    Then the "<SourceLabel>" label change state according to the "<SwitchButtonInput>" state -1US
    Examples:
      |SwitchButton|SourceLabel|SwitchButtonInput|
      |//label/span|facebook_filter|checkbox_facebook|
      |//label[2]/span|linkedin_filter|checkbox_linkedin|

  Scenario: Check if contacts have the source field filled in
    Given I am on the Contact List page -1US
    Then all contacts must have the source column filled in and and if they are valid -1US

  Scenario: Button Facebook and Button LinkedIn are switched on First Access Page
    Given I am on the Contact List page -1US
    Then Button Facebook and Button LinkedIn should be switched on -1US

  Scenario: Button Facebook turned off and no users from Facebook Should appear
    Given I am on the landing page and both buttons are on -1US
    When I switch off the Facebook Button -1US
    Then on list of users should only appears users that are not from Facebook Source -1US

  Scenario: Click on Label Facebook with both button ON
    Given I am on the landing page and both buttons are on -1US
    When I Click on Facebook Label -1US
    Then on list of users should only appears users from Facebook Source -1US
    And LinkedIn stays ON -1US

  Scenario: Button Facebook turned off and saved on session
    Given I am on the landing page and both buttons are on -1US
    When I switch off the Facebook Button -1US
    And i refresh the page -1US
    Then the Facebook button should be off -1US

  Scenario: Button Linkedin and Facebook turned off
    Given I am on the landing page and both buttons are on -1US
    When I Click on both Facebook and Linkedin Buttons -1US
    Then the list should not contains contacts -1US

  Scenario: Button Linkedin turned off and no users from Linkedin Should appear
    Given I am on the landing page and both buttons are on -1US
    When I switch off the Linkedin Button -1US
    Then on list of users should only appears users that are not from Linkedin Source -1US

  Scenario: Click on Label Linkedin with both button ON
    Given I am on the landing page and both buttons are on -1US
    When I Click on Linkedin Label -1US
    Then on list of users should only appears users from Linkedin Source -1US
    And Facebook stays ON -1US

  Scenario: Button Linkedin turned off and saved on session
    Given I am on the landing page and both buttons are on -1US
    When I switch off the Linkedin Button -1US
    And i refresh the page -1US
    Then the Linkedin button should be off -1US

