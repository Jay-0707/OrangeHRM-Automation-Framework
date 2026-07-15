package testCases;

import org.testng.Assert;
import org.testng.annotations.Test;

import baseClass.BaseClass;
import pageObjects.DashboardPage;
import pageObjects.LoginPage;
import pageObjects.PIMPage;

@Test
public class TC017_ResetSearchTest extends BaseClass {

	public void verifyResetSearch()
	{
		LoginPage loginPage=new LoginPage(driver);
		loginPage.login(config.getUsername(), config.getPassword());
		
		DashboardPage dashboardPage=new DashboardPage(driver);
		dashboardPage.clickPIM();
		
		PIMPage pimPage=new PIMPage(driver);
		pimPage.enterEmployeeName("Adam");
		pimPage.enterEmployeeId("12345");
		
		pimPage.clickReset();
		
		Assert.assertEquals(pimPage.getEmployeeName(),"");
		Assert.assertEquals(pimPage.getEmployeeId(),"");
	}
}
