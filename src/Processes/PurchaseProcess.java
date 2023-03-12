package Processes;

import static org.junit.jupiter.api.Assertions.assertEquals;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;


public class PurchaseProcess extends Process {

	private String url;
	private String product;
	private String quantity;
			
	public PurchaseProcess(WebDriver driver, String url, String product, String quantity) {
		super(driver);
		this.url=url;
		this.product=product;		
		this.quantity=quantity;
	}
			
	private void enterSite(String url) {
		driver.get(url);
	}
	
	private void selectProductAndQuantity(String product, String quantity) {
		WebElement confirmLocation = driver.findElement(By.xpath("//*[@id=\"bodyContent\"]/h1"));
		assertEquals("Welcome to DemoSQAUPC", confirmLocation.getText()); // Confirmamos que estamos en la página de inicio
		catalog.clearSearchBox();
		catalog.typeProduct(product);
		catalog.submitProduct();
		
		WebElement confirmLocation2 = driver.findElement(By.xpath("//*[@id=\"bodyContent\"]/h1"));
		assertEquals("Products meeting the search criteria", confirmLocation2.getText()); // Confirmamos que estamos en la página de búsqueda
		
		WebElement confirmProduct = driver.findElement(By.linkText(product)); 
		assertEquals(product, confirmProduct.getText()); // Confirmamos que el producto seleccionado ha aparecido en la búsqueda
		advancedSearchResult.buyNowButton();
		
		WebElement confirmLocation3 = driver.findElement(By.xpath("//*[@id=\"bodyContent\"]/h1"));
		assertEquals("What's In My Cart?", confirmLocation3.getText()); // Confirmamos que que estamos en la página shopping_cart
		shoppingCart.clearQuantityBox();
		shoppingCart.typeQuantity(quantity);
		shoppingCart.submitQuantity();
		WebElement confirmLocation4 = driver.findElement(By.name("cart_quantity[]")); 
		assertEquals(quantity, confirmLocation4.getAttribute("value")); // Confirmamos que la cantidad se ha actualizado correctamente
		
		shoppingCart.clickOnCheckOutBtn();
	}
		
	public void login(String email, String password) {
		WebElement confirmLocation = driver.findElement(By.xpath("//*[@id=\"bodyContent\"]/h1"));
		assertEquals("Welcome, Please Sign In", confirmLocation.getText()); // Confirmamos que estamos en la página de login
		login.email(email);
		login.password(password);
		login.clickLoginButton();
	}

	public void paymentProcess(){
		WebElement confirmLocation = driver.findElement(By.xpath("//*[@id=\"bodyContent\"]/h1"));
		assertEquals("Delivery Information", confirmLocation.getText()); // Confirmamos que estamos en la página checkout_shipping
		checkoutShipping.clickContinueButton();
		
		WebElement confirmLocation2 = driver.findElement(By.xpath("//*[@id=\"bodyContent\"]/h1"));
		assertEquals("Payment Information", confirmLocation2.getText()); // Confirmamos que estamos en la página checkout_payment
		checkoutPayment.clickCashOnDelivery();
		checkoutPayment.clickContinueButton();
		
	}
		
	public void confirmPayment(){
		WebElement confirmLocation = driver.findElement(By.xpath("//*[@id=\"bodyContent\"]/h1"));
		assertEquals("Order Confirmation", confirmLocation.getText()); // Confirmamos que estamos en la página checkout_confirmation	
		checkoutConfirmation.clickConfirmOrder();
				
		WebElement orderProcessed = driver.findElement(By.xpath("//*[@id=\"bodyContent\"]/h1"));
		assertEquals("Your Order Has Been Processed!", orderProcessed.getText()); // Confirmamos que el proceso de compra ha acabado con éxito
	}
			
	@Override
	public void executeProcess() {
		enterSite(url);
		selectProductAndQuantity(product, quantity);		
	}
}
