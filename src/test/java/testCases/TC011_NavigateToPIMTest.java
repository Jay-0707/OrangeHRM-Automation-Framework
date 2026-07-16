package testCases;

import org.testng.Assert;
import org.testng.annotations.Test;

import baseClass.BaseClass;
import pageObjects.DashboardPage;
import pageObjects.LoginPage;
import pageObjects.PIMPage;

public class TC011_NavigateToPIMTest extends BaseClass {

	@Test(groups = {"pim","regression","e2e"})
	public void verifyPIMPage() {
		logger.info("TC011_NavigateToPIMTest start...");
		LoginPage loginPage = new LoginPage(driver);
		logger.info("Entering username and password ");
		loginPage.login(config.getUsername(), config.getPassword());

		DashboardPage dashboardPage = new DashboardPage(driver);
		logger.info("Click on PIM Option ");
		dashboardPage.clickPIM();
		logger.info("Asserion Start");
		PIMPage pimPage = new PIMPage(driver);
		Assert.assertTrue(pimPage.isPIMPageDisplayed());
		logger.info("Asserion End");
		logger.info("TC011_NavigateToPIMTest Ends...");
	}

}
