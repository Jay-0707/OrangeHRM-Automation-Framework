package testCases;

import org.testng.Assert;
import org.testng.annotations.Test;

import baseClass.BaseClass;
import pageObjects.DashboardPage;
import pageObjects.LoginPage;
import pageObjects.PIMPage;

@Test(groups = {"pim","regression"})
public class TC017_ResetSearchTest extends BaseClass {

	public void verifyResetSearch()
	{
		
		logger.info("TC017_ResetSearchTest Start");
		LoginPage loginPage=new LoginPage(driver);
		logger.info("Entering login details");
		loginPage.login(config.getUsername(), config.getPassword());
		
		DashboardPage dashboardPage=new DashboardPage(driver);
		logger.info("Click on PIM");
		dashboardPage.clickPIM();
		
		PIMPage pimPage=new PIMPage(driver);
		logger.info("Enter employee name");
		pimPage.enterEmployeeName("Adam");
		logger.info("Enter employee id");
		pimPage.enterEmployeeId("12345");
		
		logger.info("Click on reset button");
		pimPage.clickReset();
		logger.info("Assertion Start");
		Assert.assertEquals(pimPage.getEmployeeName(),"");
		Assert.assertEquals(pimPage.getEmployeeId(),"");
		logger.info("Assertion end");
		logger.info("TC017_ResetSearchTest Ends");
	}
}
