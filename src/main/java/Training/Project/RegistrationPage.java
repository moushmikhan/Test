package Training.Project;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.Select;
import org.testng.Assert;

public class RegistrationPage {

	public WebDriver driver = Configuration.browser();
	CommonCode commonCode = new CommonCode();

	@FindBy(xpath = Elements.CreateEmail)
	private WebElement CreateEmail;

	@FindBy(xpath = Elements.CreateAccount)
	private WebElement CreateAccount;

	@FindBy(xpath = Elements.RegistrationPage)
	private WebElement RegistrationPage;

	@FindBy(xpath = Elements.FirstName)
	private WebElement AddFirstName;

	@FindBy(xpath = Elements.LastName)
	private WebElement AddLastName;

	@FindBy(id = Elements.Password)
	private WebElement Password1;

	@FindBy(xpath = Elements.AddAddress)
	private WebElement AddAddress;
	@FindBy(xpath = Elements.City)
	private WebElement City;

	@FindBy(xpath = Elements.Zipcode)
	private WebElement ZipCode;

	@FindBy(xpath = Elements.MobileNumber)
	private WebElement MobileNumber;

	@FindBy(xpath = Elements.State)
	private WebElement State;

	@FindBy(xpath = Elements.RegisterBtn)
	private WebElement RegisterBtn;

	@FindBy(xpath = Elements.AccountRegistered)
	private WebElement AccountRegistered;

	@FindBy(xpath = Elements.InvalidEmailAddress)
	private WebElement InvalidEmailAddress;

	public RegistrationPage() {

		PageFactory.initElements(driver, this);
	}


	
	public void invalidErrorMessage(){
		
		InvalidEmailAddress.isDisplayed();
	}

	public void SignUp(String Email){

		CreateEmail.click();
		CreateEmail.sendKeys(Email);
		CreateAccount.click();
		commonCode.wait5sec();
		Assert.assertTrue(RegistrationPage.isDisplayed(),"Registration page not displayed");
		commonCode.wait5sec();

	}

	public  void FillRegistrationForm()
	{
		AddFirstName.sendKeys("Robert");
		AddLastName.sendKeys("Test");
		Password1.sendKeys(Configuration.LoginPassword());
		AddAddress.sendKeys("Flat No 6,Blue Street, Open House, London");
		City.sendKeys("London");
		Select country = new Select(State);
		country.selectByVisibleText("Alabama");
		ZipCode.sendKeys("90011");
		MobileNumber.sendKeys("98979895");
		RegisterBtn.click();
		commonCode.wait5sec();
		commonCode.wait5sec();
		Assert.assertTrue(AccountRegistered.isDisplayed(),"Account not Registered");


	}
	
	
}
