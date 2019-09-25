package com.orangehrm.utils;

import java.io.FileInputStream;


import org.apache.poi.xssf.usermodel.XSSFSheet;
import org.apache.poi.xssf.usermodel.XSSFWorkbook;


public class ExcelUtility2 {
	
	public FileInputStream fis;
	public XSSFWorkbook wb;
	public XSSFSheet sheet;
	
	
	public void openExcel(String xlFilepath, String sheetName) {
		
		try {
			fis=new FileInputStream (xlFilepath);
			wb=new XSSFWorkbook(fis);
			sheet=wb.getSheet(sheetName);
		} catch (Exception e) {
			e.printStackTrace();
		
		}
	}
	
	
	public String getCellData(int rowIndex, int cellIndex) {
		
		return sheet.getRow(rowIndex).getCell(cellIndex).toString();
	}
		
	public int getRowNum() {
		
		return sheet.getPhysicalNumberOfRows();
	}

	public int getColNum(int rowIndex) {
		return sheet.getRow(rowIndex).getLastCellNum();
	}
	
	
}
