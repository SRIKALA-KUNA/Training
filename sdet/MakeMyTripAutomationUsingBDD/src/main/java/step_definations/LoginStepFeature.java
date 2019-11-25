package step_definations;



import static org.testng.Assert.assertEquals;

import java.net.MalformedURLException;

import org.openqa.selenium.WebDriver;



import base.Base;
import cucumber.api.java.en.Given;
import cucumber.api.java.en.Then;
import cucumber.api.java.en.When;
import pages.LoginPage;
import utils.Utils;

public class LoginStepFeature {
	Base base;
	WebDriver driver;
	LoginPage login ;
	@Given("^user is opening login Page$")
	public void user_opening_login_page(){
		base = new Base();
		try {
			this.driver=base.getDriver();
		} catch (MalformedURLException e) {
			e.printStackTrace();
		}
		login = new LoginPage(driver);
		driver.get(Utils.baseUrl);
		Utils.wait(driver);
	}


	@When("^verify title of login page$")
	public void verify_title_of_login_page(){
		String title = driver.getTitle();
		assertEquals("MakeMyTrip - #1 Travel Website 50% OFF on Hotels, Flights &amp; Holiday", title);
	}


	@Then("^user enters login details$")
	public void user_enters_login_details(){
		try {
			login.enterLoginDetails();
		} catch (InterruptedException e) {
			e.printStackTrace();
		}
	}

	@Then("^close the browser$")
	public void close()
	{
		driver.close();
	}
}
