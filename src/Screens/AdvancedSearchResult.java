package Screens;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class AdvancedSearchResult {

	public WebDriver driver;
	
	public AdvancedSearchResult (WebDriver driver) {
		this.driver=driver;
		PageFactory.initElements(driver, this);
	}
	
	// Localizadores
	@FindBy(id="tdb4")
	WebElement buyNowButton;
	
	// Funciones
	public void buyNowButton() {
		buyNowButton.click();
	}
}