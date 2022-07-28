package Apache_POI;

import java.io.FileInputStream;
import java.io.IOException;
import java.util.Iterator;

import org.apache.poi.xssf.usermodel.XSSFCell;
import org.apache.poi.xssf.usermodel.XSSFRow;
import org.apache.poi.xssf.usermodel.XSSFSheet;
import org.apache.poi.xssf.usermodel.XSSFWorkbook;

public class ReadDataFromExcel {

	@SuppressWarnings("rawtypes")
	public static void main(String[] args) throws IOException {
		
		String filepath = "./DataFile/Book.xlsx";
		FileInputStream file = new FileInputStream(filepath);
		
		@SuppressWarnings("resource")
		XSSFWorkbook workbook = new XSSFWorkbook(file);
		
		XSSFSheet sheet = workbook.getSheetAt(0);
		
//		int rows = sheet.getLastRowNum();
//		int cols = sheet.getRow(1).getLastCellNum();
//		
//		for(int i=1; i<=rows; i++) {
//			XSSFRow row = sheet.getRow(i);
//			for(int j=0; j<cols; j++) {
//				XSSFCell cell = row.getCell(j);
//				System.out.print(cell.getStringCellValue()); 
//				System.out.print("  |  ");
//			}
//			System.out.println();
//		}
		
		
		Iterator it = sheet.iterator();
		
		while(it.hasNext()) {
			XSSFRow row = (XSSFRow)it.next();
			Iterator cellit = row.cellIterator();
			
			while(cellit.hasNext()) {
				XSSFCell cell = (XSSFCell) cellit.next();
				System.out.print(cell.getStringCellValue());
				System.out.print("  |  ");
			}
			System.out.println();
		}

	}

}
