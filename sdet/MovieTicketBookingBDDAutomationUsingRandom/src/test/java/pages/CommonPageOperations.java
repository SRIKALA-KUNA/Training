package pages;

import java.util.ArrayList;
import java.util.List;
import java.util.Random;
import org.apache.log4j.Logger;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import utils.Utils;

public class CommonPageOperations{
	@FindBy(xpath ="//button[@type='submit']")
	WebElement next;
	public static final Random random = new Random();
	public static List<String> ticket = new ArrayList<>();
	WebDriver driver;
	Utils commonUtils;
	static Logger logger = Logger.getLogger(CommonPageOperations.class.getName());
	public CommonPageOperations(WebDriver driver) {
		this.driver = driver;
		PageFactory.initElements(this.driver, this);
		commonUtils =new Utils(driver);
	}
	public void next() {
		commonUtils =new Utils(driver);
		try {
			Utils.waitForSeconds(2);
			commonUtils.clickOn(next);
			Utils.waitForSeconds(2);
		} catch (InterruptedException e) {
			Thread.currentThread().interrupt();
			logger.error(e);
		}

	}

}
