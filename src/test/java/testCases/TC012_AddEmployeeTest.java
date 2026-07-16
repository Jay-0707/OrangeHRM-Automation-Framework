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

	
	@Test(groups = {"pim","regression","e2e","sanity"})
	public void verifyAddEmployee()
	{
		logger.info("TC012_AddEmployeeTest start");
		LoginPage loginPage=new LoginPage(driver);
		logger.info("Entering login details");
		loginPage.login(config.getUsername(),config.getPassword());
		
		DashboardPage dashboardPage=new DashboardPage(driver);
		logger.info("click on PIM option");
		dashboardPage.clickPIM();
		
		PIMPage pimPage=new PIMPage(driver);
		logger.info("click on add button");
		pimPage.clickAddButton();
		
		AddEmployeePage addEmployeePage=new AddEmployeePage(driver);
		logger.info("Entering First name and last name");
		addEmployeePage.addEmployee("Adam","Jhon");
		
		EmployeeDetailsPage  employeeDetailsPage =new EmployeeDetailsPage (driver);
		employeeId =employeeDetailsPage.getEmployeeId();
		logger.info("Assertion Start");
		Assert.assertTrue(employeeDetailsPage.isPersonalDetailsPageDisplayed());
		logger.info("Assertion Ends");
		logger.info("TC012_AddEmployeeTest Ends");
	}
}
