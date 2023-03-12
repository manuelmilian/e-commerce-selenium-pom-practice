package Screens;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class ShoppingCart {
	
	public WebDriver driver;
	
	public ShoppingCart (WebDriver driver) {
		this.driver=driver;
		PageFactory.initElements(driver, this);
	}
	
	// Localizadores
	@FindBy(name="cart_quantity[]")
	WebElement cartQty;
	
	@FindBy(id="tdb5")
	WebElement checkoutButton;
	
	// Funciones
	public void clearQuantityBox() {
		cartQty.clear();
	}
	
	public void typeQuantity(String text) {
		cartQty.sendKeys(text);
	}
	
	public void submitQuantity() {
		cartQty.submit();
	}
	
	public void clickOnCheckOutBtn() {
		checkoutButton.click();
	}
}
