package Apache_POI;

import java.io.FileInputStream;
import java.io.IOException;

import org.apache.poi.ss.usermodel.Workbook;
import org.apache.poi.ss.usermodel.WorkbookFactory;
import org.apache.poi.xssf.usermodel.XSSFSheet;

public class ReadDataFromProtectedExcel{

	public static void main(String[] args) throws IOException{
		FileInputStream file = new FileInputStream("./DataFile/Book.xlsx");
		
		Workbook workbook = WorkbookFactory.create(file, "udit@123");
		XSSFSheet sheet = (XSSFSheet) workbook.getSheetAt(0);
		
		int rowlen = sheet.getLastRowNum();
		int collen = sheet.getRow(0).getLastCellNum();
		
		System.out.println(rowlen);
		System.out.println(collen);
		
	}

}
