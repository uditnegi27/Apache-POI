package Apache_POI;

 import java.io.FileOutputStream;
import java.io.IOException;

import org.apache.poi.xssf.usermodel.XSSFCell;
import org.apache.poi.xssf.usermodel.XSSFRow;
import org.apache.poi.xssf.usermodel.XSSFSheet;
import org.apache.poi.xssf.usermodel.XSSFWorkbook;

public class WriteDataToExcel {
	


	public static void main(String[] args) throws IOException {
		
		XSSFWorkbook workBook = new XSSFWorkbook();
		XSSFSheet sheet = workBook.createSheet("TeamData");
		
		Object info[][] = { {"ID", "NAME", "TITLE"}, {101, "Udit", "SDET"}, {102, "Ayush", "DEV"}, {103, "Naman", "DevOps"}}; 
		
		int rowLen = info.length;
		int colLen = info[0].length;
		
		System.out.println(rowLen);
		System.out.println(colLen);
		
		for(int i=0; i<rowLen; i++) {
			XSSFRow row = sheet.createRow(i);
			for(int j=0; j<colLen; j++) {
				XSSFCell cell = row.createCell(j);
				Object val = info[i][j];
				if(val instanceof String) {
					cell.setCellValue((String)val);
				}
				if(val instanceof Integer) {
					cell.setCellValue((Integer)val);
				}
			}
		}
		
		FileOutputStream file = new FileOutputStream("./DataFile/teamData.xlsx");
		workBook.write(file);
		workBook.close();
		file.close();
		

	}

}
