package test;

import java.util.concurrent.TimeUnit;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;

import main.utils.Driver;

public class TestBase extends Driver{
	@BeforeMethod
	public void beforeTest(){
		getDriver().manage().window().maximize();
		getDriver().manage().timeouts().implicitlyWait(5, TimeUnit.SECONDS);
	}
	@AfterMethod
	public void afterTest() throws InterruptedException{
		Thread.sleep(3000);
		closeDriver();
	}
	
}
