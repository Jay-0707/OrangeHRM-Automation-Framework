package testCases;

import org.testng.Assert;
import org.testng.annotations.Test;

import baseClass.BaseClass;
import pageObjects.LoginPage;

public class TC005_BlankUsernameTest extends BaseClass {

	@Test(groups = {"login","regression"})
	public void verifyBlankUsername() {
		LoginPage loginPage = new LoginPage(driver);

		loginPage.enterPassword(config.getPassword());
		loginPage.clickLogin();

		Assert.assertEquals(loginPage.getUsernameRequiredMessage(), "Required");
	}

}
