package pages;

import java.util.List;

import org.apache.log4j.Logger;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import utils.Utils;

public class TimePage extends Page {
	@FindBy(xpath="//input[@name='movietiming']")
	List<WebElement> timeings;
	@FindBy(xpath ="//button[@type='submit']")
	WebElement next;
	static Logger logger = Logger.getLogger(TimePage.class.getName());
	public TimePage()
	{
		super(driver);
		PageFactory.initElements(Page.driver, this);
	}
public void selectTimeOption(String selectedTime) {
		
		try {
			
			for(WebElement time:timeings)
	        {
				Utils.wait(1);
	            String timeValue = time.getAttribute("value");
	            if(timeValue.contains(selectedTime))
	            {
	            	Utils.clickOn(time);
	                break;
	            }
	           
	        }
		} catch (InterruptedException e) {
			Thread.currentThread().interrupt();
			logger.error(e.getMessage()+"the current execution is interrupted");
		}
		
	}

}
