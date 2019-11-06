package com.epam.MovieTicketBooking;

public class Booking {
	String location;
	 String movie;
	 String price;
	 int seats;
	 public int getSeats() {
		return seats;
	}
	public void setSeats(int seats) {
		this.seats = seats;
	}
	public String getSeat_type() {
		return price;
	}
	public void setSeat_type(String string) {
		this.price = string;
	}
	public String getTime() {
		return time;
	}
	public void setTime(String time) {
		this.time = time;
	}
	String time;
	 public String getLocation() {
		return location;
	}
	public void setLocation(String location) {
		this.location = location;
	}
	public String getMovie() {
		return movie;
	}
	public void setMovie(String movie) {
		this.movie = movie;
	}
	String theater;
	public String getTheater() {
		return theater;
	}
	public void setTheater(String theater) {
		this.theater = theater;
	}
	
	
}
