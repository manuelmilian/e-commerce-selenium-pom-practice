package TestCases;

import java.io.IOException;
import java.util.ArrayList;
import org.junit.jupiter.api.AfterAll;
import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import org.openqa.selenium.remote.CapabilityType;
import Processes.PurchaseProcess;
import io.github.bonigarcia.wdm.WebDriverManager;

class TestCase1{
	
	private static WebDriver driver;
	private static ChromeOptions chromeOptions;
	private PurchaseProcess purchaseProcess;
	String url = "http://sqademosatp.net/catalog/";
	
	public static void createAndStartService() throws IOException {
		WebDriverManager.chromedriver().setup();
  		ArrayList<String> optionsList = new ArrayList<String>();
		chromeOptions = new ChromeOptions();
		optionsList.add("--start-maximized");
		optionsList.add("--incognito");
		optionsList.add("disable-notifications");
		chromeOptions.addArguments(optionsList);
		chromeOptions.setCapability(CapabilityType.ACCEPT_SSL_CERTS, true);
  		chromeOptions.setCapability(CapabilityType.ACCEPT_INSECURE_CERTS, true);
	}
		
	public static void createDriver() {
		driver = new ChromeDriver(chromeOptions);		
	}
	
	public static void quitDriver() {
		driver.quit();
	}

	@BeforeAll
	static void setUpBeforeClass() throws Exception {
		createAndStartService();			
	}

	@AfterAll
	static void tearDownAfterClass() throws Exception {}

	@BeforeEach
	void setUp() throws Exception {
		createDriver();
		driver.manage().window().maximize();	
	}

	@AfterEach
	void tearDown() throws Exception {
		quitDriver();
	}

	
	/*
	 * Para realizar el test creamos un nuevo objeto PurchaseProcess y le pasamos los atributos driver, url, product y quantity
	 * Lanzamos el proceso de compra
	 * Llamamos a la funci�n del login y le pasamos los atributos user y password
	 * Iniciamos el proceso de pago
	 * Y ejecutamos el pago
	 */
	
	@Test
	 void test1() {
		purchaseProcess = new PurchaseProcess(driver, url, "Samsung Galaxy Tab", "2");
		purchaseProcess.executeProcess();
		purchaseProcess.login("test@test.com", "jjXs2_53d");
		purchaseProcess.paymentProcess();
		purchaseProcess.confirmPayment();
	}
	
	@Test
	void test2() {
		purchaseProcess = new PurchaseProcess(driver, url, "Beloved", "3");
		purchaseProcess.executeProcess();
		purchaseProcess.login("test@test.com", "jjXs2_53d");
		purchaseProcess.paymentProcess();
		purchaseProcess.confirmPayment();
	}
}