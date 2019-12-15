package com.qa.Hubspot.util;

import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import org.apache.poi.openxml4j.exceptions.InvalidFormatException;
import org.apache.poi.ss.usermodel.Sheet;
import org.apache.poi.ss.usermodel.Workbook;
import org.apache.poi.ss.usermodel.WorkbookFactory;

public class ExelUtil {
	public static Workbook book;
	public static Sheet sheet;
	public static String TESTDATA_SHEET_PATH="C:\\Users\\user\\eclipse-workspace\\yes-m system\\OctBatchPOMSeries\\src\\main\\java\\com\\qa\\Hubspot\\testdada\\HubspotTestData.xlsx";
	
	
	
	public static Object[][] getTestData(String sheetName) {
		
		try {
			FileInputStream ip=new 	FileInputStream(TESTDATA_SHEET_PATH) ;
			//WorkBook
			book=WorkbookFactory.create(ip);
			//Sheet
		    sheet=book.getSheet(sheetName);
		    //Read data---use 2d array
		    //row-get the last row number 
		    //column-getrow 0 and last column value
		    //column remain fixed row only changes whwn we add data
		    Object data[][] =new Object[sheet.getLastRowNum()][sheet.getRow(0).getLastCellNum()];
		    
		    for(int i=0;i<sheet.getLastRowNum();i++)
		    {
		    	for(int k=0;k<sheet.getRow(0).getLastCellNum();k++)
		    	{
		    	
				data[i][k]=sheet.getRow(i+1).getCell(k).toString();
		    	}
		    }
		    
		    
			return data;
		
			} catch (FileNotFoundException e) {
				e.printStackTrace();
			} catch (InvalidFormatException e) {
				e.printStackTrace();
			} catch (IOException e) {
				e.printStackTrace();
			
			}
		return null;
		
		
		
	
		
	}
	
	
	
	
	
	
	
	

}
