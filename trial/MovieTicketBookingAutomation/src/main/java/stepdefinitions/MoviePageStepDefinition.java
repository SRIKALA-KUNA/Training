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
	MovieStep movie;
	@Given("^user opens movie page$")
	public void userOpensMoviePage() throws MalformedURLException
	{
		movie = new MovieStep();
		movie.openMoviePage();
	}

	@When("^user clicks movie \"([^\"]*)\" radio button$")
	public void userClicksMovieRadioButton(String movieName)  {
		movie.clickOnMovie(movieName);

	}
	@When("^user clicks on next button$")
	public void userClicksOnNextButton()  {
		movie.next();   
	}

	@Then("^verify user is redirected to theater page$")
	public void verifyUserIsRedirectedToTheaterPage()  {
		Assert.assertTrue(movie.verifyTitleOfTheaterPage());
	}

	@Then("^verify user is in movie page$")
	public void verifyUserIsInMoviePage()  {
		Assert.assertTrue(movie.verifyTitleOfMoviePage());	
	}

}

