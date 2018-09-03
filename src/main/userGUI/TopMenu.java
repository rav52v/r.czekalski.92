package main.userGUI;

import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import main.enums.Menu;
import main.utils.BasePage;

public class TopMenu extends BasePage{
	
    @FindBy(css = ".shopping_cart")
    protected WebElement shoppingCart;

    @FindBy(css = "#block_top_menu [title=Women]")
    private WebElement women;

    @FindBy(css = "#block_top_menu > ul > li:nth-child(2) > a")
    private WebElement dresses;

    @FindBy(css = "#block_top_menu > ul > li:nth-child(3) > a")
    private WebElement t_shirts;
	
	public TopMenu() {
		super();
	}
	
	protected WebElement getElementFromMenu(Menu menu, String option) {
		WebElement menuOption = focusOnMenuElement(menu);
		switch (menu) {
		case WOMEN:
			return menuOption.findElement(By.xpath("..")).findElement(By.partialLinkText(option));
		case DRESSES:
			return menuOption.findElement(By.xpath("..")).findElement(By.partialLinkText(option));
		case T_SHIRTS:
			return t_shirts;
		}
		return null;
		}

	
	private WebElement focusOnMenuElement(Menu menu) {
		switch (menu){
		case WOMEN:
			focusOnElement(women);
			return women;
		case DRESSES:
			focusOnElement(dresses);
			return dresses;
		case T_SHIRTS:
			return t_shirts;
		}
		return null;
	}
	
}
