package testCases;

import org.testng.Assert;
import org.testng.annotations.Test;

import baseClass.BaseClass;
import pageObjects.LoginPage;

public class TC007_BlankUsernameAndPasswordTest extends BaseClass {

	@Test(groups = {"login","regression"})
	public void verifyBlankUsernameAndPassword() {
		logger.info("TC007_BlankUsernameAndPasswordTest start...");
		LoginPage loginpage = new LoginPage(driver);
		logger.info("Click on logion button without entering username and password");
		loginpage.clickLogin();

		logger.info("Asserion Satrt");
		Assert.assertEquals(loginpage.getUsernameRequiredMessage(), "Required");
		Assert.assertEquals(loginpage.getPasswordRequiredMessage(), "Required");
		logger.info("Asserion End");
		logger.info("TC007_BlankUsernameAndPasswordTest Ends...");

	}
}
