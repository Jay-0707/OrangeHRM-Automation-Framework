package pageObjects;

import java.time.Duration;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import utilities.WaitUtility;

public class PIMPage extends BasePage {

	public PIMPage(WebDriver driver) {
		super(driver);
	}

	@FindBy(xpath = "//h6[normalize-space()='PIM']")
	private WebElement pimHeading;

	@FindBy(xpath = "//button[normalize-space()='Add']")
	private WebElement btnAddEmployee;

	@FindBy(xpath = "//label[text()='Employee Name']/following::input[1]")
	private WebElement txtEmployeeName;

	@FindBy(xpath = "//label[text()='Employee Name']/following::input[2]")
	private WebElement txtEmployeeId;

	@FindBy(xpath = "//button[@type='submit']")
	private WebElement btnSearch;

	@FindBy(xpath = "//button[@type='reset']")
	private WebElement btnReset;

	@FindBy(xpath = "//div[@class='orangehrm-container']")
	private WebElement searchResults;

	private By employeeFirstNameResult = By
			.xpath("//div[@class='orangehrm-container']//div[@class='oxd-table-body']//div[@role='cell'][3]");

	@FindBy(xpath = "//div[@role='rowgroup']//div[1]//div[1]//div[2]")
	private WebElement employeeIdResult;

	By btnDelete = By.xpath("//i[@class='oxd-icon bi-trash']/parent::button");

	@FindBy(xpath = "//button[normalize-space()='Yes, Delete']")
	private WebElement btnYesDelete;

	@FindBy(xpath = "//span[normalize-space()='No Records Found']")
	private WebElement txtNoRecordsFound;

	public boolean isPIMPageDisplayed() {
		WaitUtility waitUtility = new WaitUtility(driver);
		waitUtility.waitForElementVisible(pimHeading);

		return pimHeading.isDisplayed();
	}

	public void clickAddButton() {
		btnAddEmployee.click();
	}

	public void enterEmployeeName(String employeename) {
		txtEmployeeName.clear();
		txtEmployeeName.sendKeys(employeename);
	}

	public void enterEmployeeId(String employeeID) {
		WaitUtility waitUtility = new WaitUtility(driver);
		waitUtility.waitForElementVisible(txtEmployeeId);

		txtEmployeeId.clear();
		txtEmployeeId.sendKeys(employeeID);
	}

	public void clickSearch() {
		WaitUtility waitUtility = new WaitUtility(driver);
		waitUtility.waitForElementClickable(btnSearch);

		btnSearch.click();

		waitUtility.waitForElementVisible(searchResults);
	}

	public void searchEmployee(String employeename) {

		enterEmployeeName(employeename);
		clickSearch();
	}

	public void searchEmployeeByID(String employeeID) {
		enterEmployeeId(employeeID);
		clickSearch();
	}

	public boolean isSearchResultDisplayed() {
		WaitUtility waitUtility = new WaitUtility(driver);
		waitUtility.waitForElementVisible(searchResults);

		return searchResults.isDisplayed();
	}

	public String getEmployeeFirstNameFromResult() {

		WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(10));
		WebElement employeeName = wait.until(ExpectedConditions.visibilityOfElementLocated(employeeFirstNameResult));
		return employeeName.getText().trim();
	}

	public String getEmployeeIdFromResult() {
		WaitUtility waitUtility = new WaitUtility(driver);
		waitUtility.waitForElementVisible(employeeIdResult);

		return employeeIdResult.getText().trim();
	}

	public void clickDeleteEmployee() {
		WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(10));

		WebElement deleteBtn = wait.until(ExpectedConditions.elementToBeClickable(btnDelete));

		deleteBtn.click();
	}

	public void clickYesDelete() {
		WaitUtility waitUtility = new WaitUtility(driver);
		waitUtility.waitForElementClickable(btnYesDelete);
		btnYesDelete.click();
	}

	public boolean isNoRecordsFoundDisplayed() {
		WaitUtility waitUtility = new WaitUtility(driver);
		waitUtility.waitForElementVisible(txtNoRecordsFound);
		return txtNoRecordsFound.isDisplayed();
	}

	public void deleteEmployee() {
		clickDeleteEmployee();
		clickYesDelete();

	}

	public void clickReset() {
		btnReset.click();
	}

	public String getEmployeeName() {
		return txtEmployeeName.getAttribute("value");
	}

	public String getEmployeeId() {
		return txtEmployeeId.getAttribute("value");
	}
}
