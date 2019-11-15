package FlightBooking;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Test;

import com.epam.MakeMyTripAutomation.HomePage;

public class VerifyFlightBooking {
	WebDriver driver;
	Home home;
	static String baseUrl ="https://www.makemytrip.com/";
	@BeforeClass
	void init()
	{
		System.setProperty("webdriver.chrome.driver", "C:\\Users\\Srikala_Kuna\\eclipse-workspace\\MakeMyTripAutomation\\resource\\chromedriver.exe");
		driver = new ChromeDriver();
		home = new Home(driver);
	}
	
	@Test
	public void Clickflight()
	{
		driver.get(baseUrl);
		home.flight();
		baseUrl = driver.getCurrentUrl();
		
		
	}

}
