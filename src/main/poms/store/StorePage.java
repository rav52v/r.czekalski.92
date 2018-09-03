package main.poms.store;

import java.util.List;
import java.util.Random;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import main.userGUI.TopMenu;
import main.utils.Driver;

public class StorePage extends TopMenu{
	
	@FindBy (css = ".product_list > li")
	private List<WebElement> productList;
	
	@FindBy(css = "#layer_cart a[title='Proceed to checkout']")
	private WebElement proceedToChechoutBtn;
	
	
	public StorePage() {
		super();
	}
	
	
	public ProductIframe selectRandomItemAsPopUp() {
		int randomProductIndex = new Random().nextInt(productList.size());
		scrollToElement(productList.get(randomProductIndex), 500);
		focusOnElement(productList.get(randomProductIndex));
		productList.get(randomProductIndex).findElement(By.className("quick-view")).click();
		return new ProductIframe();
	}
	
	public CartPage proceedToCheckout() {
		implicityWaitTurnOff();
		new WebDriverWait(Driver.getDriver(), 10, 50).until(ExpectedConditions.
				invisibilityOf(Driver.getDriver().findElement(By.cssSelector(".fancybox-overlay.fancybox-overlay-fixed"))));
		implicityWaitTurnOn();
		proceedToChechoutBtn.click();
		return new CartPage();
	}
	
}
