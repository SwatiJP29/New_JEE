package com.smita.webdriver.locator;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

import com.smita.webdriver.util.ChromeDriverUtil;

public class LoginTest {

	public static void main(String[] args) throws InterruptedException {
		// get the Driver
		WebDriver driver = ChromeDriverUtil.getDriver();
		driver.get("http://www.gcrit.com/build3/admin/login.php");
		System.out.println("lets load the wesite with get method");
		driver.findElement(By.name("username")).sendKeys("abc");
		Thread.sleep(5000);
		driver.findElement(By.name("password")).sendKeys("abc");
		Thread.sleep(5000);
		driver.findElement(By.id("tdb1")).click();
		Thread.sleep(5000);
		String url = driver.getCurrentUrl();
		System.out.println("Current url is : "+url);
		if(url.equals("http://www.gcrit.com/build3/admin/login.php")){
			System.out.println("Login Passed");
		}else {
			System.out.println("Login Failed");
		}
	}
}
