package DDD_dataDrivenDevelopment;

import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.IOException;

import org.apache.poi.ss.usermodel.CellStyle;
import org.apache.poi.ss.usermodel.DataFormatter;
import org.apache.poi.ss.usermodel.FillPatternType;
import org.apache.poi.ss.usermodel.IndexedColors;
import org.apache.poi.xssf.usermodel.XSSFCell;
import org.apache.poi.xssf.usermodel.XSSFRow;
import org.apache.poi.xssf.usermodel.XSSFSheet;
import org.apache.poi.xssf.usermodel.XSSFWorkbook;

public class DDD_utils {
	
	public FileInputStream fileInput;
	public FileOutputStream fileOut;
	public XSSFWorkbook workbook;
	public XSSFSheet sheet;
	public XSSFRow row;
	public XSSFCell cell;
	public CellStyle style;
	String path = null;
	
	public DDD_utils(String path) {
		this.path = path;
	}
	
	public int getRowsNumber() throws IOException{
		
		fileInput = new FileInputStream(path);
		workbook = new XSSFWorkbook(fileInput);
		//sheet = workbook.getSheet(sheet_name);
		sheet = workbook.getSheetAt(0);
		int rows = sheet.getLastRowNum();
		workbook.close();
		fileInput.close();
		
		return rows;
	}
	
	public int getCellsNumber(int row_number) throws IOException {
		
		fileInput = new FileInputStream(path);
		workbook = new XSSFWorkbook(fileInput);
		//sheet = workbook.getSheet(sheet_name);
		sheet = workbook.getSheetAt(0);
		row = sheet.getRow(row_number);
		int cells = row.getLastCellNum();
		workbook.close();
		fileInput.close();
		
		return cells;
	}
	
	public String getDataFromCell(int row_number, int cell_number) throws IOException {
		
		fileInput = new FileInputStream(path);
		workbook = new XSSFWorkbook(fileInput);
		//sheet = workbook.getSheet(sheet_name);
		sheet = workbook.getSheetAt(0);
		row = sheet.getRow(row_number);
		cell = row.getCell(cell_number);
		
		DataFormatter format =  new DataFormatter();
		String data;
		
		try {
			data = format.formatCellValue(cell);
		}catch(Exception e) {
			data = "";
		}
		
		workbook.close();
		fileInput.close();
		
		return data;
	}
	
	public String setDataToCell(int row_number, int cell_number, String data) throws IOException {
		
		fileInput = new FileInputStream(path);
		workbook = new XSSFWorkbook(fileInput);
		//sheet = workbook.getSheet(sheet_name);
		sheet = workbook.getSheetAt(0);
		row = sheet.getRow(row_number);
		cell = row.getCell(cell_number);
		
		cell.setCellValue(data);
		
		fileOut = new FileOutputStream(path);
		workbook.write(fileOut);
		
		workbook.close();
		fileInput.close();
		fileOut.close();
		
		return data;
	}
	
	public void fillGreenColor(int row_number, int cell_number) throws IOException{
		
		fileInput = new FileInputStream(path);
		workbook = new XSSFWorkbook(fileInput);
		//sheet = workbook.getSheet(sheet_name);
		sheet = workbook.getSheetAt(0);
		
		row = sheet.getRow(row_number);
		cell = row.getCell(cell_number);
		
		style = workbook.createCellStyle();
		style.setFillForegroundColor(IndexedColors.BRIGHT_GREEN.getIndex());
		style.setFillPattern(FillPatternType.SOLID_FOREGROUND);
		
		cell.setCellStyle(style);
		fileOut = new FileOutputStream(path);
		workbook.write(fileOut);
		workbook.close();
		fileInput.close();
		fileOut.close();
	}
	
	public void fillRedColor(int row_number, int cell_number) throws IOException{
		
		fileInput = new FileInputStream(path);
		workbook = new XSSFWorkbook(fileInput);
		//sheet = workbook.getSheet(sheet_name);
		sheet = workbook.getSheetAt(0);
		
		row = sheet.getRow(row_number);
		cell = row.getCell(cell_number);
		
		style = workbook.createCellStyle();
		style.setFillForegroundColor(IndexedColors.RED.getIndex());
		style.setFillPattern(FillPatternType.SOLID_FOREGROUND);
		
		cell.setCellStyle(style);
		fileOut = new FileOutputStream(path);
		workbook.write(fileOut);
		workbook.close();
		fileInput.close();
		fileOut.close();
	}
}
