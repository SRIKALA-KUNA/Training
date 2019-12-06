package stepdefinations;


import static org.testng.Assert.assertEquals;

import java.net.MalformedURLException;

import org.openqa.selenium.WebDriver;

import base.Base;
import cucumber.api.java.en.And;
import cucumber.api.java.en.Given;
import cucumber.api.java.en.Then;
import cucumber.api.java.en.When;
import pages.LocationPage;
import utils.Utils;

public class LocationPageStepDefination {
	WebDriver driver;
	LocationPage location;
	
	@Given("^user is already in location/home page$")
	public void user_is_already_in_location__home_page()
	{
		
		try {
			this.driver=Base.getDriver();
		} catch (MalformedURLException e) {
			e.printStackTrace();
		}
		location = new LocationPage(driver);
		driver.get(Utils.baseUrl);
	}
	
	

	@When("^user clicks location \"([^\"]*)\" radio button$")
	public void user_clicks_location_radio_button(String location)  {
	   //location.clickLocationRadio(location);
	   
	}

	@When("^user clicks on search button$")
	public void user_clicks_on_search_button()  {
	    // Write code here that turns the phrase above into concrete actions
	   
	}

	@Then("^verify user is redirected to movies page$")
	public void verify_user_is_redirected_to_movies_page()  {
	    // Write code here that turns the phrase above into concrete actions
	   
	}

	

	@Then("^verify user is in same page$")
	public void verify_user_is_in_same_page() {
	    
	}

	
}
