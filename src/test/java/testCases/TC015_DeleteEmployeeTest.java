package testCases;

import org.testng.Assert;
import org.testng.annotations.Test;

import baseClass.BaseClass;
import pageObjects.DashboardPage;
import pageObjects.LoginPage;
import pageObjects.PIMPage;

public class TC015_DeleteEmployeeTest extends BaseClass{

	@Test(groups = {"pim","regression","e2e"})
	public void verifyDeleteEmployee()
	{
		logger.info("TC015_DeleteEmployeeTest Start");
		LoginPage loginPage=new LoginPage(driver);
		logger.info("Entering login details");
		loginPage.login(config.getUsername(), config.getPassword());
		
		DashboardPage dashboardPage=new DashboardPage(driver);
		logger.info("Click on PIM");
		dashboardPage.clickPIM();
		
		PIMPage pimPage=new PIMPage(driver);
		logger.info("Search employee by id");
		pimPage.searchEmployeeByID(employeeId);
		logger.info("click on delete button");
		pimPage.deleteEmployee();
		logger.info("Again Search employee by id");
		pimPage.searchEmployeeByID(employeeId);
		logger.info("Assertion Start");
		Assert.assertTrue(pimPage.isNoRecordsFoundDisplayed());
		logger.info("Assertion end");
		logger.info("TC015_DeleteEmployeeTest Ends");
		
	}
	
}
