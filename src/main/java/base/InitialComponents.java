package base;

import java.time.Duration;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import org.openqa.selenium.edge.EdgeDriver;
import org.openqa.selenium.edge.EdgeOptions;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.firefox.FirefoxOptions;

import pageObjectsfactory.HomePageObjects;

public class InitialComponents extends Reuseables {
	public WebDriver driver;// driver has to be public because we have to get it through reflection API in
	// listener class

	private ThreadLocal<WebDriver> threadLocaldriver = new ThreadLocal<WebDriver>();
	
	

	public WebDriver setupThreadLocalDriver() {

		String browserName = System.getProperty("browser") != null ? System.getProperty("browser")
				: loadProperty().getProperty("browser");
		String browserVersion = loadProperty().getProperty("browserVersion");
		String headLessMode = loadProperty().getProperty("headlessMode");
		boolean insecureCertificate = Boolean.parseBoolean(loadProperty().getProperty("insecureCertificate"));
		
		

		if (browserName.equalsIgnoreCase("chrome") && threadLocaldriver.get() == null) {

			ChromeOptions co = new ChromeOptions();

			if (!browserVersion.equalsIgnoreCase("")) {
				co.setBrowserVersion(browserVersion);
			}

			if (insecureCertificate) {
				co.setAcceptInsecureCerts(insecureCertificate);
			}

			if (headLessMode.equalsIgnoreCase("true")) {
				co.addArguments("--headless");
			}

			threadLocaldriver.set(new ChromeDriver(co));
			driver = threadLocaldriver.get();

		} else if (browserName.equalsIgnoreCase("firefox") && threadLocaldriver.get() == null) {
			FirefoxOptions fo = new FirefoxOptions();

			if (!browserVersion.equalsIgnoreCase("")) {
				fo.setBrowserVersion(browserVersion);
			}

			if (insecureCertificate) {
				fo.setAcceptInsecureCerts(insecureCertificate);
			}

			if (headLessMode.equalsIgnoreCase("true")) {
				fo.addArguments("--headless");
			}
			threadLocaldriver.set(new FirefoxDriver(fo));

			driver = threadLocaldriver.get();

		} else if (browserName.equalsIgnoreCase("edge") && threadLocaldriver.get() == null) {
			EdgeOptions eo = new EdgeOptions();
			if (!browserVersion.equalsIgnoreCase("")) {
				eo.setBrowserVersion(browserVersion);
			}

			if (insecureCertificate) {
				eo.setAcceptInsecureCerts(insecureCertificate);
			}

			if (headLessMode.equalsIgnoreCase("true")) {
				eo.addArguments("--headless");
			}
			threadLocaldriver.set(new EdgeDriver(eo));
			driver = threadLocaldriver.get();
		}
		return driver;
	}

	public HomePageObjects launchApplicationHomePage() {
		setupThreadLocalDriver();
		// System.out.println("Thread ID= " + Thread.currentThread().getId());
		long implicitWaitTime = Long.parseLong(loadProperty().getProperty("implicitWaitTime"));
		driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(implicitWaitTime));
		driver.manage().window().maximize();
		driver.get(loadProperty().getProperty("testServerURL"));
		return new HomePageObjects(driver);
	}

	public synchronized void quitDriver() {
		WebDriver driver = threadLocaldriver.get();
		if (driver != null) {
			driver.quit();
			threadLocaldriver.remove();
		}
	}
}
