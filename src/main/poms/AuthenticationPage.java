package main.poms;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

import main.data.VariableHolder;
import main.tools.Generator;
import main.utils.BasePage;

public class AuthenticationPage extends BasePage{
	
	@FindBy (id = "email_create")
	private WebElement emailCreateField;
	
	@FindBy (id = "SubmitCreate")
	private WebElement submitCreateBtn;
	
	@FindBy (id = "email")
	private WebElement emailInput;
	
	@FindBy (id = "passwd")
	private WebElement passInput;
	
	@FindBy (id = "SubmitLogin")
	private WebElement submitBtn;
	
	
	public AuthenticationPage() {
		super();
	}
	
	public AccCreationPage inputNewEmail() {
		VariableHolder.loginEmail = new Generator().gEmail(10);
		emailCreateField.sendKeys(VariableHolder.loginEmail);
		submitCreateBtn.click();
		return new AccCreationPage();
	}
	
	public MyAccountPage signIn() {
		emailInput.sendKeys(VariableHolder.loginEmail);
		passInput.sendKeys(VariableHolder.password);
		submitBtn.click();
		return new MyAccountPage();
	}
	public MyAccountPage signIn(String email, String pass) {
		emailInput.sendKeys(email);
		passInput.sendKeys(pass);
		submitBtn.click();
		return new MyAccountPage();
	}
	
	
}
