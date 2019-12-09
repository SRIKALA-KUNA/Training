package steps;

import org.openqa.selenium.WebDriver;

import pages.MoviePage;

public class MovieStep {
MoviePage movie;
	public MovieStep(WebDriver driver) {
		movie = new MoviePage(driver);
		
	}

	public void clickOnMovie(String movieName) {
		
		movie.selectMovieOptions(movieName);
	}
	public void next() {
		movie.next();	
		}

}
