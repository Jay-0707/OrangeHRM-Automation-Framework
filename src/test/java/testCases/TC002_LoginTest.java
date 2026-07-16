package testCases;

import org.testng.Assert;
import org.testng.annotations.Test;

import baseClass.BaseClass;
import pageObjects.DashboardPage;
import pageObjects.LoginPage;

public class TC002_LoginTest extends BaseClass {

	@Test(groups = {"smoke","sanity","regression","login","e2e"})
	public void verifyLoginPage() throws InterruptedException {
		logger.info("TC002_LoginTest Started...");
		LoginPage loginPage = new LoginPage(driver);
		
		logger.info("Passing username and password...");
		loginPage.login(config.getUsername(), config.getPassword());
		DashboardPage dashboardPage = new DashboardPage(driver);
		
		logger.info("Verifying dashboard is diplayed...");
		Assert.assertTrue(dashboardPage.isDashboardDisplayed());
		logger.info("Verification Completed...");
		logger.info("TC002_LoginTest end...");

	}

}
