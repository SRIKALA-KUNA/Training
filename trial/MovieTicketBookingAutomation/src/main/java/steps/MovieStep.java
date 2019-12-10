package steps;

import java.net.MalformedURLException;

import org.openqa.selenium.WebDriver;
import org.testng.Assert;

import base.Base;
import pages.MoviePage;
import utils.Utils;

public class MovieStep extends DriverStep {
	MoviePage movie;
	LocationStep location;
	public MovieStep() throws MalformedURLException {
		driver = Base.getDriverInstance();
		movie = new MoviePage(driver);	
		location = new LocationStep();
	}

	public void openMoviePage() throws MalformedURLException
	{
		location.openLocationPage();
		location.clicksOnLocation("hyderabad");
		location.next();
	}
	public void clickOnMovie(String movieName) {
		
		movie.clickOnMovieOptions(movieName);
	}
	public void next() {
		movie.next();	
		}

	public boolean verifyTitleOfTheaterPage() {
		Assert.assertEquals(driver.getCurrentUrl(),Utils.titleOfTheaterPage);
		return true;
	}

	public boolean verifyTitleOfMoviePage() {
		Assert.assertEquals(driver.getCurrentUrl(),Utils.titleOfMoviePage);
		return true;
	}

}