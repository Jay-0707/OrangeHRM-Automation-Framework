package testCases;

import org.testng.Assert;
import org.testng.annotations.Test;

import baseClass.BaseClass;
import pageObjects.LoginPage;

public class TC006_BlankPasswordTest extends BaseClass {

	@Test(groups = {"login","regression"})
	public void verifyBlankPassword() {
		LoginPage loginPage = new LoginPage(driver);

		loginPage.enterUsername(config.getUsername());
		loginPage.clickLogin();

		Assert.assertEquals(loginPage.getPasswordRequiredMessage(), "Required");
	}

}
