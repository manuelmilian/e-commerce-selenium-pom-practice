package Screens;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class CheckoutShipping {

	public WebDriver driver;
	
	public CheckoutShipping (WebDriver driver) {
		this.driver=driver;
		PageFactory.initElements(driver, this);
	}
	
	// Localizadores
	@FindBy(id="tdb6")
	WebElement continueButton;
	
	// Funciones
	public void clickContinueButton() {
		continueButton.click();
	}
}
