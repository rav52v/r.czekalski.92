package test;

import java.util.concurrent.TimeUnit;
import org.testng.annotations.AfterClass;
import org.testng.annotations.BeforeClass;
import main.utils.Driver;

public class TestBase extends Driver{
	
	protected static int IMPLICITY_WAIT_TIME = 5;
	
	@BeforeClass
	public void beforeTest(){
		getDriver().manage().window().maximize();
		getDriver().manage().timeouts().implicitlyWait(IMPLICITY_WAIT_TIME, TimeUnit.SECONDS);
	}
	@AfterClass
	public void afterTest() throws InterruptedException{
		Thread.sleep(3000);
		closeDriver();
	}
	
}
