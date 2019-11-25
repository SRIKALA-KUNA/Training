$(document).ready(function() {var formatter = new CucumberHTML.DOMFormatter($('.cucumber-report'));formatter.uri("homePage.feature");
formatter.feature({
  "line": 2,
  "name": "MMT home page feature",
  "description": "",
  "id": "mmt-home-page-feature",
  "keyword": "Feature",
  "tags": [
    {
      "line": 1,
      "name": "@homePage"
    }
  ]
});
formatter.scenario({
  "line": 3,
  "name": "MMT home page test scenario",
  "description": "",
  "id": "mmt-home-page-feature;mmt-home-page-test-scenario",
  "type": "scenario",
  "keyword": "Scenario"
});
formatter.step({
  "line": 4,
  "name": "user is opening home Page",
  "keyword": "Given "
});
formatter.step({
  "line": 5,
  "name": "title of home page",
  "keyword": "When "
});
formatter.step({
  "line": 6,
  "name": "verify navigation links",
  "keyword": "Then "
});
formatter.match({
  "location": "HomePageStepFeature.inHomePage()"
});
formatter.result({
  "duration": 10788188300,
  "status": "passed"
});
formatter.match({
  "location": "HomePageStepFeature.titleOfHomePage()"
});
formatter.result({
  "duration": 56043500,
  "status": "passed"
});
formatter.match({
  "location": "HomePageStepFeature.verifyNavigationLinks()"
});
formatter.result({
  "duration": 10311313200,
  "status": "passed"
});
});