package com.testng.testcases;

import java.io.File;
import java.io.FileInputStream;

import org.apache.poi.xssf.usermodel.XSSFSheet;
import org.apache.poi.xssf.usermodel.XSSFWorkbook;

public class ExcelUtil {
	
	public static XSSFWorkbook wb;
	public static XSSFSheet sheet;
	
	public static void excelDataConfig(String filename){
		try{
			File excelfile = new File(filename);
			FileInputStream fis =new FileInputStream(excelfile);
			wb=new XSSFWorkbook(fis);
		}catch(Exception e){
			System.out.println(e.getMessage());
			
		}
	}
	
	public static int getRows(int sheetindex){
		
		int rows = wb.getSheetAt(sheetindex).getLastRowNum();
		
		rows=rows+1;
		
		
		return rows;
		}
	
	public static String getData(int sheetnumber,int row,int column){
		sheet=wb.getSheetAt(sheetnumber);
		String data =sheet.getRow(row).getCell(column).getStringCellValue();
		return data;
		
	}
	

}
