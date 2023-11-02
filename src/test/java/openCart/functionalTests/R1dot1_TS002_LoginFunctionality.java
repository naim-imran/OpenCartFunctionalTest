package openCart.functionalTests;

import java.io.IOException;

import org.testng.Assert;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

import base.InitialComponentsAndCommonElements;
import base.Reuseables;
import pageObjectsfactory.HomePageObjects;
import pageObjectsfactory.LoginPage;
import pageObjectsfactory.MyAccountPage;

public class R1dot1_TS002_LoginFunctionality extends InitialComponentsAndCommonElements {

	private HomePageObjects homePage;

	@BeforeMethod
	public synchronized void launchBrowser() {
		homePage = launchApplicationHomePage();
	}

	@AfterMethod
	public void closeBrowser() {
		quitDriver();
	}

	// https://naayeem.atlassian.net/browse/TN-40
	@Test(priority = 0, groups = { SMOKE,
			POSSITIVE }, description = "R1.1_TS002_TC001 Verify logging into the Application using valid credentials")
	public void r1dot1_TS002_TC001() throws IOException {
		homePage.click_MyAccountDropLisButton();
		LoginPage loginPage = homePage.click_LoginButton();
		Assert.assertEquals(loginPage.getHomePageTitle(), "Account Login");
		loginPage.setEmail_emailAddressInputBox("dwana.ondricka@gmail.com");
		loginPage.setPassword_passwordInputBox("654321");
		MyAccountPage accountPage = loginPage.click_loginButton();
		Assert.assertEquals(accountPage.getPageTitle(), "My Account");
	}

	// https://naayeem.atlassian.net/browse/TN-41
	@Test(priority = 1, groups = { SMOKE,
			NEGATIVE }, description = "R1.1_TS002_TC002 Verify logging into the Application using invalid credentials (i.e. Invalid email address and Invalid Password)")
	public void r1dot1_TS002_TC002() {
		homePage.click_MyAccountDropLisButton();
		LoginPage loginPage = homePage.click_LoginButton();
		Assert.assertEquals(loginPage.getHomePageTitle(), "Account Login");
		loginPage.setEmail_emailAddressInputBox("dwondricka@gmail.com");
		loginPage.setPassword_passwordInputBox("654321invalid");
		loginPage.click_loginButton();
		Assert.assertTrue(loginPage.getLoginErrorMsg().contains("Warning"));
	}

	@Test(priority = 1, groups = { SMOKE,
			NEGATIVE }, description = "R1.1_TS002_TC003 Verify logging into the Application using invalid email address and valid Password")
	public void r1dot1_TS002_TC003() {
		homePage.click_MyAccountDropLisButton();
		LoginPage loginPage = homePage.click_LoginButton();
		Assert.assertEquals(loginPage.getHomePageTitle(), "Account Login");
		loginPage.setEmail_emailAddressInputBox("dwondri@gmail.com");
		loginPage.setPassword_passwordInputBox("654321");
		loginPage.click_loginButton();
		Assert.assertTrue(loginPage.getLoginErrorMsg().contains("Warning"));
	}
}
