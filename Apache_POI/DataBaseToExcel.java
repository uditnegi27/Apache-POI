package Apache_POI;

import java.io.FileOutputStream;
import java.io.IOException;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;

import org.apache.poi.xssf.usermodel.XSSFRow;
import org.apache.poi.xssf.usermodel.XSSFSheet;
import org.apache.poi.xssf.usermodel.XSSFWorkbook;


public class DataBaseToExcel {

	public static void main(String[] args) throws SQLException, IOException {
		
		Connection con = DriverManager.getConnection("jdbc:mysql://localhost:3306/mydb", "root", "Udit@@12");
		
		Statement statement = con.createStatement();
		
		ResultSet result = statement.executeQuery("SELECT * FROM country;");
		
		XSSFWorkbook workbook = new XSSFWorkbook();
		XSSFSheet sheet = workbook.createSheet("SQL");
		
		XSSFRow row = sheet.createRow(0);
		row.createCell(0).setCellValue("id");
		row.createCell(1).setCellValue("capital");
		row.createCell(2).setCellValue("country_name");
		
		int r = 1;
		
		while(result.next()) {
			int iD = result.getInt("id");
			String cap = result.getString("capital");
			String cou = result.getString("country_name");
			
			row = sheet.createRow(r++);
			
			row.createCell(0).setCellValue(iD);
			row.createCell(1).setCellValue(cap);
			row.createCell(2).setCellValue(cou);
		}
		
		FileOutputStream file = new FileOutputStream("./DataFile/sql.xlsx");
		workbook.write(file);
		workbook.close();
		file.close();
		
		System.out.println("DONE");

	}

}
