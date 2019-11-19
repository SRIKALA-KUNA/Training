package Base;

import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.util.Properties;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;



public class Base {
	WebDriver driver;
	static Properties prop;
	public WebDriver init()
	{
		System.setProperty("webdriver.chrome.driver",
				"C:\\Users\\Srikala_Kuna\\eclipse-workspace\\MakeMyTripAutomation\\resource\\chromedriver.exe" );
		driver = new ChromeDriver();
		driver.manage().deleteAllCookies();
		driver.manage().window().fullscreen();
		
		return driver;
		
	}
	
	public  Properties init_properties()
	{
		prop = new Properties();
		FileInputStream file;
		try {
			file = new FileInputStream("C:\\Users\\Srikala_Kuna\\eclipse-workspace\\MakeMyTripAutomation\\src\\main\\java\\Config\\config.properties");
			prop.load(file);
		} catch (FileNotFoundException e) {
			e.printStackTrace();
		}
		catch (IOException e) {
			e.printStackTrace();
		}
		return prop;	
	}
	
	
	

}
