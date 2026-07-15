package testCases;

import org.testng.Assert;
import org.testng.annotations.Test;

import baseClass.BaseClass;
import pageObjects.AddUserPage;
import pageObjects.AdminPage;
import pageObjects.DashboardPage;
import pageObjects.LoginPage;

public class TC020_VerifyAddUserPage extends BaseClass{

	@Test
	public void VerifyAddUserPageIsDisplayed()
	{
		logger.info("TC020_VerifyAddUserPage starts");
		LoginPage loginPage= new LoginPage(driver);
		logger.info("Entering login details");
		loginPage.login(config.getUsername(),config.getPassword());
		logger.info("Login Successful");
		
		
		DashboardPage dashboardPage=new DashboardPage(driver);
		logger.info("click on admin button drom menu");
		dashboardPage.clickAdmin();
		
		AdminPage adminPage=new AdminPage(driver);
		logger.info("click on add button");
		adminPage.clickAddButton();
		
		AddUserPage addUserPage=new AddUserPage(driver);
		Assert.assertTrue(addUserPage.isAddUserPageDisplayed());
		logger.info("TC020_VerifyAddUserPage finish");
	}
	
}
