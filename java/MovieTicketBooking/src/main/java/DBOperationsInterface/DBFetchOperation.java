package DBOperationsInterface;

import java.util.List;

public interface DBFetchOperation {
	
	
	public void getLocations();
	
	public void getMovies(String location);
	public void getTheaters(String movie2);
	public void getPrice();
	public void getTime();
	//public void getSeats(int seat_type);
	
	


}
