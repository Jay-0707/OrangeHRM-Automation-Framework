package testCases;

import org.testng.Assert;
import org.testng.annotations.Test;

import baseClass.BaseClass;
import pageObjects.AdminPage;
import pageObjects.DashboardPage;
import pageObjects.LoginPage;

@Test(groups = {"admin","regression","e2e"})
public class TC019_NavigateToAdminTest extends BaseClass {

	public void verifySystemUserPageIsDisplayed() {
		logger.info("TC019_NavigateToAdminTest test case start");
		logger.info("Entering login details");
		LoginPage loginPage = new LoginPage(driver);
		loginPage.login(config.getUsername(), config.getPassword());

		logger.info("click on admin button drom menu");
		DashboardPage dashboardPage = new DashboardPage(driver);
		dashboardPage.clickAdmin();

		logger.info("validating system yser is displayed");
		AdminPage adminPage = new AdminPage(driver);
		Assert.assertTrue(adminPage.isSystemUsersPageDisplayed());
		logger.info("TC019_NavigateToAdminTest finished");
	}

}
