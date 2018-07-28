package com.app.tests;

import java.io.FileInputStream;
import java.io.FileNotFoundException;

import org.apache.poi.ss.usermodel.Cell;
import org.apache.poi.ss.usermodel.Row;
import org.apache.poi.ss.usermodel.Sheet;
import org.apache.poi.ss.usermodel.Workbook;
import org.apache.poi.ss.usermodel.WorkbookFactory;


public class ExcelRead {
	public static void main(String[] args) throws Exception {
		
		String filePath = "C:\\Users\\jakyp\\Desktop\\Employees.xlsx";
	//Open file and convert to a stream of data
		FileInputStream inStream = new FileInputStream(filePath);
	//Take the stream of data and use it as WorkBook
		Workbook workbook = WorkbookFactory.create(inStream);
	//Get the first worksheet from the workbook
		Sheet worksheet = workbook.getSheetAt(0);
	//go to first row
		Row row = worksheet.getRow(0);
	//go to first cell
		Cell cell = row.getCell(0);
		
		System.out.println(cell.toString());
		
	//Find out how many rows in Excel sheet
		int rowsCount = worksheet.getPhysicalNumberOfRows();
		System.out.println("Row Count: " + rowsCount);
	//Print all first names:
		for (int i = 1; i < rowsCount; i++) {
			System.out.println("Row number: " + worksheet.getRow(i).getCell(0) );
		}
	//Print the Job ID of Nancy
		Cell NancyJob = worksheet.getRow(5).getCell(2);
			System.out.println(NancyJob);
		
		for (int i = 0; i < worksheet.getPhysicalNumberOfRows(); i++) {
			Row myrow = worksheet.getRow(i);
			if(myrow.getCell(0).toString().equals("Nancy")) {
				System.out.println("Nancy works as " + myrow.getCell(2).toString());
				break;
			}
		}
		
		
		
		
		
		workbook.close();
		inStream.close();
		
		
		
		
	}

}
