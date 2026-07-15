package testCases;

import org.testng.Assert;
import org.testng.annotations.Test;

import baseClass.BaseClass;
import pageObjects.DashboardPage;
import pageObjects.LoginPage;
import utilities.TestData;

public class TC004_LoginDataProviderTest extends BaseClass {

	@Test(dataProvider = "loginData", dataProviderClass = TestData.class)
	public void verifyLogin(String username, String password, String expectedResult) {

		logger.info("TC004_LoginDataProviderTest Start...");
		LoginPage loginPage = new LoginPage(driver);
		logger.info("Passing username and password from excel file...");
		loginPage.login(username, password);

		logger.info("...");
		if (expectedResult.equals("Pass")) {
			DashboardPage dashboardPage = new DashboardPage(driver);
			Assert.assertTrue(dashboardPage.isDashboardDisplayed());
		}

		else {
			Assert.assertEquals(loginPage.getErrorMessage(), "Invalid credentials");
		}
		logger.info("TC004_LoginDataProviderTest End...");
	}

}
