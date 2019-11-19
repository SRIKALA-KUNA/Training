package Page;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import io.qameta.allure.Step;

public class Home {
	WebDriver driver;
	@FindBy(xpath="//ul[@class ='makeFlex font12']/li/a")
	WebElement flight;
	public Home(WebDriver driver)
	{
		this.driver = driver;
		PageFactory.initElements(this.driver, this);
	}
	@Step("selecting flight option in home page")
	public void flight()
	{
		flight.click();
	}

}
