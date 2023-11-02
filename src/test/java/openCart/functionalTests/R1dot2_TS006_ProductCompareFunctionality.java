package openCart.functionalTests;

import org.testng.Assert;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

import base.InitialComponents;
import pageObjectsfactory.HomePageObjects;
import pageObjectsfactory.ProductsComparisonPage;
import pageObjectsfactory.SearchResultPage;

public class R1dot2_TS006_ProductCompareFunctionality extends InitialComponents {

	private HomePageObjects homePage;

	@BeforeMethod
	public synchronized void launchBrowser() {
		homePage = launchApplicationHomePage();
	}

	@AfterMethod
	public void closeBrowser() {
		quitDriver();
	}

	@Test(priority = 1, groups = POSSITIVE, description = "R1.2_TS006_TC001 As an user I should be able to select products for comparison.")
	public void r1dot2_TS006_TC001() {

		Assert.assertEquals("Qafox.com", homePage.getLogoText());
		String productName = "Mac";
		homePage.setTextOnSearchBox(productName);
		SearchResultPage searchResultPage = homePage.clickSearchButton();
		Assert.assertEquals("Search - " + productName, searchResultPage.getSearchedItemText());

		searchResultPage.click_productCompareButton("MacBook");

		searchResultPage.click_productCompareButton("MacBook Air");

		searchResultPage.click_productCompareButton("MacBook Pro");

		searchResultPage.click_productCompareButton("iMac");

		ProductsComparisonPage productsComparisonPage = searchResultPage.click_comparisonPageLinkButton();
		Assert.assertEquals(productsComparisonPage.getProductsComparisonPageTitle(), "Product Comparison");

	}

}
