package mmtBooking;

import java.io.IOException;
import java.net.MalformedURLException;
import java.util.Properties;

import org.openqa.selenium.WebDriver;
import org.testng.annotations.AfterClass;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.AfterTest;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Test;

import com.epam.MakeMyTripAutomation.Utils;

import base.Base;
import io.qameta.allure.Description;
import page.FlightDealsPage;
import page.FlightPage;
import page.Home;
import page.LoginPage;

public class VerifyLogin {
	WebDriver driver;
	
	LoginPage login ;
	Properties prop;
	Base base;
	@BeforeClass
	void init() throws MalformedURLException
	{
		base = new Base();
		this.driver=base.getBrowser();
		login = new LoginPage(driver);
	}
	@Description("perform login functionality")
	@Test()
	void loginFunctionalityAutomation()
	{
		try {
			driver.get(Utils.baseUrl);
			login.enterLoginDetails();
		} catch (InterruptedException e) {
			e.printStackTrace();
		}
	}
	
	@AfterClass
	public void close()
	{
		driver.close();
	}





}
