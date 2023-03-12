package Screens;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class Catalog {
	
	public WebDriver driver;
	
	// Localizadores
	@FindBy(name="keywords")
	WebElement quickFind;
	
	public Catalog (WebDriver driver) {
		this.driver=driver;
		PageFactory.initElements(driver, this);
	}
	

	// Funciones
	public void clearSearchBox() {
		quickFind.clear();
	}
	
	public void typeProduct(String inputText) {
		quickFind.sendKeys(inputText);
	}
	
	public void submitProduct() {
		quickFind.submit();
	}

}
