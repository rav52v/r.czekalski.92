package main.poms.store;

import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import main.utils.BasePage;
import main.utils.Driver;

public class ProductPopUp extends BasePage{
	
	@FindBy(tagName = "iframe")
	private WebElement iFrame;

	@FindBy(css = "#add_to_cart button.exclusive")
	private WebElement addToCartBtn;
	
	@FindBy(css = ".button-container > span:first-child")
	private WebElement continueShoppingBtn;
	
	@FindBy(css = "#layer_cart a[title='Proceed to checkout']")
	private WebElement proceedToChechoutBtn;
	
	public ProductPopUp() {
		super();
	}
	
	public ProductPopUp addToCart() {
		implicityWaitTurnOff();
		new WebDriverWait(Driver.getDriver(), 10, 50).until(ExpectedConditions.visibilityOf(iFrame));
		implicityWaitTurnOn();
		Driver.getDriver().switchTo().frame(iFrame);		
		addToCartBtn.click();
		Driver.getDriver().switchTo().defaultContent();
		return this;
	}
	
	public ProductPopUp proceedToCheckout() {
		implicityWaitTurnOff();
		new WebDriverWait(Driver.getDriver(), 10, 50).until(ExpectedConditions.
				invisibilityOf(Driver.getDriver().findElement(By.cssSelector(".fancybox-overlay.fancybox-overlay-fixed"))));
		implicityWaitTurnOn();
		proceedToChechoutBtn.click();
		return this;
	}
	
}
