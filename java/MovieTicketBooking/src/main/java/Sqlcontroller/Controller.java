package Sqlcontroller;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.logging.Logger;

import com.epam.MovieTicketBooking.Booking;
import com.epam.MovieTicketBooking.DBConnectivity;

import model.User;
import JdbcConnector.Ticket;;

public class Controller {
	static int luxury_seats =200;
	static int normal_seats =100;
	Logger logger  = Logger.getLogger( User.class.getName()); 
	InputStreamReader input=new InputStreamReader(System.in);  
	BufferedReader br=new BufferedReader(input); 
	DBConnectivity database = new DBConnectivity();
	static Booking booking= new Booking();
	Ticket ticket= new Ticket();
	public static Booking returnBookingObject() {
		return booking;
	}

	
	public void run() throws IOException {
		fetchLocation();

		fetchMovie();
		fetchTheater();
		fetchTime();
		fetchSeat_type();
		fetchSeats();
		if(booking.getSeat_type().equals("luxury_seats"))
			logger.info(" Price is: "+(luxury_seats*booking.getSeats()));
		else
			logger.info(" Price is: "+(normal_seats*booking.getSeats()));
		ticket.generateTicket();
		
	}
	public void fetchSeats() throws IOException {
		logger.info("enter number of seats within ");
		database.getSeats(booking.getSeat_type());
		int seats = Integer.parseInt(br.readLine());
		booking.setSeats(seats);
		
	}
	public void fetchSeat_type() throws IOException {
		logger.info("Enter type of seat");
		logger.info("luxury_seats \n normal_seats");
		
		booking.setSeat_type(br.readLine());
	}
	public void fetchTime() throws IOException {
		logger.info("Enter time");
		database.getTime();
		booking.setTime(br.readLine());
		
	}
	public void fetchTheater() throws IOException {
		logger.info("Enter theater");
		database.getTheaters(booking.getMovie());
		booking.setTheater(br.readLine());
		database.setTheater_id();
			}
	public void fetchMovie() throws IOException {
		logger.info("Enter movie");
		database.getMovies(booking.getLocation());
		booking.setMovie(br.readLine());
		database.setMovie_id();
		
	}
	public void fetchLocation() throws IOException {
		logger.info("Enter location");
		database.getLocations();
		booking.setLocation(br.readLine());
		database.setLocation_id(booking.getLocation());
		
	}


}

