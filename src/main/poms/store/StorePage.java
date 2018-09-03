package main.poms.store;

import java.util.List;
import java.util.Random;

import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import main.utils.BasePage;

public class StorePage extends BasePage{
	
	@FindBy (css = ".product_list > li")
	private List<WebElement> productList;
	
	
	
	public StorePage() {
		super();
	}
	
	
	public ProductPopUp selectRandomItemAsPopUp() {
		int randomProductIndex = new Random().nextInt(productList.size());
		scrollToElement(productList.get(randomProductIndex), 500);
		focusOnElement(productList.get(randomProductIndex));
		productList.get(randomProductIndex).findElement(By.className("quick-view")).click();
		return new ProductPopUp();
	}
	
}
