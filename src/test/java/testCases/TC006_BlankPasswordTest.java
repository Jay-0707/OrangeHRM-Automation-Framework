package testCases;

import org.testng.Assert;
import org.testng.annotations.Test;

import baseClass.BaseClass;
import pageObjects.LoginPage;

public class TC006_BlankPasswordTest extends BaseClass {

	@Test(groups = {"login","regression"})
	public void verifyBlankPassword() {
		logger.info("TC006_BlankPasswordTest start...");
		LoginPage loginPage = new LoginPage(driver);

		logger.info("Entering Username Only");
		loginPage.enterUsername(config.getUsername());
		loginPage.clickLogin();

		logger.info("Asserion Satrt");
		Assert.assertEquals(loginPage.getPasswordRequiredMessage(), "Required");
		logger.info("Asserion End");
		logger.info("TC006_BlankPasswordTest Ends...");
	}

}
