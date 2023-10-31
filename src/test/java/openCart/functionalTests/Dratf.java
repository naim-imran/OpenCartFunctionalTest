package openCart.functionalTests;

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
	
	
	@Test
	public void draft() {
	
	}
	
	@Test
	public void draft1() {
		System.out.println(homePage.getHomePageTitle());

	}
	
	@Test
	public void draft2() {
		System.out.println(homePage.getHomePageTitle());

	}
	
	@Test
	public void draft3() {
		System.out.println(homePage.getHomePageTitle());

	}
	
	@Test
	public void draft4() {
		System.out.println(homePage.getHomePageTitle());

	}
	
	@Test
	public void draft5() {
		System.out.println(homePage.getHomePageTitle());

	}
	
	@Test
	public void draft6() {
		System.out.println(homePage.getHomePageTitle());

	}
	
	@Test
	public void draft7() {
		System.out.println(homePage.getHomePageTitle());

	}
	
	@Test
	public void draft8() {
		System.out.println(homePage.getHomePageTitle());

	}
	
	@Test
	public void draft9() {
		System.out.println(homePage.getHomePageTitle());

	}
	
	@Test
	public void draft10() {
		System.out.println(homePage.getHomePageTitle());

	}
	
	@Test
	public void draft11() {
		System.out.println(homePage.getHomePageTitle());

	}

}
