package FlightBooking;

import static org.testng.Assert.assertEquals;
import static org.testng.Assert.assertNotEquals;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Test;

import com.epam.MakeMyTripAutomation.HomePage;

public class VerifyFlightBooking  extends Settings{
	WebDriver driver;
	Home home;
	List<String> expected =new ArrayList<String>(Arrays.asList("? 44,862",
			"? 40,872",
			"? 21,226",
			"? 13,015"));
	List<String> actual =new ArrayList();
	FlightPage flightPage;
	
	@BeforeClass
	void init()
	{
		Settings settings = new Settings();
		this.driver = settings.getDriver();
		home = new Home(driver);
		flightPage = new FlightPage(driver);
	}

	@Test
	public void Clickflight()
	{
		driver.get(baseUrl);
		home.flight();
		baseUrl = driver.getCurrentUrl();

	}

	@Test 
	public void verifyFlightBooking() 
	{
		driver.get(baseUrl);
		flightPage.verifyFlightdataEntry();
		try {
			actual =  flightPage.verifyFilters();
			expected.clear();
			String expectedprice = flightPage.bookTicketData();
			String actualprice = flightPage.bookTicketPage2();
			flightPage.trackProgressBar();
			//assertEquals(Integer.parseInt(actual.get(0)), Integer.parseInt(expected.get(0)+5));
			assertNotEquals(actualprice,expectedprice);
			expectedprice = flightPage.bookTicketPage3();
			assertEquals(actualprice,expectedprice);
		} catch (InterruptedException e) {
			e.printStackTrace();
		}
		
		
	}
	
	@Test
	public void verifyFlightBookingThroughDeals()
	{
		driver.get(baseUrl_deals);
		//*[@id="js-hp-widgetSection"]/div[2]/div[1]/input
		try {
			flightPage.verifyFlightDataEntryForDeals();
		} catch (InterruptedException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}



}