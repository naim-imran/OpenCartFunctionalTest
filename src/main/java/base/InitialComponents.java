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

		if (browserName.equalsIgnoreCase("chrome") && threadLocaldriver.get() == null) {

			ChromeOptions co = new ChromeOptions();
			co.setBrowserVersion(loadProperty().getProperty("browserVersion"));
			co.setAcceptInsecureCerts(Boolean.parseBoolean(loadProperty().getProperty("insecureCertificate")));
			if (loadProperty().getProperty("headlessMode").equalsIgnoreCase("true")) {
				co.addArguments("--headless");
			}
			if (loadProperty().getProperty("headlessMode").equalsIgnoreCase("true")
					|| Boolean.parseBoolean(loadProperty().getProperty("insecureCertificate"))
					|| loadProperty().getProperty("browserVersion") != null) {
				threadLocaldriver.set(new ChromeDriver(co));
			} else {
				threadLocaldriver.set(new ChromeDriver());
			}
			driver = threadLocaldriver.get();

		} else if (browserName.equalsIgnoreCase("firefox") && threadLocaldriver.get() == null) {
			FirefoxOptions fo = new FirefoxOptions();
			fo.setBrowserVersion(loadProperty().getProperty("browserVersion"));
			fo.setAcceptInsecureCerts(Boolean.parseBoolean(loadProperty().getProperty("insecureCertificate")));
			if (loadProperty().getProperty("headlessMode").equalsIgnoreCase("true")) {
				fo.addArguments("--headless");
			}
			if (loadProperty().getProperty("headlessMode").equalsIgnoreCase("true")
					|| Boolean.parseBoolean(loadProperty().getProperty("insecureCertificate"))
					|| loadProperty().getProperty("browserVersion") != null) {

				threadLocaldriver.set(new FirefoxDriver(fo));
			} else {
				threadLocaldriver.set(new FirefoxDriver());
			}

			driver = threadLocaldriver.get();

		} else if (browserName.equalsIgnoreCase("edge") && threadLocaldriver.get() == null) {
			EdgeOptions eo = new EdgeOptions();
			eo.setBrowserVersion(loadProperty().getProperty("browserVersion"));
			eo.setAcceptInsecureCerts(Boolean.parseBoolean(loadProperty().getProperty("insecureCertificate")));
			if (loadProperty().getProperty("headlessMode").equalsIgnoreCase("true")) {
				eo.addArguments("--headless");
			}
			if (loadProperty().getProperty("headlessMode").equalsIgnoreCase("true")
					|| Boolean.parseBoolean(loadProperty().getProperty("insecureCertificate"))
					|| loadProperty().getProperty("browserVersion") != null) {
				threadLocaldriver.set(new EdgeDriver(eo));
			} else {
				threadLocaldriver.set(new EdgeDriver());
			}
			driver = threadLocaldriver.get();
		}

		return driver;
	}

	public HomePageObjects launchApplicationHomePage() {
		setupThreadLocalDriver();
		System.out.println("Thread ID= " + Thread.currentThread().getId());

		long implicitWaitTime = Long.parseLong(loadProperty().getProperty("implicitWaitTime"));
		driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(implicitWaitTime));
		driver.manage().window().maximize();
		driver.get(loadProperty().getProperty("testServerURL"));
		return new HomePageObjects(driver);
	}
}
