$(document).ready(function() {var formatter = new CucumberHTML.DOMFormatter($('.cucumber-report'));formatter.uri("US6.feature");
formatter.feature({
  "line": 1,
  "name": "Check possible duplicated Contacts Page",
  "description": "As a user\r\nI want to see the possible duplicated contacts\r\nSo that I can decide if they are the same Contact",
  "id": "check-possible-duplicated-contacts-page",
  "keyword": "Feature"
});
formatter.before({
  "duration": 2260047803,
  "status": "passed"
});
formatter.before({
  "duration": 1535708772,
  "status": "passed"
});
formatter.before({
  "duration": 1523293164,
  "status": "passed"
});
formatter.before({
  "duration": 1518469671,
  "status": "passed"
});
formatter.before({
  "duration": 1966148737,
  "status": "passed"
});
formatter.before({
  "duration": 1101236899,
  "status": "passed"
});
formatter.scenario({
  "comments": [
    {
      "line": 7,
      "value": "#  Scenario: Check for each group if some field is similar for all the group -6US"
    },
    {
      "line": 8,
      "value": "#    Given I am on the duplicate page and there is some group of duplicates -6US"
    },
    {
      "line": 9,
      "value": "#    Then For each group of possible duplicates, you must have at least one similar field in all possible duplicates -6US"
    },
    {
      "line": 10,
      "value": "#"
    },
    {
      "line": 11,
      "value": "#  Scenario: Check if every group have at least 2 contacts -6US"
    },
    {
      "line": 12,
      "value": "#    Given I am on the duplicate page and there is some group of duplicates -6US"
    },
    {
      "line": 13,
      "value": "#    Then every group of duplicate should contain at least 2 contacts -6US"
    },
    {
      "line": 14,
      "value": "#"
    },
    {
      "line": 15,
      "value": "#  Scenario: Check if Total of possible duplicated contacts is right -6US"
    },
    {
      "line": 16,
      "value": "#    Given I am on the duplicate page and there is some group of duplicates -6US"
    },
    {
      "line": 17,
      "value": "#    Then the Total of possible duplicated contacts must be consistent to the total groups in list -6US"
    },
    {
      "line": 19,
      "value": "# \u003d\u003d\u003d\u003d\u003d\u003d\u003d\u003d\u003d\u003d\u003d\u003d\u003d\u003d\u003d\u003d\u003d\u003d\u003d\u003d"
    },
    {
      "line": 21,
      "value": "#  Scenario: Check if when i uncheck every checkbox of a group the label Group change to Separate"
    },
    {
      "line": 22,
      "value": "#    Given I am on the duplicate page and the first group of duplicate have every checkbox checked -6US"
    },
    {
      "line": 23,
      "value": "#    When I uncheck every checkbox of this first group -6US"
    },
    {
      "line": 24,
      "value": "#    Then The label \"Group\" should change to \"Separate\" -6US"
    },
    {
      "line": 25,
      "value": "#"
    },
    {
      "line": 26,
      "value": "#  Scenario: Check if when i uncheck checkbox and let only 1 checked of a group the label \"Group\" change to \"Separate\""
    },
    {
      "line": 27,
      "value": "#    Given I am on the duplicate page and the first group of duplicate have every checkbox checked -6US"
    },
    {
      "line": 28,
      "value": "#    When I uncheck checkbox but let one checked of this first group -6US"
    },
    {
      "line": 29,
      "value": "#    Then The label \"Group\" should change to \"Separate\" -6US"
    },
    {
      "line": 30,
      "value": "#"
    },
    {
      "line": 31,
      "value": "#  Scenario: Check if when i check every checkbox of a group the label \"Separate\" change to \"Group\""
    },
    {
      "line": 32,
      "value": "#    Given I am on the duplicate page and the first group of duplicate have every checkbox unchecked -6US"
    },
    {
      "line": 33,
      "value": "#    When I check at least 2 checkbox of this group -6US"
    },
    {
      "line": 34,
      "value": "#    Then The label \"Separate\" should change to \"Group\" -6US"
    },
    {
      "line": 35,
      "value": "#"
    },
    {
      "line": 36,
      "value": "#  Scenario: Check when i Separate 1 group of contacts the list decrease 1"
    },
    {
      "line": 37,
      "value": "#    Given I am on the duplicate page and the first group of duplicate have every checkbox checked -6US"
    },
    {
      "line": 38,
      "value": "#    When I uncheck every contacts of this group -6US"
    },
    {
      "line": 39,
      "value": "#    And I click on label Separate -6US"
    },
    {
      "line": 40,
      "value": "#    Then the list of groups on duplicate page should decrease 1 -6US"
    },
    {
      "line": 41,
      "value": "#"
    },
    {
      "line": 42,
      "value": "#  Scenario: Check when i Separate 1 group of contacts the total of duplicates decrease 1"
    },
    {
      "line": 43,
      "value": "#    Given I am on the duplicate page and the first group of duplicate have every checkbox checked -6US"
    },
    {
      "line": 44,
      "value": "#    When I uncheck every contacts of this group -6US"
    },
    {
      "line": 45,
      "value": "#    And I click on label Separate -6US"
    },
    {
      "line": 46,
      "value": "#    Then the total of contacts duplicated should decrease 1 -6US"
    },
    {
      "line": 47,
      "value": "#"
    },
    {
      "line": 48,
      "value": "#  Scenario: Check when i Group one group of duplicate i redirect to a form with title \"Contacts Form\""
    },
    {
      "line": 49,
      "value": "#    Given I am on the duplicate page and the first group of duplicate have every checkbox checked -6US"
    },
    {
      "line": 50,
      "value": "#    When I click on Group button of this first group -6US"
    },
    {
      "line": 51,
      "value": "#    Then page is redirected to a form with title \"Contacts Form\" -6US"
    },
    {
      "line": 53,
      "value": "#  Scenario: Check when i group one group of duplicate the field equals of this group appears on form"
    },
    {
      "line": 54,
      "value": "#    Given I am on the duplicate page and the first group of duplicate have every checkbox checked -6US"
    },
    {
      "line": 55,
      "value": "#    When I click on Group button of this first group -6US"
    },
    {
      "line": 56,
      "value": "#    Then the fields have to be on group page -6US"
    }
  ],
  "line": 58,
  "name": "Check when i group one group and on form i click on cancel button, the group is still there",
  "description": "",
  "id": "check-possible-duplicated-contacts-page;check-when-i-group-one-group-and-on-form-i-click-on-cancel-button,-the-group-is-still-there",
  "type": "scenario",
  "keyword": "Scenario"
});
formatter.step({
  "line": 59,
  "name": "I am on the duplicate page and the first group of duplicate have every checkbox checked -6US",
  "keyword": "Given "
});
formatter.step({
  "line": 60,
  "name": "I click on Group button of this first group -6US",
  "keyword": "When "
});
formatter.step({
  "line": 61,
  "name": "the form appears -6US",
  "keyword": "And "
});
formatter.step({
  "line": 62,
  "name": "I click on \"cancel\" button -6US",
  "keyword": "And "
});
formatter.step({
  "line": 63,
  "name": "i should be redirected to the \"Contacts Duplicate\" page and the first user should be the same -6US",
  "keyword": "Then "
});
formatter.match({
  "location": "US6StepsDef.iAmOnTheDuplicatePageAndTheFirstGroupOfDuplicateHaveEveryCheckboxChecked()"
});
formatter.result({
  "duration": 529540312,
  "status": "passed"
});
formatter.match({
  "location": "US6StepsDef.iClickOnGroupButtonOfThisFirstGroup()"
});
formatter.result({
  "duration": 1798862188,
  "status": "passed"
});
formatter.match({
  "location": "US6StepsDef.theFormAppearsUS()"
});
formatter.result({
  "duration": 2788295,
  "status": "passed"
});
formatter.match({
  "arguments": [
    {
      "val": "cancel",
      "offset": 12
    }
  ],
  "location": "US6StepsDef.iClickOnButtonUS(String)"
});
formatter.result({
  "duration": 276860107,
  "status": "passed"
});
formatter.match({
  "arguments": [
    {
      "val": "Contacts Duplicate",
      "offset": 31
    }
  ],
  "location": "US6StepsDef.iShouldBeRedirectedToThePageAndTheFirstUserShouldBeTheSameUS(String)"
});
formatter.result({
  "duration": 85388952,
  "status": "passed"
});
formatter.after({
  "duration": 537612253,
  "status": "passed"
});
formatter.after({
  "duration": 534058888,
  "status": "passed"
});
formatter.after({
  "duration": 532674150,
  "status": "passed"
});
formatter.after({
  "duration": 544855404,
  "status": "passed"
});
formatter.after({
  "duration": 542896756,
  "status": "passed"
});
formatter.after({
  "duration": 542913006,
  "status": "passed"
});
formatter.before({
  "duration": 1552691282,
  "status": "passed"
});
formatter.before({
  "duration": 1664739664,
  "status": "passed"
});
formatter.before({
  "duration": 1699824277,
  "status": "passed"
});
formatter.before({
  "duration": 4665466246,
  "status": "passed"
});
formatter.before({
  "duration": 1526274329,
  "status": "passed"
});
formatter.before({
  "duration": 1209161429,
  "status": "passed"
});
formatter.scenario({
  "line": 65,
  "name": "Check when i group one group and on form i submit the group isnt there anymore",
  "description": "",
  "id": "check-possible-duplicated-contacts-page;check-when-i-group-one-group-and-on-form-i-submit-the-group-isnt-there-anymore",
  "type": "scenario",
  "keyword": "Scenario"
});
formatter.step({
  "line": 66,
  "name": "I am on the duplicate page and the first group of duplicate have every checkbox checked -6US",
  "keyword": "Given "
});
formatter.step({
  "line": 67,
  "name": "I click on Group button of this first group -6US",
  "keyword": "When "
});
formatter.step({
  "line": 68,
  "name": "the form appears -6US",
  "keyword": "And "
});
formatter.step({
  "line": 69,
  "name": "I click on \"submit\" button -6US",
  "keyword": "And "
});
formatter.step({
  "line": 70,
  "name": "i should be redirected to the \"Contacts Duplicate\" page and the first user shouldnt be the same -6US",
  "keyword": "Then "
});
formatter.match({
  "location": "US6StepsDef.iAmOnTheDuplicatePageAndTheFirstGroupOfDuplicateHaveEveryCheckboxChecked()"
});
formatter.result({
  "duration": 366213397,
  "status": "passed"
});
formatter.match({
  "location": "US6StepsDef.iClickOnGroupButtonOfThisFirstGroup()"
});
formatter.result({
  "duration": 1740783126,
  "status": "passed"
});
formatter.match({
  "location": "US6StepsDef.theFormAppearsUS()"
});
formatter.result({
  "duration": 1278254,
  "status": "passed"
});
formatter.match({
  "arguments": [
    {
      "val": "submit",
      "offset": 12
    }
  ],
  "location": "US6StepsDef.iClickOnButtonUS(String)"
});
formatter.result({
  "duration": 553590207,
  "status": "passed"
});
formatter.match({
  "arguments": [
    {
      "val": "Contacts Duplicate",
      "offset": 31
    }
  ],
  "location": "US6StepsDef.iShouldBeRedirectedToThePageAndTheFirstUserShouldntBeTheSameUS(String)"
});
formatter.result({
  "duration": 87412177,
  "status": "passed"
});
formatter.after({
  "duration": 536863006,
  "status": "passed"
});
formatter.after({
  "duration": 536793299,
  "status": "passed"
});
formatter.after({
  "duration": 537350957,
  "status": "passed"
});
formatter.after({
  "duration": 532422262,
  "status": "passed"
});
formatter.after({
  "duration": 537296646,
  "status": "passed"
});
formatter.after({
  "duration": 554720920,
  "status": "passed"
});
});