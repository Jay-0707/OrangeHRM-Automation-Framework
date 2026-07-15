package pageObjects;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import utilities.WaitUtility;

public class BasePage {

	protected WebDriver driver;

	public BasePage(WebDriver driver) {
		this.driver = driver;

		PageFactory.initElements(driver, this);
	}
	@FindBy(xpath = "//div[contains(@class,'oxd-toast-content')]//p[2]")
	protected  WebElement txtToastMessage;

	public String getToastMessage() {
	    WaitUtility waitUtility = new WaitUtility(driver);
	    waitUtility.waitForElementVisible(txtToastMessage);
	    return txtToastMessage.getText().trim();
	}
}
