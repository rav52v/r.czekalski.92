package main.poms.store;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.testng.Assert;

import main.data.VariableHolder;
import main.utils.BasePage;

public class CartPage extends BasePage{
	
	@FindBy(css = "td.cart_description > p.product-name > a:first-child")
	private WebElement itemInCartName;
	
	
	
	public CartPage() {
		super();
	}
	
	public CartPage checkIfItemAddedToCart() {
		Assert.assertEquals(VariableHolder.itemName, itemInCartName.getText());
		return this;
	}
	
}
