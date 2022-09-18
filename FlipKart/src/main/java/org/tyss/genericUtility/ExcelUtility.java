package org.tyss.genericUtility;

import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;

import org.apache.poi.EncryptedDocumentException;
import org.apache.poi.ss.usermodel.DataFormatter;
import org.apache.poi.ss.usermodel.Sheet;
import org.apache.poi.ss.usermodel.Workbook;
import org.apache.poi.ss.usermodel.WorkbookFactory;

/*
 * This class contains reusable method for Excel
 * 
 */

public final class ExcelUtility {
	
	private Workbook workbook ;
	
	
	/**
	 * This method is used to initialize excel file
	 * @param excelPath
	 */
	public void initializeExcelFile(String excelPath)
	{
		FileInputStream fisExcel=null;
		try {
			fisExcel = new FileInputStream(excelPath);
		} catch (FileNotFoundException e) {
			e.printStackTrace();
		}
		try {
			workbook = WorkbookFactory.create(fisExcel);
		} catch (EncryptedDocumentException e) {
			
			e.printStackTrace();
		} catch (IOException e) {
			
			e.printStackTrace();
		}
	}
	/**
	 * This method is used to fetch the data from excel
	 * @param rowNumber
	 * @param cellNumber
	 * @param SheetName
	 */
	
	public String getDataFromExcel(int rowNumber,int cellNumber,String SheetName)
	{
		 Sheet sheet = workbook.getSheet(SheetName);
		 return new DataFormatter().formatCellValue(sheet.getRow(rowNumber).getCell(cellNumber));
	}
	/**
	 * This method is used to write the data to excel.
	 * @param sheetName
	 * @param rowNumber
	 * @param cellNumber
	 * @param value
	 */
	public void setDataInToExcel(String sheetName,int rowNumber,int cellNumber,String value)
	{
		Sheet sheet = workbook.getSheet(sheetName);
		sheet.getRow(rowNumber).createCell(cellNumber).setCellValue(value);
		System.out.println("Data entered");
	}
	/**
	 * This method is used to used to save the data in excel.
	 * @param excelSavePath
	 */
	public void saveDataIntoExcel(String excelSavePath)
	{
		FileOutputStream fosExcel=null;
		try {
			fosExcel = new FileOutputStream(excelSavePath);
		} catch (FileNotFoundException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		try {
			workbook.write(fosExcel);
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}
	/**
	 * This method is used to close the Excelbook
	 */
	public void closeWorkbook()
	{
		try {
			workbook.close();
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}
	

}
