package Screens;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class CheckoutConfirmation {

	public WebDriver driver;
	
	public CheckoutConfirmation (WebDriver driver) {
		this.driver=driver;
		PageFactory.initElements(driver, this);
	}
	
	// Localizadores
	@FindBy(id="tdb5")
	WebElement confirmOrderButton;
	
	// Funciones
	public void clickConfirmOrder() {
		confirmOrderButton.click();
	}
}
