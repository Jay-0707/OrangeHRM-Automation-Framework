package pageObjects;

import java.time.Duration;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

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

		WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(20));

		wait.until(ExpectedConditions.elementToBeClickable(btnSave));

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
