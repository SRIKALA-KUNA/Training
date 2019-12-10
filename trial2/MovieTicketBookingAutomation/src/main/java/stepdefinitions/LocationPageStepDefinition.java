package stepdefinitions;


import static org.testng.Assert.assertEquals;

import java.net.MalformedURLException;

import org.openqa.selenium.WebDriver;
import org.testng.Assert;

import DriverUtilities.DriverRunner;
import base.Base;
import cucumber.api.java.After;
import cucumber.api.java.Before;
import cucumber.api.java.en.And;
import cucumber.api.java.en.Given;
import cucumber.api.java.en.Then;
import cucumber.api.java.en.When;
import pages.LocationPage;
import steps.LocationStep;
import utils.Utils;

public class LocationPageStepDefinition {
	WebDriver driver;
	LocationStep location;
	@Before
	public void init()
	{
		try {
			this.driver=Base.getDriver();
		} catch (MalformedURLException e) {
			e.printStackTrace();
		}
		
	}
	@Given("^user opens location page$")
	public void userOpensLocationPage()
	{
		
		
		location = new LocationStep(driver);
		driver.get(Utils.baseUrl);
		//for now
		location.pre();
	}
	
	

	@When("^user clicks location \"([^\"]*)\" radio button$")
	public void userClicksLocationRadioButton(String loc)  {
		location.clicksOnLocation(loc);
	}

	@When("^user clicks on search button$")
	public void userClicksOnSearchButton()  {
		location.next();   
	}

	@Then("^verify user is redirected to movies page$")
	public void verifyUserIsRedirectedToMoviesPage()  {
		Assert.assertEquals(driver.getCurrentUrl(), Utils.movieUrl); 
	   
	}

	@Then("^verify user is in location page$")
	public void verifyUserIsInLocationPage() {
	    Assert.assertEquals(driver.getCurrentUrl(), Utils.locationUrl);
	}
	
	@After
	public void close()
	{
		driver.close();
	}

	
}