package testCases;

import org.testng.Assert;
import org.testng.annotations.Test;

import baseClass.BaseClass;
import pageObjects.AddUserPage;
import pageObjects.AdminPage;
import pageObjects.DashboardPage;
import pageObjects.LoginPage;

public class TC021_AddUserTest extends BaseClass {

	@Test
	public void verifyAddUser() throws InterruptedException {

		logger.info("TC020_VerifyAddUserPage starts");
		LoginPage loginPage = new LoginPage(driver);
		logger.info("Entering login details");
		loginPage.login(config.getUsername(), config.getPassword());
		logger.info("Login Successful");

		DashboardPage dashboardPage = new DashboardPage(driver);
		logger.info("click on admin button drom menu");
		dashboardPage.clickAdmin();

		AdminPage adminPage = new AdminPage(driver);
		logger.info("click on add button");
		adminPage.clickAddButton();

		AddUserPage addUserPage = new AddUserPage(driver);
		logger.info("selecting user role");
		addUserPage.selectUserRole("Admin");
		logger.info("entering employee name");
		addUserPage.enterEmployeeName("Ra");
		logger.info("Selecting employee name from suggestion");
		addUserPage.selectEmployeeSuggestion();
		logger.info("Selecting Status as Enable");
		addUserPage.clickStatus();
		logger.info("Entering username");
		addUserPage.enterUserName();
		logger.info("Entering Password");
		addUserPage.enterPassword("User123");
		logger.info("Entering Confirm Password");
		addUserPage.enterConfirmPassword("User123");
		logger.info("Click Save Button");
		addUserPage.clickSaveBtn();
		
		
		logger.info("Assertion Start");
		Assert.assertTrue(adminPage.isSystemUsersPageDisplayed());
		logger.info("Assertion Ends");
		
		logger.info("TC020_VerifyAddUserPage Ends");
	}

}
