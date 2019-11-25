package stepdefinations;



import static org.testng.Assert.assertEquals;

import java.net.MalformedURLException;

import org.openqa.selenium.WebDriver;



import base.Base;
import cucumber.api.java.Before;
import cucumber.api.java.en.Given;
import cucumber.api.java.en.Then;
import cucumber.api.java.en.When;
import pages.LoginPage;
import utils.Utils;

public class LoginStepFeature {
	Base base;
	WebDriver driver;
	LoginPage login ;
	@Before
	public void initDriver() {
		base = new Base();
		try {
			this.driver=base.getDriver();
		} catch (MalformedURLException e) {
			e.printStackTrace();
		}
		login = new LoginPage(driver);
	}
	@Given("^user is already on Login Page$")
	public void user_already_on_login_page(){
		
		driver.get(Utils.baseUrl);
	}


	@When("^title of login page$")
	public void title_of_login_page_is_free_CRM(){
		String title = driver.getTitle();
		assertEquals("MakeMyTrip - #1 Travel Website 50% OFF on Hotels, Flights &amp; Holiday", title);
	}


	@Then("^user enters login details$")
	public void enter_login_details(){
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
