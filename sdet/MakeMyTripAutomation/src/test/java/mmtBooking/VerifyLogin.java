package mmtBooking;

import java.io.IOException;

import org.openqa.selenium.WebDriver;
import org.testng.annotations.AfterClass;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.AfterTest;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Test;

import com.epam.MakeMyTripAutomation.Settings;

import Page.FlightDealsPage;
import Page.FlightPage;
import Page.Home;
import Page.LoginPage;

public class VerifyLogin {
	WebDriver driver;
	Settings settings;
	LoginPage login ;
	@BeforeClass
	void init()
	{
		Settings settings = new Settings();
		this.driver = settings.getDriver();
		login = new LoginPage(driver);
	}

	@Test
	void verifyLogin()
	{
		try {
			login.verifyLoginPage();
			
		} catch (InterruptedException e) {
			e.printStackTrace();
		}
	}
	@AfterClass
	void close()
	{
		driver.close();
	}
	@AfterTest
	public void screenshot()
	{
		try {
			Settings.screenShot(driver);
		} catch (IOException e) {
			
			e.printStackTrace();
		}
	}


}
