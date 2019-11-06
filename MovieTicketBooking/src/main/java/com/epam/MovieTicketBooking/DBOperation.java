package com.epam.MovieTicketBooking;

import java.util.List;

public interface DBOperation {
	
	public void initializeLocations();
	public void initializeMovies();
	public void initializeTheaters();
	public void initializePrice();
	public void initializeTime();
	public void getLocations();
	public void display(List<String> list);
	public void getMovies(String location);
	public void getTheaters(String movie2);
	public void getPrice();
	public void getTime();
	public void getSeats();
	
	


}
