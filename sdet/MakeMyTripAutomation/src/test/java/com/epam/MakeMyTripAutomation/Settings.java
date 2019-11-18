package com.epam.MakeMyTripAutomation;

import java.io.File;
import java.io.IOException;
import java.text.DateFormat;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.Properties;
import java.util.Set;
import java.util.concurrent.TimeUnit;

import org.apache.logging.log4j.core.util.FileUtils;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.io.FileHandler;

import Base.Base;

public class Settings {
	WebDriver driver;
	static File source;
	static Properties  prop;
	
	protected String baseUrl_deals =prop.getProperty("baseUrl_deals");
	public static String baseUrl = prop.getProperty("baseUrl");
	public static String baseUrl_hotels =prop.getProperty("baseUrl_hotels");
	public Settings() 
	{
		 prop = Base.init_properties();
		System.setProperty(prop.getProperty("webDriver"),
				prop.getProperty("chrome"));

	}

	public   WebDriver getDriver() {
		driver = new ChromeDriver();
		driver.manage().deleteAllCookies();
		driver.manage().window().fullscreen();
		return this.driver;
	}

	public WebDriver nextWindow(WebDriver driver)
	{
		Set<String> windowHandles = driver.getWindowHandles();
		for(String winHandle : windowHandles){
			driver.switchTo().window(winHandle);
		}

		return driver;
	}

	public static void screenShot(WebDriver driver) throws IOException
	{
		String screenShotPath=prop.getProperty("screenShotFolderPath")
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
	public static void sleep() throws InterruptedException
	{
		Thread.sleep(500);
	}
	public static void longSleep() throws InterruptedException
	{
		Thread.sleep(2000);
	}

}
