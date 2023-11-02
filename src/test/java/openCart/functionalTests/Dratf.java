package openCart.functionalTests;

import org.testng.Assert;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

import base.InitialComponents;
import pageObjectsfactory.HomePageObjects;

public class Dratf extends InitialComponents {
	private HomePageObjects homePage;
	

	@BeforeMethod
	public void launchBrowser() {
		homePage = launchApplicationHomePage();
	}
	@AfterMethod
	public void closeBrowser() {
		quitDriver();
	}
	
	
	@Test(description = "fail test 01")
	public void draft() {
		Assert.assertTrue(false);
		homePage.getHomePageTitle();

	}
	
	@Test(description = "fail test 02")
	public void draft1() {
		Assert.assertTrue(false);

	}
	
	@Test(description = "fail test 03")
	public void draft2() {
		Assert.assertTrue(false);

	}
	
	@Test(description = "fail test 04")
	public void draft3() {
		Assert.assertTrue(false);

	}
	
	

}
