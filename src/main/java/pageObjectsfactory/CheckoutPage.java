package pageObjectsfactory;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.PageFactory;

public class CheckoutPage extends CommonElements{

	private WebDriver driver;

	public CheckoutPage(WebDriver driver) {
		super(driver);
		this.driver=driver;
		PageFactory.initElements(driver, this);
	}

	
	public String getCheckoutPageTitle() {
		return driver.getTitle();
	}
}
