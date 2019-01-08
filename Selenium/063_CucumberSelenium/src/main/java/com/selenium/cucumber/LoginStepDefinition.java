package com.selenium.cucumber;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;



import cucumber.annotation.en.Given;
import cucumber.annotation.en.Then;
import cucumber.annotation.en.When;


public class LoginStepDefinition {
	WebDriver driver = ChromeDriverUtil.getDriver();
	@Given("^I am on Facebook login page$")
	public void I_am_on_Facebook_login_page() throws InterruptedException {
		
		driver.get("https://www.facebook.com/login/");
	    System.out.println("Opening Facebook login Page .....");
	    Thread.sleep(2000);
	    
	    
	}

	@When("^I enter username as \"([^\"]*)\"$")
	public void I_enter_username_as(String arg1) throws InterruptedException {
	    System.out.println("Entering Username......");
	    
	    driver.findElement(By.xpath("//*[@id=\"email\"]")).sendKeys(arg1);
	    Thread.sleep(2000);
	 
	}

	@When("^I enter password as \"([^\"]*)\"$")
	public void I_enter_password_as(String arg1) throws InterruptedException {
		System.out.println("Entering Password......");
		
		driver.findElement(By.xpath("//*[@id=\"pass\"]")).sendKeys(arg1);
		Thread.sleep(2000);
		driver.findElement(By.id("loginbutton")).click();
		Thread.sleep(2000);
		
	}

	@Then("^Login should fail$")
	public void Login_should_fail() {
		System.out.println("Login failed as entered the wrong username and password");	}

}
