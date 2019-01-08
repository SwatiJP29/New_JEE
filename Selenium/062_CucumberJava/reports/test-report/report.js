$(document).ready(function() {var formatter = new CucumberHTML.DOMFormatter($('.cucumber-report'));formatter.uri('com\selenium\cucumber\sample.feature');
formatter.feature({
  "line": 2,
  "name": "To Test my cucmber java application is running",
  "description": "",
  "id": "to-test-my-cucmber-java-application-is-running",
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
  "name": "cucumber scenario",
  "description": "",
  "id": "to-test-my-cucmber-java-application-is-running;cucumber-scenario",
  "type": "scenario",
  "keyword": "Scenario"
});
formatter.step({
  "line": 5,
  "name": "sample feature file is ready",
  "keyword": "Given "
});
formatter.step({
  "line": 6,
  "name": "I run the feature file",
  "keyword": "When "
});
formatter.step({
  "line": 7,
  "name": "run should be successful",
  "keyword": "Then "
});
formatter.match({
  "location": "StepDefinition.givenStatement()"
});
formatter.result({
  "duration": 123272511,
  "status": "passed"
});
formatter.match({
  "location": "StepDefinition.whenStatement()"
});
formatter.result({
  "duration": 56449,
  "status": "passed"
});
formatter.match({
  "location": "StepDefinition.thenStatement()"
});
formatter.result({
  "duration": 60374,
  "status": "passed"
});
});