package javaConnector;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.HashMap;
import java.util.Iterator;
import java.util.List;
import java.util.logging.Logger;

import DBOperationsInterface.DBInitializeOperation;
import DBOperationsInterface.DBFetchOperation;

public class DBJavaConnector implements DBFetchOperation, DBInitializeOperation {
	protected List<String> location = new ArrayList<String>();
	protected HashMap<String, List<String>> movie = new HashMap<String, List<String>>();
	protected HashMap<Object, List<String>> theater = new HashMap<Object, List<String>>();
	protected List<Integer> price = new ArrayList<Integer>();
	protected List<String> time = new ArrayList<String>();
	Logger logger = Logger.getLogger(DBJavaConnector.class.getName());
	protected int seats =100;

	public DBJavaConnector() {

		initializeLocations();
		initializeMovies();
		initializeTheaters();
		initializePrice();
		initializeTime();
	}

	public void initializeTheaters() {
		List<List<String>> theaterList = new ArrayList<List<String>>();
		List<String> theatersListOne = new ArrayList<String>();
		theatersListOne.add("bvk");
		theatersListOne.add("asian");
		theaterList.add(theatersListOne);
		List<String> theatersListTwo = new ArrayList<String>();
		theatersListTwo.add("miraj");
		theatersListTwo.add("pvr");
		theaterList.add(theatersListTwo);
		List<String> theatersListThree = new ArrayList<String>();
		theatersListThree.add("imax");
		theatersListThree.add("miraj");
		theaterList.add(theatersListThree);
		
		theaterList.add(theatersListOne);

		int index = 0;
		for (String loc : location) {

			for (String m : movie.get(loc)) {
				theater.put(m, theaterList.get(index));
				index++;
			}
		}
	}

	public void initializeMovies() {
		List<List<String>> movies = new ArrayList<List<String>>();
		List<String> moviesAtLocation1 = new ArrayList<String>();
		moviesAtLocation1.add("war");
		moviesAtLocation1.add("dhoom");
		movies.add(moviesAtLocation1);
		movie.put(location.get(0), moviesAtLocation1);
		List<String> moviesAtLocation2 = new ArrayList<String>();
		moviesAtLocation2.add("abcd");
		moviesAtLocation2.add("dhoom");
		movies.add(moviesAtLocation2);
		for (int i = 0; i < location.size(); i++) {
			movie.put(location.get(i), movies.get(i));
		}
		
	}

	public void initializeLocations() {
		location.add("hyderabad");
		location.add("pune");
	}

	public void initializePrice() {
		price.add(100);
		price.add(200);
	}

	public void initializeTime() {
		time.add("11:00 AM");
		time.add("02:00 PM");
		time.add("04:00 PM");
		time.add("06:00 PM");
		time.add("09:00 PM");
	}
	

	public void getLocations() {

		display(location);
	}
	public void getSeats(int seat_type)

	{
		logger.info(Integer.toString(seats));
	}
	
	public void display(List<String> list) {
		Iterator<String> iterator = list.iterator();
		while (iterator.hasNext()) {
			logger.info(iterator.next());
		}
	}

	public void getMovies(String location) {
		display(movie.get(location));

	}

	public void getTheaters(String movie2) {
		display(theater.get(movie2));

	}

	public void getPrice() {
		Iterator<Integer> iterator = price.iterator();
		while (iterator.hasNext()) {
			logger.info(Integer.toString( iterator.next()));
		}

	}

	public void getTime() {
		display(time);
	}

}
