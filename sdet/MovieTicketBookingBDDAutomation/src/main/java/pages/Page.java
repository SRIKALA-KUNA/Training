package pages;

import org.openqa.selenium.WebDriver;
import utils.Utils;

public class Page {
	protected static  WebDriver driver;
	public Page(WebDriver driver) {
		Page.driver = driver;
	}
	public void openBasePage()
	{
		driver.get(Utils.BASE_URL);
	}
	public void close()
	{
		driver.close();
	}

}
