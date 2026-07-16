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
		LoginPage loginPage=new LoginPage(driver);
		loginPage.login(config.getUsername(), config.getPassword());
		
		DashboardPage dashboardPage=new DashboardPage(driver);
		dashboardPage.clickPIM();
		
		PIMPage pimPage=new PIMPage(driver);
		pimPage.searchEmployeeByID(employeeId);
		
		WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(15));

		wait.until(driver ->pimPage.getEmployeeIdFromResult().equals(employeeId));
		
		Assert.assertEquals(pimPage.getEmployeeIdFromResult(), employeeId);
	}
}
