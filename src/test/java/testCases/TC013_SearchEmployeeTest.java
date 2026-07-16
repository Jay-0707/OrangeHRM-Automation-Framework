package testCases;

import org.testng.Assert;
import org.testng.annotations.Test;

import baseClass.BaseClass;
import pageObjects.DashboardPage;
import pageObjects.LoginPage;
import pageObjects.PIMPage;

public class TC013_SearchEmployeeTest extends BaseClass{

	@Test(groups = {"pim","regression","e2e","sanity"})
	public void verifySearchEmployee()
	{
		LoginPage loginPage=new LoginPage(driver);
		loginPage.login(config.getUsername(), config.getPassword());
		
		DashboardPage dashboardPage=new DashboardPage(driver);
		dashboardPage.clickPIM();
		
		PIMPage pimPage=new PIMPage(driver);
		pimPage.searchEmployeeByID(employeeId);
		
		Assert.assertEquals(pimPage.getEmployeeIdFromResult(), employeeId);
	}
}
