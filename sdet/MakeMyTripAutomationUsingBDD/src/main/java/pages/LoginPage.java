package pages;

import java.util.Properties;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import io.qameta.allure.Step;
import utils.Utils;
public class LoginPage {
	WebDriver driver;
	Properties prop;
	@FindBy(xpath ="//*[@id=\"SW\"]/div[2]/div[1]/ul/li[6]")
	WebElement loginButton;
	@FindBy(xpath = "//*[@id=\"username\"]")
	WebElement username;

	@FindBy(xpath = "//*[@id=\"SW\"]/div[2]/div[2]/div[2]/section/form/div[2]/button")
	WebElement nextButton;

	@FindBy(xpath = "//*[@id=\"password\"]")
	WebElement passwordButton;

	@FindBy(xpath ="//button")
	WebElement submit;
	@FindBy(xpath = "//*[@id=\"SW\"]/div[2]/div[2]/div[2]/section/div[1]/div/span")
	WebElement cancel;
	public LoginPage(WebDriver driver,Properties prop)
	{
		this.driver = driver;
		this.prop = prop;
		PageFactory.initElements(this.driver, this);
	}
	@Step("entering login details")
	public void enterLoginDetails() throws InterruptedException
	{	
		Utils.wait(5);
		loginButton.click();
		Utils.wait(5);
		Utils.wait(driver);
		username.sendKeys(prop.getProperty("username"));
		Utils.wait(5);
		username.submit();
		passwordButton.sendKeys(prop.getProperty("password"));
		Utils.wait(5);
		passwordButton.submit();
		Utils.wait(5);
		cancel.click();	
	}


}
