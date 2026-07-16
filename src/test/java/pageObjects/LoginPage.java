package pageObjects;

import java.time.Duration;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

public class LoginPage extends BasePage {

	public LoginPage(WebDriver driver) {
		super(driver);
	}

	@FindBy(name = "username")
	private WebElement txtUsername;

	@FindBy(name = "password")
	private WebElement txtPassword;

	@FindBy(xpath = "//button[@type='submit']")
	private WebElement btnLogin;

	@FindBy(xpath = "//p[contains(@class,'oxd-alert-content-text')]")
	private WebElement errorMessage;

	@FindBy(xpath = "//span[contains(@class,'oxd-input-field-error-message')][1]")
	private WebElement usernameRequiredMessage;

	@FindBy(xpath = "//input[@name='password']/ancestor::div[contains(@class,'oxd-input-group')]//span[contains(@class,'oxd-input-field-error-message')]")
	private WebElement passwordRequiredMessage;

	@FindBy(xpath = "//p[contains(@class,'orangehrm-login-forgot-header')]")
	private WebElement forgotPasswordLink;

	public void enterUsername(String username) {
		txtUsername.sendKeys(username);
	}

	public void enterPassword(String password) {
		txtPassword.sendKeys(password);
	}

	public void clickLogin() {
		btnLogin.click();
	}

	public String getErrorMessage() {

		WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(10));

		WebElement error = wait.until(ExpectedConditions.visibilityOf(errorMessage));

		return error.getText();
	}

	public String getUsernameRequiredMessage() {
		return usernameRequiredMessage.getText();
	}

	public String getPasswordRequiredMessage() {
		return passwordRequiredMessage.getText();
	}

	public void login(String username, String password) {
		enterUsername(username);
		enterPassword(password);
		clickLogin();
	}

	public void clickForgotPassword() {
		forgotPasswordLink.click();
	}

	public boolean isLoginButtonDisplayed() {
		return btnLogin.isDisplayed();
	}

}
