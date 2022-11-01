package Apache_POI;

import java.io.FileInputStream;
import java.io.IOException;
import java.util.HashMap;
import java.util.Map;

import org.apache.poi.xssf.usermodel.XSSFSheet;
import org.apache.poi.xssf.usermodel.XSSFWorkbook;

public class ExcelToHashMap {

	@SuppressWarnings({ "resource", "rawtypes" })
	public static void main(String[] args) throws IOException {
		
		Map<String, String> data = new HashMap<>();
		
		FileInputStream file  = new FileInputStream("./DataFile/employee.xlsx");
		
		XSSFWorkbook workbook = new XSSFWorkbook(file);
		
		XSSFSheet sheet = workbook.getSheetAt(0);
		
		int rowlen = sheet.getLastRowNum();
		
		for(int r=0; r<=rowlen; r++) {
			
			String key = sheet.getRow(r).getCell(0).getStringCellValue();
			String value = sheet.getRow(r).getCell(1).getStringCellValue();
			
			data.put(key, value);
		}
		
		for(Map.Entry entry:data.entrySet()) {
			System.out.println("key = " + entry.getKey() +" and "+ "Value = "+ entry.getValue());
		}
		
	}

}
