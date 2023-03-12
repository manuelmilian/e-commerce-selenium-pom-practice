package Screens;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class Login {
	public WebDriver driver;
	
	public Login (WebDriver driver) {
		this.driver=driver;
		PageFactory.initElements(driver, this);
	}
	
	// Localizadores
	@FindBy(name="email_address")
	WebElement emailTextBox;
	
	@FindBy(name="password")
	WebElement passTextBox;
	
	@FindBy(id="tdb1")
	WebElement signInButton;
	
	// Funciones
	public void email(String email) {
		emailTextBox.sendKeys(email);
	}
	
	public void password(String password) {
		passTextBox.sendKeys(password);
	}
	
	public void clickLoginButton() {
		signInButton.click();
	}
}
