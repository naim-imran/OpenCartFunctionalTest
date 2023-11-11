package openCart.functionalTests;

import org.testng.Assert;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

import base.InitialComponentsAndCommonElements;
import pageObjectsfactory.HomePageObjects;
import pageObjectsfactory.LoginPage;

public class R1dot3_TS009_WishListtFunctionality extends InitialComponentsAndCommonElements {

	
	private HomePageObjects homePage;

	@BeforeMethod
	public synchronized void launchBrowser() {
		homePage = launchApplication();
		System.out.println("Thread ID= " + Thread.currentThread().getId());
	}

	@AfterMethod
	public void closeBrowser() {
		//quitDriver();
	}
	
	
	@Test(priority = 0, groups = {SMOKE, POSSITIVE, REGRESSION}, description = "R1.3_TS009_TC003 Verify adding a product to 'Wish List' page from the Product that is displayed in the 'Featured' section of 'Home' page")
	public void R1dot3_TS009_TC003() {
		Assert.assertEquals(homePage.getHomePageTitle(), "Your Store");
		homePage.addtoWishListInProductThumbnail("MacBook");
		LoginPage loginPage = homePage.clickHeaderWishListButton();
		loginPage.setEmail_emailAddressInputBox("dwana.ondricka@gmail.com");
		loginPage.setPassword_passwordInputBox("654321");
		loginPage.click_loginButton();
		
		//Assert.assertEquals(wishListPage.getWishListPageTitle(), "My Wish List");
	}
	
	
	
	
}
