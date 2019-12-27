package driverhandler;

import java.io.FileInputStream;
import java.io.IOException;
import java.util.Properties;
import org.apache.log4j.Logger;
import org.apache.log4j.PropertyConfigurator;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.ie.InternetExplorerDriver;


public class Base {

	Properties prop;
	static Logger logger = Logger.getLogger(Base.class.getName());
	public    WebDriver getDriver() 
	{
		WebDriver driver;
		prop = initProperties();
		driver = getLocalDriver();
		driver.manage().deleteAllCookies();
		driver.manage().window().fullscreen();
		PropertyConfigurator.configure("./log4j.properties");
		return driver;
	}
	
	public  WebDriver getLocalDriver()
	{
		WebDriver driver;
		String browser = prop.getProperty("browser");
		switch(browser)
		{
		case "chrome" :

		driver = chromeDriver();

		break;

		case "firefox":System.setProperty("webdriver.gecko.driver",
				"./src/test/resources/drivers/geckodriver.exe");
		driver =  new FirefoxDriver();

		break;

		case "ie": System.setProperty("webdriver.ie.driver",
				"./src/test/resources/drivers/IEDriverServer.exe");
		driver = new InternetExplorerDriver();

		break;

		default: 
			driver = chromeDriver();

			break;
		}
		return driver;
	}
	public WebDriver chromeDriver() {
		WebDriver driver;
		System.setProperty("webdriver.chrome.driver",
				"./src/test/resources/drivers/chromedriver.exe");
		driver = new ChromeDriver();
		return driver;
	}

	public  Properties initProperties()
	{
		prop = new Properties();
		FileInputStream file;
		try {

			file = new FileInputStream("./src/test/resources/config.properties");
			prop.load(file);
		} catch (IOException  e) {
			logger.error(e.getMessage());
		}

		return prop;	
	}
	
}
