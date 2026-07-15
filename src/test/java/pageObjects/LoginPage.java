package pageObjects;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

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

	@FindBy(xpath = "//p[text()='Invalid credentials']")
	private WebElement errorMessage;

	@FindBy(xpath="//span[contains(@class,'oxd-input-field-error-message')][1]")
	private WebElement usernameRequiredMessage;
	
	@FindBy(xpath="//input[@name='password']/ancestor::div[contains(@class,'oxd-input-group')]//span[contains(@class,'oxd-input-field-error-message')]")
	private WebElement passwordRequiredMessage;
	
	@FindBy(xpath="//p[contains(@class,'orangehrm-login-forgot-header')]")
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
		return errorMessage.getText();
	}
	
	public String getUsernameRequiredMessage()
	{
		return usernameRequiredMessage.getText();
	}
	
	public String getPasswordRequiredMessage()
	{
		return passwordRequiredMessage.getText();
	}
	
	public void login(String username,String password)
	{
		enterUsername(username);
		enterPassword(password);
		clickLogin();
	}
	
	public void clickForgotPassword()
	{
		forgotPasswordLink.click();
	}
	
	public boolean isLoginButtonDisplayed()
	{
		return btnLogin.isDisplayed();
	}
	
}
