package com.smita.selenium.testNg;

import static org.testng.Assert.assertNotNull;
import static org.testng.Assert.assertNull;

import org.openqa.selenium.WebDriver;
import org.testng.annotations.AfterTest;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Test;

import com.smita.webdriver.util.ChromeDriverUtil;

public class FirstTestNg {

	String baseUrl = "https://www.twitter.com";
	WebDriver driver;
	@AfterTest
	public void terminateBrowser() throws InterruptedException {
		System.out.println("Trying to close the Browser ...");
		
		driver.close();
		Thread.sleep(2000);
		assertNull(driver, "Driver is open.. or already closed");
	}
	
	@BeforeTest
	public void launchBrowser() {
		System.out.println("Trying to launch the Chrome Driver...");
		driver = ChromeDriverUtil.getDriver();
		assertNotNull(driver, "Driver Not Loaded");
		System.out.println("driver loaded...."+driver);
	}

	@Test
	public void openWebSite() {
		System.out.println("Opening the Website.." + baseUrl);
		driver.get(baseUrl);
	}

	
}
