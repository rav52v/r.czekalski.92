package main.utils;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.testng.annotations.Parameters;

public class Driver {
	
	private static WebDriver driver;
	private static final String LinkAdress = "http://automationpractice.com/index.php";
	
	@Parameters({"explorer"})
		public static WebDriver getDriver(String explorer) {
		switch (explorer) {
			case "mozilla":
				if (driver==null) {
					System.setProperty("webdriver.gecko.driver", "src\\test\\resources\\geckodriver.exe");
					driver = new FirefoxDriver();
					driver.get(LinkAdress);
			}
			return driver;
			case "google":
				if (driver==null) {
					System.setProperty("webdriver.chrome.driver", "src\\test\\resources\\chromedriver.exe");
					driver = new ChromeDriver();
					driver.get(LinkAdress);
				}
				return driver;
		}
		return null;
		}
		
		public static void close() {
			driver.quit();
			driver = null;
		}
}