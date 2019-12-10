package DriverUtilities;

import org.testng.annotations.DataProvider;

public class BrowsersData {
	@DataProvider(name ="browsers")
	public Object[] browsers() {
		Object[] object = new Object[]{
				"chrome"
				//"firefox",
				//"internet explorer"
		};
		return object;
		
	}

}
