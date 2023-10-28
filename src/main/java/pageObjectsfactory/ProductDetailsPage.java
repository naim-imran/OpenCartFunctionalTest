package pageObjectsfactory;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class ProductDetailsPage {

	private WebDriver driver;

	public ProductDetailsPage(WebDriver driver) {
		this.driver= driver;
		PageFactory.initElements(driver, this);
	}
	
	
	
	
	public String getProductDetailsPageTitle() { return driver.getTitle(); }
	 
	
	@FindBy(xpath= "//div[@class='col-sm-4']/div[@class='btn-group']/following-sibling::h1")
	private WebElement rightColumnProductName;
	
	public String getrightColumnProductName() {
		return rightColumnProductName.getText();
		
		
	}

}