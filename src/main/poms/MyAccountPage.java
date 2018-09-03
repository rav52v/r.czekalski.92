package main.poms;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.testng.Assert;

import main.enums.Menu;
import main.poms.store.StorePage;
import main.userGUI.TopMenu;

public class MyAccountPage extends TopMenu{
	
	@FindBy (css = ".logout")
	private WebElement signOutBtn;
	
	
	public MyAccountPage() {
		super();
	}
	
	public MyAccountPage checkIfLoggedIn() {
		Assert.assertTrue(signOutBtn.isDisplayed());
		return this;
	}
	
	public MainPage signOut() {
		signOutBtn.click();
		return new MainPage();
	}
	
	public StorePage selectMainMenuOption(Menu menu, String option) {
		getElementFromMenu(menu, option).click();
		return new StorePage();
	}	
}
