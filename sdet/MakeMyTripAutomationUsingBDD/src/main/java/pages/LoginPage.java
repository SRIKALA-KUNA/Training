package pages;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;


import utils.Utils;






public class LoginPage {
	WebDriver driver;

	@FindBy(xpath ="//*[@id=\"SW\"]/div[2]/div[1]/ul/li[6]")
	WebElement loginButton;
	@FindBy(xpath = "//*[@id=\"username\"]")
	WebElement username;

	@FindBy(xpath = "//*[@id=\"SW\"]/div[2]/div[2]/div[2]/section/form/div[2]/button")
	WebElement nextButton;

	@FindBy(xpath = "//*[@id=\"password\"]")
	WebElement passwordButton;

	@FindBy(xpath ="//button")
	WebElement submit;
	@FindBy(xpath = "//*[@id=\"SW\"]/div[2]/div[2]/div[2]/section/div[1]/div/span")
	WebElement cancel;
	public LoginPage(WebDriver driver)
	{
		this.driver = driver;
		PageFactory.initElements(this.driver, this);
	}
	//@Step("entering login details")
	public void enterLoginDetails() throws InterruptedException
	{	
		Utils.wait(5);
		loginButton.click();
		Utils.wait(5);
		Utils.wait(driver);
		username.sendKeys("jaspreetsinghproacc@gmail.com");
		Utils.wait(5);
		username.submit();
		passwordButton.sendKeys("Qwerty@123");
		Utils.wait(5);
		passwordButton.submit();
		Utils.wait(5);
		cancel.click();	
	}
	
	
}
