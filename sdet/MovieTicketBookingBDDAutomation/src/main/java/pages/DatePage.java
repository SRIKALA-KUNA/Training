package pages;

import java.util.List;
import java.util.logging.Logger;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import io.qameta.allure.Step;
import utils.Utils;

public class DatePage extends Page {
	@FindBy(xpath="//input[@name='userDate']")
	List<WebElement> dates;
	@FindBy(xpath ="//button[@type='submit']")
	WebElement next;
	static Logger logger = Logger.getLogger(DatePage.class.getName());
	public DatePage() {
		super(driver);
		PageFactory.initElements(Page.driver, this);
	}
	@Step("user selects {0}:date")
	public void selectDateOption(String selectedDate) {

		for(WebElement date:dates)
		{
			
			String dateValue = date.getAttribute("value");
			if(dateValue.contains(selectedDate))
			{
				Utils.clickOn(date);
				break;
			}

		}

	}
}
