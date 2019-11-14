package com.epam.Tasks;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.annotations.BeforeClass;

public class Factory {
	WebDriver driver;
	@BeforeClass
	void initialize() {

		System.setProperty("webdriver.chrome.driver", "C:\\\\Users\\\\Srikala\\\\eclipse-workspace\\\\Tasks\\\\resource\\\\chromedriver.exe");
		driver= new ChromeDriver();	

	}
}