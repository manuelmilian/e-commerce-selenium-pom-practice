package Screens;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.PageFactory;

public class CheckoutSuccess {

	public WebDriver driver;
	
	public CheckoutSuccess (WebDriver driver) {
		this.driver=driver;
		PageFactory.initElements(driver, this);
	}
		
}
