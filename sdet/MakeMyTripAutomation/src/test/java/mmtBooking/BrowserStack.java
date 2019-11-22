package mmtBooking;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.remote.DesiredCapabilities;
import org.openqa.selenium.remote.RemoteWebDriver;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Test;

import page.Home;

import java.net.MalformedURLException;
import java.net.URL;

public class BrowserStack {
	WebDriver driver;
	public static final String USERNAME = "srikalakuna1";
	public static final String AUTOMATE_KEY = "d6Nz1F8u6wVoVZABxYQe";
	public static final String URL = "https://" + USERNAME + ":" + AUTOMATE_KEY + "@hub-cloud.browserstack.com/wd/hub";

	@BeforeClass()
	public void init() throws MalformedURLException
	{
		DesiredCapabilities caps = new DesiredCapabilities();
		caps.setCapability("browser", "Chrome");
		caps.setCapability("browser_version", "62.0");
		caps.setCapability("os", "Windows");
		caps.setCapability("os_version", "10");
		caps.setCapability("resolution", "1024x768");
		caps.setCapability("name", "Bstack-[Java] Sample Test");
		driver = new RemoteWebDriver(new URL(URL), caps); 
	}
	@Test
	void flightClicking() 
	{

		driver.get("https://www.makemytrip.com/");
		Home home = new Home(driver);
		home.flightLink();
		driver.quit();
	}

}
