package mmtBooking;

import static org.testng.Assert.assertEquals;
import static org.testng.Assert.assertNotEquals;

import java.io.IOException;
import java.net.MalformedURLException;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.Properties;

import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.annotations.AfterClass;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.AfterTest;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Test;
import org.testng.asserts.SoftAssert;

import com.epam.MakeMyTripAutomation.Utils;

import base.Base;
import io.qameta.allure.Description;
import page.FlightDealsPage;
import page.FlightPage;
import page.Home;
import page.HomePage;

public class VerifyFlightBooking {
	WebDriver driver;
	Home home;
	List expectedListOfFlightPrices;
	List actualListOfFlightPrices;
	String expectedFlightPrice;
	String actualProgress;
	List<String> actual =new ArrayList();
	FlightPage flightPage;
	FlightDealsPage deals;
	SoftAssert softAssertion= new SoftAssert();

	Base base;
	Properties prop;
	@BeforeClass
	void init() throws MalformedURLException
	{
		base = new Base();
		prop= base.init_properties();
		this.driver = base.getBrowser();
		home = new Home(driver);
		flightPage = new FlightPage(driver);
		deals = new FlightDealsPage(driver , prop);

	}

	@Test
	public void Clickflight()
	{
		driver.get(Utils.baseUrl);
		home.flightLink();
		assertEquals(driver.getCurrentUrl(),prop.getProperty("flight.url"));

	}
	@Description("flight booking automation")
	@Test 
	public void verifyFlightBooking() throws InterruptedException 
	{
		Utils.wait(5);
		driver.get(Utils.baseFlightUrl);
		flightPage.verifyFlightdataEntry();
		try {
			flightPage.verifyFilters();
			expectedListOfFlightPrices = flightPage.bookTicketData();
			actualListOfFlightPrices = flightPage.bookTicketPage2();
			softAssertion.assertNotEquals(actualListOfFlightPrices,expectedListOfFlightPrices);
			actualProgress =flightPage.trackProgressBar(2);
			softAssertion.assertEquals("2",actualProgress);
			expectedFlightPrice = flightPage.bookTicketPage3();
			softAssertion.assertEquals(actualListOfFlightPrices.get(2),expectedFlightPrice);
			actualProgress =flightPage.trackProgressBar(3);
			softAssertion.assertEquals("3",actualProgress);
		} catch (InterruptedException e) {
			e.printStackTrace();
		}


	}
	@Description("flight booking automation through deals")
	@Test
	public void enterFlightDetailsThroughDeals() throws InterruptedException
	{
		Utils.wait(5);
		driver.get(Utils.baseDealsUrl);
		try {
			assertEquals(deals.enterFlightData().contains("flight"),true);
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