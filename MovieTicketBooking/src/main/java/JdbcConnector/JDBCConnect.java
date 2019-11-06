package JdbcConnector;

import java.sql.SQLException;

import javax.sql.rowset.JdbcRowSet;
import javax.sql.rowset.RowSetProvider;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

public class JDBCConnect {
	public static final Logger logger=LoggerFactory.getLogger(JDBCConnect.class);
	static String URL = "jdbc:mysql://localhost/moviebookingdb";
	static String password = "root";
	static String userName = "root";
	public JdbcRowSet getRowSet (String command)
	{
		JdbcRowSet rowSet = null;
	
			
			try {
				rowSet = RowSetProvider.newFactory().createJdbcRowSet();
				rowSet.setUrl(JDBCConnect.URL);
				rowSet.setUsername(JDBCConnect.userName);
				rowSet.setPassword(JDBCConnect.password);
				rowSet.setCommand(command);
				rowSet.execute();
				
			} catch (SQLException e) {
				
				e.printStackTrace();
			}
			
		
		return rowSet;
	}
	
	
	
}
