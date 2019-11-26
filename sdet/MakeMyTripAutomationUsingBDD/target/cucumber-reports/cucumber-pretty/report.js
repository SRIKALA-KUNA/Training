$(document).ready(function() {var formatter = new CucumberHTML.DOMFormatter($('.cucumber-report'));formatter.uri("login.feature");
formatter.feature({
  "line": 2,
  "name": "MMT login feature",
  "description": "",
  "id": "mmt-login-feature",
  "keyword": "Feature",
  "tags": [
    {
      "line": 1,
      "name": "@login"
    }
  ]
});
formatter.scenario({
  "line": 3,
  "name": "MMT login test scenario",
  "description": "",
  "id": "mmt-login-feature;mmt-login-test-scenario",
  "type": "scenario",
  "keyword": "Scenario"
});
formatter.step({
  "line": 4,
  "name": "user is opening login Page",
  "keyword": "Given "
});
formatter.step({
  "line": 5,
  "name": "verify title of login page",
  "keyword": "When "
});
formatter.step({
  "line": 6,
  "name": "user enters login details",
  "keyword": "Then "
});
formatter.step({
  "line": 7,
  "name": "close the browser",
  "keyword": "Then "
});
formatter.match({
  "location": "LoginStepFeature.user_opening_login_page()"
});
formatter.result({
  "duration": 11336068500,
  "status": "passed"
});
formatter.match({
  "location": "LoginStepFeature.verify_title_of_login_page()"
});
formatter.result({
  "duration": 505838200,
  "status": "passed"
});
formatter.match({
  "location": "LoginStepFeature.user_enters_login_details()"
});
formatter.result({
  "duration": 4121600500,
  "status": "passed"
});
formatter.match({
  "location": "LoginStepFeature.close()"
});
formatter.result({
  "duration": 4315475200,
  "status": "passed"
});
});