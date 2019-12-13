package steps;

import static org.testng.Assert.assertEquals;
import static org.testng.Assert.assertTrue;

import java.util.List;

import org.openqa.selenium.WebDriver;

import base.Base;
import pages.DatePage;
import pages.HomePage;
import pages.LocationPage;
import pages.LoginPage;
import pages.MoviePage;
import pages.Page;
import pages.SeatPage;
import pages.TheatrePage;
import pages.TicketPage;
import pages.TimePage;
import utils.Utils;

public class MovieBookingStep {
	WebDriver driver;
	Page page;
	public MovieBookingStep()
	{
		Base base = new Base();
		this.driver = base.getDriver();
		 page = new Page(driver);
	}
	LoginPage login;
	LocationPage location;
	HomePage home;
	MoviePage movie;
	TheatrePage theatre;
	DatePage date;
	TimePage time;
	SeatPage seat;
	TicketPage ticket;
	public void openLoginPage()   {
		login = new LoginPage();
		home = new HomePage();
		location = new LocationPage();
		movie = new MoviePage();
		theatre = new TheatrePage();
		date = new DatePage();
		time = new TimePage();
		seat = new SeatPage();
		ticket = new TicketPage();
	}
	public void loginUsingCredentials(String username, String password) {
		openLoginPage();
		login.enterLoginCredentials(username,password);
		login.clickOnLogin();
	}

	public void bookTicket(List<List<String>> data) {
		loginUsingCredentials(data.get(1).get(0), data.get(1).get(1));
		proceedForBooking();
		selectLocation(data.get(1).get(2));
		selectMovie(data.get(1).get(3));
		selectTheatre(data.get(1).get(4));
		selectDate(data.get(1).get(5));
		selectTime(data.get(1).get(6));
		selectSeats(data.get(1).get(7));
	}

	public void proceedForBooking() {
		home.cliclOnProccedButton();
	}
	public  List<String> getTicketData() {
		return ticket.tickteData();
	}
	void selectSeats(String selectedSeats) {
		seat.selectSeatOption(selectedSeats);
		location.next();
	}

	void selectTime(String selectedTime) {
		time.selectTimeOption(selectedTime);
		location.next();
	}

	void selectDate(String selectedDate) {
		date.selectDateOption(selectedDate);
		location.next();
	}

	void selectTheatre(String theatreName) {
		theatre.selectTheaterOption(theatreName);
		location.next();
	}
	
	void selectMovie(String movieName) {
		movie.clickOnMovieOption(movieName);
		location.next();
	}

	void selectLocation(String locationName) {
		proceedForBooking();
		location.selectLocationOption(locationName);
		location.next();	
	}

	public boolean verifyUserIsInLoginPage() {
		assertEquals(driver.getTitle(),Utils.TITLE_OF_LOGIN_PAGE);
		location.close();
		return true;
	}

	public void next() {
		location.next();
	}

	public void locationPage(String username, String password) {
		loginUsingCredentials(username, password);
	}

	public boolean verifyTitleOfLocationPage() {
		assertEquals(driver.getTitle(),Utils.TITLE_OF_LOCATION_PAGE);
		location.close();
		return true;
	}

	public void goToMoviePage(List<List<String>> data) {
		locationPage(data.get(1).get(0),data.get(1).get(1));
		selectLocation(data.get(1).get(2));
	}

	public boolean verifyTitleOfMoviePage() {
		assertEquals(driver.getTitle(),Utils.TITLE_OF_MOVIE_PAGE);
		location.close();
		return true;
	}

	public void goToTheatrePage(List<List<String>> data) {
		goToMoviePage(data);
		selectMovie(data.get(1).get(3));

	}

	public boolean verifyTitleOfTheatrePage() {
		assertEquals(driver.getTitle(),Utils.TITLE_OF_THEATRE_PAGE);
		location.close();
		return true;
	}

	public void goToDatePage(List<List<String>> data) {
		goToTheatrePage(data);
		selectTheatre(data.get(1).get(4));

	}

	public boolean verifyTitleOfDatePage() {
		assertEquals(driver.getTitle(),Utils.TITLE_OF_DATE_PAGE);
		location.close();
		return true;
	}

	public void goToTimePage(List<List<String>> data) {
		goToDatePage(data);
		selectDate(data.get(1).get(5));

	}

	public boolean verifyTitleOfTimePage() {
		assertEquals(driver.getTitle(),Utils.TITLE_OF_TIME_PAGE);
		location.close();
		return true;
	}
	public void goToLocationPage(List<List<String>> data) {
		locationPage(data.get(1).get(0),data.get(1).get(1));
		proceedForBooking();

		
	}
	public boolean verifTheTicketDetails(List<String> expected, List<String> actual) {
				for(int i=0;i<actual.size();i++)
		{
			assertTrue(actual.get(i).contains(expected.get(i+2)));
		}
				location.close();
		return true;
	}


}
