package com.smita.webdriver.locator;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

import com.smita.webdriver.util.ChromeDriverUtil;

public class LocatorExample2 {

	public static void main(String[] args) throws InterruptedException {
		//get the driver
		WebDriver driver = ChromeDriverUtil.getDriver();
		System.out.println("loading http://demo.opencart.com/");
		driver.get("http://demo.opencart.com/");
		//lets locate the web element
		WebElement webElement = driver.findElement(By.name("search"));
		Thread.sleep(5000);
		webElement.sendKeys("phone");
		Thread.sleep(5000);
		webElement.findElement(By.className("input-group-btn")).click();
		Thread.sleep(5000);
		driver.close();
	}

}
