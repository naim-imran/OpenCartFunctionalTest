package openCart.functionalTests;

import org.testng.Assert;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

import base.InitialComponents;
import pageObjectsfactory.HomePageObjects;
import pageObjectsfactory.ProductDetailsPage;

public class Dratf extends InitialComponents {
	private HomePageObjects homePageObjects;
	private String productName= "Canon EOS 5D";

	@BeforeMethod
	public void launchBrowser() {
		 homePageObjects = launchApplicationHomePage();
	}
	@AfterMethod
	public void closeBrowser() {
		quitDriver();
	}
	
	
	@Test
	public void draft() {
		System.out.println(homePageObjects.getHomePageTitle());
		ProductDetailsPage productDetailsPage= homePageObjects.clickHomePageFeaturedProduct(productName);
		Assert.assertTrue(productDetailsPage.getrightColumnProductName().contains(productName));
	}
	
	@Test
	public void draft1() {
		System.out.println(homePageObjects.getHomePageTitle());

	}
	
	@Test
	public void draft2() {
		System.out.println(homePageObjects.getHomePageTitle());

	}
	
	@Test
	public void draft3() {
		System.out.println(homePageObjects.getHomePageTitle());

	}
	
	@Test
	public void draft4() {
		System.out.println(homePageObjects.getHomePageTitle());

	}
	
	@Test
	public void draft5() {
		System.out.println(homePageObjects.getHomePageTitle());

	}
	
	@Test
	public void draft6() {
		System.out.println(homePageObjects.getHomePageTitle());

	}
	
	@Test
	public void draft7() {
		System.out.println(homePageObjects.getHomePageTitle());

	}
	
	@Test
	public void draft8() {
		System.out.println(homePageObjects.getHomePageTitle());

	}
	
	@Test
	public void draft9() {
		System.out.println(homePageObjects.getHomePageTitle());

	}
	
	@Test
	public void draft10() {
		System.out.println(homePageObjects.getHomePageTitle());

	}
	
	@Test
	public void draft11() {
		System.out.println(homePageObjects.getHomePageTitle());

	}

}
