package pageObjects;

import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

import utilities.WaitUtility;

public class EmployeeDetailsPage extends BasePage {

	public EmployeeDetailsPage(WebDriver driver) {
		super(driver);
	}

	@FindBy(xpath = "//h6[normalize-space()='Personal Details']")
	private WebElement personalDetailsHeading;

	@FindBy(xpath = "//label[text()='Employee Id']/following::input[1]")
	private WebElement txtEmployeeId;

	@FindBy(xpath = "//button[i[contains(@class,'bi-pencil-fill')]]")
	private WebElement btnEdit;

	@FindBy(xpath = "(//label[contains(text(),'Other Id')]/following::input[1])")
	private WebElement txtOtherId;

	@FindBy(xpath = "//div[@class='orangehrm-horizontal-padding orangehrm-vertical-padding']//button[@type='submit'][normalize-space()='Save']")
	private WebElement btnSave;

	public boolean isPersonalDetailsPageDisplayed() {
		WaitUtility waitUtility = new WaitUtility(driver);
		waitUtility.waitForElementVisible(personalDetailsHeading);

		return personalDetailsHeading.isDisplayed();
	}

	public String getEmployeeId() {

	    WaitUtility waitUtility = new WaitUtility(driver);
	    waitUtility.waitForElementVisible(txtEmployeeId);

	    while (txtEmployeeId.getAttribute("value").trim().isEmpty()) {
			// wait until Employee ID is populated
	    }

	    return txtEmployeeId.getAttribute("value").trim();
	}

	public void clickEdit() {
		driver.navigate().refresh();

		WaitUtility waitUtility = new WaitUtility(driver);
		waitUtility.waitForElementClickable(btnEdit);

		((JavascriptExecutor) driver).executeScript("arguments[0].click();", btnEdit);

	}

	public void eneterOtherID(String otherId) {
		txtOtherId.clear();
		txtOtherId.sendKeys(otherId);
	}

	public void clickSave() {
		WaitUtility waitUtility = new WaitUtility(driver);
		waitUtility.waitForElementClickable(btnSave);

		((JavascriptExecutor) driver).executeScript("arguments[0].scrollIntoView(true);", btnSave);

		((JavascriptExecutor) driver).executeScript("arguments[0].click();", btnSave);
	}

	public void editOtherId(String OtherId) {
		clickEdit();
		eneterOtherID(OtherId);
		clickSave();
	}

	public String getOtherId() {
		return txtOtherId.getAttribute("value");
	}

}
