package main.poms;

import java.util.List;
import java.util.Random;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.ui.Select;

import main.enums.Gender;
import main.tools.DataBaseReader;
import main.tools.Generator;
import main.utils.PageFactorySuper;

public class AccCreationPage extends PageFactorySuper{
	
	private Generator g;
	private Random r;
	
	//-------------Your Personal Information--------------//
	@FindBy (id = "id_gender1")
	private WebElement genderMrChoice;
	
	@FindBy (id = "id_gender2")
	private WebElement genderMrsChoice;
	
	@FindBy (id = "customer_firstname")
	private WebElement firstNameInput;
	
	@FindBy (id = "customer_lastname")
	private WebElement lastNameInput;
	
	@FindBy (id = "email")
	private WebElement emailInput;
	
	@FindBy (id = "passwd")
	private WebElement passInput;
	
	@FindBy (id = "days")
	private WebElement daySelect;
	
	@FindBy (id = "months")
	private WebElement monthSelect;
	
	@FindBy (id = "years")
	private WebElement yearSelect;
	
	//----------------Your Address-------------//
	@FindBy (id = "firstname")
	private WebElement firstNameAddressInput;
	
	@FindBy (id = "lastname")
	private WebElement lastNameAddressInput;
	
	@FindBy (id = "company")
	private WebElement comapnyInput;
	
	@FindBy (id = "address1")
	private WebElement addressInput;
	
	@FindBy (id = "address2")
	private WebElement addressSecondLineInput;
	
	@FindBy (id = "city")
	private WebElement cityInput;
	
	@FindBy (id = "id_state")
	private WebElement stateSelect;
	
	@FindBy (css = "#id_state > option:nth-child(n+2)")
	private List<WebElement> stateList;
	
	@FindBy (id = "postcode")
	private WebElement postCodeInput;
	
	@FindBy (id = "id_country")
	private WebElement countrySelect;
	
	@FindBy (id = "other")
	private WebElement addInfoInput;
	
	@FindBy (id = "phone")
	private WebElement homePhoneInput;
	
	@FindBy (id = "phone_mobile")
	private WebElement mobilePhoneInput;
	
	@FindBy (id = "alias")
	private WebElement aliasInput;
	
	@FindBy (id = "submitAccount")
	private WebElement createAccBtn;
	
	
	public AccCreationPage() {
		super();
		r = new Random();
		g = new Generator();
	}
	
	
	public AccCreationPage selectGender(Gender gender) {
		if(gender == Gender.MALE) {
			genderMrChoice.click();
		}else if(gender == Gender.FEMALE){
			genderMrsChoice.click();
		}
		return this;		
	}
	public AccCreationPage selectGender() {
		WebElement[] genderAray = {genderMrChoice, genderMrsChoice};
		genderAray[r.nextInt(2)].click();
		return this;		
	}
	
	public AccCreationPage typeFirstName(String value) {
		firstNameInput.sendKeys(value);
		return this;
	}
	public AccCreationPage typeFirstName() {
		firstNameInput.sendKeys(g.gName());
		return this;
	}
	
	public AccCreationPage typeLastName(String value) {
		lastNameInput.sendKeys(value);
		return this;
	}
	public AccCreationPage typeLastName() {
		lastNameInput.sendKeys(g.gLower(g.randomFromRange(4, 12)));
		return this;
	}
	
	public AccCreationPage typeEmail(String value) {
		emailInput.clear();
		emailInput.sendKeys(value);
		return this;
	}
	
	public AccCreationPage typePass(String value) {
		passInput.sendKeys(value);
		return this;
	}
	public AccCreationPage typePass() {
		passInput.sendKeys(g.gPass(g.randomFromRange(8, 15)));
		return this;
	}
	
	public AccCreationPage typeDate(int day, int month, int year) {
		new Select(daySelect).selectByValue(String.valueOf(day));
		new Select(monthSelect).selectByValue(String.valueOf(month));
		new Select(yearSelect).selectByValue(String.valueOf(year));
		return this;
	}
	public AccCreationPage typeDate() {
		new Select(daySelect).selectByValue(String.valueOf(r.nextInt(31)+1));
		new Select(monthSelect).selectByValue(String.valueOf(r.nextInt(12)+1));
		new Select(yearSelect).selectByValue(String.valueOf(g.randomFromRange(1900, 2018)));
		return this;
	}
	
	public AccCreationPage typeFirstNameAddress(String value) {
		firstNameAddressInput.clear();
		firstNameAddressInput.sendKeys(value);
		return this;
	}
	
	public AccCreationPage typeLastNameAddress(String value) {
		lastNameAddressInput.clear();
		lastNameAddressInput.sendKeys(value);
		return this;
	}
	
	public AccCreationPage typeCompany(String value) {
		addressInput.sendKeys(value);
		return this;
	}
	public AccCreationPage typeCompany() {
		comapnyInput.sendKeys(g.gLower(g.randomFromRange(3, 12)));
		return this;
	}
	
	public AccCreationPage typeAddress(String value) {
		addressInput.sendKeys(value);
		return this;
	}
	public AccCreationPage typeAddress() {
		addressInput.sendKeys(String.format("%s %s %d", g.gLower(g.randomFromRange(3, 12)), g.gLower(g.randomFromRange(3, 12)), g.randomFromRange(1, 200)));
		return this;
	}
	
	public AccCreationPage typeaddressSecondLine(String value) {
		addressSecondLineInput.sendKeys(value);
		return this;
	}
	
	public AccCreationPage typeCity(String value) {
		addressSecondLineInput.sendKeys(value);
		return this;
	}
	public AccCreationPage typeCity() {
		cityInput.sendKeys(new DataBaseReader().getCity());
		return this;
	}
	
	public AccCreationPage selectState(String value) {
		for (int i=0 ; i<stateList.size() ; i++) {
			if (stateList.get(i).getText().equalsIgnoreCase(value)) {
				new Select(stateSelect).selectByVisibleText(value);
				break;
			}
		}
		return this;
	}
	public AccCreationPage selectState() {
		new Select(stateSelect).selectByValue(String.valueOf(r.nextInt(stateList.size())));
		return this;
	}
	
	public AccCreationPage typePostCode(String value) {
		postCodeInput.sendKeys(value);
		return this;
	}
	public AccCreationPage typePostCode() {
		postCodeInput.sendKeys(g.gNumbers(5));
		return this;
	}
	
	public AccCreationPage selectCountry() {
		new Select(countrySelect).selectByValue("21");	
		return this;
	}
	
	public AccCreationPage typeAdditionalInfo(String value) {
		addInfoInput.sendKeys(value);
		return this;
	}
	
	public AccCreationPage typeHomePhone(String value) {
		homePhoneInput.sendKeys(value);
		return this;
	}
	
	public AccCreationPage typeMobilePhone(String value) {
		mobilePhoneInput.sendKeys(value);
		return this;
	}
	public AccCreationPage typeMobilePhone() {
		mobilePhoneInput.sendKeys(g.gNumbers(9));
		return this;
	}
	
	public AccCreationPage typeAlias(String value) {
		aliasInput.clear();
		aliasInput.sendKeys(g.gNumbers(9));
		return this;
	}
	public AccCreationPage typeAlias() {
		aliasInput.clear();
		aliasInput.sendKeys(g.gLower(g.randomFromRange(2, 10)));
		return this;
	}
	
	public MyAccountPage createAccountConfirm() {
		createAccBtn.click();
		return new MyAccountPage();
	}
}
