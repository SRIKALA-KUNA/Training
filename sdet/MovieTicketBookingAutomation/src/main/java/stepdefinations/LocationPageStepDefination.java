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
	Base base;
	LocationPage location;
	
	@Given("^user is already in location/home page$")
	public void user_is_already_in_location__home_page()
	{
		base = new Base();
		try {
			this.driver=base.getDriver();
		} catch (MalformedURLException e) {
			e.printStackTrace();
		}
		location = new LocationPage(driver);
		driver.get(Utils.baseUrl);
	}
	
	@And("^user clicks on search button$")
	public void user_clicks_on_search_button()
	{
		location.clickSearchButton();
	}
	 
	
	@Then("^verify user is in same page$")
	public void verify_user_is_in_same_page()
	{
		assertEquals(driver.getCurrentUrl(),"");
	}
	
	@When("^user clicks location  \"([^\"]*)\" radio button$")
	public void user_clicks_location_radio_button()
	{
		
	}
	
	@Then("^verify user is redirected to movies page$")
	public void verify_user_is_redirected_to_movies_page()
	{
		
	}
	
	@When("^user clicks multiple locations \"([^\"]*)\" radio button$")
	public void user_clicks_multiple_locations_radio_button()
	{
		
	}
	
	@When("^user clicks location radio button twice$")
	public void user_clicks_location_radio_button_twice()
	{
		
	}
	
}
