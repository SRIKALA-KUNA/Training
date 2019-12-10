package pages;

import java.util.List;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import utils.Utils;

public class MoviePage {
	WebDriver driver;
	@FindBy (xpath ="//input")
	List<WebElement> movies;
	@FindBy(xpath ="//button[@type='submit']")
	WebElement next;
	public MoviePage(WebDriver driver) {
		this.driver = driver;
		PageFactory.initElements(this.driver, this);
	}



	public void clickOnMovieOptions(String movieName) {
		for(WebElement movie: movies)
		{
			try {
				Utils.wait(5);
			} catch (InterruptedException e) {
				e.printStackTrace();
			}
			String movieValue = movie.getAttribute("value");
			if(movieValue.contains(movieName))
			{
				movie.click();
				break;
			}

		}

	}
	public void next() {
		try {
			Utils.wait(5);
			next.click();
			Utils.wait(5);
		} catch (InterruptedException e) {
			e.printStackTrace();
		}


	}

}
