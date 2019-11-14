package JdbcConnector;

import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;

import com.epam.MovieTicketBooking.Booking;

import Sqlcontroller.Controller;

public class UpdateService {
	Booking booking= Controller.returnBookingObject();
	private java.sql.Connection connect = null;
	private java.sql.Statement statement = null;
	private ResultSet resultSet = null;
	public void availSeats(int seats,String seat_type) {
		
		try {
			connect= DriverManager.getConnection("jdbc:mysql://localhost/moviebookingdb","root","root");
			statement = connect.createStatement(  ResultSet.TYPE_SCROLL_INSENSITIVE,
			        ResultSet.CONCUR_UPDATABLE);
		} catch (SQLException e1) {

			e1.printStackTrace();
		}
		if (seat_type.equals("luxuary_seats"))
			try {
				resultSet =statement.executeQuery("SELECT theater_id,show_time,avail_luxury_seats from  theater_time where theater_id ="+ "'" +booking.getTheater()+"'"+"AND theater_time.show_time ="+"'"+booking.getTime()+"'");
				resultSet.absolute(1);
				resultSet.updateInt("avail_luxury_seats" , resultSet.getInt("avail_luxury_seats")-seats);
			resultSet.updateRow();
			
			} catch (SQLException e) {
				e.printStackTrace();
			}
		else
			try {
				resultSet =statement.executeQuery("SELECT theater_id,show_time,avail_normal_seats from  theater_time where theater_id ="+ "'" +booking.getTheater()+"'"+"AND theater_time.show_time ="+"'"+booking.getTime()+"'");
				resultSet.absolute(1);
				resultSet.updateInt("avail_normal_seats" , resultSet.getInt("avail_normal_seats")-seats);
			resultSet.updateRow();
			} catch (SQLException e) {
				e.printStackTrace();
			}
			
	}
}
