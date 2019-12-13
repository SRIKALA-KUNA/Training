package pages;

import java.util.List;

import org.apache.log4j.Logger;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import io.qameta.allure.Step;
import utils.Utils;

public class LocationPage extends Page{
	@FindBy (xpath ="//input[@name='movieLocation']")
	List<WebElement> locations;

	@FindBy(xpath ="//button[@type='submit']")
	WebElement next;
	public static final Logger logger = Logger.getLogger(LocationPage.class);
	public LocationPage() {
		super(driver);
		PageFactory.initElements(Page.driver, this);
	}
	@Step("user selects location:{0}")
	public void selectLocationOption(String locationName) {
		for(WebElement location:locations)
		{
			
			String locationValue = location.getAttribute("value");
			if(locationValue.contains(locationName))
			{
				Utils.clickOn(location);
				break;
			}
		}

	}
	public void next() {
		try {
			Utils.wait(1);
			next.click();
			Utils.wait(1);
		} catch (InterruptedException e) {
			Thread.currentThread().interrupt();
			logger.error(e);
		}


	}
	public void closeDriver()
	{
		close();
	}
	

}
