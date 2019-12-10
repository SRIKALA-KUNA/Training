package stepdefinitions;


import static org.testng.Assert.assertEquals;

import java.net.MalformedURLException;

import org.openqa.selenium.WebDriver;
import org.testng.Assert;

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
	
	LocationStep location;
	
	@Given("^user opens location page$")
	public void userOpensLocationPage() throws MalformedURLException
	{
		location = new LocationStep();
		location.openLocationPage();
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
		Assert.assertTrue(location.verifyTitleOfMoviePage());
				

	}

	@Then("^verify user is in location page$")
	public void verifyUserIsInLocationPage() {
		Assert.assertTrue(location.verifyTitleOfLocationPage());	
	}

//		@After
//		public void close()
//		{
//			driver.close();
//		}


}
