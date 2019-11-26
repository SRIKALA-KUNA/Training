package step_definations;



import static org.testng.Assert.assertEquals;

import java.net.MalformedURLException;
import java.util.Properties;

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
	Properties prop;
	@Given("^user is opening login Page$")
	public void user_opening_login_page(){
		base = new Base();
		try {
			this.driver=base.getDriver();
			this.prop = base.init_properties();
		} catch (MalformedURLException e) {
			e.printStackTrace();
		}
		login = new LoginPage(driver,prop);
		driver.get(Utils.baseUrl);
		Utils.wait(driver);
	}


	@When("^verify url of login page$")
	public void verify_url_of_login_page() throws InterruptedException{
		Utils.wait(20);
		String url = driver.getCurrentUrl();
		assertEquals(Utils.baseUrl, url);
	}


	@Then("^user enters login details$")
	public void user_enters_login_details(){
		try {
			login.enterLoginDetails();
		} catch (InterruptedException e) {
			e.printStackTrace();
		}
	}

	
}
