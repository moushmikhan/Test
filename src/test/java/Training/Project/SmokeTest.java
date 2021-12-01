package Training.Project;

import org.testng.annotations.Test;

public class SmokeTest extends TestNGAnnotationsTest {
	
	ShoppingCart shoppingCart = new ShoppingCart();
	
	@Test(testName = "login_Positive", description = "login_Positive", timeOut = 190000, enabled = true, groups = {
			 "1", "sanity" }, priority=1)
	public void validCredentials(){
		home.loginLink();
		login.loginToApp(Configuration.LoginUserNmae(), Configuration.LoginPassword());
	}
	
	@Test(testName = "login_Negative", description = "login_Negative", timeOut = 190000, enabled = true, groups = {
			 "2", "sanity"}, priority=11)
	public void login_Negative(){
		
		home.logout();
		login.loginToApp("aaa", "aaa");
		login.invalidErrorMessage();

	}

	
	@Test(testName = "search Product", description = "search Product", timeOut = 190000, enabled = true, groups = {
			"3", "sanity"}, priority=3)
	public void search_Product() throws InterruptedException {
		
		home.searchProduct(read.readData("Product1"));
		wait5sec();
		home.clickAddToCart();

		wait5sec();
		home.CloseProductWindow();
	}
	
	@Test(testName = "Shopping Cart - Summary", description = "Shopping Cart - Summary", timeOut = 190000, enabled = true, groups = {
			"4", "sanity"}, priority=4)
	public void ShoppingCart_Summary(){
		home.shoppingCart();
		shoppingCart.validateItemDescription();
	}

	@Test(testName = "Delete Item", description = "Delete Item", timeOut = 190000, enabled = true, groups = {
			"5", "sanity"}, priority=5)
	public void DeleteItem(){
		shoppingCart.delteItem();
		wait5sec();
	}

	@Test(testName = "search Product", description = "search Product", timeOut = 190000, enabled = true, groups = {
			"3", "sanity"}, priority=6)
	public void search_Product2() throws InterruptedException {

		home.searchProduct(read.readData("Product2"));
		wait5sec();
		home.clickAddToCart();

		wait5sec();
		home.CloseProductWindow();
	}
	
	@Test(testName = "Shopping Cart - Address", description = "Shopping Cart - Address", timeOut = 190000, enabled = true, groups = {
			"6", "sanity"}, priority=7)
	public void ShoppingCart_Address() throws InterruptedException {
		search_Product();
		shoppingCart.clickNextButton();
		wait5sec();
		shoppingCart.nextAddress();
		wait5sec();
	}
	
	@Test(testName = "Shopping Cart - Carrier", description = "Shopping Cart - Carrier", timeOut = 190000, enabled = true, groups = {
			"7", "sanity"}, priority=8)
	public void ShoppingCart_Carrier(){
		shoppingCart.Shipping();
		shoppingCart.nextCarrier();
		wait5sec();

		shoppingCart.Shipping();
	}
	
	@Test(testName = "Shopping Cart - Carrier", description = "Shopping Cart - Carrier", timeOut = 190000, enabled = true, groups = {
			"8", "sanity"}, priority=9)
	public void ShoppingCart_Payment(){
		shoppingCart.clickPaybycheck();
		wait5sec();
		shoppingCart.clickSubmit();
		wait5sec();
		home.logout();
	}

	@Test(testName = "Register", description = "Shopping Cart - Carrier", timeOut = 190000, enabled = true, groups = {
			"8", "sanity"}, priority=10)
	public void Registration(){
		home.loginLink();
		wait5sec();
//		register.SignUp(read.readData("RegisterEmail"));
		register.SignUp("129001@xyz.com");
		register.FillRegistrationForm();


	}


	
	public void wait5sec(){
		try {
			Thread.sleep(5000);
		} catch (InterruptedException e) {
			e.printStackTrace();
		}
	}

}
