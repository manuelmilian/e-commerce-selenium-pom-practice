package Screens;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class CheckoutPayment {

	public WebDriver driver;
	
	public CheckoutPayment (WebDriver driver) {
		this.driver=driver;
		PageFactory.initElements(driver, this);
	}
	
	// Localizadores
	@FindBy(xpath="//*[@id='bodyContent']/form/div/div[4]/table[1]/tbody/tr/td[2]/input")
	WebElement cashOnDelivery;
	
	@FindBy(id="tdb6")
	WebElement continueButton;
	
	// Funciones
	public void clickCashOnDelivery() {
		cashOnDelivery.click();
	}
	
	public void clickContinueButton() {
		continueButton.click();
	}
}
