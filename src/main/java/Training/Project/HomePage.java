package Training.Project;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.testng.Assert;

public class HomePage {

	public WebDriver driver = Configuration.browser();

	public ReadExcel read;

	@FindBy(xpath = Elements.Login)
	private WebElement Login;

	@FindBy(xpath = Elements.Image_Logo)
	private WebElement Image_Logo;

	@FindBy(xpath = Elements.ShoppingCart)
	private WebElement shoppingCart;
	
	@FindBy(className = Elements.Logout)
	private WebElement Logout;

	@FindBy(name = Elements.Search_Btn)
	private WebElement Search_Btn;

	@FindBy(id = Elements.Login_Btn)
	private WebElement Login_Btn;

	@FindBy(id = Elements.SearchBox)
	private WebElement SearchBox;

	@FindBy(xpath = Elements.ResultsDisplayed)
	private WebElement ResultsDisplayed;

//	@FindBy(xpath = Elements.Ipodtouch)
//	private WebElement Ipodtouch;
//
//	@FindBy(xpath = Elements.IpodShuffle_amound)
//	private WebElement IpodShuffle_amound;
//
//	@FindBy(xpath = Elements.AddtoCart)
//	private WebElement AddtoCart;
//
//	@FindBy(xpath = Elements.iPodShuffle)
//	private WebElement IpodShuffle;

	@FindBy(xpath = Elements.ShuffleAddToCart)
	private WebElement addToCart;

	@FindBy(xpath = Elements.FirstOption)
	private WebElement FirstOption;

	@FindBy(xpath = Elements.CloseProductWindow)
	private WebElement CloseProductWindow;

	public HomePage() {

		PageFactory.initElements(driver, this);
		read = new ReadExcel();
	}

	public void shoppingCart() {
		Assert.assertTrue(shoppingCart.isDisplayed());
		shoppingCart.click();
	}
	
	public void loginLink() {

		Login.click();
		System.out.println("Title is "+ driver.getTitle());
		Assert.assertEquals(driver.getTitle(), read.readData("Login_Title"));
	}

	public void validateHomePage() {
		Assert.assertEquals(driver.getTitle(), read.readData("MyAccount_Title"));

	}

	public void logout() {

		Logout.click();
		Login_Btn.click();
	}
	
	public void searchProduct(String prodcut) throws InterruptedException {
		SearchBox.clear();
		SearchBox.sendKeys(prodcut);
		Search_Btn.click();
		Thread.sleep(5000);
	}
	
//	public void validateResults(){
//		Assert.assertTrue(ResultsDisplayed.isDisplayed());
//		Assert.assertTrue(IpodShuffle.isDisplayed());
//	}
//
//	public void ProductAvailable(){
//		Assert.assertTrue(IpodShuffle.isDisplayed());
//
//	}
	
	public void navigateToHome(){
		
		Image_Logo.click();
	}
	
	public void clickAddToCart(){

		Actions actions=new Actions(driver);
		actions.moveToElement(FirstOption).click(addToCart).build().perform();
//		Assert.assertTrue(addToCart.isDisplayed());
//		addToCart.click();
	}

	public void CloseProductWindow(){
//		Assert.assertTrue(CloseProductWindow.isDisplayed());
		CloseProductWindow.click();
	}



}
