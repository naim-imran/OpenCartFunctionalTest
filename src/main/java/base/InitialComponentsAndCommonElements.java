package base;

import java.time.Duration;
import java.util.HashMap;
import java.util.Properties;

import org.openqa.selenium.Capabilities;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import org.openqa.selenium.edge.EdgeDriver;
import org.openqa.selenium.edge.EdgeOptions;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.firefox.FirefoxOptions;
import org.openqa.selenium.remote.RemoteWebDriver;

import pageObjectsfactory.HomePageObjects;

public class InitialComponentsAndCommonElements extends Reuseables{
	

	public WebDriver driver;// driver has to be public because we have to get it through reflection API in
	// listener class

	private ThreadLocal<WebDriver> threadLocaldriver = new ThreadLocal<WebDriver>();
	private Properties prop;
	


	public WebDriver setupThreadLocalDriver() {
		prop= loadProperty();
		String browserName = System.getProperty("browser") != null ? System.getProperty("browser")
				: prop.getProperty("browser");
		String browserVersion = prop.getProperty("browserVersion");
		String headLessMode = prop.getProperty("headlessMode");
		boolean insecureCertificate = Boolean.parseBoolean(prop.getProperty("insecureCertificate"));
		
		

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

	public HomePageObjects launchApplication() {
		setupThreadLocalDriver();
		// System.out.println("Thread ID= " + Thread.currentThread().getId());
		long implicitWaitTime = Long.parseLong(prop.getProperty("implicitWaitTime"));
		driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(implicitWaitTime));
		driver.manage().window().maximize();
		driver.manage().deleteAllCookies();
		driver.get(prop.getProperty("testServerURL"));
		return new HomePageObjects(driver);
	}
	
	public void launchApplication(String testServerURL) {
		setupThreadLocalDriver();
		long implicitWaitTime = Long.parseLong(prop.getProperty("implicitWaitTime"));
		driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(implicitWaitTime));
		driver.manage().window().maximize();
		driver.manage().deleteAllCookies();
		driver.get(prop.getProperty(testServerURL));

	}
	
	public HashMap<String, String> getBrowserNameVersion() {
		setupThreadLocalDriver();
		RemoteWebDriver remoteWebDriver = (RemoteWebDriver) setupThreadLocalDriver();
		Capabilities caps = remoteWebDriver.getCapabilities();
		String browserName = caps.getBrowserName();
		String browserVersion = caps.getBrowserVersion();
	
		HashMap<String, String> hashMap = new HashMap<String, String>();
		hashMap.put("name", browserName);
		hashMap.put("version", browserVersion);
		quitDriver();
		return hashMap;
	}

	public void quitDriver() {
		WebDriver driver = threadLocaldriver.get();
		if (driver != null) {
			driver.quit();
			threadLocaldriver.remove();
		}
	}
}
