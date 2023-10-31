package pageObjectsfactory;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class ShoppingCartPage {

	private WebDriver driver;

	public ShoppingCartPage(WebDriver driver) {
		this.driver=driver;
		PageFactory.initElements(driver, this);
	}
	//
	@FindBy(xpath="//div[@id='content']/p[text()='Your shopping cart is empty!']")
	private WebElement yourCartIsEmptyText;
	
	
	
	
	//
	public String getShoppingCartPageTitle() {
		return driver.getTitle();	
	}
	//
	public String getCartIsEmptyText() {
		return yourCartIsEmptyText.getText();
	}

}
