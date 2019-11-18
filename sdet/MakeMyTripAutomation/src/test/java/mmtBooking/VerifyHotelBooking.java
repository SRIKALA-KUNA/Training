package mmtBooking;

import static org.testng.Assert.assertEquals;
import static org.testng.Assert.assertTrue;

import java.io.IOException;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

import org.openqa.selenium.WebDriver;
import org.testng.annotations.AfterClass;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.AfterTest;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Test;

import com.epam.MakeMyTripAutomation.Settings;

import Page.FlightPage;
import Page.Home;
import Page.HotelPage;

public class VerifyHotelBooking extends Settings {
	WebDriver driver;
	
	HotelPage hotelPage;
	List<String> actual = new ArrayList<String>();
	List<String> expected = new ArrayList<String>(Arrays.asList("INR3,092","INR8,590","INR34,002")) ;
@BeforeClass
	void init()
	{
		Settings settings = new Settings();
		this.driver = settings.getDriver();
		hotelPage = new HotelPage(driver);

	}

	@Test
	void verifyHotelBooking()
	{
		driver.get(baseUrl_hotels);
		try {
			
			assertTrue(true,hotelPage.verifyDataEntryInHotelBooking());
			hotelPage.verifyFilters();
			actual = hotelPage.verifySort();
			assertEquals(actual,expected);
			hotelPage.selectHotel();
			hotelPage.refresh();
		} catch (InterruptedException e) {
			e.printStackTrace();
		}
	}
	@AfterClass
	void close()
	{
		driver.close();
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

}
