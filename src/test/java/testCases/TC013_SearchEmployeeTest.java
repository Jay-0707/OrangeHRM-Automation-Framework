package testCases;

import java.time.Duration;

import org.openqa.selenium.support.ui.WebDriverWait;
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
		logger.info("TC013_SearchEmployeeTest start");
		LoginPage loginPage=new LoginPage(driver);
		logger.info("Entering login details");
		loginPage.login(config.getUsername(), config.getPassword());
		
		DashboardPage dashboardPage=new DashboardPage(driver);
		dashboardPage.clickPIM();
		
		PIMPage pimPage=new PIMPage(driver);
		logger.info("Searching employee by ID");
		pimPage.searchEmployeeByID(employeeId);
		
		WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(15));

		wait.until(driver ->pimPage.getEmployeeIdFromResult().equals(employeeId));
		
		logger.info("Assertion Start");
		Assert.assertEquals(pimPage.getEmployeeIdFromResult(), employeeId);
		logger.info("Assertion Ends");
		logger.info("TC013_SearchEmployeeTest Ends");
	}
}
