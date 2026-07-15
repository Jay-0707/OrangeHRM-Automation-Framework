package testCases;

import org.testng.Assert;
import org.testng.annotations.Test;

import baseClass.BaseClass;
import pageObjects.AddEmployeePage;
import pageObjects.DashboardPage;
import pageObjects.EmployeeDetailsPage;
import pageObjects.LoginPage;
import pageObjects.PIMPage;

public class TC012_AddEmployeeTest extends BaseClass{

	
	@Test
	public void verifyAddEmployee()
	{
		LoginPage loginPage=new LoginPage(driver);
		loginPage.login(config.getUsername(),config.getPassword());
		
		DashboardPage dashboardPage=new DashboardPage(driver);
		dashboardPage.clickPIM();
		
		PIMPage pimPage=new PIMPage(driver);
		pimPage.clickAddButton();
		
		AddEmployeePage addEmployeePage=new AddEmployeePage(driver);
		addEmployeePage.addEmployee("Adam","Jhon");
		
		EmployeeDetailsPage  employeeDetailsPage =new EmployeeDetailsPage (driver);
		employeeId =employeeDetailsPage.getEmployeeId();
		Assert.assertTrue(employeeDetailsPage.isPersonalDetailsPageDisplayed());
	}
}
