package main.utils;

import java.util.concurrent.TimeUnit;

import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.PageFactory;

import test.TestBase;

public abstract class BasePage extends TestBase{

	public BasePage() {
		PageFactory.initElements(Driver.getDriver(), this);
	}
	
	protected void focusOnElement(WebElement element) {
		Actions act = new Actions(Driver.getDriver());
		/*Twice, because ones doesn't work for Mozilla*/
		act.moveToElement(element).build().perform();
		act.moveToElement(element).build().perform();
	}
	
	protected void implicityWaitTurnOff() {
		Driver.getDriver().manage().timeouts().implicitlyWait(0, TimeUnit.SECONDS);
	}
	protected void implicityWaitTurnOn() {
		Driver.getDriver().manage().timeouts().implicitlyWait(IMPLICITY_WAIT_TIME, TimeUnit.SECONDS);
	}
	
	protected void scrollToElement(WebElement element, int scrollValue) {
		int elementYposition = element.getLocation().getY();
		int browserYsize = Driver.getDriver().manage().window().getSize().height;
		int scrollTempValue = 0;
		if(browserYsize-350 < elementYposition) {
			scrollTempValue = Math.abs(browserYsize - elementYposition);
			if(scrollTempValue < 100) {
				scrollTempValue+=scrollValue;
			}
			else if(scrollTempValue < 200) {
				scrollTempValue+=scrollValue-100;
			}
			else if(scrollTempValue < 300) {
				scrollTempValue+=scrollValue-200;
			}
			else {
				scrollTempValue+=scrollValue;
			}
		}
		JavascriptExecutor js = (JavascriptExecutor)Driver.getDriver();
		js.executeScript("window.scrollBy(0,"+scrollTempValue+")");
	}
	
}
