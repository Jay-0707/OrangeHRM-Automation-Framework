package pageObjects;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

import utilities.WaitUtility;

public class EditUserInfoPage extends BasePage {

	public EditUserInfoPage(WebDriver driver) {
		super(driver);
	}

	@FindBy(xpath = "//label[normalize-space()='Status']/following::div[@class=\"oxd-select-text oxd-select-text--active\"]")
	private WebElement drpStatus;

	@FindBy(xpath = "//div[@class='oxd-grid-item oxd-grid-item--gutters']//div[3]")
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
		waitUtility.waitForElementClickable(btnDisabled);
		btnDisabled.click();
	}
	
	public void clickSaveBtn() {
		WaitUtility waitUtility = new WaitUtility(driver);
		waitUtility.waitForElementClickable(btnSave);
		btnSave.click();
	}
}
