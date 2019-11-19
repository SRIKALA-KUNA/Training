package mmtBooking;

import java.io.IOException;
import java.util.Properties;

import org.openqa.selenium.WebDriver;
import org.testng.annotations.AfterClass;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.AfterTest;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Test;

import com.epam.MakeMyTripAutomation.Settings;

import Base.Base;
import Page.FlightDealsPage;
import Page.FlightPage;
import Page.Home;
import Page.LoginPage;
import io.qameta.allure.Description;

public class VerifyLogin {
	WebDriver driver;
	Settings settings;
	LoginPage login ;
	Properties prop;
	@BeforeClass
	void init()
	{
		settings = new Settings();
		this.driver=settings.getDriver();
		login = new LoginPage(driver);
	}
	@Description("verify login functionality")
	@Test()
	void verifyLogin()
	{
		try {
			driver.get(settings.baseUrl);
			login.verifyUserName();
			login.verifyPassrord();

		} catch (InterruptedException e) {
			e.printStackTrace();
		}
	}
	@AfterMethod
	public void screenshot()
	{
		try {
			Settings.screenShot(driver);
		} catch (IOException e) {

			e.printStackTrace();
		}
	}




}
