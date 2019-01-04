package com.smita.webdriver.locator;

import java.util.List;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.Select;

import com.smita.webdriver.util.ChromeDriverUtil;

public class WorkingWithForms 
{

	public static void main(String[] args) throws InterruptedException
	{
		WebElement element;		
		//WebDriver driver = new FirefoxDriver();
		WebDriver driver= ChromeDriverUtil.getDriver();
		driver.get("file:\\C:\\Users\\Administrator\\Documents\\GitHub\\New_JEE\\Selenium\\060SeleniumWebDriver\\src\\WorkingWithForms.html");
		driver.manage().window().maximize();
		
		element = driver.findElement(By.id("txtUserName"));
        element.sendKeys("CG_Smita");
                
        driver.findElement(By.name("txtPwd")).sendKeys("cg@123");
                
        driver.findElement(By.className("Format")).sendKeys("cg@123");
                
        driver.findElement(By.cssSelector("Input.Format1")).sendKeys("Smita");
                
        driver.findElement(By.cssSelector("Input#txtLastName")).sendKeys("Kumar");
              
        List<WebElement> radioElem = driver.findElements(By.name("gender"));
        
        for(WebElement webElement : radioElem)
        {
        		String radioSelection;
        		radioSelection = webElement.getAttribute("value").toString();
        		if(radioSelection.equals("Female"))
        		{
        			webElement.click();
        		}
        }
        
      driver.findElement(By.cssSelector("#DOB")).sendKeys("12/12/2009");      
driver.findElement(By.cssSelector("#txtEmail"))
.sendKeys("smita.raje@capgemini.com");        
        driver.findElement(By.name("Address")).sendKeys("Mumbai");
        
        Select drpCity = new Select(driver.findElement(By.name("City")));
        drpCity.selectByIndex(1);
        drpCity.selectByValue("Mumbai");
        drpCity.selectByVisibleText("Bangalore");
        
        List<WebElement> checkElem = driver.findElements(By.name("chkHobbies"));
        
        for(WebElement webElement : checkElem)
        {
        		String checkSelection;
        		checkSelection = webElement.getAttribute("value").toString();
        		if(checkSelection.equalsIgnoreCase("Music"))
        		{
        			webElement.click();
        		}
        		     
        		if(checkSelection.equalsIgnoreCase("Reading"))
        		{
        			webElement.click();
        		}
        		if(checkSelection.equalsIgnoreCase("Movies"))
        		{
        			webElement.click();
        		}
        		     
        		try
        		{
        			Thread.sleep(500);
        		}
        		catch(InterruptedException ex)
        		{
        			System.out.println(ex.getMessage());
        		}	
        }
 
        
    }
     
	}