package HotelBooking;

import static org.testng.Assert.assertEquals;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

import org.openqa.selenium.WebDriver;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Test;

import FlightBooking.FlightPage;
import FlightBooking.Home;
import FlightBooking.Settings;

public class VerifyHotelBooking extends Settings {
	WebDriver driver;
	HotelPage hotelPage;
	List<String> actual = new ArrayList<String>();
	List<String> expected = new ArrayList<String>(Arrays.asList("INR8,590","INR33,567")) ;
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
			//hotelPage.verifyDataEntryInHotelBooking();
			//hotelPage.verifyFilters();
			actual = hotelPage.verifySort();
			System.out.println(actual);
			assertEquals(actual,expected);
			hotelPage.refresh();
		} catch (InterruptedException e) {
			e.printStackTrace();
		}
	}

}
