package testCases;

import org.testng.annotations.Test;

import baseClass.BaseClass;
import pageObjects.ForgotPasswordPage;
import pageObjects.LoginPage;

public class TC009_ResetPasswordTest extends BaseClass{

	@Test(groups = {"login","regression"})
	public void verifyResetPassword()
	{
		LoginPage loginPage=new LoginPage(driver);
		loginPage.clickForgotPassword();
		
		ForgotPasswordPage forgotPasswordPage=new ForgotPasswordPage(driver);
		forgotPasswordPage.resetPassword(config.getUsername());
	}
	
}
