package testCases;

import org.testng.Assert;
import org.testng.annotations.Test;

import baseClass.BaseClass;
import pageObjects.DashboardPage;
import pageObjects.LoginPage;
import pageObjects.PIMPage;

public class TC018_SearchEmployeeByNameTest extends BaseClass {

	@Test(groups = {"pim","regression"})
	public void verifySearchEmployeeByName() {

		logger.info("TC018_SearchEmployeeByNameTest Start");
		LoginPage loginPage = new LoginPage(driver);
		logger.info("Entering login details");
		loginPage.login(config.getUsername(), config.getPassword());

		DashboardPage dashboardPage = new DashboardPage(driver);
		logger.info("Click on PIM");
		dashboardPage.clickPIM();

		PIMPage pimPage = new PIMPage(driver);
		logger.info("search employee by name");
		pimPage.searchEmployee("Adam");
		logger.info("Assertion Start");
		Assert.assertEquals(pimPage.getEmployeeFirstNameFromResult(),"Adam");
		logger.info("Assertion end");
		logger.info("TC018_SearchEmployeeByNameTest End");
	}
}
