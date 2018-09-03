package main.utils;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Parameters;

public class Driver {
	private static final String LINK_ADDRESS = "http://automationpractice.com/index.php";
	private static WebDriver driver;
	
	@BeforeTest
	@Parameters({"browser"})
	public void setupDriver(String browser) throws Exception {
		if(browser.equalsIgnoreCase("mozilla")) {
			if (driver==null) {
				System.setProperty("webdriver.gecko.driver", "src\\test\\resources\\geckodriver.exe");
				driver = new FirefoxDriver();
				driver.get(LINK_ADDRESS);
			}
		}
		else if(browser.equalsIgnoreCase("chrome")) {
			if (driver==null) {
				System.setProperty("webdriver.chrome.driver", "src\\test\\resources\\chromedriver.exe");
				driver = new ChromeDriver();
				driver.get(LINK_ADDRESS);
			}
		}
		else {
			throw new Exception("Wrong browser! Check parametr for browser in testng.xml!");
		}
	}
	
	public static WebDriver getDriver() {
		return driver;
	}
	
	public static void closeDriver() {
		driver.close();
		driver = null;
	}
}