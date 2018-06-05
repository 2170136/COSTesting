Feature: Check not duplicated contacts Page
  As a user
  I want to see the not duplicated contacts
  So that I can export contacts

  Scenario: Check if the total contacts on duplicate page is equal or lower than the total on the landing page
    Given I am on the "Not duplicate" page -7US
    And i know the total of contacts in landing page -7US
    Then the total contacts on duplicate page is equal or lower than the total on the landing page -7US
