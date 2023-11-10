package openCart.functionalTests;

import org.testng.Assert;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

import base.InitialComponentsAndCommonElements;
import pageObjectsfactory.HomePageObjects;
import pageObjectsfactory.SearchResultPage;
import pageObjectsfactory.ShoppingCartPage;

public class R1dot3_TS008_AddToCartFunctionality extends InitialComponentsAndCommonElements{
	
	private HomePageObjects homePage;

	@BeforeMethod
	public synchronized void launchBrowser() {
		homePage = launchApplication();
	}

	@AfterMethod
	public void closeBrowser() {
		//quitDriver();
	}
	
	
	// Jira TN-59
	@Test(priority = 0, groups = {SMOKE, POSSITIVE, REGRESSION}, description = "R1.3_TS008_TC003 As an user I should be able to add product to Cart from Search Results Page")
	public void R1dot3_TS008_TC003() {
		
		String expectedProductName= "iMac";
		
		homePage.setTextOnSearchBox("mac");
		SearchResultPage searchResultPage = homePage.clickSearchButton();
		searchResultPage.addToCartButtonInProductThumbnail(expectedProductName);
		ShoppingCartPage shoppingCartPage = searchResultPage.clickShoppingCartButton();
		Assert.assertEquals(shoppingCartPage.getProductNameFromCartTable(), expectedProductName);
	}
	
	@Test(priority = 1, groups = {REGRESSION, POSSITIVE}, description = "R1.3_TS008_TC001 As a guest user I should be able to add the product to Cart from 'Featured Product list add to cart button' in home Page")
	public void R1dot3_TS008_TC001() {
		String expectedProductName= "iPhone";
		homePage.addToCartButtonInProductThumbnail(expectedProductName);
		ShoppingCartPage cart = homePage.clickShoppingCartButton();
		Assert.assertEquals(cart.getShoppingCartPageTitle(), "Shopping Cart");
		Assert.assertTrue(cart.getProductNameFromCartTable().contains(expectedProductName));
		
		
	}

}
