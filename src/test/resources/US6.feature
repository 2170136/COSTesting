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