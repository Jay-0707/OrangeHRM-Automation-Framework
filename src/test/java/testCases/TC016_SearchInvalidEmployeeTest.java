package testCases;

import org.testng.Assert;
import org.testng.annotations.Test;

import baseClass.BaseClass;
import pageObjects.DashboardPage;
import pageObjects.LoginPage;
import pageObjects.PIMPage;

@Test(groups = {"pim","regression"})
public class TC016_SearchInvalidEmployeeTest extends BaseClass{

	public void verifySearchInvalidEmployee()
	{
		logger.info("TC016_SearchInvalidEmployeeTest Start");
		LoginPage loginPage=new LoginPage(driver);
		logger.info("Entering login details");
		loginPage.login(config.getUsername(),config.getPassword());
		
		DashboardPage dashboardPage=new DashboardPage(driver);
		logger.info("Click on PIM");
		dashboardPage.clickPIM();
		
		PIMPage pimPage=new PIMPage(driver);
		logger.info("Search employee by id");
		pimPage.searchEmployeeByID("1234567890");
		logger.info("Assertion Start");
		Assert.assertTrue(pimPage.isNoRecordsFoundDisplayed());
		logger.info("Assertion end");
		logger.info("TC016_SearchInvalidEmployeeTest End");
	}
	
}
