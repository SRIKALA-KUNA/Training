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
		driver.findElement(By.xpath("//input[@type='submit']")).click();
		
		driver.findElement(By.xpath("//input[@type='radio']")).click();
		
		driver.findElement(By.xpath("/html/body/form/button")).click();
		
	}
	
	public void clickOnLocationOptions(String locationName) {
		
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
