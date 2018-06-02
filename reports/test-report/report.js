$(document).ready(function() {var formatter = new CucumberHTML.DOMFormatter($('.cucumber-report'));formatter.uri("US6.feature");
formatter.feature({
  "line": 1,
  "name": "Check possible duplicated Contacts Page",
  "description": "As a user\r\nI want to see the possible duplicated contacts\r\nSo that I can decide if they are the same Contact",
  "id": "check-possible-duplicated-contacts-page",
  "keyword": "Feature"
});
formatter.before({
  "duration": 2980646585,
  "status": "passed"
});
formatter.before({
  "duration": 1942734761,
  "status": "passed"
});
formatter.before({
  "duration": 1933586846,
  "status": "passed"
});
formatter.before({
  "duration": 1936112134,
  "status": "passed"
});
formatter.before({
  "duration": 1508536586,
  "status": "passed"
});
formatter.before({
  "duration": 1842645681,
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
      "value": "#    Given I am on the duplicate page and the first group of duplicate have every checkbox checked"
    },
    {
      "line": 23,
      "value": "#    When I uncheck every checkbox of this first group"
    },
    {
      "line": 24,
      "value": "#    Then The label \"Group\" should change to \"Separate\""
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
      "value": "#    Given I am on the duplicate page and the first group of duplicate have every checkbox checked"
    },
    {
      "line": 28,
      "value": "#    When I uncheck checkbox but let one checked of this first group"
    },
    {
      "line": 29,
      "value": "#    Then The label \"Group\" should change to \"Separate\""
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
      "value": "#    Given I am on the duplicate page and the first group of duplicate have every checkbox unchecked"
    },
    {
      "line": 33,
      "value": "#    When I check at least 2 checkbox of this group"
    },
    {
      "line": 34,
      "value": "#    Then The label \"Separate\" should change to \"Group\""
    },
    {
      "line": 35,
      "value": "#"
    }
  ],
  "line": 36,
  "name": "Check when i Separate 1 group of contacts the list decrease 1",
  "description": "",
  "id": "check-possible-duplicated-contacts-page;check-when-i-separate-1-group-of-contacts-the-list-decrease-1",
  "type": "scenario",
  "keyword": "Scenario"
});
formatter.step({
  "line": 37,
  "name": "I am on the duplicate page and the first group of duplicate have every checkbox checked",
  "keyword": "Given "
});
formatter.step({
  "line": 38,
  "name": "I uncheck every contacts of this group",
  "keyword": "When "
});
formatter.step({
  "line": 39,
  "name": "I click on label Separate",
  "keyword": "And "
});
formatter.step({
  "line": 40,
  "name": "the list of groups on duplicate page should decrease 1",
  "keyword": "Then "
});
formatter.match({
  "location": "US6StepsDef.iAmOnTheDuplicatePageAndTheFirstGroupOfDuplicateHaveEveryCheckboxChecked()"
});
formatter.result({
  "duration": 563894495,
  "status": "passed"
});
formatter.match({
  "location": "US6StepsDef.iUncheckEveryContactsOfThisGroup()"
});
formatter.result({
  "duration": 249200824,
  "status": "passed"
});
formatter.match({
  "location": "US6StepsDef.iClickOnLabelSeparate()"
});
formatter.result({
  "duration": 1321291066,
  "status": "passed"
});
formatter.match({
  "arguments": [
    {
      "val": "1",
      "offset": 53
    }
  ],
  "location": "US6StepsDef.theListOfGroupsOnDuplicatePageShouldDecrease(int)"
});
formatter.result({
  "duration": 967810594,
  "error_message": "java.lang.AssertionError: Teste falhou! List of duplicate contacts not decrease\r\n\tat org.junit.Assert.fail(Assert.java:88)\r\n\tat org.junit.Assert.assertTrue(Assert.java:41)\r\n\tat US6StepsDef.theListOfGroupsOnDuplicatePageShouldDecrease(US6StepsDef.java:395)\r\n\tat ✽.Then the list of groups on duplicate page should decrease 1(US6.feature:40)\r\n",
  "status": "failed"
});
formatter.after({
  "duration": 540622071,
  "status": "passed"
});
formatter.after({
  "duration": 546513841,
  "status": "passed"
});
formatter.after({
  "duration": 542880932,
  "status": "passed"
});
formatter.after({
  "duration": 542471669,
  "status": "passed"
});
formatter.after({
  "duration": 546201654,
  "status": "passed"
});
formatter.after({
  "duration": 539355793,
  "status": "passed"
});
formatter.before({
  "duration": 1964889300,
  "status": "passed"
});
formatter.before({
  "duration": 1949697799,
  "status": "passed"
});
formatter.before({
  "duration": 1840663939,
  "status": "passed"
});
formatter.before({
  "duration": 2597649536,
  "status": "passed"
});
formatter.before({
  "duration": 1560860728,
  "status": "passed"
});
formatter.before({
  "duration": 1844047953,
  "status": "passed"
});
formatter.scenario({
  "line": 42,
  "name": "Check when i Separate 1 group of contacts the total of duplicates decrease 1",
  "description": "",
  "id": "check-possible-duplicated-contacts-page;check-when-i-separate-1-group-of-contacts-the-total-of-duplicates-decrease-1",
  "type": "scenario",
  "keyword": "Scenario"
});
formatter.step({
  "line": 43,
  "name": "I am on the duplicate page and the first group of duplicate have every checkbox checked",
  "keyword": "Given "
});
formatter.step({
  "line": 44,
  "name": "I uncheck every contacts of this group",
  "keyword": "When "
});
formatter.step({
  "line": 45,
  "name": "I click on label Separate",
  "keyword": "And "
});
formatter.step({
  "line": 46,
  "name": "the total of contacts duplicated should decrease 1",
  "keyword": "Then "
});
formatter.match({
  "location": "US6StepsDef.iAmOnTheDuplicatePageAndTheFirstGroupOfDuplicateHaveEveryCheckboxChecked()"
});
formatter.result({
  "duration": 473597375,
  "status": "passed"
});
formatter.match({
  "location": "US6StepsDef.iUncheckEveryContactsOfThisGroup()"
});
formatter.result({
  "duration": 225432752,
  "status": "passed"
});
formatter.match({
  "location": "US6StepsDef.iClickOnLabelSeparate()"
});
formatter.result({
  "duration": 1082464237,
  "status": "passed"
});
formatter.match({
  "arguments": [
    {
      "val": "1",
      "offset": 49
    }
  ],
  "location": "US6StepsDef.theTotalOfContactsDuplicatedShouldDecrease(int)"
});
formatter.result({
  "duration": 28581843071,
  "error_message": "java.lang.AssertionError: Teste falhou! List of dupplicate contacts not decrease\r\n\tat org.junit.Assert.fail(Assert.java:88)\r\n\tat org.junit.Assert.assertTrue(Assert.java:41)\r\n\tat US6StepsDef.theTotalOfContactsDuplicatedShouldDecrease(US6StepsDef.java:403)\r\n\tat ✽.Then the total of contacts duplicated should decrease 1(US6.feature:46)\r\n",
  "status": "failed"
});
formatter.after({
  "duration": 540428345,
  "status": "passed"
});
formatter.after({
  "duration": 534609705,
  "status": "passed"
});
formatter.after({
  "duration": 538553516,
  "status": "passed"
});
formatter.after({
  "duration": 537176903,
  "status": "passed"
});
formatter.after({
  "duration": 533766802,
  "status": "passed"
});
formatter.after({
  "duration": 539162494,
  "status": "passed"
});
formatter.before({
  "duration": 2198995700,
  "status": "passed"
});
formatter.before({
  "duration": 1827461878,
  "status": "passed"
});
formatter.before({
  "duration": 2166921761,
  "status": "passed"
});
formatter.before({
  "duration": 1986046553,
  "status": "passed"
});
formatter.before({
  "duration": 1424167157,
  "status": "passed"
});
formatter.before({
  "duration": 1989306548,
  "status": "passed"
});
formatter.scenario({
  "line": 48,
  "name": "Check when i Group one group of duplicate i redirect to a form with title \"form contact\"",
  "description": "",
  "id": "check-possible-duplicated-contacts-page;check-when-i-group-one-group-of-duplicate-i-redirect-to-a-form-with-title-\"form-contact\"",
  "type": "scenario",
  "keyword": "Scenario"
});
formatter.step({
  "line": 49,
  "name": "I am on the duplicate page and the first group of duplicate have every checkbox checked",
  "keyword": "Given "
});
formatter.step({
  "line": 50,
  "name": "I click on Group button of this first group",
  "keyword": "When "
});
formatter.step({
  "line": 51,
  "name": "page is redirected to a form with title \"Contacts Form\"",
  "keyword": "Then "
});
formatter.match({
  "location": "US6StepsDef.iAmOnTheDuplicatePageAndTheFirstGroupOfDuplicateHaveEveryCheckboxChecked()"
});
formatter.result({
  "duration": 382641242,
  "status": "passed"
});
formatter.match({
  "location": "US6StepsDef.iClickOnGroupButtonOfThisFirstGroup()"
});
formatter.result({
  "duration": 47074269558,
  "status": "passed"
});
formatter.match({
  "arguments": [
    {
      "val": "Contacts Form",
      "offset": 41
    }
  ],
  "location": "US6StepsDef.pageIsRedirectedToAFormWithTitle(String)"
});
formatter.result({
  "duration": 19147715,
  "error_message": "junit.framework.ComparisonFailure: expected:\u003cContacts [Form]\u003e but was:\u003cContacts [Duplicate]\u003e\r\n\tat junit.framework.Assert.assertEquals(Assert.java:100)\r\n\tat junit.framework.Assert.assertEquals(Assert.java:107)\r\n\tat junit.framework.TestCase.assertEquals(TestCase.java:269)\r\n\tat US6StepsDef.pageIsRedirectedToAFormWithTitle(US6StepsDef.java:441)\r\n\tat ✽.Then page is redirected to a form with title \"Contacts Form\"(US6.feature:51)\r\n",
  "status": "failed"
});
formatter.after({
  "duration": 537801703,
  "status": "passed"
});
formatter.after({
  "duration": 81591825,
  "status": "passed"
});
formatter.after({
  "duration": 543483923,
  "status": "passed"
});
formatter.after({
  "duration": 547978979,
  "status": "passed"
});
formatter.after({
  "duration": 547127094,
  "status": "passed"
});
formatter.after({
  "duration": 542154779,
  "status": "passed"
});
});