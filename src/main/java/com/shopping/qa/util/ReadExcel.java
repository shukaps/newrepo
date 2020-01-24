package com.shopping.qa.util;

import java.io.File;
import java.io.FileInputStream;
import java.io.IOException;

import org.apache.poi.xssf.usermodel.XSSFSheet;
import org.apache.poi.xssf.usermodel.XSSFWorkbook;

public class ReadExcel {
	
	
	XSSFWorkbook wb;
	XSSFSheet sheet1;
	
	public ReadExcel(String ExcelPath) {
		
		try {
		File src = new File(ExcelPath);
		FileInputStream ip = new FileInputStream(src);
		wb = new XSSFWorkbook(ip);
		}catch (Exception e) {
			System.out.println(e.getMessage());
		}
		
	}
	
	public String getDate(int SheetNumber, int row, int column) {
		sheet1 = wb.getSheetAt(SheetNumber);
		String data = sheet1.getRow(row).getCell(column).getStringCellValue();
		return data;
	}
	
	public int getrowcount(int sheetindex) {
		int row = wb.getSheetAt(sheetindex).getLastRowNum();
		
		return row;
		
		
	}
	
	public int getcolcount(int sheetindex) {
		int col = wb.getSheetAt(sheetindex).getRow(0).getLastCellNum();
		return col;
	}
	

}

