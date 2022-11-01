package Apache_POI;

import java.io.FileOutputStream;
import java.io.IOException;

import org.apache.poi.ss.usermodel.FillPatternType;
import org.apache.poi.ss.usermodel.IndexedColors;
import org.apache.poi.xssf.usermodel.XSSFCell;
import org.apache.poi.xssf.usermodel.XSSFCellStyle;
import org.apache.poi.xssf.usermodel.XSSFRow;
import org.apache.poi.xssf.usermodel.XSSFSheet;
import org.apache.poi.xssf.usermodel.XSSFWorkbook;

public class StylingOfCellInExcel {

	public static void main(String[] args) throws IOException {
		
		XSSFWorkbook workbook = new XSSFWorkbook();
		
		XSSFSheet sheet = workbook.createSheet("coloring");
		
		XSSFRow row = sheet.createRow(0);
		
		XSSFCellStyle style = workbook.createCellStyle();
		style.setFillBackgroundColor(IndexedColors.PINK.getIndex());
		style.setFillPattern(FillPatternType.SOLID_FOREGROUND);
		
		XSSFCell cell = row.createCell(0);
		
		cell.setCellValue("hello worlds");
		cell.setCellStyle(style);
		
		FileOutputStream file = new FileOutputStream("./DataFile/style.xlsx");
		workbook.write(file);
		workbook.close();
		file.close();
	}

}
