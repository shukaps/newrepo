package com.shopping.qa.util;

import java.io.File;
import java.io.FileInputStream;
import java.io.IOException;

import org.apache.poi.ss.usermodel.Row;
import org.apache.poi.xssf.usermodel.XSSFSheet;
import org.apache.poi.xssf.usermodel.XSSFWorkbook;

public class demoexcel {

	public static void main(String[] args) throws IOException {
		// TODO Auto-generated method stub
		
		File f= new File("C:\\Users\\apoorva shukla\\eclipse-workspace\\FramworkDemoTest\\src\\main\\java\\com\\shopping\\qa\\testdata\\TestData.xlsx");
		FileInputStream ip = new FileInputStream(f);
		XSSFWorkbook wb=new XSSFWorkbook(ip);
		XSSFSheet sheet = wb.getSheetAt(0);
		int rowcount= sheet.getLastRowNum();
		System.out.println(rowcount);
		
		
		for(int i=1;i<=rowcount;i++) {
			Row row=sheet.getRow(i);
			for(int j=0;j<=row.getLastCellNum();j++) {
			
			System.out.println(row.getCell(j).getStringCellValue());
		}
			System.out.println("");

	}

}
}
