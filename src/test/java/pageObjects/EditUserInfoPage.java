package pageObjects;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

import utilities.WaitUtility;

public class EditUserInfoPage extends BasePage {

	public EditUserInfoPage(WebDriver driver) {
		super(driver);
	}

	@FindBy(xpath = "//label[text()='Status']/ancestor::div[contains(@class,'oxd-input-group')]//div[contains(@class,'oxd-select-text')]")
	private WebElement drpStatus;

	@FindBy(xpath = "//div[@role='option']//span[text()='Disabled']")
	private WebElement btnDisabled;

	@FindBy(xpath = "//button[@type=\"submit\"]")
	private WebElement btnSave;

	public void clickStatusDropDown() {
		WaitUtility waitUtility = new WaitUtility(driver);
		waitUtility.waitForElementClickable(drpStatus);
		drpStatus.click();
	}

	public void selectDisableStatusOption() {

	    WaitUtility waitUtility = new WaitUtility(driver);

	    waitUtility.waitForElementVisible(btnDisabled);
	    waitUtility.waitForElementClickable(btnDisabled);

	    btnDisabled.click();
	}

	public void clickSaveBtn() {
		WaitUtility waitUtility = new WaitUtility(driver);
		waitUtility.waitForElementClickable(btnSave);
		btnSave.click();
	}
}
