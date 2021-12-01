package Training.Project;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.testng.Assert;

public class ShoppingCart {
	public WebDriver driver = Configuration.browser();
	
	@FindBy(xpath = Elements.ItemDescription)
	private WebElement itemDescription;
	
	@FindBy(xpath = Elements.ProceedToCheckout)
	private WebElement ProceedToCheckout;
	
	@FindBy(xpath = Elements.CartTitle)
	private WebElement cartTitle;
	
	@FindBy(xpath = Elements.Delete)
	private WebElement delete;
	
	@FindBy(xpath = Elements.CheckBox)
	private WebElement checkBox;

	@FindBy(xpath = Elements.Next2)
	private WebElement nextBtn2;
	
	@FindBy(id = Elements.TermsAndConditionsChkBox)
	private WebElement agreeCheck;
	
	@FindBy(xpath = Elements.Next3)
	private WebElement NextBtn3;
	
	@FindBy(xpath = Elements.PayByCheck)
	private WebElement paybycheck;

	@FindBy(xpath = Elements.Submit)
	private WebElement submit;
	
	public ShoppingCart(){
		PageFactory.initElements(driver, this);
	}
	
	public void validateItemDescription(){
		//System.out.println(itemDescription.getText());
		Assert.assertEquals(itemDescription.getText(), "Printed Summer Dress");
	}
	
	public void clickNextButton(){
//		Assert.assertTrue(ProceedToCheckout.isDisplayed());
		ProceedToCheckout.click();
	}
	
	public void validateCartTitle(){
		System.out.println("carttile"+cartTitle.getText());
		Assert.assertEquals(cartTitle.getText(), "Shopping-cart summary","Not matching");
	}
	
	public void delteItem(){
		delete.click();
	}
	
	public void uncheckAddress(){
		checkBox.click();
		//Assert.assertEquals(checkBox.getAttribute(arg0), expected);
	}
	
	public void nextAddress(){
		nextBtn2.click();
	}
	
	public void checkAgree(){
		agreeCheck.click();
	}
	
	public void nextCarrier(){
		agreeCheck.click();

	}
	
	public void clickPaybycheck(){
		paybycheck.click();
	}
	
	public void clickSubmit(){
		submit.click();
	}

	public void Shipping(){
		NextBtn3.click();

	}
}
