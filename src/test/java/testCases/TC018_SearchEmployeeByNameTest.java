package testCases;

import org.testng.Assert;
import org.testng.annotations.Test;

import baseClass.BaseClass;
import pageObjects.DashboardPage;
import pageObjects.LoginPage;
import pageObjects.PIMPage;

public class TC018_SearchEmployeeByNameTest extends BaseClass {

	@Test
	public void verifySearchEmployeeByName() {

		LoginPage loginPage = new LoginPage(driver);
		loginPage.login(config.getUsername(), config.getPassword());

		DashboardPage dashboardPage = new DashboardPage(driver);
		dashboardPage.clickPIM();

		PIMPage pimPage = new PIMPage(driver);
		pimPage.searchEmployee("Adam");
		Assert.assertEquals(pimPage.getEmployeeFirstNameFromResult(), "Adam");
	}
}
