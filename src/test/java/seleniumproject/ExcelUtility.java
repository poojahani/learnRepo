package seleniumproject;

import java.io.FileInputStream;
import java.io.FileNotFoundException;
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

public class ExcelUtility {
	public static FileInputStream fi;
	public static FileOutputStream fo;
	public static XSSFWorkbook wb;
	public static XSSFSheet ws;
	public static XSSFRow row;
	public static XSSFCell cell;
	public static CellStyle style;
	

public static int getRowCount(String xlfile,String xlSheet) throws IOException
{
	fi=new FileInputStream(xlfile);
	wb=new XSSFWorkbook(fi);
	ws=wb.getSheet(xlSheet);
	int rowcount=ws.getLastRowNum();
	wb.close();
	fi.close();
	return rowcount;
	
}
public static int getCellCount(String xlfile,String xlSheet,int rownum) throws IOException
{
	fi=new FileInputStream(xlfile);
	wb=new XSSFWorkbook(fi);
	ws=wb.getSheet(xlSheet);
	row =ws.getRow(rownum);
	int Cellcount =row.getLastCellNum();
	wb.close();
	fi.close();
	return Cellcount;
}

public static String getCellData(String xlfile,String xlSheet,int rownum,int colnum) throws IOException {
	fi=new FileInputStream(xlfile);
	wb=new XSSFWorkbook(fi);
	ws=wb.getSheet(xlSheet);
	row =ws.getRow(rownum);
	cell=row.getCell(colnum);
	
	String data;
	try {
		DataFormatter formatter = new DataFormatter();
		data =formatter.formatCellValue(cell);
		return data;
		
	}
	catch(Exception e){
		 data="";
	}
	wb.close();
	fi.close();
	return data;
	
	
	
}
public static void  setCellData(String xlfile,String xlSheet,int rownum,int colnum,String data) throws IOException {
	fi=new FileInputStream(xlfile);
	wb=new XSSFWorkbook(fi);
	ws=wb.getSheet(xlSheet);
	row =ws.getRow(rownum);
	cell=row.createCell(colnum);
	cell.setCellValue(data);
	fo=new FileOutputStream(xlfile);
	wb.close();
	fi.close();
	fo.close();
}
public static void fillGreenColor(String xlfile,String xlSheet,int rownum,int colnum ) throws IOException {
	fi=new FileInputStream(xlfile);
	wb=new XSSFWorkbook(fi);
	ws=wb.getSheet(xlSheet);
	row =ws.getRow(rownum);
	cell=row.getCell(colnum);
	style=wb.createCellStyle();
	style.setFillForegroundColor(IndexedColors.GREEN.getIndex());
	style.setFillPattern(FillPatternType.SOLID_FOREGROUND);
	
	cell.setCellStyle(style);
	fo=new FileOutputStream(xlfile);
	wb.write(fo);
	wb.close();
	fi.close();
	fo.close();
}
	public static void fillRedColor(String xlfile,String xlSheet,int rownum,int colnum) throws IOException {
		fi=new FileInputStream(xlfile);
		wb=new XSSFWorkbook(fi);
		ws=wb.getSheet(xlSheet);
		row =ws.getRow(rownum);
		cell=row.getCell(colnum);
		style=wb.createCellStyle();
		style.setFillForegroundColor(IndexedColors.RED.getIndex());
		style.setFillPattern(FillPatternType.SOLID_FOREGROUND);
		wb.close();
		fi.close();
		fo.close();
		
	}
	
}
