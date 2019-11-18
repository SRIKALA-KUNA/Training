package FlightBooking;

import java.io.File;
import java.io.IOException;
import java.util.Set;

import org.apache.commons.io.FileUtils;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;

public class Settings {
	WebDriver driver;
	File source;
	String baseUrl_deals ="https://www.makemytrip.com/daily-deals/";
	static String baseUrl ="https://www.makemytrip.com/";
	public static String baseUrl_hotels ="https://www.makemytrip.com/hotels/";
	public Settings() 
	{
		System.setProperty("webdriver.chrome.driver",
				"C:\\\\Users\\\\Srikala\\\\eclipse-workspace\\\\Tasks\\\\resource\\\\chromedriver.exe");
		
	}

	public WebDriver getDriver() {
		driver = new ChromeDriver();
		driver.manage().deleteAllCookies();
		driver.manage().window().fullscreen();
		return this.driver;
	}
	
	public WebDriver nextWindow(WebDriver driver)
	{
		Set<String> windowHandles = driver.getWindowHandles();
        for(String winHandle : windowHandles){
            driver.switchTo().window(winHandle);
        }
        
        return driver;
	}
	
	public void screenShot(WebDriver driver) throws IOException
	{
		TakesScreenshot screenShot = (TakesScreenshot)driver;
		source = screenShot.getScreenshotAs(OutputType.FILE);
		FileUtils.copyFile(source, new File(""));
		
		}

}
