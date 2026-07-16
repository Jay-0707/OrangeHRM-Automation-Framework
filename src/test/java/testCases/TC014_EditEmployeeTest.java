package testCases;

import org.testng.Assert;
import org.testng.annotations.Test;

import baseClass.BaseClass;
import pageObjects.DashboardPage;
import pageObjects.EmployeeDetailsPage;
import pageObjects.LoginPage;
import pageObjects.PIMPage;

public class TC014_EditEmployeeTest extends BaseClass {

	@Test(groups = {"pim","regression","e2e"})
	public void verifyEditEmployee() {
		logger.info("TC014_EditEmployeeTest Start");
		LoginPage loginPage = new LoginPage(driver);
		logger.info("Entering login details");
		loginPage.login(config.getUsername(), config.getPassword());

		DashboardPage dashboardPage = new DashboardPage(driver);
		logger.info("Click on PIM");
		dashboardPage.clickPIM();

		PIMPage pimPage = new PIMPage(driver);
		
		logger.info("Search employee by id");
		pimPage.searchEmployeeByID(employeeId);

		EmployeeDetailsPage employeeDetailsPage = new EmployeeDetailsPage(driver);
		logger.info("Editing employee id");
		employeeDetailsPage.editOtherId("99999");
		logger.info("Assertion Start");
		Assert.assertEquals(employeeDetailsPage.getOtherId(),"99999");
		logger.info("Assertion end");
		logger.info("TC014_EditEmployeeTest End");

	}

}
