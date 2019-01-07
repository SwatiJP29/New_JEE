package com.smita.selenium.wait;

import java.time.LocalDateTime;
import java.util.concurrent.TimeUnit;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Test;

import com.smita.webdriver.util.ChromeDriverUtil;

public class ImplicitExplicitWait {
	
	WebDriver driver;
  @Test
  public void f() {
	  LocalDateTime startdate = LocalDateTime.now();
	  driver = ChromeDriverUtil.getDriver();
	  driver.get("http://demo.opencart.com/");
	  WebDriverWait wait = new WebDriverWait(driver, 10);
	  WebElement searchBox = wait.until(ExpectedConditions.visibilityOfElementLocated(By.name("search")));
	  searchBox.sendKeys("Phone");
	  
	  wait.until(ExpectedConditions.elementToBeClickable(By.className("input-group-btn"))).click();
	  driver.quit();
	  LocalDateTime enddate=LocalDateTime.now();
	  System.out.println(startdate.toString());
	  System.out.println(enddate.toString());
  }
  
  @BeforeTest
  public void setUp(){
	  driver = new ChromeDriverUtil().getDriver();
	  driver.get("http://gmail.com");
	  driver.manage().window().maximize();
	  driver.manage().deleteAllCookies();
	  driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
	  
  }
  
  
}
