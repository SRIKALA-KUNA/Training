package DriverUtilities;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.edge.EdgeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.ie.InternetExplorerDriver;



public class DriverFactory {
	WebDriver driver;
	public WebDriver getDriverInstance( String browser) {
		switch(browser) {
		case "chrome" : 
			System.setProperty("webdriver.chrome.driver", "./resources/chromedriver.exe");
			driver = new ChromeDriver();	
			break;

		case "firefox" :
			System.setProperty("webdriver.gecko.driver", "./resources/geckodriver.exe");
			driver = new FirefoxDriver();	
			break;

		case "edge" :
			System.setProperty("webdriver.edge.driver", "./resources/msedgedriver.exe");
			driver = new EdgeDriver();	
			break;

		case "internet explorer":
			System.setProperty("webdriver.ie.driver", "./resource/IEDriverServer.exe");
			driver = new InternetExplorerDriver();	
			break;
		default : System.setProperty("webdriver.chrome.driver", "./resources/chromedriver.exe");
		driver = new ChromeDriver();	
		}
		return driver;
	}		
}
