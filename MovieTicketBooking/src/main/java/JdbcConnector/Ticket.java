package JdbcConnector;

import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;

import com.epam.MovieTicketBooking.Booking;

import Sqlcontroller.Controller;

public class Ticket {
	
	Booking booking= Controller.returnBookingObject();
	private java.sql.Connection connect = null;
	private java.sql.Statement statement = null;
	String location_id = null;
	String movie_id = null;
	String theater_id = null;
	String seat_type = null;
	int num_of_seats ;
	public void generateTicket() {
	try {
		connect= DriverManager.getConnection("jdbc:mysql://localhost/moviebookingdb","root","root");
		statement = connect.createStatement();
		 location_id = booking.getLocation();
		 movie_id = booking.getMovie();
		 theater_id = booking.getTheater();
		 seat_type = booking.getSeat_type();
		 num_of_seats = booking.getSeats();
		
		 String sql ="INSERT INTO booking values (null,'"+location_id+"','"+movie_id+"','"+theater_id+"','"+seat_type+"','"+num_of_seats+"')";
		
		statement.executeUpdate(sql);
	} catch (SQLException e1) {

		e1.printStackTrace();
	}

}
}