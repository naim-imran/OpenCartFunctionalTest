package pageObjectsfactory;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.PageFactory;

public class WishListPage extends CommonElements {
	
	WebDriver driver;
	
	public WishListPage(WebDriver driver) {
		super(driver);
		this.driver=driver;
		PageFactory.initElements(driver, this);
	}
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	public String getWishListPageTitle() {
		return driver.getTitle();
	}
}
