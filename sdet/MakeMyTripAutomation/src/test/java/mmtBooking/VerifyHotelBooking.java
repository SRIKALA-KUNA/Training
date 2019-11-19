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
import io.qameta.allure.Description;

public class VerifyHotelBooking  {
	WebDriver driver;
	Settings settings;
	HotelPage hotelPage;
	List<String> actual = new ArrayList<String>();
	List<String> expected = new ArrayList<String>() ;
	@BeforeClass
	void init()
	{
		settings = new Settings();
		this.driver = settings.getDriver();
		hotelPage = new HotelPage(driver);

	}
	@Description("Hotel booking automation")
	@Test
	void verifyHotelBooking()
	{
		driver.get(settings.baseUrl_hotels);
		try {

			assertTrue(true,hotelPage.verifyDataEntryInHotelBooking());
			hotelPage.verifyFilters();
			actual = hotelPage.verifySort();
			expected = actual;
			assertEquals(actual,expected);
			hotelPage.selectHotel();

			hotelPage.refresh();
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
