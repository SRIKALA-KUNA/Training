package utils;

import java.io.File;
import java.io.IOException;
import java.text.DateFormat;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.Properties;
import java.util.Set;
import java.util.concurrent.TimeUnit;


import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.ie.InternetExplorerDriver;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.io.FileHandler;

import base.Base;

public class Utils {
	WebDriver driver;
	static File source;
	String browser;
	static JavascriptExecutor javaScript;
	static Base base = new Base();
	static Properties  prop = base.init_properties();
	public static String titleOfMoviePage = prop.getProperty("movie.title");
	public static  String titleOfLocationPage = prop.getProperty("location.title");
	public static String baseUrl = prop.getProperty("base.url");
	public static String titleOfTheaterPage = prop.getProperty("theater.title");
	public static String homePageUrl = prop.getProperty("home.title");
	public static String titleOfLoginPage = prop.getProperty("login.title");
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
		driver.manage().timeouts().implicitlyWait(3, TimeUnit.SECONDS);
	}
	public static void wait(int time) throws InterruptedException
	{
		Thread.sleep(time *100);
	}

	public static Actions getActions(WebDriver driver)
	{
		Actions action = new Actions(driver);
		return action;
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
		element.sendKeys(data);

	}



	public static void clickOn(WebElement element) {
		element.click();

	}



}
