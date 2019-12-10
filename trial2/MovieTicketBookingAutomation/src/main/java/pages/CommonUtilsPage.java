package pages;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

import utils.Utils;

public class CommonUtilsPage {
	@FindBy(xpath ="//button[@type='submit']")
	WebElement next;
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
