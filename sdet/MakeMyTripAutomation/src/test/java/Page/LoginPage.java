package Page;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import com.epam.MakeMyTripAutomation.Settings;

public class LoginPage {
	WebDriver driver;
	
	@FindBy(xpath ="//*[@id=\"SW\"]/div[2]/div[1]/ul/li[6]")
	WebElement login;
	@FindBy(xpath = "//*[@id=\"username\"]")
	WebElement username;
	
	@FindBy(xpath = "//*[@id=\"SW\"]/div[2]/div[2]/div[2]/section/form/div[2]/button")
	WebElement next;
	
	@FindBy(xpath = "//*[@id=\"password\"]")
	WebElement password;
	
	@FindBy(xpath ="//button")
	WebElement submit;
	@FindBy(xpath = "//*[@id=\"SW\"]/div[2]/div[2]/div[2]/section/div[1]/div/span")
	WebElement cancel;
	public LoginPage(WebDriver driver)
	{
		this.driver = driver;
		PageFactory.initElements(this.driver, this);
	}
	
	public void verifyLoginPage() throws InterruptedException
	{
		driver.get(Settings.baseUrl);
		Settings.sleep();
		login.click();
		Settings.sleep();
		Settings.wait(driver);
		username.sendKeys("jaspreetsinghproacc@gmail.com");
		Settings.sleep();
		username.submit();
		password.sendKeys("Qwerty@123");
		Settings.sleep();
		password.submit();
		cancel.click();
	}
	
}
