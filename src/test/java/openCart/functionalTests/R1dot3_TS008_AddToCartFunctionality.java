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
		homePage = launchApplicationHomePage();
	}

	@AfterMethod
	public void closeBrowser() {
		quitDriver();
	}
	
	
	// Jira TN-59
	@Test(priority = 0, groups = {SMOKE, POSSITIVE}, description = "R1.3_TS008_TC003 As an user I can  add  product to Cart from Search Results Page")
	public void R1dot3_TS008_TC003() {
		homePage.setTextOnSearchBox("mac");
		String expectedProductName= "iMac";
		SearchResultPage searchResultPage = homePage.clickSearchButton();
		searchResultPage.click_addToCartButton(expectedProductName);
		ShoppingCartPage shoppingCartPage = searchResultPage.clickShoppingCartButton();
		Assert.assertEquals(shoppingCartPage.getProductNameFromCartTable(), expectedProductName);
	}
	

}
