package pages;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import io.qameta.allure.Step;
import utils.Utils;


public class LoginPage{
	@FindBy(xpath = "//input[@id='username']")
	WebElement userName;
	@FindBy(xpath = "//input[@id='password']")
	WebElement passWord;
	@FindBy(xpath = "//button[@type='submit']")
	WebElement login;
	Utils commonUtils;
	WebDriver driver;
	public LoginPage(WebDriver driver, String movieTicketBookingUrl) {
		this.driver = driver;
		PageFactory.initElements(this.driver, this);
		commonUtils =new Utils(driver);
		driver.get(movieTicketBookingUrl);

	}
	
	@Step("user enters login credentials username: {0} password: {1}")
	public void enterLoginCredentials(String username, String password) {
		commonUtils.sendKeys(userName,username);
		commonUtils.sendKeys(passWord,password);

	}
	@Step("user clicks on login")
	public void clickOnLogin() {
		commonUtils.clickOn(login);

	}
	
	public WebDriver returnDriver()
	{
		return driver;
	}
	

}
