package mmtBooking;

import static org.testng.Assert.assertEquals;
import static org.testng.Assert.assertTrue;

import java.io.IOException;
import java.net.MalformedURLException;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

import org.openqa.selenium.WebDriver;
import org.testng.annotations.AfterClass;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.AfterTest;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Test;

import com.epam.MakeMyTripAutomation.Utils;

import base.Base;
import io.qameta.allure.Description;
import page.FlightPage;
import page.Home;
import page.HotelPage;

public class VerifyHotelBooking  {
	WebDriver driver;
	
	Base base;
	HotelPage hotelPage;
	List<String> actual = new ArrayList<String>();
	List<String> expected = new ArrayList<String>() ;
	@BeforeClass
	void init() throws MalformedURLException
	{
		base= new Base();
		driver = base.getBrowser();
		hotelPage = new HotelPage(driver);

	}
	@Description("Hotel booking automation")
	@Test
	void verifyHotelBooking()
	{
		driver.get(Utils.baseHotelsUrl);
		try {

			assertTrue(true,hotelPage.verifyDataEntryInHotelBooking());
			hotelPage.clickFilters();
			actual = hotelPage.verifyPriceSorting();
			expected = actual;
			assertEquals(actual,expected);
			hotelPage.selectHotel();
			hotelPage.refreshPage();
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
