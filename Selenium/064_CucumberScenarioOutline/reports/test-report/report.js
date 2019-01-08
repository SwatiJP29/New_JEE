$(document).ready(function() {var formatter = new CucumberHTML.DOMFormatter($('.cucumber-report'));formatter.uri('com\selenium\cucumber\outline.feature');
formatter.feature({
  "line": 2,
  "name": "scenario Outline to test facebook login",
  "description": "",
  "id": "scenario-outline-to-test-facebook-login",
  "keyword": "Feature",
  "tags": [
    {
      "line": 1,
      "name": "@smokeTest"
    }
  ]
});
formatter.scenario({
  "line": 3,
  "name": "facebook login scenario",
  "description": "",
  "id": "scenario-outline-to-test-facebook-login;facebook-login-scenario",
  "type": "scenario",
  "keyword": "Scenario"
});
formatter.step({
  "line": 5,
  "name": "I am on Facebook login page",
  "keyword": "Given "
});
formatter.step({
  "line": 6,
  "name": "I enter Username as \"\u003cusername\u003e\"",
  "keyword": "When "
});
formatter.step({
  "line": 7,
  "name": "Password as \"\u003cpassword\u003e\"",
  "keyword": "And "
});
formatter.step({
  "line": 8,
  "name": "Login should fail",
  "rows": [
    {
      "cells": [
        "username",
        "password"
      ],
      "line": 9
    },
    {
      "cells": [
        "username1",
        "password1"
      ],
      "line": 10
    },
    {
      "cells": [
        "username2",
        "password2"
      ],
      "line": 11
    }
  ],
  "keyword": "Then "
});
formatter.match({});
formatter.result({
  "status": "undefined"
});
formatter.match({});
formatter.result({
  "status": "undefined"
});
formatter.match({});
formatter.result({
  "status": "undefined"
});
formatter.match({});
formatter.result({
  "status": "undefined"
});
});