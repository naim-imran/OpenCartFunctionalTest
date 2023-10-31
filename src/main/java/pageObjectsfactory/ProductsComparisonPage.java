package pageObjectsfactory;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.PageFactory;

public class ProductsComparisonPage {

	private WebDriver driver;

	public ProductsComparisonPage(WebDriver driver) {
		this.driver=driver;
		PageFactory.initElements(driver, this);
	}
	
	public String getProductsComparisonPageTitle() {
		return driver.getTitle();
	}

}
