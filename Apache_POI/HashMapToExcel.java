package Apache_POI;

import java.io.FileOutputStream;
import java.io.IOException;
import java.util.HashMap;
import java.util.Map;

import org.apache.poi.xssf.usermodel.XSSFRow;
import org.apache.poi.xssf.usermodel.XSSFSheet;
import org.apache.poi.xssf.usermodel.XSSFWorkbook;

public class HashMapToExcel {

	@SuppressWarnings("rawtypes")
	public static void main(String[] args) throws IOException {
		
		XSSFWorkbook workbook = new XSSFWorkbook();
		XSSFSheet sheet = workbook.createSheet();
		
		Map<String, String> employee = new HashMap<String, String>();
		
		employee.put("101", "Udit");
		employee.put("102", "Sai");
		employee.put("103", "Pardh");
		employee.put("104", "Ayush");
		employee.put("105", "Vivek");
		employee.put("106", "Prateek");
		employee.put("107", "Anshu");
		
		int rowNo = 0;
		
		for(Map.Entry entry:employee.entrySet()) {
			
			XSSFRow row = sheet.createRow(rowNo++);
			
			row.createCell(0).setCellValue((String)entry.getKey());
			row.createCell(1).setCellValue((String)entry.getValue());
			
		}
		
		FileOutputStream file = new FileOutputStream("./DataFile/employee.xlsx");
		
		workbook.write(file);
		workbook.close();
		file.close();
		
		System.out.println("DOne....!!");
	}
	
	

}
