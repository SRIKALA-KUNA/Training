package stepdefinitions;


import java.util.List;
import org.testng.Assert;
import cucumber.api.DataTable;
import cucumber.api.java.en.Given;
import cucumber.api.java.en.Then;
import cucumber.api.java.en.When;
import steps.MovieBookingStep;
public class MovieTicketBookingStepDefinition {
	MovieBookingStep movieBooking;

	List<List<String>> data;
	@Given("^user opens application$")
	public void opensApplication()  {
		movieBooking = new MovieBookingStep();

	}

	@When("^user enters details for movie booking$")
	public void dataForMovieBooking(DataTable details)  {
		data = details.raw();
		movieBooking.bookTicket(data);
	}

	@Then("^verify the ticketBooked contains all the details$")
	public void verifyTheTicketBookedContainsAllTheDetails()  {
		List <String> expected = data.get(1);
		List<String> actual = (List<String>) movieBooking.getTicketData();
		Assert.assertTrue(movieBooking.verifTheTicketDetails(expected,actual));

	}
	@When("^user enters details\"(.*?)\"\"(.*?)\" for movie booking$")
	public void userEntersLoginDetails(String username, String password)  {
		movieBooking.loginUsingCredentials(username, password);
	}

	@Then("^verify the user is in login Page$")
	public void verifyTheUserIsInLoginPage() {
		Assert.assertTrue(movieBooking.verifyUserIsInLoginPage());
	}

	@When("^user is in location page and clicks on next button$")
	public void userIsInLocationPageAndClicksOnNextButton(DataTable details)  {
		data = details.raw();
		movieBooking.goToLocationPage(data);
		movieBooking.next();
	}

	@Then("^verify the user is in location Page$")
	public void verifyTheUserIsInLocationPage()  {
		Assert.assertTrue(movieBooking.verifyTitleOfLocationPage());
	}

	@When("^user is in movie page and clicks on next button$")
	public void userIsInMoviePageAndClicksOnNextButton(DataTable details) {
		data = details.raw();
		movieBooking.goToMoviePage(data);
		movieBooking.next();

	}

	@Then("^verify the user is in movie Page$")
	public void verifyTheUserIsInMoviePage()  {
		Assert.assertTrue(movieBooking.verifyTitleOfMoviePage());
	}

	@When("^user is in theatre page and clicks on next button$")
	public void userIsInTheatrePageAndClicksOnNextButton(DataTable details) {
		data = details.raw();
		movieBooking.goToTheatrePage(data);
		movieBooking.next();   
	}

	@Then("^verify the user is in theatre Page$")
	public void verifyTheUserIsInTheatrePage()  {
		Assert.assertTrue(movieBooking.verifyTitleOfTheatrePage());
	}

	@When("^user is in date page and clicks on next button$")
	public void userIsInDatePageAndClickOnNextButton(DataTable details)  {
		data = details.raw();
		movieBooking.goToDatePage(data);
		movieBooking.next();
	}

	@Then("^verify the user is in date Page$")
	public void verifyTheUserIsInDatePage() {
		Assert.assertTrue(movieBooking.verifyTitleOfDatePage());
	}

	@When("^user is in time page and clicks on next button$")
	public void userIsInTimePageAndClicksOnNextButton(DataTable details) {
		data = details.raw();
		movieBooking.goToTimePage(data);
		movieBooking.next();
	}

	@Then("^verify the user is in time Page$")
	public void verifyTheUserIsInTimePage() {
		Assert.assertTrue(movieBooking.verifyTitleOfTimePage());
	}
	

}
