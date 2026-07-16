package testCases;

import org.testng.Assert;
import org.testng.annotations.Test;

import baseClass.BaseClass;
import pageObjects.ForgotPasswordPage;
import pageObjects.LoginPage;

public class TC008_ForgotPasswordLinkTest extends BaseClass {

	@Test(groups = {"login","regression"})
	public void verifyForgotPage() {
		LoginPage loginPage = new LoginPage(driver);
		loginPage.clickForgotPassword();
		
		ForgotPasswordPage forgotPasswordPage = new ForgotPasswordPage(driver);
		forgotPasswordPage.enterUsername(config.getUsername());
		forgotPasswordPage.clickResetPassword();
		Assert.assertTrue(forgotPasswordPage.isForgotPasswordPageDisplayed());
		
		Assert.assertEquals(forgotPasswordPage.getResetPasswordNotSentMessage(),"Please contact your administrator to reset your password.");
	}

}
