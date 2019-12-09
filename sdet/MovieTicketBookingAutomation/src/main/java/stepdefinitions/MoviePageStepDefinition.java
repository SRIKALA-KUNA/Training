package stepdefinitions;

import static org.testng.Assert.assertEquals;

import java.net.MalformedURLException;

import org.openqa.selenium.WebDriver;
import org.testng.Assert;

import base.Base;
import cucumber.api.java.en.And;
import cucumber.api.java.en.Given;
import cucumber.api.java.en.Then;
import cucumber.api.java.en.When;
import pages.MoviePage;
import steps.LocationStep;
import steps.MovieStep;
import utils.Utils;

public class MoviePageStepDefinition {
	WebDriver driver;
	Base base;
	LocationStep location;
	MovieStep movie;
	@Given("^user opens movie page$")
	public void userOpensMoviePage()
	{
		movie = new MovieStep(driver);
		driver.get(Utils.baseUrl);
		//for now
		location.pre();
		location.clicksOnLocation("Hyderabad");
		location.next();
	}

	@When("^user clicks movie \"([^\"]*)\" radio button$")
	public void userClicksMovieRadioButton(String movieName)  {
		movie.clickOnMovie(movieName);

	}

	@Then("^verify user is redirected to theater page$")
	public void verifyUserIsRedirectedToTheaterPage()  {

	}

	@Then("^verify user is in movie page$")
	public void verifyUserIsInMoviePage()  {
		
	}


}

