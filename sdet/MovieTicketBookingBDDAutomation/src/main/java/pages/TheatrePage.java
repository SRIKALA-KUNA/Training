package pages;

import java.util.List;

import org.apache.log4j.Logger;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import io.qameta.allure.Step;
import utils.Utils;

public class TheatrePage extends Page{
	@FindBy(xpath = "//input[@name='theatreName']")
	List<WebElement> theatres;
	@FindBy(xpath ="//button[@type='submit']")
	WebElement next;
	static Logger logger = Logger.getLogger(TheatrePage.class.getName());
	public TheatrePage() {
		super(driver);
		PageFactory.initElements(Page.driver, this);
	}
	@Step("user selects movie:{0}")
	public void selectTheaterOption(String theaterName) {

		for(WebElement theatre: theatres)
		{

			String theaterValue = theatre.getAttribute("value");
			if(theaterValue.contains(theaterName))
			{
				Utils.clickOn(theatre);
				break;
			}

		}

	}

}
