package pageObjects;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

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

	@FindBy(xpath = "//div[@class=\"orangehrm-container\"]//div[@class=\"oxd-table-body\"]//div[@role=\"cell\"][3]")
	private WebElement employeeFirstNameResult;

	@FindBy(xpath = "//div[@role='rowgroup']//div[1]//div[1]//div[2]")
	private WebElement employeeIdResult;

	@FindBy(xpath = "//i[@class='oxd-icon bi-trash']/parent::button")
	private WebElement btnDelete;

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
		txtEmployeeName.sendKeys(employeename);
	}

	public void enterEmployeeId(String employeeID) {
		txtEmployeeId.sendKeys(employeeID);
	}

	public void clickSearch() {
		btnSearch.click();
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
		WaitUtility waitUtility = new WaitUtility(driver);
		waitUtility.waitForElementVisible(employeeFirstNameResult);
		return employeeFirstNameResult.getText();
	}

	public String getEmployeeIdFromResult() {
		WaitUtility waitUtility = new WaitUtility(driver);
		waitUtility.waitForElementVisible(employeeIdResult);

		return employeeIdResult.getText();
	}

	public void clickDeleteEmployee() {
		WaitUtility waitUtility = new WaitUtility(driver);
		waitUtility.waitForElementClickable(btnDelete);
		btnDelete.click();
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
