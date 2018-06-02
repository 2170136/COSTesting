Feature: Check possible duplicated Contacts Page
  As a user
  I want to see the possible duplicated contacts
  So that I can decide if they are the same Contact


  Scenario: Check for each group if some field is similar for all the group -6US
    Given I am on the duplicate page and there is some group of duplicates -6US
    Then For each group of possible duplicates, you must have at least one similar field in all possible duplicates -6US

  Scenario: Check if every group have at least 2 contacts -6US
    Given I am on the duplicate page and there is some group of duplicates -6US
    Then every group of duplicate should contain at least 2 contacts -6US

  Scenario: Check if Total of possible duplicated contacts is right -6US
    Given I am on the duplicate page and there is some group of duplicates -6US
    Then the Total of possible duplicated contacts must be consistent to the total groups in list -6US

    # ====================

  Scenario: Check if when i uncheck every checkbox of a group the label Group change to Separate
    Given I am on the duplicate page and the first group of duplicate have every checkbox checked
    When I uncheck every checkbox of this first group
    Then The label "Group" should change to "Separate"

  Scenario: Check if when i uncheck checkbox and let only 1 checked of a group the label "Group" change to "Separate"
    Given I am on the duplicate page and the first group of duplicate have every checkbox checked
    When I uncheck checkbox but let one checked of this first group
    Then The label "Group" should change to "Separate"

  Scenario: Check if when i check every checkbox of a group the label "Separate" change to "Group"
    Given I am on the duplicate page and the first group of duplicate have every checkbox unchecked
    When I check at least 2 checkbox of this group
    Then The label "Separate" should change to "Group"

  Scenario: Check when i Separate 1 group of contacts the list decrease 1
    Given I am on the duplicate page and the first group of duplicate have every checkbox checked
    When I uncheck every contacts of this group
    And I click on label Separate
    Then the list of groups on duplicate page should decrease 1

  Scenario: Check when i Separate 1 group of contacts the total of duplicates decrease 1
    Given I am on the duplicate page and the first group of duplicate have every checkbox checked
    When I uncheck every contacts of this group
    And I click on label Separate
    Then the total of contacts duplicated should decrease 1

  Scenario: Check when i Group one group of duplicate i redirect to a form with title "form contact"
    Given I am on the duplicate page and the first group of duplicate have every checkbox checked
    When I click on Group button of this first group
    Then page is redirected to a form with title "Contacts Form"