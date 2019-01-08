package com.selenium.cucumber;

import cucumber.annotation.en.Given;
import cucumber.annotation.en.Then;
import cucumber.annotation.en.When;
import cucumber.table.DataTable;

public class SeleniumOutlineSteps {
	
	@Given("^I am on Facebook login page$")
	public void I_am_on_Facebook_login_page() {
	    // Express the Regexp above with the code you wish you had
	    
	}

	@When("^I enter Username as \"([^\"]*)\"$")
	public void I_enter_Username_as(String arg1) {
	    // Express the Regexp above with the code you wish you had
	    
	}

	@When("^Password as \"([^\"]*)\"$")
	public void Password_as(String arg1) {
	    // Express the Regexp above with the code you wish you had
	    
	}

	@Then("^Login should fail$")
	public void Login_should_fail(DataTable arg1) {
	    // Express the Regexp above with the code you wish you had
	    // For automatic conversion, change DataTable to List<YourType>
	    
	}

}
