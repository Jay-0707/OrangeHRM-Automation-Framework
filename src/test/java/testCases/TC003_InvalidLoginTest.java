package testCases;

import org.testng.Assert;
import org.testng.annotations.Test;

import baseClass.BaseClass;
import pageObjects.LoginPage;

public class TC003_InvalidLoginTest extends BaseClass {

	@Test
	public void verifyInvalidLogin() {
		logger.info("TC003_InvalidLoginTest start...");
		String username = "Admin";
		String password = "Wrong123";

		LoginPage loginPage = new LoginPage(driver);

		logger.info("Passing Valid Username...");
		loginPage.enterUsername(username);
		logger.info("Passing Invalid Username...");
		loginPage.enterPassword(password);
		logger.info("Click on login button...");
		loginPage.clickLogin();

		String actualMessage = loginPage.getErrorMessage();

		logger.info("Verify error message...");
		Assert.assertEquals(actualMessage, "Invalid credentials");
		logger.info("Error message verified...");
		logger.info("TC003_InvalidLoginTest end...");

	}
}
