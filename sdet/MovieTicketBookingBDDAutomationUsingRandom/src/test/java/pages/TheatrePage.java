package pages;

import java.util.List;

import org.apache.log4j.Logger;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import io.qameta.allure.Step;
import utils.Utils;


public class TheatrePage{
	@FindBy(xpath = "//input[@name='theatreName']")
	List<WebElement> theatres;
	static Logger logger = Logger.getLogger(TheatrePage.class.getName());
	Utils commonUtils;
	WebDriver driver;
	public TheatrePage(WebDriver driver) {
		this.driver = driver;
		PageFactory.initElements(this.driver, this);
		commonUtils =new Utils(driver);
	}
	@Step("user selects movie:{0}")
	public void selectTheaterOption() {
		int ra =  CommonPageOperations.random.nextInt(theatres.size());
		CommonPageOperations.ticket.add(theatres.get(ra).getAttribute("value").split("-")[0]);
		commonUtils.clickOn(theatres.get(ra));
	}
	public WebDriver returnDriver()
	{
		return driver;
	}

}
