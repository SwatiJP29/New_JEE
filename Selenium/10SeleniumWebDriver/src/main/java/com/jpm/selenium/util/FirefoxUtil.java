package com.jpm.selenium.util;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.remote.DesiredCapabilities;

public class FirefoxUtil {
	public static WebDriver getDriver(){
		WebDriver driver = null;
		
		//Step 1
		String driverClassKey = "webdriver.gecko.driver";
		
		//step2 : driver path
		String driverPathValue = ".\\driver\\geckodriver.exe";
		
		//Step3 : Set the System class properties (K,V) (driverClassKey, druverPathValue)
		System.setProperty(driverClassKey, driverPathValue);
		
		//Step4 : set the capabilities of the Browser
		//driver = new FireFoxDriver();
		DesiredCapabilities capabilities = DesiredCapabilities.firefox();
		driver = new FirefoxDriver(capabilities);
		return driver;
	}
}