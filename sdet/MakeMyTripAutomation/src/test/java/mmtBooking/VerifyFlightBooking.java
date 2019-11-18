package mmtBooking;

import static org.testng.Assert.assertEquals;
import static org.testng.Assert.assertNotEquals;

import java.io.IOException;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

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

import com.epam.MakeMyTripAutomation.Settings;

import Page.FlightDealsPage;
import Page.FlightPage;
import Page.Home;
import Page.HomePage;

public class VerifyFlightBooking  extends Settings{
	WebDriver driver;
	Home home;
	List expectedprice;
	List actualprice;
	String expectedprice1;
	String actualProgress;
	/*List<String> expected =new ArrayList<String>(Arrays.asList("? 44,862",
			"? 40,872",
			"? 21,226",
			"? 13,015"));*/
	List<String> actual =new ArrayList();
	FlightPage flightPage;
	FlightDealsPage flightDeals;

	@BeforeClass
	void init()
	{
		Settings settings = new Settings();
		this.driver = settings.getDriver();
		home = new Home(driver);
		flightPage = new FlightPage(driver);
		flightDeals = new FlightDealsPage(driver);

	}

	@Test
	public void Clickflight()
	{
		driver.get(baseUrl);
		home.flight();
		baseUrl = driver.getCurrentUrl();

	}

	@Test 
	public void verifyFlightBooking() throws InterruptedException 
	{
		Settings.sleep();
		driver.get(baseUrl);
		flightPage.verifyFlightdataEntry();
		try {
			actual =  flightPage.verifyFilters();
			expectedprice = flightPage.bookTicketData();
			actualprice = flightPage.bookTicketPage2();
			
			assertNotEquals(actualprice,expectedprice);
			actualProgress =flightPage.trackProgressBar(2);

			assertEquals("2",actualProgress);
			expectedprice1 = flightPage.bookTicketPage3();
			assertEquals(actualprice.get(2),expectedprice1);
			
			actualProgress =flightPage.trackProgressBar(3);
			assertEquals("3",actualProgress);
		} catch (InterruptedException e) {
			e.printStackTrace();
		}


	}

	@Test
	public void verifyFlightBookingThroughDeals() throws InterruptedException
	{
		Settings.sleep();
		driver.get(baseUrl_deals);
		try {
			flightDeals.verifyFlightDataEntryForDeals();
		} catch (InterruptedException e) {
			e.printStackTrace();
		}
	}
	
	@AfterTest
	public void screenshot()
	{
		try {
			
			Settings.screenShot(driver);
		} catch (IOException e) {

			e.printStackTrace();
		} 
	}
	@AfterClass
	void close()
	{
		driver.quit();
	}




}