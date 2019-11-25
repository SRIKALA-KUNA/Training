package step_definations;

import static org.testng.Assert.assertEquals;

import java.net.MalformedURLException;
import java.util.ArrayList;
import java.util.List;

import org.openqa.selenium.WebDriver;

import org.testng.asserts.SoftAssert;

import base.Base;
import cucumber.api.java.After;
import cucumber.api.java.Before;
import cucumber.api.java.en.Given;
import cucumber.api.java.en.Then;
import cucumber.api.java.en.When;
import pages.FlightPage;
import pages.LoginPage;
import utils.Utils;

public class FlightPageStepDefination {
	Base base = new Base();;
	WebDriver driver;
	FlightPage flightPage;
	List expectedListOfFlightPrices;
	List actualListOfFlightPrices;
	String expectedFlightPrice;
	String actualProgress;
	List<String> actual =new ArrayList();
	SoftAssert softAssertion= new SoftAssert();
	
	
	@Given("^user is already opened browser and opening home page$")
	public void user_already_opened_browser_and_opening_home_page(){
		
		
		try {
			this.driver=base.getDriver();
		} catch (MalformedURLException e) {
			e.printStackTrace();
		}
		flightPage = new FlightPage(driver);
		
		driver.get(Utils.baseUrl);
	}


	@When("^verify title of home page$")
	public void verify_title_of_home_page(){
		String title = driver.getTitle();
		assertEquals("MakeMyTrip - #1 Travel Website 50% OFF on Hotels, Flights &amp; Holiday", title);
	}


	@Then("^click flight link$")
	public void click_flight_links(){
		flightPage.flightLink();
	}
	@Given("^user is already opened browser and opening flight page$")
	public void user_is_already_opened_browser_and_opening_flight_page (){
		try {
			this.driver=base.getDriver();
		} catch (MalformedURLException e) {
			e.printStackTrace();
		}
		flightPage = new FlightPage(driver);
		
		driver.get(Utils.baseFlightUrl);
	}


	@When("^verify title of flight page$")
	public void verify_title_of_flight_page(){
		String title = driver.getTitle();
		assertEquals("Flight Booking, Flight Tickets Booking at Lowest Airfare | MakeMyTrip", title);
	}


	@Then("^user enters flight data$")
	public void user_enters_flight_details(){
		flightPage.verifyFlightdataEntry();
	}
	@Then("^click filters$")
	public void click_filters(){
		try {
			flightPage.clickFilters();
		} catch (InterruptedException e) {
				e.printStackTrace();
		}
		
	}


	@Then("^verify sort filter$")
	public void verify_sort_filter(){
		try {
			expectedListOfFlightPrices = flightPage.bookTicketData();
			actualListOfFlightPrices = flightPage.bookTicketPage2();
		} catch (InterruptedException e) {
			e.printStackTrace();
		}
				softAssertion.assertNotEquals(actualListOfFlightPrices,expectedListOfFlightPrices);
	}

	@Then("^track progress bar$")
	public void track_progress_bar(){
		actualProgress =flightPage.trackProgressBar(2);
		softAssertion.assertEquals("2",actualProgress);
		try {
			expectedFlightPrice = flightPage.bookTicketPage3();
		} catch (InterruptedException e) {
			
			e.printStackTrace();
		}
		softAssertion.assertEquals(actualListOfFlightPrices.get(2),expectedFlightPrice);
		actualProgress =flightPage.trackProgressBar(3);
		softAssertion.assertEquals("3",actualProgress);
	}




	
}