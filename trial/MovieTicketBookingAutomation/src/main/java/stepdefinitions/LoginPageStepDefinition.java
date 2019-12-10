package stepdefinitions;

import java.net.MalformedURLException;

import org.openqa.selenium.WebDriver;
import org.testng.Assert;

import base.Base;
import cucumber.api.java.en.Given;
import cucumber.api.java.en.Then;
import cucumber.api.java.en.When;
import steps.LocationStep;
import steps.LoginStep;
import utils.Utils;

public class LoginPageStepDefinition {
	LoginStep login;
	@Given("^user opens login page$")
	public void userOpensLoginPage() throws MalformedURLException  {
		login = new LoginStep();
		login.openLoginPage();
	}

	@When("^user enters \"([^\"]*)\" and \"([^\"]*)\"$")
	public void userEntersLoginDetails(String username, String password){
		login.enterLoginCredentials(username,password);

	}

	@When("^user clicks on login button$")
	public void userClicksOnLoginButton() {
		login.clickOnLogin();
	}

	@Then("^verify user is redirected to locations page$")
	public void verifyUserIsRedirectedToLocationsPage()  {
		Assert.assertTrue(login.verifyUserRedirectedToLocationPage());  
	}

	@Then("^verify user is in login page$")
	public void verifyUserIsInLoginPage() {
		Assert.assertTrue(login.verifyUserIsInLoginPage());

	}
}
