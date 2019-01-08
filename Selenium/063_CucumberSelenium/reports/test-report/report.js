$(document).ready(function() {var formatter = new CucumberHTML.DOMFormatter($('.cucumber-report'));formatter.uri('com\selenium\cucumber\login.feature');
formatter.feature({
  "line": 2,
  "name": "To test facebook login",
  "description": "",
  "id": "to-test-facebook-login",
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
  "id": "to-test-facebook-login;facebook-login-scenario",
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
  "name": "I enter username as \"TOM\"",
  "keyword": "When "
});
formatter.step({
  "line": 7,
  "name": "I enter password as \"JERRY\"",
  "keyword": "And "
});
formatter.step({
  "line": 8,
  "name": "Login should fail",
  "keyword": "Then "
});
formatter.match({
  "location": "LoginStepDefinition.I_am_on_Facebook_login_page()"
});
formatter.result({
  "duration": 3306631026,
  "status": "passed"
});
formatter.match({
  "arguments": [
    {
      "val": "TOM",
      "offset": 21
    }
  ],
  "location": "LoginStepDefinition.I_enter_username_as(String)"
});
formatter.result({
  "duration": 2126042772,
  "status": "passed"
});
formatter.match({
  "arguments": [
    {
      "val": "JERRY",
      "offset": 21
    }
  ],
  "location": "LoginStepDefinition.I_enter_password_as(String)"
});
formatter.result({
  "duration": 25693928943,
  "status": "passed"
});
formatter.match({
  "location": "LoginStepDefinition.Login_should_fail()"
});
formatter.result({
  "duration": 125276,
  "status": "passed"
});
});