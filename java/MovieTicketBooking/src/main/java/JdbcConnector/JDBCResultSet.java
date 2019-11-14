package JdbcConnector;

import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;

import javax.sql.rowset.JdbcRowSet;

public class JDBCResultSet {
	private java.sql.Connection connect = null;
	private java.sql.Statement statement = null;
	private ResultSet resultSet = null;
	public ResultSet getResultSet (String command)
	{
	try {
		connect= DriverManager.getConnection("jdbc:mysql://localhost/moviebookingdb","root","root");
		statement = connect.createStatement();
	} catch (SQLException e) {

		e.printStackTrace();
	}
	return resultSet;
	}
}
