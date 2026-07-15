package testCases;

import org.testng.Assert;
import org.testng.annotations.Test;

import baseClass.BaseClass;
import pageObjects.DashboardPage;
import pageObjects.LoginPage;
import pageObjects.PIMPage;

@Test
public class TC016_SearchInvalidEmployeeTest extends BaseClass{

	public void verifySearchInvalidEmployee()
	{
		LoginPage loginPage=new LoginPage(driver);
		loginPage.login(config.getUsername(),config.getPassword());
		
		DashboardPage dashboardPage=new DashboardPage(driver);
		dashboardPage.clickPIM();
		
		PIMPage pimPage=new PIMPage(driver);
		pimPage.searchEmployeeByID("1234567890");
		
		Assert.assertTrue(pimPage.isNoRecordsFoundDisplayed());
	}
	
}
