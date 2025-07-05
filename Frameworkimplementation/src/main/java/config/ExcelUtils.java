package config;

import java.io.FileInputStream;
import java.io.IOException;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import org.apache.poi.ss.usermodel.*;
import org.apache.poi.xssf.usermodel.XSSFWorkbook;


public class ExcelUtils {
	
	
	public static Map<String, List<Map<String, String>>> readExcelData(String filePath) throws IOException {
		
		
		Map<String, List<Map<String, String>>> exceldata = new HashMap<>();
		
		FileInputStream fis = new FileInputStream(filePath);

		Workbook workbook = new XSSFWorkbook(fis);
		
		for (Sheet sheet : workbook) {
			
			String sheetName = sheet.getSheetName();
			List<Map<String, String>> sheetData = new ArrayList<>();

			
			
		}
		


		
		return null;
		
		
		
	
	}

}
