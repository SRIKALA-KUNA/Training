package pages;

import java.util.List;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import utils.Utils;

public class LocationPage {
	WebDriver driver;
	@FindBy (xpath ="//input")
	List<WebElement> locations;
	
	@FindBy(xpath ="//button[@type='submit']")
	WebElement next;
	public LocationPage(WebDriver driver) {
		this.driver = driver;
		PageFactory.initElements(this.driver, this);
	}
	//for now 
	public void preRequisit()
	{
		try {
			Utils.wait(5);
		} catch (InterruptedException e1) {
			// TODO Auto-generated catch block
			e1.printStackTrace();
		}
		driver.findElement(By.xpath("/html/body/form/input")).click();	
		try {
			Utils.wait(5);
		} catch (InterruptedException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}
	
	public void selectLocationOptions(String locationName) {
		
		try {
			
			for(WebElement location:locations)
	        {
				Utils.wait(5);
	            String locationValue = location.getAttribute("value");
	            if(locationValue.contains(locationName))
	            {
	            	location.click();
	                break;
	            }
	           
	        }
		} catch (InterruptedException e) {
			
			e.printStackTrace();
		}
		
	}
	public void next() {
		try {
			Utils.wait(5);
			next.click();
			Utils.wait(5);
		} catch (InterruptedException e) {
			e.printStackTrace();
		}
		
		
	}
	
	

}
