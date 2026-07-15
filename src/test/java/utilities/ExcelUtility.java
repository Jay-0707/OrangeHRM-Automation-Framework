package utilities;

import java.io.FileInputStream;

import org.apache.poi.ss.usermodel.Sheet;
import org.apache.poi.ss.usermodel.Workbook;
import org.apache.poi.xssf.usermodel.XSSFWorkbook;

public class ExcelUtility {

	public Object[][] getExcelData(String filePath, String sheetName) throws Exception {

		FileInputStream fis = new FileInputStream(filePath);

		Workbook workbook = new XSSFWorkbook(fis);

		Sheet sheet = workbook.getSheet(sheetName);

		int totalRows = sheet.getLastRowNum();

		int totalColumns = sheet.getRow(0).getLastCellNum();

		Object[][] data = new Object[totalRows][totalColumns];

		for (int r = 1; r <= totalRows; r++) {
			for (int c = 0; c < totalColumns; c++) {
				data[r - 1][c] = sheet.getRow(r).getCell(c).toString();
			}
		}

		workbook.close();
		fis.close();

		return data;

	}

}
