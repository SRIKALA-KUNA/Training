package stepdefinations;

import static org.testng.Assert.assertEquals;

import java.net.MalformedURLException;

import org.openqa.selenium.WebDriver;

import base.Base;
import cucumber.api.java.en.And;
import cucumber.api.java.en.Given;
import cucumber.api.java.en.Then;
import cucumber.api.java.en.When;
import pages.MoviePage;
import utils.Utils;

public class MoviePageStepDefination {
	WebDriver driver;
	Base base;
	MoviePage movie;
	
	@Given("^user is already in movie page$")
	public void user_is_already_in_movie_page()
	{
		base = new Base();
		try {
			this.driver=base.getDriver();
		} catch (MalformedURLException e) {
			e.printStackTrace();
		}
		movie = new MoviePage(driver);
		driver.get(Utils.baseUrl);
	}
	
	@And("^user clicks on search button$")
	public void user_clicks_on_search_button()
	{
		movie.clickSearchButton();
	}
	 
	
	@Then("^verify user is in same page$")
	public void verify_user_is_in_same_page()
	{
		assertEquals(driver.getCurrentUrl(),"");
	}
	
	@When("^user clicks movie \"([^\"]*)\" radio button$")
	public void user_clicks_movie_radio_button()
	{
		
	}
	
	@Then("^verify user is redirected to theater page$")
	public void verify_user_is_redirected_to_theater_page()
	{
		
	}
	
	@When("^user clicks multiple movies \"([^\"]*)\" radio button$")
	public void user_clicks_multiple_movies_radio_button()
	{
		
	}
	
	@When("^user clicks movie radio button twice$")
	public void user_clicks_movie_radio_button_twice()
	{
		
	}
	
}

