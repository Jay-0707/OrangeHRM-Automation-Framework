package testCases;

import org.testng.Assert;
import org.testng.annotations.Test;

import baseClass.BaseClass;
import pageObjects.DashboardPage;
import pageObjects.EmployeeDetailsPage;
import pageObjects.LoginPage;
import pageObjects.PIMPage;

public class TC014_EditEmployeeTest extends BaseClass {

	@Test
	public void verifyEditEmployee() {
		LoginPage loginPage = new LoginPage(driver);
		loginPage.login(config.getUsername(), config.getPassword());

		DashboardPage dashboardPage = new DashboardPage(driver);
		dashboardPage.clickPIM();

		PIMPage pimPage = new PIMPage(driver);
		pimPage.searchEmployeeByID(employeeId);

		EmployeeDetailsPage employeeDetailsPage = new EmployeeDetailsPage(driver);
		employeeDetailsPage.editOtherId("99999");
		
		Assert.assertEquals(employeeDetailsPage.getOtherId(),"99999");

	}

}
