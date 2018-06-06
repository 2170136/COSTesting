$(document).ready(function() {var formatter = new CucumberHTML.DOMFormatter($('.cucumber-report'));formatter.uri("US6.feature");
formatter.feature({
  "line": 1,
  "name": "Check possible duplicated Contacts Page",
  "description": "As a user\r\nI want to see the possible duplicated contacts\r\nSo that I can decide if they are the same Contact",
  "id": "check-possible-duplicated-contacts-page",
  "keyword": "Feature"
});
formatter.scenarioOutline({
  "comments": [
    {
      "line": 6,
      "value": "#  Scenario: Check for each group if some field is similar for all the group -6US"
    },
    {
      "line": 7,
      "value": "#    Given I am on the duplicate page and there is some group of duplicates -6US"
    },
    {
      "line": 8,
      "value": "#    Then For each group of possible duplicates, you must have at least one similar field in all possible duplicates -6US"
    },
    {
      "line": 9,
      "value": "#"
    },
    {
      "line": 10,
      "value": "#  Scenario: Check if every group have at least 2 contacts -6US"
    },
    {
      "line": 11,
      "value": "#    Given I am on the duplicate page and there is some group of duplicates -6US"
    },
    {
      "line": 12,
      "value": "#    Then every group of duplicate should contain at least 2 contacts -6US"
    },
    {
      "line": 13,
      "value": "#"
    },
    {
      "line": 14,
      "value": "#  Scenario: Check if Total of possible duplicated contacts is right -6US"
    },
    {
      "line": 15,
      "value": "#    Given I am on the duplicate page and there is some group of duplicates -6US"
    },
    {
      "line": 16,
      "value": "#    Then the Total of possible duplicated contacts must be consistent to the total groups in list -6US"
    },
    {
      "line": 18,
      "value": "# \u003d\u003d\u003d\u003d\u003d\u003d\u003d\u003d\u003d\u003d\u003d\u003d\u003d\u003d\u003d\u003d\u003d\u003d\u003d\u003d"
    },
    {
      "line": 20,
      "value": "#  Scenario: Check if when i uncheck every checkbox of a group the label Group change to Separate"
    },
    {
      "line": 21,
      "value": "#    Given I am on the duplicate page and the first group of duplicate have every checkbox checked -6US"
    },
    {
      "line": 22,
      "value": "#    When I uncheck every checkbox of this first group -6US"
    },
    {
      "line": 23,
      "value": "#    Then The label \"Group\" should change to \"Separate\" -6US"
    },
    {
      "line": 24,
      "value": "#"
    },
    {
      "line": 25,
      "value": "#  Scenario: Check if when i uncheck checkbox and let only 1 checked of a group the label \"Group\" change to \"Separate\""
    },
    {
      "line": 26,
      "value": "#    Given I am on the duplicate page and the first group of duplicate have every checkbox checked -6US"
    },
    {
      "line": 27,
      "value": "#    When I uncheck checkbox but let one checked of this first group -6US"
    },
    {
      "line": 28,
      "value": "#    Then The label \"Group\" should change to \"Separate\" -6US"
    },
    {
      "line": 29,
      "value": "#"
    },
    {
      "line": 30,
      "value": "#  Scenario: Check if when i check every checkbox of a group the label \"Separate\" change to \"Group\""
    },
    {
      "line": 31,
      "value": "#    Given I am on the duplicate page and the first group of duplicate have every checkbox unchecked -6US"
    },
    {
      "line": 32,
      "value": "#    When I check at least 2 checkbox of this group -6US"
    },
    {
      "line": 33,
      "value": "#    Then The label \"Separate\" should change to \"Group\" -6US"
    },
    {
      "line": 34,
      "value": "#"
    },
    {
      "line": 35,
      "value": "#  Scenario: Check when i Separate 1 group of contacts the list decrease 1"
    },
    {
      "line": 36,
      "value": "#    Given I am on the duplicate page and the first group of duplicate have every checkbox checked -6US"
    },
    {
      "line": 37,
      "value": "#    When I uncheck every contacts of this group -6US"
    },
    {
      "line": 38,
      "value": "#    And I click on label Separate -6US"
    },
    {
      "line": 39,
      "value": "#    Then the list of groups on duplicate page should decrease 1 -6US"
    },
    {
      "line": 40,
      "value": "#"
    },
    {
      "line": 41,
      "value": "#  Scenario: Check when i Separate 1 group of contacts the total of duplicates decrease 1"
    },
    {
      "line": 42,
      "value": "#    Given I am on the duplicate page and the first group of duplicate have every checkbox checked -6US"
    },
    {
      "line": 43,
      "value": "#    When I uncheck every contacts of this group -6US"
    },
    {
      "line": 44,
      "value": "#    And I click on label Separate -6US"
    },
    {
      "line": 45,
      "value": "#    Then the total of contacts duplicated should decrease 1 -6US"
    },
    {
      "line": 46,
      "value": "#"
    },
    {
      "line": 47,
      "value": "#  Scenario: Check when i Group one group of duplicate i redirect to a form with title \"Contacts Form\""
    },
    {
      "line": 48,
      "value": "#    Given I am on the duplicate page and the first group of duplicate have every checkbox checked -6US"
    },
    {
      "line": 49,
      "value": "#    When I click on Group button of this first group -6US"
    },
    {
      "line": 50,
      "value": "#    Then page is redirected to a form with title \"Contacts Form\" -6US"
    },
    {
      "line": 51,
      "value": "#"
    },
    {
      "line": 52,
      "value": "#  Scenario: Check when i group one group of duplicate the field equals of this group appears on form"
    },
    {
      "line": 53,
      "value": "#    Given I am on the duplicate page and the first group of duplicate have every checkbox checked -6US"
    },
    {
      "line": 54,
      "value": "#    When I click on Group button of this first group -6US"
    },
    {
      "line": 55,
      "value": "#    Then the fields have to be on group page -6US"
    },
    {
      "line": 56,
      "value": "#"
    },
    {
      "line": 57,
      "value": "#  Scenario: Check when i group one group and on form i click on cancel button, the group is still there"
    },
    {
      "line": 58,
      "value": "#    Given I am on the duplicate page and the first group of duplicate have every checkbox checked -6US"
    },
    {
      "line": 59,
      "value": "#    When I click on Group button of this first group -6US"
    },
    {
      "line": 60,
      "value": "#    And the form appears -6US"
    },
    {
      "line": 61,
      "value": "#    And I click on \"cancel\" button -6US"
    },
    {
      "line": 62,
      "value": "#    Then i should be redirected to the \"Contacts Duplicate\" page and the first user should be the same -6US"
    },
    {
      "line": 63,
      "value": "#"
    },
    {
      "line": 64,
      "value": "#  Scenario: Check when i group one group and on form i submit the group isnt there anymore"
    },
    {
      "line": 65,
      "value": "#    Given I am on the duplicate page and the first group of duplicate have every checkbox checked -6US"
    },
    {
      "line": 66,
      "value": "#    When I click on Group button of this first group -6US"
    },
    {
      "line": 67,
      "value": "#    And the form appears -6US"
    },
    {
      "line": 68,
      "value": "#    And I click on \"submit\" button -6US"
    },
    {
      "line": 69,
      "value": "#    Then i should be redirected to the \"Contacts Duplicate\" page and the first user shouldnt be the same -6US"
    },
    {
      "line": 70,
      "value": "#"
    },
    {
      "line": 71,
      "value": "#  Scenario: Check when i separate all the duplicated contacts i\u0027m redirected to the Not duplicate page"
    },
    {
      "line": 72,
      "value": "#    Given I am on the \"Contacts Duplicate\" page and there is some groups to resolve -6US"
    },
    {
      "line": 73,
      "value": "#    When I separe all this groups -6US"
    },
    {
      "line": 74,
      "value": "#    Then i should be redirected to the \"Not duplicate\" page -6US"
    },
    {
      "line": 75,
      "value": "#"
    },
    {
      "line": 76,
      "value": "#  Scenario: Check when i group all the duplicated contacts i\u0027m redirected to the Not duplicate page"
    },
    {
      "line": 77,
      "value": "#    Given I am on the \"Contacts Duplicate\" page and there is some groups to resolve -6US"
    },
    {
      "line": 78,
      "value": "#    When I group all this groups -6US"
    },
    {
      "line": 79,
      "value": "#    Then i should be redirected to the \"Not duplicate\" page -6US"
    },
    {
      "line": 80,
      "value": "#"
    },
    {
      "line": 81,
      "value": "#  Scenario: Duplicate page\u0027s title and text contains \"Contacts Duplicate\""
    },
    {
      "line": 82,
      "value": "#    Given I am on the duplicate page and there is some group of duplicates -6US"
    },
    {
      "line": 83,
      "value": "#    Then the title of the page should be \"Contacts Duplicate\" -6US"
    },
    {
      "line": 84,
      "value": "#    And I can see the text \"Contacts Duplicate\" -6US"
    },
    {
      "line": 85,
      "value": "#"
    },
    {
      "line": 86,
      "value": "#  Scenario: On duplicate page i should see the total of duplicate contacts"
    },
    {
      "line": 87,
      "value": "#    Given I am on the duplicate page and there is some group of duplicates -6US"
    },
    {
      "line": 88,
      "value": "#    Then I can see the total of duplicate contacts -6US"
    }
  ],
  "line": 90,
  "name": "On duplicate page i should see a datable with header",
  "description": "",
  "id": "check-possible-duplicated-contacts-page;on-duplicate-page-i-should-see-a-datable-with-header",
  "type": "scenario_outline",
  "keyword": "Scenario Outline"
});
formatter.step({
  "line": 91,
  "name": "I am on the duplicate page and there is some group of duplicates -6US",
  "keyword": "Given "
});
formatter.step({
  "line": 92,
  "name": "I can see a datable with an header with \"\u003cfield\u003e\" field on position \"\u003cposition\u003e\"",
  "keyword": "Then "
});
formatter.examples({
  "line": 93,
  "name": "",
  "description": "",
  "id": "check-possible-duplicated-contacts-page;on-duplicate-page-i-should-see-a-datable-with-header;",
  "rows": [
    {
      "cells": [
        "field",
        "position"
      ],
      "line": 94,
      "id": "check-possible-duplicated-contacts-page;on-duplicate-page-i-should-see-a-datable-with-header;;1"
    },
    {
      "cells": [
        "Name",
        "1"
      ],
      "line": 95,
      "id": "check-possible-duplicated-contacts-page;on-duplicate-page-i-should-see-a-datable-with-header;;2"
    },
    {
      "cells": [
        "Surname",
        "2"
      ],
      "line": 96,
      "id": "check-possible-duplicated-contacts-page;on-duplicate-page-i-should-see-a-datable-with-header;;3"
    },
    {
      "cells": [
        "Email",
        "3"
      ],
      "line": 97,
      "id": "check-possible-duplicated-contacts-page;on-duplicate-page-i-should-see-a-datable-with-header;;4"
    },
    {
      "cells": [
        "Phone Number",
        "4"
      ],
      "line": 98,
      "id": "check-possible-duplicated-contacts-page;on-duplicate-page-i-should-see-a-datable-with-header;;5"
    },
    {
      "cells": [
        "Group",
        "5"
      ],
      "line": 99,
      "id": "check-possible-duplicated-contacts-page;on-duplicate-page-i-should-see-a-datable-with-header;;6"
    },
    {
      "cells": [
        "Action",
        "6"
      ],
      "line": 100,
      "id": "check-possible-duplicated-contacts-page;on-duplicate-page-i-should-see-a-datable-with-header;;7"
    }
  ],
  "keyword": "Examples"
});
formatter.before({
  "duration": 2820261844,
  "status": "passed"
});
formatter.before({
  "duration": 1496956395,
  "status": "passed"
});
formatter.before({
  "duration": 1363255481,
  "status": "passed"
});
formatter.before({
  "duration": 1477524712,
  "status": "passed"
});
formatter.before({
  "duration": 1482562460,
  "status": "passed"
});
formatter.before({
  "duration": 1180206864,
  "status": "passed"
});
formatter.before({
  "duration": 1169454820,
  "status": "passed"
});
formatter.scenario({
  "line": 95,
  "name": "On duplicate page i should see a datable with header",
  "description": "",
  "id": "check-possible-duplicated-contacts-page;on-duplicate-page-i-should-see-a-datable-with-header;;2",
  "type": "scenario",
  "keyword": "Scenario Outline"
});
formatter.step({
  "line": 91,
  "name": "I am on the duplicate page and there is some group of duplicates -6US",
  "keyword": "Given "
});
formatter.step({
  "line": 92,
  "name": "I can see a datable with an header with \"Name\" field on position \"1\"",
  "matchedColumns": [
    0,
    1
  ],
  "keyword": "Then "
});
formatter.match({
  "location": "US6StepsDef.Iamontheduplicatepageandthereissomegroupofduplicates()"
});
formatter.result({
  "duration": 399267260,
  "status": "passed"
});
formatter.match({
  "arguments": [
    {
      "val": "Name",
      "offset": 41
    },
    {
      "val": "1",
      "offset": 66
    }
  ],
  "location": "US6StepsDef.iCanSeeADatableWithAnHeaderWithFieldOnPosition(String,String)"
});
formatter.result({
  "duration": 36993242,
  "status": "passed"
});
formatter.after({
  "duration": 539217464,
  "status": "passed"
});
formatter.after({
  "duration": 546561544,
  "status": "passed"
});
formatter.after({
  "duration": 81567056,
  "status": "passed"
});
formatter.after({
  "duration": 539576692,
  "status": "passed"
});
formatter.after({
  "duration": 78082542,
  "status": "passed"
});
formatter.after({
  "duration": 533451850,
  "status": "passed"
});
formatter.after({
  "duration": 77309346,
  "status": "passed"
});
formatter.before({
  "duration": 1496823824,
  "status": "passed"
});
formatter.before({
  "duration": 1584799683,
  "status": "passed"
});
formatter.before({
  "duration": 1531039461,
  "status": "passed"
});
formatter.before({
  "duration": 1386663907,
  "status": "passed"
});
formatter.before({
  "duration": 1483407075,
  "status": "passed"
});
formatter.before({
  "duration": 1102750833,
  "status": "passed"
});
formatter.before({
  "duration": 1144237850,
  "status": "passed"
});
formatter.scenario({
  "line": 96,
  "name": "On duplicate page i should see a datable with header",
  "description": "",
  "id": "check-possible-duplicated-contacts-page;on-duplicate-page-i-should-see-a-datable-with-header;;3",
  "type": "scenario",
  "keyword": "Scenario Outline"
});
formatter.step({
  "line": 91,
  "name": "I am on the duplicate page and there is some group of duplicates -6US",
  "keyword": "Given "
});
formatter.step({
  "line": 92,
  "name": "I can see a datable with an header with \"Surname\" field on position \"2\"",
  "matchedColumns": [
    0,
    1
  ],
  "keyword": "Then "
});
formatter.match({
  "location": "US6StepsDef.Iamontheduplicatepageandthereissomegroupofduplicates()"
});
formatter.result({
  "duration": 214774033,
  "status": "passed"
});
formatter.match({
  "arguments": [
    {
      "val": "Surname",
      "offset": 41
    },
    {
      "val": "2",
      "offset": 69
    }
  ],
  "location": "US6StepsDef.iCanSeeADatableWithAnHeaderWithFieldOnPosition(String,String)"
});
formatter.result({
  "duration": 28449596,
  "status": "passed"
});
formatter.after({
  "duration": 536802081,
  "status": "passed"
});
formatter.after({
  "duration": 534960182,
  "status": "passed"
});
formatter.after({
  "duration": 557198550,
  "status": "passed"
});
formatter.after({
  "duration": 534001812,
  "status": "passed"
});
formatter.after({
  "duration": 535638439,
  "status": "passed"
});
formatter.after({
  "duration": 531843876,
  "status": "passed"
});
formatter.after({
  "duration": 539502281,
  "status": "passed"
});
formatter.before({
  "duration": 1435218312,
  "status": "passed"
});
formatter.before({
  "duration": 1431899299,
  "status": "passed"
});
formatter.before({
  "duration": 1372310171,
  "status": "passed"
});
formatter.before({
  "duration": 1372961914,
  "status": "passed"
});
formatter.before({
  "duration": 1365178635,
  "status": "passed"
});
formatter.before({
  "duration": 1074063034,
  "status": "passed"
});
formatter.before({
  "duration": 1077443629,
  "status": "passed"
});
formatter.scenario({
  "line": 97,
  "name": "On duplicate page i should see a datable with header",
  "description": "",
  "id": "check-possible-duplicated-contacts-page;on-duplicate-page-i-should-see-a-datable-with-header;;4",
  "type": "scenario",
  "keyword": "Scenario Outline"
});
formatter.step({
  "line": 91,
  "name": "I am on the duplicate page and there is some group of duplicates -6US",
  "keyword": "Given "
});
formatter.step({
  "line": 92,
  "name": "I can see a datable with an header with \"Email\" field on position \"3\"",
  "matchedColumns": [
    0,
    1
  ],
  "keyword": "Then "
});
formatter.match({
  "location": "US6StepsDef.Iamontheduplicatepageandthereissomegroupofduplicates()"
});
formatter.result({
  "duration": 229109806,
  "status": "passed"
});
formatter.match({
  "arguments": [
    {
      "val": "Email",
      "offset": 41
    },
    {
      "val": "3",
      "offset": 67
    }
  ],
  "location": "US6StepsDef.iCanSeeADatableWithAnHeaderWithFieldOnPosition(String,String)"
});
formatter.result({
  "duration": 28561641,
  "status": "passed"
});
formatter.after({
  "duration": 539454812,
  "status": "passed"
});
formatter.after({
  "duration": 535613634,
  "status": "passed"
});
formatter.after({
  "duration": 535070516,
  "status": "passed"
});
formatter.after({
  "duration": 553378328,
  "status": "passed"
});
formatter.after({
  "duration": 539769563,
  "status": "passed"
});
formatter.after({
  "duration": 75310497,
  "status": "passed"
});
formatter.after({
  "duration": 538042702,
  "status": "passed"
});
formatter.before({
  "duration": 1394982607,
  "status": "passed"
});
formatter.before({
  "duration": 1381815181,
  "status": "passed"
});
formatter.before({
  "duration": 1424288792,
  "status": "passed"
});
formatter.before({
  "duration": 1378896451,
  "status": "passed"
});
formatter.before({
  "duration": 2225596639,
  "status": "passed"
});
formatter.before({
  "duration": 1062563025,
  "status": "passed"
});
formatter.before({
  "duration": 1097199901,
  "status": "passed"
});
formatter.scenario({
  "line": 98,
  "name": "On duplicate page i should see a datable with header",
  "description": "",
  "id": "check-possible-duplicated-contacts-page;on-duplicate-page-i-should-see-a-datable-with-header;;5",
  "type": "scenario",
  "keyword": "Scenario Outline"
});
formatter.step({
  "line": 91,
  "name": "I am on the duplicate page and there is some group of duplicates -6US",
  "keyword": "Given "
});
formatter.step({
  "line": 92,
  "name": "I can see a datable with an header with \"Phone Number\" field on position \"4\"",
  "matchedColumns": [
    0,
    1
  ],
  "keyword": "Then "
});
formatter.match({
  "location": "US6StepsDef.Iamontheduplicatepageandthereissomegroupofduplicates()"
});
formatter.result({
  "duration": 215789708,
  "status": "passed"
});
formatter.match({
  "arguments": [
    {
      "val": "Phone Number",
      "offset": 41
    },
    {
      "val": "4",
      "offset": 74
    }
  ],
  "location": "US6StepsDef.iCanSeeADatableWithAnHeaderWithFieldOnPosition(String,String)"
});
formatter.result({
  "duration": 29439185,
  "status": "passed"
});
formatter.after({
  "duration": 537972140,
  "status": "passed"
});
formatter.after({
  "duration": 85577156,
  "status": "passed"
});
formatter.after({
  "duration": 547113644,
  "status": "passed"
});
formatter.after({
  "duration": 538280050,
  "status": "passed"
});
formatter.after({
  "duration": 545055351,
  "status": "passed"
});
formatter.after({
  "duration": 533796538,
  "status": "passed"
});
formatter.after({
  "duration": 546569669,
  "status": "passed"
});
formatter.before({
  "duration": 1407677906,
  "status": "passed"
});
formatter.before({
  "duration": 1365213274,
  "status": "passed"
});
formatter.before({
  "duration": 1532777442,
  "status": "passed"
});
formatter.before({
  "duration": 1429794393,
  "status": "passed"
});
formatter.before({
  "duration": 1445691528,
  "status": "passed"
});
formatter.before({
  "duration": 1057927269,
  "status": "passed"
});
formatter.before({
  "duration": 1328410765,
  "status": "passed"
});
formatter.scenario({
  "line": 99,
  "name": "On duplicate page i should see a datable with header",
  "description": "",
  "id": "check-possible-duplicated-contacts-page;on-duplicate-page-i-should-see-a-datable-with-header;;6",
  "type": "scenario",
  "keyword": "Scenario Outline"
});
formatter.step({
  "line": 91,
  "name": "I am on the duplicate page and there is some group of duplicates -6US",
  "keyword": "Given "
});
formatter.step({
  "line": 92,
  "name": "I can see a datable with an header with \"Group\" field on position \"5\"",
  "matchedColumns": [
    0,
    1
  ],
  "keyword": "Then "
});
formatter.match({
  "location": "US6StepsDef.Iamontheduplicatepageandthereissomegroupofduplicates()"
});
formatter.result({
  "duration": 216315293,
  "status": "passed"
});
formatter.match({
  "arguments": [
    {
      "val": "Group",
      "offset": 41
    },
    {
      "val": "5",
      "offset": 67
    }
  ],
  "location": "US6StepsDef.iCanSeeADatableWithAnHeaderWithFieldOnPosition(String,String)"
});
formatter.result({
  "duration": 31225490,
  "status": "passed"
});
formatter.after({
  "duration": 537631300,
  "status": "passed"
});
formatter.after({
  "duration": 538929654,
  "status": "passed"
});
formatter.after({
  "duration": 536257252,
  "status": "passed"
});
formatter.after({
  "duration": 540918666,
  "status": "passed"
});
formatter.after({
  "duration": 81619230,
  "status": "passed"
});
formatter.after({
  "duration": 545567251,
  "status": "passed"
});
formatter.after({
  "duration": 541633702,
  "status": "passed"
});
formatter.before({
  "duration": 1381089454,
  "status": "passed"
});
formatter.before({
  "duration": 1360178091,
  "status": "passed"
});
formatter.before({
  "duration": 1437303547,
  "status": "passed"
});
formatter.before({
  "duration": 1373606386,
  "status": "passed"
});
formatter.before({
  "duration": 1420625946,
  "status": "passed"
});
formatter.before({
  "duration": 1057907598,
  "status": "passed"
});
formatter.before({
  "duration": 1117738350,
  "status": "passed"
});
formatter.scenario({
  "line": 100,
  "name": "On duplicate page i should see a datable with header",
  "description": "",
  "id": "check-possible-duplicated-contacts-page;on-duplicate-page-i-should-see-a-datable-with-header;;7",
  "type": "scenario",
  "keyword": "Scenario Outline"
});
formatter.step({
  "line": 91,
  "name": "I am on the duplicate page and there is some group of duplicates -6US",
  "keyword": "Given "
});
formatter.step({
  "line": 92,
  "name": "I can see a datable with an header with \"Action\" field on position \"6\"",
  "matchedColumns": [
    0,
    1
  ],
  "keyword": "Then "
});
formatter.match({
  "location": "US6StepsDef.Iamontheduplicatepageandthereissomegroupofduplicates()"
});
formatter.result({
  "duration": 213479100,
  "status": "passed"
});
formatter.match({
  "arguments": [
    {
      "val": "Action",
      "offset": 41
    },
    {
      "val": "6",
      "offset": 68
    }
  ],
  "location": "US6StepsDef.iCanSeeADatableWithAnHeaderWithFieldOnPosition(String,String)"
});
formatter.result({
  "duration": 27944538,
  "status": "passed"
});
formatter.after({
  "duration": 537266513,
  "status": "passed"
});
formatter.after({
  "duration": 535259111,
  "status": "passed"
});
formatter.after({
  "duration": 536103297,
  "status": "passed"
});
formatter.after({
  "duration": 540162577,
  "status": "passed"
});
formatter.after({
  "duration": 559709299,
  "status": "passed"
});
formatter.after({
  "duration": 533588699,
  "status": "passed"
});
formatter.after({
  "duration": 546639376,
  "status": "passed"
});
formatter.uri("US7.feature");
formatter.feature({
  "line": 1,
  "name": "Check not duplicated contacts Page",
  "description": "As a user\r\nI want to see the not duplicated contacts\r\nSo that I can export contacts",
  "id": "check-not-duplicated-contacts-page",
  "keyword": "Feature"
});
formatter.before({
  "duration": 1391658890,
  "status": "passed"
});
formatter.before({
  "duration": 1414581503,
  "status": "passed"
});
formatter.before({
  "duration": 1704652348,
  "status": "passed"
});
formatter.before({
  "duration": 2066785668,
  "status": "passed"
});
formatter.before({
  "duration": 1418025391,
  "status": "passed"
});
formatter.before({
  "duration": 1293222218,
  "status": "passed"
});
formatter.before({
  "duration": 1146997493,
  "status": "passed"
});
formatter.scenario({
  "line": 6,
  "name": "Check if the total contacts on duplicate page is equal or lower than the total on the landing page",
  "description": "",
  "id": "check-not-duplicated-contacts-page;check-if-the-total-contacts-on-duplicate-page-is-equal-or-lower-than-the-total-on-the-landing-page",
  "type": "scenario",
  "keyword": "Scenario"
});
formatter.step({
  "line": 7,
  "name": "I am on the \"Not duplicate\" page -7US",
  "keyword": "Given "
});
formatter.step({
  "line": 8,
  "name": "i know the total of contacts in landing page -7US",
  "keyword": "And "
});
formatter.step({
  "line": 9,
  "name": "the total contacts on duplicate page is equal or lower than the total on the landing page -7US",
  "keyword": "Then "
});
formatter.match({
  "arguments": [
    {
      "val": "Not duplicate",
      "offset": 13
    }
  ],
  "location": "US7StepsDef.iAmOnThePageUS(String)"
});
formatter.result({
  "duration": 1773476,
  "status": "passed"
});
formatter.match({
  "location": "US7StepsDef.iKnowTheTotalOfContactsInLandingPageUS()"
});
formatter.result({
  "duration": 1013203350,
  "status": "passed"
});
formatter.match({
  "location": "US7StepsDef.theTotalContactsOnDuplicatePageIsEqualOrLowerThanTheTotalOnTheLandingPageUS()"
});
formatter.result({
  "duration": 32502,
  "status": "passed"
});
formatter.after({
  "duration": 104364795,
  "status": "passed"
});
formatter.after({
  "duration": 536288898,
  "status": "passed"
});
formatter.after({
  "duration": 542764844,
  "status": "passed"
});
formatter.after({
  "duration": 539347898,
  "status": "passed"
});
formatter.after({
  "duration": 537763017,
  "status": "passed"
});
formatter.after({
  "duration": 548305512,
  "status": "passed"
});
formatter.after({
  "duration": 547306943,
  "status": "passed"
});
});