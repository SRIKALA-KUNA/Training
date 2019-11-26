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
	Base base = new Base();
	WebDriver driver;
	WebDriver flightDriver;
	FlightPage flightPage;
	List expectedListOfFlightPrices;
	List actualListOfFlightPrices;
	String expectedFlightPrice;
	String actualProgress;
	List<String> actual =new ArrayList();
	SoftAssert softAssertion= new SoftAssert();
	
	
	@Given("^user is opening home page$")
	public void user_is_opening_home_page(){
		
		
		try {
			this.driver=base.getDriver();
		} catch (MalformedURLException e) {
			e.printStackTrace();
		}
		flightPage = new FlightPage(driver);
		
		driver.get(Utils.baseUrl);
	}


	@When("^verify url of home page$")
	public void verify_url_of_home_page() throws InterruptedException{
		Utils.wait(20);
		String url = driver.getCurrentUrl();
		assertEquals(Utils.baseUrl, url);
	}


	@Then("^click flight link$")
	public void click_flight_links(){
		flightPage.flightLink();
	}
	
	@Given("^user is opening flight page$")
	public void user_is_opening_flight_page () throws InterruptedException{
		
		try {
			this.flightDriver=base.getDriver();
		} catch (MalformedURLException e) {
			e.printStackTrace();
		}
		flightPage = new FlightPage(flightDriver);
		Utils.wait(5);
		flightDriver.get(Utils.baseFlightUrl);
		
	}


	@When("^verify url of flight page$")
	public void verify_url_of_flight_page() throws InterruptedException{
		Utils.wait(40);
		Utils.wait(driver);
		String title = flightDriver.getCurrentUrl();
		assertEquals(Utils.baseFlightUrl, title);
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