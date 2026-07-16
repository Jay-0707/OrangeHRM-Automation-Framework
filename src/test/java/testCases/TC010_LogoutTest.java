package testCases;

import org.testng.Assert;
import org.testng.annotations.Test;

import baseClass.BaseClass;
import pageObjects.DashboardPage;
import pageObjects.LoginPage;

public class TC010_LogoutTest extends BaseClass {

	@Test(groups = {"smoke","sanity","regression","login","e2e"})
	public void verifyLogout() {
		logger.info("TC010_LogoutTest start...");
		LoginPage loginPage = new LoginPage(driver);
		logger.info("Entering username and password ");
		loginPage.login(config.getUsername(), config.getPassword());

		DashboardPage dashboardPage = new DashboardPage(driver);
		logger.info("Click on logout button");
		dashboardPage.logout();
		logger.info("Asserion Start");
		Assert.assertTrue(loginPage.isLoginButtonDisplayed());
		logger.info("Asserion End");
		logger.info("TC010_LogoutTest End...");
	}

}
