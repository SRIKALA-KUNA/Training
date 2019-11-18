package Base;

import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.util.Properties;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;

import io.restassured.internal.support.FileReader;

public class Base {
	WebDriver driver;
	static Properties prop;
	public WebDriver init()
	{
		System.setProperty("webdrive.chrome.driver",
				"C:\\Users\\Srikala_Kuna\\eclipse-workspace\\MakeMyTripAutomation\\resource\\chromedriver.exe" );
		driver = new ChromeDriver();
		return driver;
		
	}
	
	public static Properties init_properties()
	{
		prop = new Properties();
		FileInputStream file;
		try {
			file = new FileInputStream("C:\\Users\\Srikala_Kuna\\eclipse-workspace\\MakeMyTripAutomation\\src\\test\\java\\Config\\config.properties");
			prop.load(file);
		} catch (FileNotFoundException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return prop;	
	}
	
	/*public Properties readFromPropertyFile(Properties propertyFile)
	{
		FileReader reader=new FileReader("db.properties");  
	      
	    Properties p=new Properties();  
	    p.load(reader);  
	      
		return prop;
		
	}*/
	

}
