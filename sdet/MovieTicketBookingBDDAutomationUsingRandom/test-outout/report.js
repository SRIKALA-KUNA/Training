$(document).ready(function() {var formatter = new CucumberHTML.DOMFormatter($('.cucumber-report'));formatter.uri("movieTicketBooking.feature");
formatter.feature({
  "line": 1,
  "name": "Movie ticket booking feature",
  "description": "",
  "id": "movie-ticket-booking-feature",
  "keyword": "Feature"
});
formatter.background({
  "line": 2,
  "name": "",
  "description": "",
  "type": "background",
  "keyword": "Background"
});
formatter.step({
  "line": 3,
  "name": "user opens application",
  "keyword": "Given "
});
formatter.match({
  "location": "MovieTicketBookingStepDefinition.opensApplication()"
});
formatter.result({
  "duration": 10037825300,
  "status": "passed"
});
formatter.scenario({
  "line": 48,
  "name": "Movie ticket booking date feature negative test scenario",
  "description": "",
  "id": "movie-ticket-booking-feature;movie-ticket-booking-date-feature-negative-test-scenario",
  "type": "scenario",
  "keyword": "Scenario",
  "tags": [
    {
      "line": 47,
      "name": "@date"
    }
  ]
});
formatter.step({
  "line": 49,
  "name": "user is in date page and clicks on next button",
  "rows": [
    {
      "cells": [
        "username",
        "password",
        "location",
        "movie",
        "theatre"
      ],
      "line": 50
    },
    {
      "cells": [
        "appy",
        "kumar",
        "Hyderabad",
        "Chichore",
        "INOX"
      ],
      "line": 51
    }
  ],
  "keyword": "When "
});
formatter.step({
  "line": 52,
  "name": "verify the user is in date Page",
  "keyword": "Then "
});
formatter.match({
  "location": "MovieTicketBookingStepDefinition.userIsInDatePageAndClickOnNextButton(DataTable)"
});
formatter.result({
  "duration": 13351072000,
  "status": "passed"
});
formatter.match({
  "location": "MovieTicketBookingStepDefinition.verifyTheUserIsInDatePage()"
});
formatter.result({
  "duration": 15722600,
  "error_message": "java.lang.AssertionError: expected [Select Date] but found [Error Occured]\r\n\tat org.testng.Assert.fail(Assert.java:97)\r\n\tat org.testng.Assert.assertEqualsImpl(Assert.java:136)\r\n\tat org.testng.Assert.assertEquals(Assert.java:118)\r\n\tat org.testng.Assert.assertEquals(Assert.java:575)\r\n\tat org.testng.Assert.assertEquals(Assert.java:585)\r\n\tat steps.MovieBookingStep.verifyTitleOfDatePage(MovieBookingStep.java:152)\r\n\tat stepdefinitions.MovieTicketBookingStepDefinition.verifyTheUserIsInDatePage(MovieTicketBookingStepDefinition.java:91)\r\n\tat ✽.Then verify the user is in date Page(movieTicketBooking.feature:52)\r\n",
  "status": "failed"
});
});