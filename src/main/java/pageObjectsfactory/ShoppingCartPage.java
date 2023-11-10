package pageObjectsfactory;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class ShoppingCartPage extends CommonElements{

	private WebDriver driver;

	public ShoppingCartPage(WebDriver driver) {
		super(driver);
		this.driver=driver;
		PageFactory.initElements(driver, this);
	}
	//
	@FindBy(xpath="//div[@id='content']/p[text()='Your shopping cart is empty!']")
	private WebElement yourCartIsEmptyText;
	
	// product name webElement in cart table.
	@FindBy(css = "table.table-bordered tbody tr td.text-left a")
	private WebElement productNameFromCartTable;
	
	
	// returns ShoppingCart Page Title.
	public String getShoppingCartPageTitle() {
		return driver.getTitle();	
	}
	
	// returns ShoppingCart-Subtitle message.
	public String getShoppingCartSubtitleMessage() {
		return yourCartIsEmptyText.getText();
	}
	
	// returns the name of the product in cart table
	public String getProductNameFromCartTable() {
		return productNameFromCartTable.getText();
	}

}
