package steps;

import java.net.MalformedURLException;

import org.openqa.selenium.WebDriver;
import org.testng.Assert;

import base.Base;
import pages.LoginPage;
import utils.Utils;

public class LoginStep {
	WebDriver driver;
	public void driverInit()
	{
		Base base = new Base();
		this.driver = base.getDriver();
	}
	LoginPage login;
	public void openLoginPage() throws MalformedURLException  {
		driver=Base.getDriverInstance();
		login = new LoginPage(driver);
		driver.get(Utils.baseUrl);

	}

	public void enterLoginCredentials(String username, String password) {
		login.enterLoginCredentials(username,password);

	}
	public void clickOnLogin() {
		login.clickOnLogin();
	}
	public boolean verifyUserRedirectedToLocationPage() {
		Assert.assertEquals(driver.getCurrentUrl(), Utils.homePageUrl);
		return true;

	}
	public boolean verifyUserIsInLoginPage() {
		Assert.assertEquals(driver.getTitle(), Utils.titleOfLoginPage);
		return true;
	}
	
	public WebDriver loginFeature(String username, String password) throws MalformedURLException
	{
		openLoginPage();
		enterLoginCredentials(username, password);
		clickOnLogin();
		return driver;
		
	}

}
