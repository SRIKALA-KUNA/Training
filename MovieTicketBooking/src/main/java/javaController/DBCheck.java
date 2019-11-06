package javaController;

import java.util.Iterator;
import java.util.logging.Logger;

import com.epam.MovieTicketBooking.Booking;

import javaConnector.DBJavaConnector;

public class DBCheck extends DBJavaConnector {
	
	
	Booking booking=new Booking();
	public Booking returnBookingObject() {
		return booking;
	}
	public boolean checkLocation(String enteredLocation)
	{
		
		return location.contains(enteredLocation);
		
	}
	public boolean checkMovie(String enteredMovie)
	{
		
		return movie.get(booking.getLocation()).contains(enteredMovie);
		
	}
	
	public boolean checkTheater(String enteredtheater)
	{
		
		return theater.get(booking.getMovie()).contains(enteredtheater);
	}
	public boolean checkTime(String enteredTime)
	{
		return time.contains(enteredTime);
	}
	public boolean checkPrice(int enteredPrice)
	{
		return price.contains(enteredPrice);
	}
	public boolean chechSeats(int enteredSeats)
	{
		if (enteredSeats < seats)
		{
			
			return true;
		}
		return false;
		
	}

}
