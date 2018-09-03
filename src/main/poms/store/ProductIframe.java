package main.poms.store;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import main.data.VariableHolder;
import main.utils.BasePage;
import main.utils.Driver;

public class ProductIframe extends BasePage{
	
	@FindBy(tagName = "iframe")
	private WebElement iFrame;

	@FindBy(css = "#add_to_cart button.exclusive")
	private WebElement addToCartBtn;
	
	@FindBy(css = ".button-container > span:first-child")
	private WebElement continueShoppingBtn;
	
	@FindBy(css = "div.pb-center-column h1:first-child")
	private WebElement itemName;
	
	
	
	public ProductIframe() {
		super();
	}
	
	public StorePage addToCart() {
		implicityWaitTurnOff();
		new WebDriverWait(Driver.getDriver(), 10, 50).until(ExpectedConditions.visibilityOf(iFrame));
		implicityWaitTurnOn();
		Driver.getDriver().switchTo().frame(iFrame);
		VariableHolder.itemName = this.itemName.getText();
		addToCartBtn.click();
		Driver.getDriver().switchTo().defaultContent();
		return new StorePage();
	}
	
	
	
}
