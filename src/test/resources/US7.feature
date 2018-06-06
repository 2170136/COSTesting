Feature: Check not duplicated contacts Page
  As a user
  I want to see the not duplicated contacts
  So that I can export contacts

  Scenario: Check if the total contacts on duplicate page is equal or lower than the total on the landing page
    Given I am on the "Not duplicate" page -7US
    And i know the total of contacts in landing page -7US
    Then the total contacts on duplicate page is equal or lower than the total on the landing page -7US


 # Os testes abaixo não foram automatizados

#  Scenario: When i click on export contacts button it should export a csv file
#    Given I am on the "Not duplicate" page -7US
#    When I click on export contacts button -7US
#    Then It should export a csv file with the name contacts.csv to my download folder -7US

#  Scenario: When i open the csv file i should see an header with all fields and a line for each contact with respective information
#    Given I open the csv file exported -7US
#    Then i should see an header with all fields -7US
#    And for each contact a line with respective information -7US