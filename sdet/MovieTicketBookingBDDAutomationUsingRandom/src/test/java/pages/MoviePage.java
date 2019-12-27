package pages;

import java.util.List;

import org.apache.log4j.Logger;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import io.qameta.allure.Step;
import utils.Utils;


public class MoviePage {

	@FindBy (xpath ="//input[@name='movieName']")
	List<WebElement> movies;
	static Logger logger = Logger.getLogger(MoviePage.class.getName());
	Utils commonUtils;
	WebDriver driver;
	public MoviePage(WebDriver driver) {
		this.driver = driver;
		PageFactory.initElements(this.driver, this);
		commonUtils =new Utils(driver);
	}
	@Step("user selects movie:{0}")
	public void clickOnMovieOption()
	{
		int ra =  CommonPageOperations.random.nextInt(movies.size());
		CommonPageOperations.ticket.add(movies.get(ra).getAttribute("value").split("-")[0]);
		commonUtils.clickOn(movies.get(ra));
	}
	public WebDriver returnDriver()
	{
		return driver;
	}
}
