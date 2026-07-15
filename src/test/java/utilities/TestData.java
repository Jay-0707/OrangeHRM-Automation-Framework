package utilities;

import org.testng.annotations.DataProvider;

public class TestData  {

	public static String username;
	
	@DataProvider(name = "loginData")
	public Object[][] loginTestData() throws Exception {

		ExcelUtility excelUtility = new ExcelUtility();

		return excelUtility.getExcelData("src/test/resources/testData/LoginData.xlsx", "Login");
	}
}
