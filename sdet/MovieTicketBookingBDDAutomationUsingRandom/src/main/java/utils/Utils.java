package utils;

import java.io.File;
import java.util.Properties;
import java.util.Set;
import org.apache.log4j.Logger;
import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import driverhandler.Base;


public class Utils {
	WebDriver driver;
	static File source;
	static JavascriptExecutor javaScript;
	static Base base = new Base();
	static Properties  prop = base.initProperties();
	static WebDriverWait wait;
	public static final Logger logger = Logger.getLogger(Utils.class.getName());
	
	
	public Utils(WebDriver driver)
	{
		this.driver = driver;		
	}
	public static WebDriver nextWindow(WebDriver driver)
	{
		Set<String> windowHandles = driver.getWindowHandles();
		for(String winHandle : windowHandles){
			driver.switchTo().window(winHandle);
		}
		return driver;
	}
	public  void sendKeys(WebElement element, String data) {
		if(isElementPresent(element))
		{
			element.sendKeys(data);
		}
		else
		{
			logger.info("web element is not present");
		}
	}

	public void clickOn(WebElement element) {
		if(isElementPresent(element))
		{
			element.click();	
		}
		else
		{
			logger.info("web element is not present");
		}
	}
	private  boolean isElementPresent(WebElement element) {
		//element.getSize()
		return element.isDisplayed();		
	}
	public void dynamicXpath(WebDriver driver, String typeOfElement,String name)
	{
		switch(typeOfElement)
		{
		case "xpath": 
			if(isElementPresent(driver.findElement(By.xpath(prop.getProperty(name)))))
			{
				clickOn(driver.findElement(By.xpath(prop.getProperty(name))));
			}
			else
			{
				waitForElement(driver);
				wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath(prop.getProperty(name))));
				clickOn(driver.findElement(By.xpath(prop.getProperty(name))));
			}
			break;
		case "id":
			if(isElementPresent(driver.findElement(By.id(prop.getProperty(name)))))
			{
				clickOn(driver.findElement(By.id(prop.getProperty(name))));
			}
			else
			{
				waitForElement(driver);
				wait.until(ExpectedConditions.visibilityOfElementLocated(By.id(prop.getProperty(name))));
				clickOn(driver.findElement(By.id(prop.getProperty(name))));
			}
			break;
		}
	}
	public static  void waitForElement(WebDriver driver)
	{
		 wait=new WebDriverWait(driver, 10);
	}

	public static void waitForSeconds(int time) throws InterruptedException
	{
		Thread.sleep(time *(long)1000);
	}
	public void closeTheBrowser()
	{
		driver.close();
	}
}
