package pages;


import java.util.List;
import org.apache.log4j.Logger;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import io.qameta.allure.Step;
import utils.Utils;


public class SeatPage {

	@FindBy(xpath = "//input[@name='seat']")
	List<WebElement> seats;
	@FindBy(xpath ="//button[@type='submit'][2]")
	WebElement book;
	static Logger logger = Logger.getLogger(SeatPage.class.getName());
	Utils commonUtils;
	WebDriver driver;
	public SeatPage(WebDriver driver) {
		this.driver = driver;
		PageFactory.initElements(this.driver, this);
		commonUtils =new Utils(driver);
	}

	@Step("user selects seats:{0}")
	public void selectSeatOption() {

		int ra =  CommonPageOperations.random.nextInt(seats.size());
		if(seats.get(ra).isEnabled())
		{
			CommonPageOperations.ticket.add(seats.get(ra).getAttribute("value"));
			commonUtils.clickOn(seats.get(ra));
		}
		else
		{
			logger.info("seat is already booked");
		}

	}
	public WebDriver returnDriver()
	{
		return driver;
	}
	
	public void book()
	{
		commonUtils.dynamicXpath(driver, "xpath", "book");;
	}
}
