package DriverUtilities;
import org.openqa.selenium.WebDriver;
import org.testng.annotations.Test;
public class DriverRunner  {

	public WebDriver getDriver(String inputBrowser)
	{
		DriverFactory driver = new DriverFactory();
		return driver.getDriverInstance(inputBrowser);
	}

}
