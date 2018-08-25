package test;

import java.util.concurrent.TimeUnit;

import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Parameters;

import main.utils.Driver;

public class TestBase {
	@BeforeMethod
	@Parameters({"explorer"})
	public void beforeTest(String explorer){
		Driver.getDriver(explorer).manage().window().maximize();
		Driver.getDriver(explorer).manage().timeouts().implicitlyWait(5, TimeUnit.SECONDS);

	}
	
	
	@AfterMethod
	public void afterTest() throws InterruptedException{
		Thread.sleep(2000);
		Driver.close();
	}
}