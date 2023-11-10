package openCart.functionalTests;

import org.testng.Assert;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

import base.InitialComponentsAndCommonElements;
import pageObjectsfactory.CheckoutPage;
import pageObjectsfactory.HomePageObjects;
import pageObjectsfactory.ShoppingCartPage;

public class R1dot3_TS012_CheckoutFunctionality extends InitialComponentsAndCommonElements {

	private HomePageObjects homePage;

	@BeforeMethod
	public synchronized void launchBrowser() {
		homePage = launchApplication();

	}

	@AfterMethod
	public void closeBrowser() {
		quitDriver();
	}

	@Test(priority = 0, groups = {
			NEGATIVE }, description = "R1.3_TS012_TC001 As a user I shouldn't be able to  navigate to Checkout page when there is no product in the Shopping Cart")
	public void R1dot3_TS012_TC001() {

		if (homePage.totalCartItems() == 0) {
			ShoppingCartPage shoppingCartPage = homePage.clickShoppingCartButton();
			Assert.assertEquals(shoppingCartPage.getShoppingCartPageTitle(), "Shopping Cart");
			Assert.assertEquals(shoppingCartPage.getShoppingCartSubtitleMessage(), "Your shopping cart is empty!");
		}

	}

	@Test(priority = 15, groups = { SMOKE,
			REGRESSION }, description = "R1.3_TS012_TC015  Verify adding comments about your order in the 'Payment Method' section of Checkout page.")
	public void R1dot3_TS012_TC015() {
		homePage.clickFeaturedProductAddToCartButton("MacBook");
		 CheckoutPage checkoutPage = homePage.headerCheckoutButton();
		 Assert.assertEquals(checkoutPage.getCheckoutPageTitle(), "Checkout");
		 try {
			Thread.sleep(3000);
		} catch (InterruptedException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}
}
