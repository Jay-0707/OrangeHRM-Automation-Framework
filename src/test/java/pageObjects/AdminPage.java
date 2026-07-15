package pageObjects;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

import utilities.WaitUtility;

public class AdminPage extends BasePage {

	public AdminPage(WebDriver driver) {
		super(driver);
	}

	@FindBy(xpath = "//h5[text()='System Users']")
	private WebElement txtSystemUsersHeadline;

	@FindBy(xpath = "//button[normalize-space()='Add']")
	private WebElement btnAdd;

	@FindBy(xpath = "//label[text()='Username']/following::input[1]")
	private WebElement txtUsername;

	@FindBy(xpath = "//button[normalize-space()='Search']")
	private WebElement btnSearch;

	@FindBy(xpath = "//div[@class='orangehrm-paper-container']//button[2]")
	private WebElement btnEdit;

	@FindBy(xpath = "//div[@class='orangehrm-container']//button[1]")
	private WebElement btnDelete;
	
	@FindBy(xpath = "//button[normalize-space()='Yes, Delete']")
	private WebElement confirmBtnDelete;
	
	@FindBy(xpath = "//span[normalize-space()='No Records Found']")
	private WebElement noRecordFoudMessage;

	public boolean isSystemUsersPageDisplayed() {
		WaitUtility waitUtility = new WaitUtility(driver);
		waitUtility.waitForElementVisible(txtSystemUsersHeadline);
		return txtSystemUsersHeadline.isDisplayed();
	}

	public void clickAddButton() {
		WaitUtility waitUtility = new WaitUtility(driver);
		waitUtility.waitForElementClickable(btnAdd);
		btnAdd.click();
	}

	public void enterUsername(String username) {
		WaitUtility waitUtility = new WaitUtility(driver);
		waitUtility.waitForElementVisible(txtUsername);
		txtUsername.clear();
		txtUsername.sendKeys(username);

	}

	public void clickSearch() {
		WaitUtility waitUtility = new WaitUtility(driver);
		waitUtility.waitForElementClickable(btnSearch);

		btnSearch.click();
	}

	public void clickEditBtn() {
		WaitUtility waitUtility = new WaitUtility(driver);
		waitUtility.waitForElementClickable(btnEdit);
		btnEdit.click();
	}

	public boolean isUserPresent(String username) {

		return driver.findElements(By.xpath("//div[@class='oxd-table-card']//div[text()='" + username + "']")).size() > 0;
	}
	
	public void clickDeleteBtn() 
	{
		WaitUtility waitUtility = new WaitUtility(driver);
		waitUtility.waitForElementClickable(btnDelete);
		btnDelete.click();
	}
	
	public void clickConfirmDeleteBtn() 
	{
		WaitUtility waitUtility = new WaitUtility(driver);
		waitUtility.waitForElementClickable(confirmBtnDelete);
		confirmBtnDelete.click();
	}
	
	public boolean isNoRecordFoundMessageDisplayed()
	{
		WaitUtility waitUtility = new WaitUtility(driver);
		waitUtility.waitForElementVisible(noRecordFoudMessage);
		return noRecordFoudMessage.isDisplayed();
	}
	
}
