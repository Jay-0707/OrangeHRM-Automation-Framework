package testCases;

import org.testng.Assert;
import org.testng.annotations.Test;

import baseClass.BaseClass;
import pageObjects.DashboardPage;
import pageObjects.LoginPage;

public class TC010_LogoutTest extends BaseClass {

	@Test(groups = {"smoke","sanity","regression","login","e2e"})
	public void verifyLogout() {

		LoginPage loginPage = new LoginPage(driver);
		loginPage.login(config.getUsername(), config.getPassword());

		DashboardPage dashboardPage = new DashboardPage(driver);
		dashboardPage.logout();

		Assert.assertTrue(loginPage.isLoginButtonDisplayed());
	}

}
