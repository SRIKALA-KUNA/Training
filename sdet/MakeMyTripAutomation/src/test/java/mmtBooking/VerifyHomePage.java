package mmtBooking;

import static org.testng.Assert.assertEquals;

import java.io.IOException;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.logging.Logger;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.devtools.Log;
import org.openqa.selenium.interactions.Actions;
import org.testng.annotations.AfterClass;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Test;

import com.epam.MakeMyTripAutomation.Settings;

import Page.HomePage;
import io.qameta.allure.Description;

public class VerifyHomePage  {
	WebDriver driver;
	Settings settings;
	Logger logger  = Logger.getLogger( VerifyHomePage.class.getName()); 

	private List<String> actual = new ArrayList<String>();
	private final List<String> expected = new ArrayList<String>(Arrays.asList("https://www.makemytrip.com/flights/",
			"https://www.makemytrip.com/hotels/",
			"https://www.makemytrip.com/homestays/",
			"https://www.makemytrip.com/holidays-india/",
			"https://www.makemytrip.com/railways/",
			"https://www.makemytrip.com/bus-tickets/",
			"https://www.makemytrip.com/cabs/",
			"https://www.makemytrip.com/visa/",
			"https://www.makemytrip.com/"));
	HomePage home;

	@BeforeClass
	void init()
	{
		settings = new Settings();

		this.driver = settings.getDriver();
		home = new HomePage(driver);
	}
	@Description("Home page Navigationbar automation")
	@Test
	void verifyNavigationBar()
	{

		driver.get(settings.baseUrl);

		actual = home.verifyNavigationBar();
		assertEquals(actual, expected );
	}
	@Description("Checking Home page BrokenLinks ")
	@Test
	void verifyBrokenLinks()
	{
		driver.get(settings.baseUrl);
		List<String> brokenLinks = home.verifyFooterLinks();
		for(String broken : brokenLinks)
		{
			System.out.println(broken);
		}

	}

	@Test
	void verifyMouseHower()
	{
		driver.get(settings.baseUrl);
		Actions action = new Actions(driver);
		action.moveToElement(driver.findElement(By.xpath("//ul[@class ='makeFlex font12']/li[10]"))).build().perform();
	}



	@Test
	void verifyMoreOptions() 
	{
		driver.get(settings.baseUrl);
		String actual;
		try {
			actual = home.verifyDeals();
			assertEquals(actual,"https://www.makemytrip.com/daily-deals/");
		} catch (InterruptedException e) {
			e.printStackTrace();
		}

	}

	@AfterMethod
	public void screenshot()
	{
		try {
			Settings.screenShot(driver);
		} catch (IOException e) {

			e.printStackTrace();
		}
	}
}
