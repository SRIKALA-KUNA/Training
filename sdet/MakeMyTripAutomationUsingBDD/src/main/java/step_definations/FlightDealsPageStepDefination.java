package step_definations;

import static org.testng.Assert.assertEquals;

import java.net.MalformedURLException;
import java.util.Properties;

import org.openqa.selenium.WebDriver;

import base.Base;
import cucumber.api.java.After;
import cucumber.api.java.Before;
import cucumber.api.java.en.Given;
import cucumber.api.java.en.Then;
import cucumber.api.java.en.When;
import pages.FlightDealsPage;
import pages.LoginPage;
import utils.Utils;


public class FlightDealsPageStepDefination {
	Base base;
	WebDriver driver;
	FlightDealsPage flightDeals;
	Properties prop;

	@Given("^user is opening flight deals page$")
	public void user_is_opening_flight_deals_page(){
		base = new Base();
		try {
			this.driver=base.getDriver();
			this.prop = base.init_properties();
		} catch (MalformedURLException e) {
			e.printStackTrace();
		}
		flightDeals =  new FlightDealsPage(driver , prop);

		driver.get(Utils.baseDealsUrl);
		
	}


	@When("^verify url of deals page$")
	public void verify_url_of_deals_page() throws InterruptedException{
		
		Utils.wait(20);
		String url = driver.getCurrentUrl();
		System.out.println(url);
		assertEquals(Utils.baseDealsUrl, url);
	}


	@Then("^enter flight data and verify link$")
	public void enter_flight_data_and_verify_link(){
		try {
			assertEquals(flightDeals.enterFlightData().contains("flight"),true);
		} catch (InterruptedException e) {
			e.printStackTrace();
		}
	}

}