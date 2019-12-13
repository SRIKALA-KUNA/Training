package pages;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import io.qameta.allure.Step;
import utils.Utils;

public class LoginPage extends Page{
	@FindBy(xpath = "//input[@id='username']")
	WebElement userName;
	@FindBy(xpath = "//input[@id='password']")
	WebElement passWord;
	@FindBy(xpath = "//button[@type='submit']")
	WebElement login;
	public LoginPage() {
		super(driver);
		PageFactory.initElements(Page.driver, this);
		openBasePage();
	}
	@Step("user enters login credentials username: {0} password: {1}")
	public void enterLoginCredentials(String username, String password) {
		Utils.sendKeys(userName,username);
		Utils.sendKeys(passWord,password);

	}
	@Step("user clicks on login")
	public void clickOnLogin() {
		Utils.clickOn(login);

	}

}
