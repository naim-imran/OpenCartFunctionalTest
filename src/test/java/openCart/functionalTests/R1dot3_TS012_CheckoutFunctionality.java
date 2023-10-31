package openCart.functionalTests;

import org.testng.Assert;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

import base.InitialComponents;
import pageObjectsfactory.HomePageObjects;
import pageObjectsfactory.ShoppingCartPage;

public class R1dot3_TS012_CheckoutFunctionality extends InitialComponents {
	
	private HomePageObjects homePage;

	@BeforeMethod
	public synchronized void launchBrowser() {
		homePage = launchApplicationHomePage();
	}

	@AfterMethod
	public void closeBrowser() {
		quitDriver();
	}
	
	@Test(groups = {
			NEGATIVE }, description = "R1.3_TS012_TC001 As a user I shouldn't be able to  navigate to Checkout page when there is no product in the Shopping Cart")
	public void R1dot3_TS012_TC001() {
		ShoppingCartPage shoppingCartPage = homePage.clickShoppingCartButton();
		Assert.assertEquals(shoppingCartPage.getShoppingCartPageTitle(), "Shopping Cart");
	}
}
