package com.utils;

import java.io.FileInputStream;
import java.util.HashMap;

import org.apache.poi.ss.usermodel.DataFormatter;
import org.apache.poi.ss.usermodel.Sheet;
import org.apache.poi.ss.usermodel.Workbook;
import org.apache.poi.ss.usermodel.WorkbookFactory;

public class DataDriven {
 public static FileInputStream fis ;
 public static Workbook wb;
 public static Sheet sheet;
 public static int row;
 public static int cell;
	
	public static Object[][] getData(String filepath,String sheetName) throws Exception{
		fis = new FileInputStream(filepath);
		wb = WorkbookFactory.create(fis);
		sheet =wb.getSheet(sheetName);
		row = sheet.getLastRowNum();
		System.out.println("No of rows are:"+row);
		cell = sheet.getRow(0).getLastCellNum();
		System.out.println("No of  Cells are");
		Object[][] object = new Object[row][1];
		for(int i=1;i<=row;i++) {
			HashMap<String, String> hash = new HashMap<String, String>();
			for(int j=0;j<cell;j++) {
				DataFormatter format = new DataFormatter();
				String key = format.formatCellValue(sheet.getRow(0).getCell(j));
				String val = format.formatCellValue(sheet.getRow(i).getCell(j));
				hash.put(key, val);
				
			}
			object[i-1][0] = hash;
		}
		return object;
	
		
		
	}

}
