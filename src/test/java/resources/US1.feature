Feature: Access to the Contacts Orchestrator Solution's (COS) Landing Page
  As a user
  I want to access to the URL address provided for the landing page
  So that I can see the list of the contacts available
  Scenario: Landing page's title and text contains "Contacts Orchestrator Solution"
    Given I access the landing page of COS
    Then the title of the page should be "Contacts Orchestrator Solution"
    And I can see the text "Contacts Orchestrator Solution"


#  Scenario: Check Email Format
#    Given I am on the Contact List page
#    When i click in the first more info button
#    Then the field "email" should be in the right format
#
#  Scenario: Check Phone Format
#    Given I am on the Contact List page
#    When i click in the first more info button
#    Then the field "phone" should be in the right format
##
#  Scenario: Check Occupation Exists
#    Given I am on the Contact List page
#    When i click in the first more info button
#    Then the field Occupation should be in the right format
#
#  Scenario: Check Phone Format
#    Given I am on the Contact List page
#    When i click in the first more info button
#    Then the field Phone should be in the right format
#
 Scenario: Check Guid exits
    Given I am on the Contact List page
    Then the field "Guid" should exist
#
  Scenario: Check Name exits
    Given I am on the Contact List page
    Then the field "Name" should exist

  Scenario: Check Actions exits
    Given I am on the Contact List page
    Then the field "Actions" should exist

  Scenario: From the contacts list open a profile page
    Given I am on the Contact List page
    Then I click on the button more info
    And I can see the profile page