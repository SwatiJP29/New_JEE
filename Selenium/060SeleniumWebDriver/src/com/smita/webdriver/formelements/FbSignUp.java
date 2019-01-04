package com.smita.webdriver.formelements;

import java.util.List;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.Select;

import com.smita.webdriver.util.ChromeDriverUtil;

public class FbSignUp {

	public static void main(String[] args) throws InterruptedException {
		
		WebElement element;
		//Get the selenium Driver
		WebDriver driver = ChromeDriverUtil.getDriver();
		//Get the url you need to test
		driver.get("https://www.facebook.com"); 
		//Now test the elements one by one
		
		driver.findElement(By.xpath("//*[@id=\"u_0_j\"]")).sendKeys("Coding");;
		Thread.sleep(1000);
		driver.findElement(By.xpath("//*[@id=\"u_0_l\"]")).sendKeys("coding");;
		Thread.sleep(1000);
		driver.findElement(By.xpath("//*[@id=\"u_0_o\"]")).sendKeys("uhgtrenh@gmail.com");;
		Thread.sleep(1000);
		driver.findElement(By.xpath("//*[@id=\"u_0_r\"]")).sendKeys("uhgtrenh@gmail.com");
		Thread.sleep(1000);
		driver.findElement(By.xpath("//*[@id=\"u_0_v\"]")).sendKeys("java@123");
		Thread.sleep(1000);
		
		
		
		System.out.println("SElecting date");
		Select selectByIndex = new Select(driver.findElement(By.id("day")));
		selectByIndex.selectByIndex(10);
		Thread.sleep(1000);
		
		System.out.println("SElecting month");
		Select selectByValue = new Select(driver.findElement(By.id("month")));
		selectByValue.selectByVisibleText("Nov");
		Thread.sleep(1000);
		
		System.out.println("SElecting year");
		Select selectByVisible = new Select(driver.findElement(By.id("year")));
		selectByVisible.selectByValue("1980");
		
		List<WebElement> radioElem = driver.findElements(By.name("sex"));
		
		for(WebElement webElement : radioElem){
			String radioSelection;
			radioSelection = webElement.getAttribute("value").toString();
			if (radioSelection.equals("1")){
				webElement.click();
			}
		}
		
		driver.findElement(By.id("u_0_11")).click();
		Thread.sleep(2000);

	}

}