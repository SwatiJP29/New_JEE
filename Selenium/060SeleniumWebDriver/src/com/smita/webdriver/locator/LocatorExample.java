package com.smita.webdriver.locator;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

import com.smita.webdriver.util.ChromeDriverUtil;

public class LocatorExample {

	public static void main(String[] args) throws InterruptedException {
		//get the driver
		WebDriver driver = ChromeDriverUtil.getDriver();
		driver.get("file:\\C:\\Users\\Administrator\\Documents\\GitHub\\New_JEE\\Selenium\\060SeleniumWebDriver\\src\\Locators.html");
		//lets locate the web element
		WebElement webElement = driver.findElement(By.id("user"));
		Thread.sleep(5000);
		webElement.sendKeys("10");
		Thread.sleep(5000);
		webElement.findElement(By.name("name")).sendKeys("Swati");
		Thread.sleep(5000);
		webElement.findElement(By.linkText("How to use locators?"));
		Thread.sleep(5000);
		//^ - beginning of the text
		//$ - end of the text
		//* - any text
		driver.close();
	}

}