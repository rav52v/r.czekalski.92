package test;

import org.testng.annotations.Test;

import main.enums.Menu;
import main.poms.MainPage;

public class TestSuite_1 extends TestBase{
	@Test (priority = 1)
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
	
	@Test (priority = 2)
	public void testAddItemToCartAsUser() {
		new MainPage()
				.clickLoginBtn()
				.signIn()
				.selectMainMenuOption(Menu.WOMEN, "TOPS")
				.selectRandomItemAsPopUp()
				.addToCart()
				.proceedToCheckout()
				
				;
	}
}
