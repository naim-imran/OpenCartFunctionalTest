package openCart.functionalTests;

import java.util.HashMap;

import org.testng.Assert;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;
import org.testng.asserts.SoftAssert;

import base.InitialComponentsAndCommonElements;
import pageObjectsfactory.AccountCreationSuccessPage;
import pageObjectsfactory.HomePageObjects;
import pageObjectsfactory.MyAccountPage;
import pageObjectsfactory.RegistrationPage;

public class R1dot1_TS001_RegisterFunctionality extends InitialComponentsAndCommonElements {
	
	private HomePageObjects homePage;
	

	@BeforeMethod
	public  void launchBrowser() {

		homePage = launchApplication();
	}

	@AfterMethod
	public void closeBrowser() {
		quitDriver();
	}
	
	@Test(priority = 1, groups = {SMOKE,POSSITIVE}, description = "R1.1_TS001_TC001 As a user I should be able to Register an Account by providing only the Mandatory fields")
	public void r1dot1_TS001_TC001(){
		HashMap<String, String> testData = getFakerTestData();
		homePage.click_MyAccountDropLisButton();
		RegistrationPage registrationPage = homePage.click_registerButton();
		Assert.assertEquals(registrationPage.getRegistrationPageTitle(), "Register Account");
		registrationPage.enterFirstName(testData.get("randomFirstName"));
		registrationPage.enterLastName(testData.get("randomLastName"));
		registrationPage.enterEmail(testData.get("randomEmail"));
		registrationPage.enterTelephone(testData.get("randomPhoneNumber"));
		registrationPage.enterPassword(testData.get("randomPassword"));
		registrationPage.confirmPassword(testData.get("randomPassword"));
		registrationPage.checkPrivacyAndPolicyCheckBox();
		AccountCreationSuccessPage accountCreationSuccessPage = registrationPage.clickContinue();
		Assert.assertEquals(accountCreationSuccessPage.getAccountCreateConfirmationText(),
				"Your Account Has Been Created!");
		System.out.println(accountCreationSuccessPage.getAccountCreateConfirmationText());
		MyAccountPage myAccountPage = accountCreationSuccessPage.clickContinueButton();
		Assert.assertEquals(myAccountPage.getPageTitle(), "My Account");
		System.out.println(myAccountPage.getPageTitle());
	}

	@Test(priority = 3, groups = {SMOKE,POSSITIVE}, description = "R1.1_TS001_TC003 Verify Registering an Account by providing all the fields")
	public void r1dot1_TS001_TC003(){
		HashMap<String, String> testData = getFakerTestData();
		homePage.click_MyAccountDropLisButton();
		RegistrationPage registrationPage = homePage.click_registerButton();
		Assert.assertEquals(registrationPage.getRegistrationPageTitle(), "Register Account");
		registrationPage.enterFirstName(testData.get("randomFirstName"));
		registrationPage.enterLastName(testData.get("randomLastName"));
		registrationPage.enterEmail(testData.get("randomEmail"));
		registrationPage.enterTelephone(testData.get("randomPhoneNumber"));
		registrationPage.enterPassword(testData.get("randomPassword"));
		registrationPage.confirmPassword(testData.get("randomPassword"));
		registrationPage.clickSubscribeNewletterYesButton();
		registrationPage.checkPrivacyAndPolicyCheckBox();
		AccountCreationSuccessPage accountCreationSuccessPage = registrationPage.clickContinue();
		Assert.assertEquals(accountCreationSuccessPage.getAccountCreateConfirmationText(),
				"Your Account Has Been Created!");
		System.out.println(accountCreationSuccessPage.getAccountCreateConfirmationText());
		MyAccountPage myAccountPage = accountCreationSuccessPage.clickContinueButton();
		Assert.assertEquals(myAccountPage.getPageTitle(), "My Account");
		System.out.println(myAccountPage.getPageTitle());
	}

	@Test(priority = 4, groups = {SMOKE,NEGATIVE}, description = "R1.1_TS001_TC004 Verify proper error messages are displayed for the mandatory fields, when you don't provide any mandatory fields in the 'Register Account' page and submit")
	public void r1dot1_TS001_TC004() {
		SoftAssert softAssert= new SoftAssert();
		homePage.click_MyAccountDropLisButton();
		RegistrationPage registrationPage = homePage.click_registerButton();
		Assert.assertEquals(registrationPage.getRegistrationPageTitle(), "Register Account");
		registrationPage.clickContinue();
		softAssert.assertEquals(registrationPage.getFirstnameErrorMessage(), "First Name must be between 1 and 32 characters!");
		softAssert.assertEquals(registrationPage.getLastnameErrorMessage(), "Last Name must be between 1 and 32 characters!");
		softAssert.assertEquals(registrationPage.getEmailErrorMessage(), "E-Mail Address does not appear to be valid!");
		softAssert.assertEquals(registrationPage.getPhoneErrorMessage(), "Telephone must be between 3 and 32 characters!");
		softAssert.assertEquals(registrationPage.getPasswordErrorMessage(), "Password must be between 4 and 20 characters!");
		softAssert.assertAll();
	}

	@Test(priority = 28, groups =  {SMOKE,NEGATIVE}, description = "R1.1_TS001_TC028 Verify the application throws proper error message when user click continue button without selecting privacy and policy check box.")
	public void r1dot1_TS001_TC028() {
		HashMap<String, String> testData = getFakerTestData();
		homePage.click_MyAccountDropLisButton();
		RegistrationPage registrationPage = homePage.click_registerButton();
		Assert.assertEquals(registrationPage.getRegistrationPageTitle(), "Register Account");
		registrationPage.enterFirstName(testData.get("randomFirstName"));
		registrationPage.enterLastName(testData.get("randomLastName"));
		registrationPage.enterEmail(testData.get("randomEmail"));
		registrationPage.enterTelephone(testData.get("randomPhoneNumber"));
		registrationPage.enterPassword(testData.get("randomPassword"));
		registrationPage.confirmPassword(testData.get("randomPassword"));
		registrationPage.clickSubscribeNewletterYesButton();
		registrationPage.clickContinue();
		Assert.assertEquals(registrationPage.getPrivacyPolicyErrorMsg(),
				"Warning: You must agree to the Privacy Policy!");
	}
	
	@Test(priority = 5, groups =  {SMOKE,POSSITIVE}, description = "R1.1_TS001_TC005 As an user I should be able to register an Account by providing only the Mandatory fields and 'Yes' option is selected for Newsletter field" )
	public void r1dot1_TS001_TC005(){
		HashMap<String, String> testData = getFakerTestData();
		homePage.click_MyAccountDropLisButton();
		RegistrationPage registrationPage = homePage.click_registerButton();
		Assert.assertEquals(registrationPage.getRegistrationPageTitle(), "Register Account");
		registrationPage.enterFirstName(testData.get("randomFirstName"));
		registrationPage.enterLastName(testData.get("randomLastName"));
		registrationPage.enterEmail(testData.get("randomEmail"));
		registrationPage.enterTelephone(testData.get("randomPhoneNumber"));
		registrationPage.enterPassword(testData.get("randomPassword"));
		registrationPage.confirmPassword(testData.get("randomPassword"));
		Assert.assertTrue(registrationPage.clickSubscribeNewletterYesButton());
		registrationPage.checkPrivacyAndPolicyCheckBox();
		AccountCreationSuccessPage accountCreationSuccessPage = registrationPage.clickContinue();
		Assert.assertEquals(accountCreationSuccessPage.getAccountCreateConfirmationText(),
				"Your Account Has Been Created!");
		System.out.println(accountCreationSuccessPage.getAccountCreateConfirmationText());
		MyAccountPage myAccountPage = accountCreationSuccessPage.clickContinueButton();
		Assert.assertEquals(myAccountPage.getPageTitle(), "My Account");
		System.out.println(myAccountPage.getPageTitle());
	}
	
	@Test(priority = 6, groups =  {SMOKE,NEGATIVE}, description = "R1.1_TS001_TC006 As an user when I navigate to the registration page Newsletter field 'No' option should be pre-selected" )
	public void r1dot1_TS001_TC006(){
		homePage.click_MyAccountDropLisButton();
		RegistrationPage registrationPage = homePage.click_registerButton();
		Assert.assertEquals(registrationPage.getRegistrationPageTitle(), "Register Account");		
		Assert.assertTrue(registrationPage.checkNewletterSubscribeNoButton());		
	}
	
	@Test(priority = 7, groups =  {SMOKE,NEGATIVE}, description = "R1.1_TS001_TC029 As an user when I navigate to the registration page NEWSLETTER subscribe \"Yes\" checkBox shouldn’t be pre-selected." )
	public void r1dot1_TS001_TC029(){
		homePage.click_MyAccountDropLisButton();
		RegistrationPage registrationPage = homePage.click_registerButton();
		Assert.assertEquals(registrationPage.getRegistrationPageTitle(), "Register Account");
		Assert.assertTrue(registrationPage.checkNewletterSubscribeNoButton());		
	}
}
