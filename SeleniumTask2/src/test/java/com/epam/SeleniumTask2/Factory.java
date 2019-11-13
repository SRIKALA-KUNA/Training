package com.epam.SeleniumTask2;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.annotations.BeforeClass;

public class Factory {
	WebDriver driver;
	@BeforeClass
	void initialize() {

		System.setProperty("webdriver.chrome.driver", "C:\\Users\\Srikala_Kuna\\eclipse-workspace\\SeleniumTask2\\resource\\chromedriver.exe");
		driver= new ChromeDriver();	

	}
}
