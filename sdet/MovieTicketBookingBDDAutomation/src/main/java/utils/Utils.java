package utils;

import java.io.File;
import java.io.IOException;
import java.text.DateFormat;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.Properties;
import java.util.Set;
import java.util.concurrent.TimeUnit;
import org.apache.log4j.Logger;
import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.io.FileHandler;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import base.Base;

public class Utils {
	WebDriver driver;
	static File source;
	String browser;
	static JavascriptExecutor javaScript;
	static Base base = new Base();
	static Properties  prop = base.initProperties();
	static WebDriverWait wait;
	public static Logger logger = Logger.getLogger(Utils.class.getName());
	public static final String TITLE_OF_MOVIE_PAGE = prop.getProperty("moviePage.title");
	public static final String TITLE_OF_LOCATION_PAGE = prop.getProperty("locationPage.title");
	public static final String BASE_URL = prop.getProperty("base.url");
	public static final String TITLE_OF_THEATRE_PAGE = prop.getProperty("theaterPage.title");
	public static final String TITLE_OF_LOGIN_PAGE = prop.getProperty("loginPage.title");
	public static final String TITLE_OF_DATE_PAGE = prop.getProperty("datePage.title");
	public static final String TITLE_OF_TIME_PAGE = prop.getProperty("timePage.title");
	public Utils() 
	{
		browser = prop.getProperty("browser");
	}
	public static WebDriver nextWindow(WebDriver driver)
	{
		Set<String> windowHandles = driver.getWindowHandles();
		for(String winHandle : windowHandles){
			driver.switchTo().window(winHandle);
		}
		return driver;
	}

	public void dynamicXpath(WebDriver driver, String typeOfElement,String name)
	{
		switch(typeOfElement)
		{
		case "xpath": 
			if(isElementPresent(driver.findElement(By.xpath(prop.getProperty(name)))))
			{
				driver.findElement(By.xpath(prop.getProperty(name))).click();
			}
			else
			{
				wait(driver);
				wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath(prop.getProperty(name))));
				driver.findElement(By.xpath(prop.getProperty(name))).click();
			}
			break;
		case "id":
			if(isElementPresent(driver.findElement(By.id(prop.getProperty(name)))))
			{
				driver.findElement(By.id(prop.getProperty(name))).click();
			}
			else
			{
				wait(driver);
				wait.until(ExpectedConditions.visibilityOfElementLocated(By.id(prop.getProperty(name))));
				driver.findElement(By.id(prop.getProperty(name))).click();
			}
			break;
		}
	}
	public static void takeScreenShot(WebDriver driver) throws IOException
	{
		String screenShotPath= prop.getProperty("screenShotFolderPath")
				+getCurrentDateTime()+".png";
		TakesScreenshot screenShot = (TakesScreenshot)driver;
		source = screenShot.getScreenshotAs(OutputType.FILE);
		FileHandler.copy(source, new File(screenShotPath));
	} 

	public static String getCurrentDateTime() {
		DateFormat format=new SimpleDateFormat("MM_dd_yyyy_HH_mm_ss");
		Date date=new Date();
		return format.format(date);
	}


	public static  void wait(WebDriver driver)
	{
		//driver.manage().timeouts().implicitlyWait(3, TimeUnit.SECONDS);
		 wait=new WebDriverWait(driver, 20);
	}

	public static void wait(int time) throws InterruptedException
	{
		Thread.sleep(time *(long)1000);
	}

	public static Actions getActions(WebDriver driver)
	{
		return  new Actions(driver);
	}
	public static WebDriver navigateBack(WebDriver driver)
	{
		driver.navigate().back();
		return driver;

	}
	public static WebDriver refreshPage(WebDriver driver)
	{
		driver.navigate().refresh();
		return driver;

	}

	public static void scroll (WebDriver driver)
	{
		javaScript = (JavascriptExecutor) driver;
		javaScript.executeScript("window.scrollBy(0,2000)");
	}


	public static void sendKeys(WebElement element, String data) {
		if(isElementPresent(element))
		{
			element.sendKeys(data);
		}
		else
		{
			logger.info("web element is not present");
		}
	}

	public static void clickOn(WebElement element) {
		if(isElementPresent(element))
		{
			element.click();	
		}
		else
		{
			logger.info("web element is not present");
		}
	}
	private static boolean isElementPresent(WebElement element) {
		if(element.isDisplayed())
			return true;

		return false;		
	}
}
