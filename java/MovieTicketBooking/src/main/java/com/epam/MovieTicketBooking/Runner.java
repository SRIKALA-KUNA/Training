package com.epam.MovieTicketBooking;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.logging.Logger;

public class Runner {
	Logger logger  = Logger.getLogger( User.class.getName()); 
	InputStreamReader input=new InputStreamReader(System.in);  
	BufferedReader br=new BufferedReader(input); 
	DBConnectivity database = new DBConnectivity();
	Booking booking= database.returnBookingObject();
	
	public void run() throws IOException {
		displayLocation();

		displayMovie();
		displayTheater();
		displayTime();
		displayPrice();
		displaySeats();
		logger.info(" Price is: "+(booking.getPrice()*booking.getSeats()));
		
	}
	public void displaySeats() throws IOException {
		logger.info("enter number of seats within ");
		database.getSeats();
		int seats = Integer.parseInt(br.readLine());
		if (database.chechSeats(seats))
		{
			booking.setSeats(seats);
		}
		else
			logger.info("haven't entered appropriate number of seats" );
	}
	public void displayPrice() throws IOException {
		logger.info("Enter price");
		database.getPrice();
		booking.setPrice(Integer.parseInt(br.readLine()));
		if( database.checkPrice(booking.getPrice()) == false)
		{
			run();
		}
	}
	public void displayTime() throws IOException {
		logger.info("Enter time");
		database.getTime();
		booking.setTime(br.readLine());
		if(  database.checkTime(booking.getTime()) == false)
		{
			run();
		}
	}
	public void displayTheater() throws IOException {
		logger.info("Enter theater");
		database.getTheaters(booking.getMovie());
		booking.setTheater(br.readLine());
		if (  database.checkTheater(booking.getTheater()) == false)
		{
			run();
		}
	}
	public void displayMovie() throws IOException {
		logger.info("Enter movie");
		database.getMovies(booking.getLocation());
		booking.setMovie(br.readLine());
		if( database.checkMovie(booking.getMovie()) == false)
		{
			run();
		}
	}
	public void displayLocation() throws IOException {
		logger.info("Enter location");
		database.getLocations();
		booking.setLocation(br.readLine());
		if ( database.checkLocation(booking.getLocation())== false)
		{
			run();
		}
	}


}
