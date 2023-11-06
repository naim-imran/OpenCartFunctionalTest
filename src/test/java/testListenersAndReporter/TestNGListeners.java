package testListenersAndReporter;

import java.io.File;
import java.util.HashMap;

import org.openqa.selenium.WebDriver;
import org.testng.ITestContext;
import org.testng.ITestListener;
import org.testng.ITestResult;

import com.aventstack.extentreports.ExtentReports;
import com.aventstack.extentreports.ExtentTest;
import com.aventstack.extentreports.Status;
import com.aventstack.extentreports.reporter.ExtentSparkReporter;

import base.InitialComponentsAndCommonElements;

public class TestNGListeners extends InitialComponentsAndCommonElements implements ITestListener {

	

	private ExtentReports setReport;
	private ThreadLocal<ExtentTest> threadLocalStatusLogger = new ThreadLocal<ExtentTest>();
	private String resultfolderPath;

	@Override
	public void onStart(ITestContext context) {

		String timeStamp = getTimeStamp();
		String resultFolder = context.getName() + "_" + timeStamp;
		File folder = new File("." + File.separator + "testResultsAndScreecshots" + File.separator + resultFolder);
		folder.mkdirs();
		resultfolderPath = System.getProperty("user.dir") + File.separator + "testResultsAndScreecshots"
				+ File.separator + resultFolder + File.separator;

		ExtentSparkReporter configureReport = new ExtentSparkReporter(
				resultfolderPath + context.getName() + "_report" + timeStamp + ".html");
		configureReport.config().setReportName(context.getName());
		configureReport.config().setDocumentTitle(context.getName());
		
		setReport = new ExtentReports();
		setReport.attachReporter(configureReport);
		setReport.setSystemInfo("Operating System: "+ System.getProperty("os.name"), "version: "+ System.getProperty("os.version"));
		setReport.setSystemInfo("Programing Language: java", "version "+ System.getProperty("java.version"));
		
		
		HashMap<String, String> browserNameAndVersion = getBrowserNameVersion();
		setReport.setSystemInfo("WebBrowser: "+ browserNameAndVersion.get("name"), "version: "+ browserNameAndVersion.get("version"));



	}

	@Override
	public void onFinish(ITestContext context) {
		setReport.flush();
	}

	@Override
	public void onTestStart(ITestResult result) {
		ExtentTest logStatus = setReport.createTest(result.getMethod().getDescription());
		threadLocalStatusLogger.set(logStatus);
	}

	@Override
	public void onTestSuccess(ITestResult result) {
		threadLocalStatusLogger.get().log(Status.PASS, "test passed");
	}

	@Override
	public void onTestFailure(ITestResult result) {
		threadLocalStatusLogger.get().log(Status.FAIL, "Test failed. " + result.getThrowable());

		try {
			WebDriver driver = (WebDriver) result.getTestClass().getRealClass().getField("driver")
					.get(result.getInstance());
			String screenshot = takeScreenShot(driver, result.getName(), resultfolderPath);
			threadLocalStatusLogger.get().addScreenCaptureFromPath(screenshot);
		} catch (IllegalArgumentException | IllegalAccessException | NoSuchFieldException | SecurityException e) {
			e.printStackTrace();
		}
	}
	
	@Override
	public void onTestSkipped(ITestResult result) {
		threadLocalStatusLogger.get().log(Status.SKIP, "Test skipped. " + result.getThrowable());
	}

}
