package pages;

import java.util.List;
import org.apache.log4j.Logger;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import io.qameta.allure.Step;
import utils.Utils;


public class LocationPage{

	@FindBy (xpath ="//input[@name='movieLocation']")
	List<WebElement> locations;
	public static final Logger logger = Logger.getLogger(LocationPage.class);
	Utils commonUtils;
	WebDriver driver;
	public LocationPage(WebDriver driver) {
		this.driver = driver;
		PageFactory.initElements(this.driver, this);
		commonUtils =new Utils(driver);
		
	}
	@Step("user selects location:{0}")
	public void selectLocationOption()
	{
		
	    int ra = CommonPageOperations.random.nextInt(locations.size()-1);
	    CommonPageOperations.ticket.add(locations.get(ra).getAttribute("value").split("-")[0]);
		commonUtils.clickOn(locations.get(ra));
	}
 
	public WebDriver returnDriver()
	{
		return driver;
	}

}
