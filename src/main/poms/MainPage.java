package main.poms;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import main.utils.PageFactorySuper;

public class MainPage extends PageFactorySuper{
	public MainPage () {
		super();
	}
	
	@FindBy (className = ("login"))
	private WebElement loginBtn;
	
	public AuthenticationPage clickLoginBtn() {
		loginBtn.click();
		return new AuthenticationPage();
	}
}