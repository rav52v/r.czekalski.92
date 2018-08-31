package test;

import org.testng.annotations.Test;
import main.poms.MainPage;

public class TestSuite_1 extends TestBase{
	@Test
	public void testCreateNewAccount() {
		new MainPage()
				.clickLoginBtn()
				.inputEmail()
				.selectGender()
				.typeFirstName()
				.typeLastName()
				.typePass()
				.typeCompany()
				.typeAddress()
				.typeCity()
				.selectState("Alaska")
				.typePostCode()
				.selectCountry()
				.typeMobilePhone()
				.typeAlias()
				.createAccountConfirm()
				;
	}
}
