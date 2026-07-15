package pageObjects;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

import utilities.TestData;
import utilities.WaitUtility;

public class AddUserPage extends BasePage {

	public AddUserPage(WebDriver driver) {
		super(driver);
	}

	@FindBy(xpath = "//h6[normalize-space()='Add User']")
	private WebElement txtAddUser;

	@FindBy(xpath = "//label[text()='User Role']/following::div[contains(@class,'oxd-select-text')][1]")
	private WebElement drpUserRole;

	@FindBy(xpath = "//input[@placeholder='Type for hints...']")
	private WebElement txtEmployeeName;

	@FindBy(xpath = "//div[@role='listbox']")
	private WebElement suggestionList;

	@FindBy(xpath = "//div[@role='listbox']//div[2]")
	private WebElement selectFromSuggestion;

	@FindBy(xpath = "//label[text()='Status']/following::div[contains(@class,'oxd-select-text')][1]")
	private WebElement selectStatus;

	@FindBy(xpath = "//div[@role='listbox']//div[2]")
	private WebElement selectStatusEnable;

	@FindBy(xpath = "//label[text()='Username']/following::input[1]")
	private WebElement txtUsername;

	@FindBy(xpath = "//label[text()='Password']/following::input[@type='password'][1]")
	private WebElement txtPassword;

	@FindBy(xpath = "//label[text()='Confirm Password']/following::input[@type='password'][1]")
	private WebElement txtConfirmPassword;

	@FindBy(xpath = "//button[@type=\"submit\"]")
	private WebElement btnSave;

	public boolean isAddUserPageDisplayed() {
		WaitUtility waitUtility = new WaitUtility(driver);
		waitUtility.waitForElementVisible(txtAddUser);
		return txtAddUser.isDisplayed();
	}

	public void clickUserRole() {
		WaitUtility waitUtility = new WaitUtility(driver);
		waitUtility.waitForElementClickable(drpUserRole);
		drpUserRole.click();
	}

	public void selectUserRole(String role) {
		clickUserRole();
		WebElement option = driver.findElement(By.xpath("//div[@role='option'][normalize-space()='" + role + "']"));
		option.click();
	}

	public void enterEmployeeName(String employeeName) {
		txtEmployeeName.sendKeys(employeeName);
	}

	public void selectEmployeeSuggestion() {

		WaitUtility waitUtility = new WaitUtility(driver);
		waitUtility.waitForElementVisible(suggestionList);

		waitUtility.waitForElementVisible(selectFromSuggestion);
		selectFromSuggestion.click();
	}

	public void clickStatus() {
		selectStatus.click();
		WaitUtility waitUtility = new WaitUtility(driver);
		waitUtility.waitForElementClickable(selectStatusEnable);
		selectStatusEnable.click();
	}

	public String generateUsername() {
		TestData.username = "user" + System.currentTimeMillis();
		return TestData.username;
	}

	public void enterUserName() {
		txtUsername.sendKeys(generateUsername());
	}

	public void enterPassword(String password) {
		txtPassword.sendKeys(password);
	}

	public void enterConfirmPassword(String password) {
		txtConfirmPassword.sendKeys(password);
	}

	public void clickSaveBtn() {
		WaitUtility waitUtility = new WaitUtility(driver);
		waitUtility.waitForElementClickable(btnSave);
		btnSave.click();
	}
}
