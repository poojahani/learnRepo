package seleniumproject;

import java.io.FileOutputStream;
import java.io.IOException;

import org.apache.poi.xssf.usermodel.XSSFCell;
import org.apache.poi.xssf.usermodel.XSSFRow;
import org.apache.poi.xssf.usermodel.XSSFSheet;
import org.apache.poi.xssf.usermodel.XSSFWorkbook;

public class WritingData {

	public static void main(String[] args) throws IOException {
		// TODO Auto-generated method stub
		
		FileOutputStream file = new FileOutputStream(System.getProperty("user.dir")+"//testdata//myfile.xlsl");
		
		 XSSFWorkbook workbook =new XSSFWorkbook();
		 
		 XSSFSheet sheet =workbook.createSheet();
		 XSSFRow row = sheet.createRow(0);
	    row.createCell(1).setCellValue("welcome");
	    row.createCell(2).setCellValue("12345");
	     row.createCell(3).setCellValue("xyz");
	     XSSFRow row2 = sheet.createRow(1);
	     row2.createCell(1).setCellValue("abe");
	     row2.createCell(2).setCellValue("4567");
	     row2.createCell(3).setCellValue("testing");
	     
	     workbook.write(file);
	     workbook.close();
	     file.close();
	     System.out.println("writting is done!!");
	     
	     
		 

	}

}
