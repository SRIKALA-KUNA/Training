package pages;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import io.qameta.allure.Step;
import utils.Utils;


public class HomePage{
	@FindBy(xpath = "/html/body/form/input")
	WebElement proceed;
	Utils commonUtils;
	WebDriver driver;
	public HomePage(WebDriver driver)
	{
		this.driver = driver;
		PageFactory.initElements(this.driver, this);
		commonUtils =new Utils(driver);
	}
	
	@Step("click on proceed button")
	public void cliclOnProccedButton()
	{
		commonUtils.dynamicXpath(driver, "xpath", "book.now");
	}

	public WebDriver returnDriver() {
		
		return driver;
	}
	

}
