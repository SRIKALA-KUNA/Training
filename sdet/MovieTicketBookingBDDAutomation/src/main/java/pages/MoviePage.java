package pages;

import java.util.List;

import org.apache.log4j.Logger;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import io.qameta.allure.Step;
import utils.Utils;

public class MoviePage extends Page {

	@FindBy (xpath ="//input[@name='movieName']")
	List<WebElement> movies;
	@FindBy(xpath ="//button[@type='submit']")
	WebElement next;
	static Logger logger = Logger.getLogger(MoviePage.class.getName());
	public MoviePage() {
		super(driver);
		PageFactory.initElements(Page.driver, this);
	}
	@Step("user selects movie:{0}")
	public void clickOnMovieOption(String movieName) {
		for(WebElement movie: movies)
		{
			String movieValue = movie.getAttribute("value");
			if(movieValue.contains(movieName))
			{
				Utils.clickOn(movie);
				break;
			}


		}
	}
}
