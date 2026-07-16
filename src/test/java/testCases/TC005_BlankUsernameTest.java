package testCases;

import org.testng.Assert;
import org.testng.annotations.Test;

import baseClass.BaseClass;
import pageObjects.LoginPage;

public class TC005_BlankUsernameTest extends BaseClass {

	@Test(groups = {"login","regression"})
	public void verifyBlankUsername() {
		logger.info("TC005_BlankUsernameTest start...");
		LoginPage loginPage = new LoginPage(driver);

		logger.info("Entering Password Only");
		loginPage.enterPassword(config.getPassword());
		loginPage.clickLogin();

		logger.info("Asserion Satrt");
		Assert.assertEquals(loginPage.getUsernameRequiredMessage(), "Required");
		logger.info("Asserion End");
		logger.info("TC005_BlankUsernameTest ends...");
	}

}
