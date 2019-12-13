package base;
import java.net.MalformedURLException;
import java.net.URL;
import java.io.FileInputStream;
import java.io.IOException;
import java.util.Properties;
import org.apache.log4j.Logger;
import org.apache.log4j.PropertyConfigurator;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.ie.InternetExplorerDriver;
import org.openqa.selenium.remote.DesiredCapabilities;
import org.openqa.selenium.remote.RemoteWebDriver;

public class Base {

	Properties prop;
	static ThreadLocal<WebDriver> tdriver = new ThreadLocal<WebDriver>();
	public static final String USERNAME = "srikalakuna1";
	public static final String AUTOMATE_KEY = "d6Nz1F8u6wVoVZABxYQe";
	public static final String URL = "https://" + USERNAME + ":" + AUTOMATE_KEY + "@hub-cloud.browserstack.com/wd/hub";
	static Logger logger = Logger.getLogger(Base.class.getName());
	public    WebDriver getDriver() 
	{
		WebDriver driver;
		prop = initProperties();
		driver = getLocalDriver();
		driver.manage().deleteAllCookies();
		driver.manage().window().fullscreen();
		tdriver.set(driver);
		PropertyConfigurator.configure("./log4j.properties");
		return driver;



	}
	public static WebDriver getRemoteDriver() throws MalformedURLException
	{
		WebDriver driver;
		DesiredCapabilities caps = new DesiredCapabilities();
		caps.setCapability("browser", "Chrome");
		caps.setCapability("browser_version", "72.0");
		caps.setCapability("os", "Windows");
		caps.setCapability("os_version", "10");
		caps.setCapability("resolution", "1024x768");
		caps.setCapability("name", "Bstack-[Java] Sample Test");
		System.setProperty("webdriver.chrome.driver",
				"./src/main/java/resources/chromedriver.exe" );
		driver = new RemoteWebDriver(new URL(URL), caps);
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
				"./src/main/java/resources/geckodriver.exe");
		driver =  new FirefoxDriver();

		break;

		case "ie": System.setProperty("webdriver.ie.driver",
				"./src/main/java/resources/IEDriverServer.exe");
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
				"./src/main/java/resources/chromedriver.exe");
		driver = new ChromeDriver();
		return driver;
	}

	public  Properties initProperties()
	{
		prop = new Properties();
		FileInputStream file;
		try {

			file = new FileInputStream("./src/main/java/resources/config.properties");
			prop.load(file);
		} catch (IOException  e) {
			logger.error(e.getMessage());
		}

		return prop;	
	}
	public static synchronized WebDriver getDriverInstance() {

		return tdriver.get();
	}




}
