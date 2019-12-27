package pages;

import java.util.List;
import java.util.logging.Logger;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import io.qameta.allure.Step;
import utils.Utils;


public class DatePage{
	@FindBy(xpath="//input[@name='userDate']")
	List<WebElement> dates;
	static Logger logger = Logger.getLogger(DatePage.class.getName());
	Utils commonUtils;
	WebDriver driver;
	public DatePage(WebDriver driver) {
		this.driver = driver;
		PageFactory.initElements(this.driver, this);
		commonUtils =new Utils(driver);
		
	}
	@Step("user selects {0}:date")
	public void selectDateOption() {
		int ra =  CommonPageOperations.random.nextInt(dates.size());
		CommonPageOperations.ticket.add(dates.get(ra).getAttribute("value"));
		commonUtils.clickOn(dates.get(ra));
	}
	public WebDriver returnDriver()
	{
		return driver;
	}
}
