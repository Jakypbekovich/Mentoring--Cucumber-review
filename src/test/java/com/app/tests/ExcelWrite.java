package com.app.tests;

import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;

import org.apache.poi.ss.usermodel.Cell;
import org.apache.poi.ss.usermodel.Sheet;
import org.apache.poi.ss.usermodel.Workbook;
import org.apache.poi.ss.usermodel.WorkbookFactory;

public class ExcelWrite {
	public static void main(String[] args) throws Exception {
		String filePath = "./src/test/resources/testdata/Employees.xlsx";
		
		FileInputStream inStream = new FileInputStream(filePath);
		
		Workbook workbook = WorkbookFactory.create(inStream);
		Sheet worksheet = workbook.getSheet("Sheet1");
		
	//changing the cell value
		Cell job = worksheet.getRow(5).getCell(2);
		job.setCellValue("Automation Architect");
		
	//To save the changes
		FileOutputStream outStream = new FileOutputStream(filePath);
		workbook.write(outStream);
		
		
		outStream.close();
		workbook.close();
		inStream.close();
		
	}

}
