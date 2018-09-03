package test;

import org.testng.annotations.Test;
import main.enums.Menu;
import main.poms.MainPage;
import main.userGUI.TopMenu;

public class TestSuite_1 extends TestBase{
	
	@Test (priority = 1, enabled = true)
	public void testCreateNewAccount() {
		new MainPage()
				.clickLoginBtn()
				.inputNewEmail()
				.selectGender()
				.typeFirstName()
				.typeLastName()
				.typePass()
				.typeDate()
				.typeCompany()
				.typeAddress()
				.typeCity()
				.selectState()
				.typePostCode()
				.selectCountry()
				.typeMobilePhone()
				.typeAlias()
				.createAccountConfirm()
				.checkIfLoggedIn()
				.signOut();
	}
	
	@Test (priority = 0, enabled = true)
	public void testAddItemToCartAsNotRegistered() {
		new TopMenu()
				.selectMainMenuOption(Menu.WOMEN, "TOPS")
				.selectRandomItemAsPopUp()
				.addToCart()
				.proceedToCheckout()
				.checkIfItemAddedToCart();
	}
	
	@Test (priority = 2, enabled = true)
	public void testAddItemToCartAsUser() {
		new MainPage()
				.clickLoginBtn()
				.signIn()
				.selectMainMenuOption(Menu.DRESSES, "EVENING")
				.selectRandomItemAsPopUp()
				.addToCart()
				.proceedToCheckout()
				.checkIfItemAddedToCart();
	}
	
	@Test (priority = 3, enabled = true)
	public void testOrderNewsletter() {
		new MainPage()
				.orderNewsletter()
				.checkIfNewsletterSubscribed();
	}
	
}
