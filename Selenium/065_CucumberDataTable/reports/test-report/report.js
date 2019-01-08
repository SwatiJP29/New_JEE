$(document).ready(function() {var formatter = new CucumberHTML.DOMFormatter($('.cucumber-report'));formatter.uri('com\cucumber\datatable\datatable.feature');
formatter.feature({
  "line": 2,
  "name": "Data table",
  "description": "Verify that the new user registration is unsuccessful after passing incorrect inputs.",
  "id": "data-table",
  "keyword": "Feature",
  "tags": [
    {
      "line": 1,
      "name": "@smokeTest"
    }
  ]
});
formatter.scenario({
  "line": 4,
  "name": "",
  "description": "",
  "id": "data-table;",
  "type": "scenario",
  "keyword": "Scenario"
});
formatter.step({
  "line": 5,
  "name": "I am on the new user registration page",
  "keyword": "Given "
});
formatter.step({
  "line": 6,
  "name": "I enter invalid data on the page",
  "rows": [
    {
      "cells": [
        "Fields",
        "Values"
      ],
      "line": 7
    },
    {
      "cells": [
        "First Name",
        "Yoyo"
      ],
      "line": 8
    },
    {
      "cells": [
        "Last Name",
        "Honey Singh"
      ],
      "line": 9
    },
    {
      "cells": [
        "Email Address",
        "someone@someone.com"
      ],
      "line": 10
    },
    {
      "cells": [
        "Re-enter Email Address",
        "someone@someone.com"
      ],
      "line": 11
    },
    {
      "cells": [
        "Password",
        "Password1"
      ],
      "line": 12
    },
    {
      "cells": [
        "Birthdate",
        "01"
      ],
      "line": 13
    }
  ],
  "keyword": "When "
});
formatter.step({
  "line": 14,
  "name": "User registration should be unsuccessful",
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
});