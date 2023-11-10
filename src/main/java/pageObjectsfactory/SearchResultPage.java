package pageObjectsfactory;

import java.time.Duration;
import java.util.List;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

public class SearchResultPage extends CommonElements{
	private WebDriver driver;

	public SearchResultPage(WebDriver driver) {
		super(driver);
		this.driver = driver;
		PageFactory.initElements(driver, this);
	}
	//____ Sub-title with searched text _____
	@FindBy(xpath = "//div[@id='content']/h1")
	private WebElement searchText;
	//
	@FindBy(xpath = "//div[@class='caption']/h4/a")
	private List<WebElement> listOfSearchedProducts;
	//
	@FindBy(css = "//div[@class='product-thumb transition']//button[@data-original-title='Compare this Product']")
	private List<WebElement> listOfCompareButton;
	//
	@FindBy(xpath = "//a[text()='product comparison']")
	private WebElement comparisonPageLinkButton;
	
	
	//____ get Sub-title text starts with "Searched - " ____
	public String getSearchedItemText() {
		return searchText.getText();
	}

	public ProductDetailsPage click_Product(String expectedProductName) {
		for (WebElement e : listOfSearchedProducts) {
			if (e.getText().contains(expectedProductName)) {
				e.click();
				break;
			}
		}
		return new ProductDetailsPage(driver);
	}



	public ProductsComparisonPage click_comparisonPageLinkButton() {
		WebDriverWait webDriverWait = new WebDriverWait(driver, Duration.ofSeconds(15));
		webDriverWait.until(ExpectedConditions.elementToBeClickable(comparisonPageLinkButton)).click();
		return new ProductsComparisonPage(driver);
	}

}
