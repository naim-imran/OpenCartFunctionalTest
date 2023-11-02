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
	@FindBy(css = "table.table-bordered tbody tr td.text-left a")
	private WebElement productNameFromCartTable;
	
	
	
	
	//
	public String getShoppingCartPageTitle() {
		return driver.getTitle();	
	}
	//
	public String getCartIsEmptyText() {
		return yourCartIsEmptyText.getText();
	}
	// returns the name of the product in cart table
	public String getProductNameFromCartTable() {
		return productNameFromCartTable.getText();
	}

}
