package Processes;


import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.ui.WebDriverWait;

import Screens.*;

public abstract class Process {
	private static final int ESPERA = 10;
	
	protected WebDriverWait wait;
	protected WebDriver driver;
	
	public Catalog catalog;
	public Login login;
	public AdvancedSearchResult advancedSearchResult;
	public ShoppingCart shoppingCart;
	public CheckoutShipping checkoutShipping;
	public CheckoutPayment checkoutPayment;
	public CheckoutConfirmation checkoutConfirmation;
		
	public Process(WebDriver driver) {
		processInitialization(driver);
	}

	public abstract void executeProcess();
		
	private void processInitialization(WebDriver driver) {
		this.driver = driver;
		catalog = new Catalog(driver);
		login =  new Login(driver);
		advancedSearchResult = new AdvancedSearchResult(driver);
		shoppingCart = new ShoppingCart(driver);
		checkoutShipping = new CheckoutShipping(driver);
		checkoutPayment = new CheckoutPayment(driver);
		checkoutConfirmation = new CheckoutConfirmation(driver);
		wait = new WebDriverWait(driver, ESPERA);
	}
}
