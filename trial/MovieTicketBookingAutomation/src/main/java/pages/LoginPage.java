package pages;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import utils.Utils;

public class LoginPage {
	WebDriver driver;
	@FindBy(xpath = "//input[@id='username']")
	WebElement userName;
	@FindBy(xpath = "//input[@id='password']")
	WebElement passWord;
	@FindBy(xpath = "//button[@type='submit']")
	WebElement login;
	public LoginPage(WebDriver driver) {
		this.driver = driver;
		PageFactory.initElements(this.driver, this);
	}
	public void enterLoginCredentials(String username, String password) {
		Utils.sendKeys(userName,username);
		Utils.sendKeys(passWord,password);
		
	}
	public void clickOnLogin() {
		Utils.clickOn(login);
		
	}

}
