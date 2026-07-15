package pageObjects;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

import utilities.WaitUtility;

public class ForgotPasswordPage extends BasePage {

	public ForgotPasswordPage(WebDriver driver) {
		super(driver);
	}

	@FindBy(xpath = "//h6[contains(@class,'orangehrm-forgot-password-title')]")
	private WebElement resetPasswordHeading;

	@FindBy(xpath = "//input[@name='username']")
	private WebElement txtUsername;

	@FindBy(xpath = "//button[contains(@class,'oxd-button oxd-button--large oxd-button--secondary')]")
	private WebElement btnResetPassword;

	@FindBy(xpath = "//h6[text()=\"Reset password link was not sent\"]")
	private WebElement resetPasswordNotSentHeading;

	@FindBy(xpath = "//p[text()=\"Please contact your administrator to reset your password.\"]")
	private WebElement resetPasswordMessage;

	public boolean isForgotPasswordPageDisplayed() {
		return resetPasswordHeading.isDisplayed();
	}

	public void enterUsername(String username) {
		txtUsername.sendKeys(username);
	}

	public void clickResetPassword() {
		btnResetPassword.click();
	}

	public void resetPassword(String username) {
		enterUsername(username);
		clickResetPassword();
	}

	public boolean isResetPasswordNotSentDisplayed() {

		WaitUtility waitUtility = new WaitUtility(driver);
		waitUtility.waitForElementVisible(resetPasswordNotSentHeading);
		return resetPasswordNotSentHeading.isDisplayed();
	}
	
	public String getResetPasswordNotSentMessage()
	{
		return resetPasswordMessage.getText();
	}
}
