package testCases;

import org.testng.Assert;
import org.testng.annotations.Test;

import baseClass.BaseClass;
import pageObjects.AdminPage;
import pageObjects.DashboardPage;
import pageObjects.LoginPage;
import utilities.TestData;

public class TC024_DeleteUser extends BaseClass{

	@Test(groups = {"admin","regression","e2e"})
	public void verifyDeleteUser() throws InterruptedException
	{
		logger.info("TC024_DeleteUser Starts");
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
		Thread.sleep(3000);
		logger.info("Clicking Delete Button");
		adminPage.clickDeleteBtn();
		logger.info("Clicking Yes Delete Button");
		adminPage.clickConfirmDeleteBtn();
		logger.info("Successfully Deleted message Assertion Start");
		Assert.assertEquals(adminPage.getToastMessage(), "Successfully Deleted");
		logger.info("Successfully Deleted message  Assertion Ends");
		
		logger.info("Entering username Again");
		adminPage.enterUsername(TestData.username);
		logger.info("Clicking Search Button");
		adminPage.clickSearch();
		logger.info("No Records Found Assertin Start");
		Assert.assertTrue(adminPage.isNoRecordFoundMessageDisplayed());
		logger.info("No Records Found Assertin Finished");
		logger.info("TC024_DeleteUser Finished");
	}
	
}
