package testCases;

import org.testng.Assert;
import org.testng.annotations.Test;

import baseClass.BaseClass;
import pageObjects.AdminPage;
import pageObjects.DashboardPage;
import pageObjects.LoginPage;
import utilities.TestData;

public class TC022_SearchUser extends BaseClass{

	
	@Test(groups = {"admin","regression","e2e"})
	public void verifySearchUser() throws InterruptedException
	{
		logger.info("TC022_SearchUser Starts");
		logger.info("Entering login details");
		LoginPage loginPage=new LoginPage(driver);
		loginPage.login(config.getUsername(), config.getPassword());
		
		logger.info("Clicking admin from menu");
		DashboardPage dashboardPage=new DashboardPage(driver);
		dashboardPage.clickAdmin();
		
		logger.info("Entering username");
		AdminPage adminPage=new AdminPage(driver);
		adminPage.enterUsername(TestData.username);
		logger.info("Clicking Search Button");
		adminPage.clickSearch();
		logger.info("Assertion Starts");
		Assert.assertTrue(adminPage.isUserPresent(TestData.username));
		logger.info("Assertion Ends");
		logger.info("TC022_SearchUser Finished");
		
	}
	
}
