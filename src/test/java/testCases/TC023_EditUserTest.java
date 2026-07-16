package testCases;

import org.testng.Assert;
import org.testng.annotations.Test;

import baseClass.BaseClass;
import pageObjects.AdminPage;
import pageObjects.DashboardPage;
import pageObjects.EditUserInfoPage;
import pageObjects.LoginPage;
import utilities.TestData;

public class TC023_EditUserTest extends BaseClass{

	@Test(groups = {"admin","regression","e2e"})
	public void verifyEditUserTest() throws InterruptedException
	{
		logger.info("TC023_EditUserTest Starts");
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
		logger.info("Clicking Edit User Button");
		adminPage.clickEditBtn();
		
		EditUserInfoPage editUserInfoPage=new EditUserInfoPage(driver);
		logger.info("Clicking Status Dropdown");
		editUserInfoPage.clickStatusDropDown();
		logger.info("Selecting disable option");
		editUserInfoPage.selectDisableStatusOption();
		logger.info("Clicking Save Button");
		editUserInfoPage.clickSaveBtn();
		logger.info("Assertin Start");
		Assert.assertEquals(editUserInfoPage.getToastMessage(), "Successfully Updated");
		logger.info("Assertin Finished");
		logger.info("TC023_EditUserTest End");
		
	}
}
