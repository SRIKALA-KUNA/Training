package Base;

import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.util.Properties;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;

public class Base {
	WebDriver driver;
	Properties prop;
	public WebDriver init()
	{
		System.setProperty("webdrive.chrome.driver",
				"C:\\Users\\Srikala\\eclipse-workspace\\Tasks\\resource\\chromedriver.exe" );
		driver = new ChromeDriver();
		return driver;
		
	}
	
	public Properties init_properties()
	{
		prop = new Properties();
		FileInputStream file;
		try {
			file = new FileInputStream("C:\\Users\\Srikala\\eclipse-workspace\\Tasks\\src\\test\\java\\Config\\config.properties");
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
	

}
