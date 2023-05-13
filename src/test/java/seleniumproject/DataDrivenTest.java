package seleniumproject;

import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;

import org.apache.poi.xssf.usermodel.XSSFCell;
import org.apache.poi.xssf.usermodel.XSSFRow;
import org.apache.poi.xssf.usermodel.XSSFSheet;
import org.apache.poi.xssf.usermodel.XSSFWorkbook;
//File---Workbook---sheet--row--cells
public class DataDrivenTest {

	public static void main(String[] args) throws IOException {
		
		//FileInputStream file =new FileInputStream("C:\\Users\\User\\eclipse-workspace\\seleniumproject\\testdata\\Book1.xlsx");
		FileInputStream file =new FileInputStream(System.getProperty("user.dir")+"\\testdata\\Book1.xlsx");
		
		XSSFWorkbook workbook =new XSSFWorkbook(file);
		
	XSSFSheet sheet=workbook.getSheet("Sheet1");
	       
	  int totalRow =  sheet.getLastRowNum();
	int totalcells=  sheet.getRow(1).getLastCellNum();
	
	System.out.println("total number of rows:"+totalRow);//5 rows are counting from 0
	System.out.println("Total umber of colums:"+totalcells);//4 coulums are counting from 1
	
	
	for(int r=0;r<=totalRow;r++) {
		XSSFRow currentRow= sheet.getRow(r);
		
		for(int c=0;c<totalcells;c++) {
		XSSFCell cell=	currentRow.getCell(c);
			String  value=cell.toString();
			System.out.print(value+ "       ");
		}
		System.out.println();
	}
		
		workbook.close();
		file.close();

	}

}
