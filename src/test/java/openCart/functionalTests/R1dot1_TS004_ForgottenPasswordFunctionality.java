package openCart.functionalTests;

import org.testng.Assert;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

import base.InitialComponentsAndCommonElements;
import pageObjectsfactory.ForgottenPasswordPage;
import pageObjectsfactory.HomePageObjects;
import pageObjectsfactory.LoginPage;



public class R1dot1_TS004_ForgottenPasswordFunctionality extends InitialComponentsAndCommonElements {
	
	private HomePageObjects homePage;

	@BeforeMethod
	public synchronized void launchBrowser() {
		homePage = launchApplicationHomePage();
	}

	@AfterMethod
	public void closeBrowser() {
		quitDriver();
	}
	
	//Jira link: https://naayeem.atlassian.net/browse/TN-53
	@Test(priority = 1, groups = {SMOKE,POSSITIVE}, description = "R1.1_TS004_TC001 as a Registered user I should be able to reset my password by using \"Forgotten Password\" link in \"Returning Customer\" Login box")
	public void r1dot1_TS004_TC001() {
		homePage.click_MyAccountDropLisButton();
		LoginPage loginPage = homePage.click_LoginButton();
		Assert.assertEquals(loginPage.getHomePageTitle(), "Account Login");
		ForgottenPasswordPage forgottenPasswordPage = loginPage.clickForgottenPasswordInReturningCustomerBox();
		Assert.assertEquals(forgottenPasswordPage.getForgottenPasswordPageTitle(),"Forgot Your Password?");
		forgottenPasswordPage.enterEmailInInputBox("dwana.ondricka@gmail.com");
		LoginPage loginPage2 = forgottenPasswordPage.clickContinueButton();
		Assert.assertEquals(loginPage2.getHomePageTitle(), "Account Login");
		Assert.assertEquals(loginPage2.getEmailSentConfirmationText(), "An email with a confirmation link has been sent your email address.");
	}
	
	
	// jira link: https://naayeem.atlassian.net/browse/TN-54
	@Test(priority = 2, groups = {SMOKE,POSSITIVE}, description = "R1.1_TS004_TC002 as a Registered user I should be able to reset my password by using \"Forgotten Password\" link in right column")
	public void r1dot1_TS004_TC002() {
		homePage.click_MyAccountDropLisButton();
		LoginPage loginPage = homePage.click_LoginButton();
		Assert.assertEquals(loginPage.getHomePageTitle(), "Account Login");
		ForgottenPasswordPage forgottenPasswordPage = loginPage.clickforgottenPasswordFromRightColumn();
		Assert.assertEquals(forgottenPasswordPage.getForgottenPasswordPageTitle(),"Forgot Your Password?");
		forgottenPasswordPage.enterEmailInInputBox("dwana.ondricka@gmail.com");
		LoginPage loginPage2 = forgottenPasswordPage.clickContinueButton();
		Assert.assertEquals(loginPage2.getHomePageTitle(), "Account Login");
		Assert.assertEquals(loginPage2.getEmailSentConfirmationText(), "An email with a confirmation link has been sent your email address.");
	}
}
