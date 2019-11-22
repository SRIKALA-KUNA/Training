package mmtBooking;

import static org.testng.Assert.assertEquals;

import java.io.IOException;
import java.net.MalformedURLException;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

import org.apache.log4j.Logger;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.interactions.Actions;
import org.testng.annotations.AfterClass;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Test;

import com.epam.MakeMyTripAutomation.Utils;

import base.Base;
import io.qameta.allure.Description;
import page.HomePage;

public class VerifyHomePage  {
	WebDriver driver;
	Base base;

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
			"https://www.makemytrip.com/gift-cards/?intid=Header_ch_giftcard"));
	HomePage home;

	@BeforeClass
	void init() throws MalformedURLException
	{
		base = new Base();
		this.driver = base.getBrowser();
		home = new HomePage(driver);
	}
	@Description("Home page Navigationbar automation")
	@Test
	void verifyNavigationLinks()
	{

		driver.get(Utils.baseUrl);

		try {
			actual = home.verifyNavigationLinks();
		} catch (InterruptedException e) {
			e.printStackTrace();
		}
		assertEquals(actual, expected );
	}
	@Description("Checking Home page BrokenLinks ")
	@Test
	void verifyBrokenLinks()
	{
		driver.get(Utils.baseUrl);
		List<String> brokenLinks = home.verifyFooterLinks();		
		logger.info(brokenLinks+"server problem");	
	}
	@Description("perform mouse hower")
	@Test
	void performMouseHower()
	{
		driver.get(Utils.baseUrl);
		home.performMouseHower();
	}


	@Description("verify more options")
	@Test
	void verifyMoreOptions() 
	{
		driver.get(Utils.baseUrl);
		String actual;
		try {
			actual = home.verifyDealsLink();
			assertEquals(actual,Utils.baseDealsUrl);
		} catch (InterruptedException e) {
			e.printStackTrace();
		}

	}
	@AfterClass
	public void close()
	{
		driver.close();
	}


}
