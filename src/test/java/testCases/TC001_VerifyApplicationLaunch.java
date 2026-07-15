package testCases;

import org.testng.Assert;
import org.testng.annotations.Test;

import baseClass.BaseClass;

public class TC001_VerifyApplicationLaunch extends BaseClass {

	@Test
	public void verifyApplicationLaunch() {
		logger.info("TC001_VerifyApplicationLaunch start...");
		logger.info("Getting Title...");
		String actualTitle = driver.getTitle();
		
		logger.info("Verify Title...");
		Assert.assertTrue(actualTitle.contains("OrangeHRM"));
		logger.info("Title Verified...");
		logger.info("TC001_VerifyApplicationLaunch end... ");
	}

}
