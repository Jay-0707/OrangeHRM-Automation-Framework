package testCases;

import org.testng.Assert;
import org.testng.annotations.Test;

import baseClass.BaseClass;
import pageObjects.DashboardPage;
import pageObjects.LoginPage;
import pageObjects.PIMPage;

public class TC011_NavigateToPIMTest extends BaseClass {

	@Test
	public void verifyPIMPage() {

		LoginPage loginPage = new LoginPage(driver);
		loginPage.login(config.getUsername(), config.getPassword());

		DashboardPage dashboardPage = new DashboardPage(driver);
		dashboardPage.clickPIM();

		PIMPage pimPage = new PIMPage(driver);
		Assert.assertTrue(pimPage.isPIMPageDisplayed());
	}

}
