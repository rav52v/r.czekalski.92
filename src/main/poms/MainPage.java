package main.poms;

import org.openqa.selenium.Keys;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.FindBy;
import org.testng.Assert;

import main.tools.Generator;
import main.userGUI.TopMenu;
import main.utils.Driver;

public class MainPage extends TopMenu{
	
	@FindBy (className = ("login"))
	private WebElement loginBtn;
	
	@FindBy (css = "div.form-group > input")
	private WebElement newsletterEmailInput;
	
	@FindBy (css = ".alert.alert-success")
	private WebElement subscribedNewsletterSuccessInfo;
	
	public MainPage () {
		super();
	}
	
	public AuthenticationPage clickLoginBtn() {
		loginBtn.click();
		return new AuthenticationPage();
	}
	
	public MainPage orderNewsletter() {
		scrollToElement(newsletterEmailInput, 400);
		newsletterEmailInput.sendKeys(new Generator().gEmail(10));
		new Actions(Driver.getDriver()).sendKeys(Keys.ENTER).build().perform();
		return this;
	}
	
	public MainPage checkIfNewsletterSubscribed() {
		Assert.assertTrue(subscribedNewsletterSuccessInfo.isDisplayed());
		return this;
	}
}