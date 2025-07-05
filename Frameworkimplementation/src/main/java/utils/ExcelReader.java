package utils;

import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;

import org.apache.poi.ss.usermodel.Cell;
import org.apache.poi.ss.usermodel.DateUtil;
import org.apache.poi.ss.usermodel.Row;
import org.apache.poi.ss.usermodel.Sheet;
import org.apache.poi.ss.usermodel.Workbook;
import org.apache.poi.xssf.usermodel.XSSFWorkbook;

public class ExcelReader {

	static Workbook workbook;

	public static void excelReader(String filePath) {

		try {
			FileInputStream fis = new FileInputStream(filePath);
			workbook = new XSSFWorkbook(fis);

		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
		
	
	}

	public static void printSheetData(String sheetName) {

		Sheet sheet = workbook.getSheet(sheetName);

		if (sheet == null) {
			System.out.println("Sheet '" + sheetName + "' not found.");
			return;
		}

		for (Row row : sheet) {
			for (Cell cell : row) {
				// Convert each cell to string based on its type
				switch (cell.getCellType()) {
				case STRING:
					System.out.print(cell.getStringCellValue() + "\t");
					break;
				case NUMERIC:
					if (DateUtil.isCellDateFormatted(cell)) {
						System.out.print(cell.getDateCellValue() + "\t");
					} else {
						System.out.print(cell.getNumericCellValue() + "\t");
					}
					break;
				case BOOLEAN:
					System.out.print(cell.getBooleanCellValue() + "\t");
					break;
				case FORMULA:
					System.out.print(cell.getCellFormula() + "\t");
					break;
				case BLANK:
					System.out.print("[BLANK]\t");
					break;
				default:
					System.out.print("[UNKNOWN]\t");
				}
			}
			System.out.println(); // Move to next row

		}

	}
}
