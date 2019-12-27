package pages;

import java.util.List;
import org.apache.log4j.Logger;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import utils.Utils;

public class TimePage{
	@FindBy(xpath="//input[@name='movietiming']")
	List<WebElement> timeings;
	static Logger logger = Logger.getLogger(TimePage.class.getName());
	Utils commonUtils;
	WebDriver driver;
	public TimePage(WebDriver driver)
	{
		this.driver = driver;
		PageFactory.initElements(this.driver, this);
		commonUtils =new Utils(driver);
	}
	public void selectTimeOption()
	{
		int ra =  CommonPageOperations.random.nextInt(timeings.size());
		CommonPageOperations.ticket.add(timeings.get(ra).getAttribute("value").split("-")[0]);
		commonUtils.clickOn(timeings.get(ra));
	}
	public WebDriver returnDriver()
	{
		return driver;
	}

}
