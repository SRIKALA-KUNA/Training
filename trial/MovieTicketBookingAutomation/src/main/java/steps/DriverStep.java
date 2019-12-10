package steps;

import java.net.MalformedURLException;

import org.openqa.selenium.WebDriver;

import base.Base;

public class DriverStep {
	
	protected  WebDriver driver ;
	public DriverStep() throws MalformedURLException
	{
		Base base = new Base();
		driver = base.getDriver();	
	}

}
