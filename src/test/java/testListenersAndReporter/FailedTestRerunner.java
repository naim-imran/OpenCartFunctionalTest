package testListenersAndReporter;

import org.testng.IRetryAnalyzer;
import org.testng.ITestResult;

import base.Reuseables;

public class FailedTestRerunner implements IRetryAnalyzer {
	
	private byte retryCount= 1;
	private byte maxRetryCount= Byte.parseByte((new Reuseables().loadProperty().getProperty("maxFailedTestRetryCount")));
	
	@Override
	public boolean retry(ITestResult result) {
		if (retryCount< maxRetryCount) {
			retryCount++;
			return true;
		}
		return false;
	}

}
