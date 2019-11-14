package Sqlcontroller;

import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.List;

import javax.sql.RowSet;
import javax.sql.rowset.JdbcRowSet;
import javax.sql.rowset.RowSetProvider;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import com.epam.MovieTicketBooking.Booking;

import DBOperationsInterface.DBFetchOperation;
import JdbcConnector.JDBCConnect;
import JdbcConnector.UpdateService;



public class DBSqlConnector implements DBFetchOperation {
	UpdateService update =new UpdateService();

	RowSet rowSet =null;
	Booking booking= Controller.returnBookingObject();
	JDBCConnect jdbc = new JDBCConnect();
	private static final Logger logger = LoggerFactory.getLogger(DBSqlConnector.class);

	public void getLocations() {
		try {
			rowSet = jdbc.getRowSet ("SELECT location_name FROM location");
			display();

		} catch (SQLException e) {
			e.printStackTrace();
		}
	}


	public void display() throws SQLException {
		while (rowSet.next())
		{
			logger.info(rowSet.getString(1));
		}
	}


	public void setLocation_id(String location) {

		rowSet = jdbc.getRowSet("SELECT location_id FROM location where location_name ="+ " '" +location+ "'"); 
		try {
			while(rowSet.next())
			{
				booking.setLocation(rowSet.getString(1));
			}
		} catch (SQLException e) {
			e.printStackTrace();
		}
	}



	public void getMovies(String location) {
		try {

			rowSet = jdbc.getRowSet ("SELECT movie_name FROM movie where movie.location_id="+"'"+ booking.getLocation()+ "'");
			display();

		} catch (SQLException e) {
			e.printStackTrace();
		}
	}


	public void setMovie_id() {
		rowSet = jdbc.getRowSet ("SELECT movie_id FROM movie where movie_name ="+ "'" + booking.getMovie()+ "'");
		try {
			while(rowSet.next())
			{
				booking.setMovie(rowSet.getString(1));
			}
		} catch (SQLException e) {

			e.printStackTrace();
		}
	}


	public void getTheaters(String movie2) {
		rowSet = jdbc.getRowSet("SELECT  theater.theater_name FROM connect,theater where  connect.location_id =" + "'" +booking.getLocation() + "'" + " AND connect.movie_id = " + "'" + booking.getMovie() + "'"+"AND theater.theater_id=connect.theater_id");

		try {
			display();
		} catch (SQLException e) {

			e.printStackTrace();
		}
	}


	public void setTheater_id() {
		rowSet = jdbc.getRowSet ("SELECT theater_id FROM theater where theater_name ="+ "'" + booking.getTheater()+ "'");
		try {
			while(rowSet.next())
			{
				booking.setTheater(rowSet.getString(1));
			}
		} catch (SQLException e) {

			e.printStackTrace();
		}



	}


	public void getPrice() {


	}


	public void getTime() {

		rowSet = jdbc.getRowSet("SELECT theater_time.show_time FROM theater_time where theater_time.theater_id= " + "'" +booking.getTheater() + "'");

		try {

			display();

		} catch (SQLException e) {
			e.printStackTrace();
		}

	}


	public void getSeats(String seat_type) {
		if( seat_type.equals("luxury_seats"))
			getLuxurySeats( seat_type);
		else
			getNormalSeats(seat_type);
	}


	private void getNormalSeats(String seat_type) {
		try {


			rowSet = jdbc.getRowSet(" SELECT  theater_time.avail_normal_seats FROM theater_time where theater_time.theater_id=" + "'" + booking.getTheater() +"'" + "AND theater_time.show_time =  " + "'" + booking.getTime() + "'");

			display();

		} catch (SQLException e) {
			e.printStackTrace();
		}
		update.availSeats(booking.getSeats(),seat_type);

	}


	public void getLuxurySeats(String seat_type) {
		try {


			rowSet = jdbc.getRowSet(" SELECT  theater_time.avail_luxury_seats FROM theater_time where theater_time.theater_id=" + "'" + booking.getTheater() +"'" + "AND theater_time.show_time =  " + "'" + booking.getTime() + "'");

			display();

		} catch (SQLException e) {
			e.printStackTrace();
		}
		update.availSeats(booking.getSeats(),seat_type);

	}


}
