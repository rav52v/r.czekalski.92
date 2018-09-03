package main.poms;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import main.utils.BasePage;

public class MainPage extends BasePage{
	
	@FindBy (className = ("login"))
	private WebElement loginBtn;
	
	public MainPage () {
		super();
	}
	
	public AuthenticationPage clickLoginBtn() {
		loginBtn.click();
		return new AuthenticationPage();
	}
}