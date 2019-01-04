package com.jpm.selenium.util;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;


public class ChromeUtil {
	public static WebDriver getDriver(){
		WebDriver driver = null;
		
		//Step 1
		String driverClassKey = "webdriver.chrome.driver";
		
		//step2 : driver path
		String driverPathValue = ".\\driver\\chromedriver.exe";
		
		//Step3 : Set the System class properties (K,V) (driverClassKey, druverPathValue)
		System.setProperty(driverClassKey, driverPathValue);
		
		//Step4 : set the capabilities of the Browser
		//driver = new FireFoxDriver();
		ChromeOptions options = new ChromeOptions();
		System.out.println("Trying to load Chrome Driver");
		driver = new ChromeDriver(options);
		return driver;
	}
}