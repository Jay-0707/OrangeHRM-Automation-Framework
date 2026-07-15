package pageObjects;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

import utilities.WaitUtility;

public class AddEmployeePage extends BasePage {

	public AddEmployeePage(WebDriver driver) {
		super(driver);
	}

	@FindBy(xpath = "//input[@name=\"firstName\"]")
	private WebElement txtFirstName;

	@FindBy(xpath = "//input[@name=\"lastName\"]")
	private WebElement txtLastName;

	@FindBy(xpath = "//button[normalize-space()='Save']")
	private WebElement btnSave;

	public void enterFirstName(String firstname) {
		txtFirstName.sendKeys(firstname);
	}

	public void enterLastName(String lastname) {
		txtLastName.sendKeys(lastname);
	}

	public void clickSave() {

		WaitUtility waitUtility = new WaitUtility(driver);
		waitUtility.waitForElementClickable(btnSave);

		btnSave.click();

	}

	public void addEmployee(String firstname, String lastname) {
		enterFirstName(firstname);
		enterLastName(lastname);
		try {
			Thread.sleep(3000);
		} catch (Exception e) {
		}

		clickSave();
	}

}
