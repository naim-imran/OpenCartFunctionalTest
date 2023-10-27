package pageObjectsfactory;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.PageFactory;

public class HomePageObjects {
	private WebDriver driver;
	public HomePageObjects(WebDriver driver) {
		this.driver=driver;
		PageFactory.initElements(driver, this);
	}

	
	
	public String getHomePageTitle() {
		return driver.getTitle();
	}
}
