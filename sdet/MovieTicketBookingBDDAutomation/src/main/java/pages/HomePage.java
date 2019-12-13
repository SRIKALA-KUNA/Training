package pages;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import io.qameta.allure.Step;
import utils.Utils;

public class HomePage extends Page{
	@FindBy(xpath = "/html/body/form/input")
	WebElement proceed;
	
	public HomePage()
	{
		super(driver);
		PageFactory.initElements(Page.driver, this);
	}
	@Step("click on proceed button")
	public void cliclOnProccedButton()
	{
		Utils.clickOn(proceed);
	}
	

}
