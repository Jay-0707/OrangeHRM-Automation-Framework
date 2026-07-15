package pageObjects;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

import utilities.WaitUtility;

public class DashboardPage extends BasePage {

	public DashboardPage(WebDriver driver) {
		super(driver);
	}

	@FindBy(xpath = "//h6[normalize-space()='Dashboard']")
	private WebElement dashboardHeading;

	@FindBy(xpath = "//p[@class='oxd-userdropdown-name']")
	private WebElement profileDropdown;

	@FindBy(xpath = "//a[@href=\"/web/index.php/auth/logout\"]")
	private WebElement logoutOption;

	@FindBy(xpath = "//span[normalize-space()='PIM']")
	private WebElement pimMenu;

	@FindBy(xpath="//span[text()='Admin']")
	private WebElement menuAdmin;
	
	public boolean isDashboardDisplayed() {
		WaitUtility webUtility = new WaitUtility(driver);
		webUtility.waitForElementVisible(dashboardHeading);

		return dashboardHeading.isDisplayed();
	}

	public void clickProfileDropdown() {
		profileDropdown.click();
	}

	public void clickLogout() {
		logoutOption.click();
	}

	public void logout() {
		clickProfileDropdown();
		clickLogout();
	}

	public void clickPIM() {
		WaitUtility waitUtility=new WaitUtility(driver); 
		waitUtility.waitForElementClickable(pimMenu);
		pimMenu.click();
	}
	
	public void clickAdmin()
	{
		WaitUtility waitUtility=new WaitUtility(driver);
		waitUtility.waitForElementClickable(menuAdmin);
		
		menuAdmin.click();
	}
}
