package testCases;

import org.testng.Assert;
import org.testng.annotations.Test;

import baseClass.BaseClass;
import pageObjects.LoginPage;

public class TC007_BlankUsernameAndPasswordTest extends BaseClass {

	@Test(groups = {"login","regression"})
	public void verifyBlankUsernameAndPassword() {

		LoginPage loginpage = new LoginPage(driver);

		loginpage.clickLogin();

		Assert.assertEquals(loginpage.getUsernameRequiredMessage(), "Required");
		Assert.assertEquals(loginpage.getPasswordRequiredMessage(), "Required");

	}
}
