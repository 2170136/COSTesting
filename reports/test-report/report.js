$(document).ready(function() {var formatter = new CucumberHTML.DOMFormatter($('.cucumber-report'));formatter.uri("US7.feature");
formatter.feature({
  "line": 1,
  "name": "Check not duplicated contacts Page",
  "description": "As a user\r\nI want to see the not duplicated contacts\r\nSo that I can export contacts",
  "id": "check-not-duplicated-contacts-page",
  "keyword": "Feature"
});
formatter.before({
  "duration": 2169317971,
  "status": "passed"
});
formatter.before({
  "duration": 1426121284,
  "status": "passed"
});
formatter.before({
  "duration": 1419165513,
  "status": "passed"
});
formatter.before({
  "duration": 1456152768,
  "status": "passed"
});
formatter.before({
  "duration": 1553305627,
  "status": "passed"
});
formatter.before({
  "duration": 1211462290,
  "status": "passed"
});
formatter.before({
  "duration": 1165092762,
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
  "duration": 121604330,
  "status": "passed"
});
formatter.match({
  "arguments": [
    {
      "val": "7",
      "offset": 46
    }
  ],
  "location": "US7StepsDef.iKnowTheTotalOfContactsInLandingPageUS(int)"
});
formatter.result({
  "duration": 788620674,
  "status": "passed"
});
formatter.match({
  "arguments": [
    {
      "val": "7",
      "offset": 91
    }
  ],
  "location": "US7StepsDef.theTotalContactsOnDuplicatePageIsEqualOrLowerThanTheTotalOnTheLandingPageUS(int)"
});
formatter.result({
  "duration": 79972,
  "status": "passed"
});
formatter.after({
  "duration": 83444024,
  "status": "passed"
});
formatter.after({
  "duration": 539260230,
  "status": "passed"
});
formatter.after({
  "duration": 534639442,
  "status": "passed"
});
formatter.after({
  "duration": 536101158,
  "status": "passed"
});
formatter.after({
  "duration": 535569587,
  "status": "passed"
});
formatter.after({
  "duration": 546881429,
  "status": "passed"
});
formatter.after({
  "duration": 536631020,
  "status": "passed"
});
});