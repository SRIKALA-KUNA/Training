package base;
import java.net.MalformedURLException;
import java.net.URL;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.net.URL;
import java.util.Properties;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.ie.InternetExplorerDriver;
import org.openqa.selenium.remote.DesiredCapabilities;
import org.openqa.selenium.remote.RemoteWebDriver;



public class Base {
	WebDriver driver;
	static Properties prop;
	public static ThreadLocal<WebDriver> tdriver = new ThreadLocal<WebDriver>();
	public static final String USERNAME = "srikalakuna1";
	public static final String AUTOMATE_KEY = "d6Nz1F8u6wVoVZABxYQe";
	public static final String URL = "https://" + USERNAME + ":" + AUTOMATE_KEY + "@hub-cloud.browserstack.com/wd/hub";
	public WebDriver getBrowser() throws MalformedURLException
	{
		prop = init_properties();
		if(prop.getProperty("driver").equalsIgnoreCase("remoteDriver")){
			DesiredCapabilities caps = new DesiredCapabilities();
			caps.setCapability("browser", "Chrome");
			caps.setCapability("browser_version", "72.0");
			caps.setCapability("os", "Windows");
			caps.setCapability("os_version", "10");
			caps.setCapability("resolution", "1024x768");
			caps.setCapability("name", "Bstack-[Java] Sample Test");
			System.setProperty("webdriver.chrome.driver",
					"./resource/chromedriver.exe" );
			driver = new RemoteWebDriver(new URL(URL), caps);



		}
		else
		{
			driver = getBrowserDriver();
		}
		driver.manage().deleteAllCookies();
		driver.manage().window().fullscreen();
		return this.driver;


	}
	public WebDriver getBrowserDriver()
	{
		String browser = prop.getProperty("browser");
		switch(browser)
		{
		case "chrome" :System.setProperty("webdriver.chrome.driver",
				"./resource/chromedriver.exe");
		driver = new ChromeDriver();
		break;

		case "firefox":System.setProperty("webdriver.gecko.driver",
				"./resource/geckodriver.exe");
		driver =  new FirefoxDriver();
		break;

		case "ie": System.setProperty("webdriver.ie.driver",
				"./resource/IEDriverServer.exe");
		driver = new InternetExplorerDriver();	
		break;

		default: 
			System.setProperty("webdriver.chrome.driver",
					".resource/chromedriver.exe");
			driver = new ChromeDriver();
			break;
		}
		return driver;
	}

	public  Properties init_properties()
	{
		prop = new Properties();
		FileInputStream file;
		try {
			
			file = new FileInputStream("./resource/config.properties");
			prop.load(file);
		} catch (IOException  e) {
			e.printStackTrace();
		}

		return prop;	
	}
	 public static synchronized WebDriver getDriver() {
	        return tdriver.get();
	    }



}
