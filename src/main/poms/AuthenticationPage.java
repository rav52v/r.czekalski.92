package main.poms;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import main.tools.Generator;
import main.utils.PageFactorySuper;

public class AuthenticationPage extends PageFactorySuper{
	public AuthenticationPage() {
		super();
	}
	
	@FindBy (id = "email_create")
	private WebElement emailCreateField;
	
	@FindBy (id = "SubmitCreate")
	private WebElement submitCreateBtn;
	
	public AccCreationPage inputEmail() {
		emailCreateField.sendKeys(new Generator().gEmail(10));
		submitCreateBtn.click();
		return new AccCreationPage();
	}
}
