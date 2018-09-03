package main.poms;

import java.util.List;
import java.util.Random;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.testng.Assert;
import main.enums.Menu;
import main.poms.store.ProductIframe;
import main.userGUI.TopMenu;

public class MyAccountPage extends TopMenu{
	
	@FindBy (css = ".product_list > li")
	private List<WebElement> productList;
	
	
	public MyAccountPage() {
		super();
	}
	
	public TopMenu checkIfLoggedIn() {
		Assert.assertTrue(signOutBtn.isDisplayed());
		return new TopMenu();
	}
	
	public MyAccountPage selectMainMenuOption(Menu menu, String option) {
		getElementFromMenu(menu, option).click();
		return this;
	}	
	
	public ProductIframe selectRandomItemAsPopUp() {
		int randomProductIndex = new Random().nextInt(productList.size());
		scrollToElement(productList.get(randomProductIndex), 500);
		focusOnElement(productList.get(randomProductIndex));
		productList.get(randomProductIndex).findElement(By.className("quick-view")).click();
		return new ProductIframe();
	}
	
}
