package utilities;

import org.openqa.selenium.WebDriver;
import org.testng.ITestListener;
import org.testng.ITestResult;

import baseClass.BaseClass;

public class TestListener implements ITestListener {

	@Override
	public void onTestStart(ITestResult result) {
		System.out.println(result.getName() + " Started");
	}

	@Override
	public void onTestSuccess(ITestResult result) {
		System.out.println(result.getName() + " Passed");
	}

	@Override
	public void onTestFailure(ITestResult result) {

		System.out.println(result.getName() + " Failed");

		Object currentClass = result.getInstance();

		WebDriver driver = ((BaseClass) currentClass).getDriver();

		ScreenshotUtility.captureScreenshot(driver, result.getName());
	}

	@Override
	public void onTestSkipped(ITestResult result) {
		System.out.println(result.getName() + " Skipped");
	}
}