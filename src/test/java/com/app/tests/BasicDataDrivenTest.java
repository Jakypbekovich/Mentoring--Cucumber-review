package com.app.tests;

import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;
import java.text.DecimalFormat;
import java.time.LocalDateTime;
import java.util.concurrent.TimeUnit;

import org.apache.poi.ss.usermodel.Row;
import org.apache.poi.ss.usermodel.Sheet;
import org.apache.poi.ss.usermodel.Workbook;
import org.apache.poi.ss.usermodel.WorkbookFactory;
import org.openqa.selenium.WebDriver;
import org.testng.annotations.AfterClass;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Test;

import com.app.pages.GasMileageCalculatorPage;
import com.app.utilities.ConfigurationReader;
import com.app.utilities.Driver;

public class BasicDataDrivenTest {

	WebDriver driver;
	Workbook workbook;
	Sheet worksheet;
	GasMileageCalculatorPage page;
	FileInputStream inStream;
	FileOutputStream outStream;
	public static final int CURRENTOD_COLNUM = 1;
	public static final int PREVIOUSOD_COLNUM = 2;
	public static final int GAS_COLNUM = 3;

	@BeforeClass
	public void setUpa() throws Exception {
		inStream = new FileInputStream(ConfigurationReader.getProperty("gasmileage.testdata.path"));
		workbook = WorkbookFactory.create(inStream);
		worksheet = workbook.getSheetAt(0);
		driver = Driver.getDriver();
		driver.manage().timeouts().implicitlyWait(5, TimeUnit.SECONDS);
		driver.manage().window().maximize();
		driver.get("http://www.calculator.net/gas-mileage-calculator.html");
	}

	@Test
	public void dataDrivenMileageCalculatorTest() {

		for (int i = 1; i < worksheet.getPhysicalNumberOfRows(); i++) {

			Row currentRow = worksheet.getRow(i);
			
			//To check the control column. If it does not say Y, then skip this row
			if(!currentRow.getCell(0).toString().equalsIgnoreCase("Y")) {
				if(currentRow.getCell(6)==null) {
					currentRow.createCell(6);
				}
				currentRow.getCell(6).setCellValue("Skip Requested");
				continue;
			}
			double currentOr = currentRow.getCell(CURRENTOD_COLNUM).getNumericCellValue();
			double previousOr = currentRow.getCell(PREVIOUSOD_COLNUM).getNumericCellValue();
			double gas = currentRow.getCell(GAS_COLNUM).getNumericCellValue();

			page = new GasMileageCalculatorPage();
			page.currentOdometer.clear();
			page.currentOdometer.sendKeys(String.valueOf(currentOr));
			page.previousOdometer.clear();
			page.previousOdometer.sendKeys(String.valueOf(previousOr));
			page.gas.clear();
			page.gas.sendKeys(String.valueOf(gas));
			page.calculate.click();

			// Actual Result
			String[] result = page.result.getText().split(" ");
			System.out.println(result[0]);

			// Write Result in Actual Result column
			if (currentRow.getCell(5) == null)
				currentRow.createCell(5);
			currentRow.getCell(5).setCellValue(result[0]);

			double calculationResult = (currentOr - previousOr) / gas;
			DecimalFormat format = new DecimalFormat("##.00");
			System.out.println(format.format(calculationResult));

			if (currentRow.getCell(4) == null)
				currentRow.createCell(4);
			currentRow.getCell(4).setCellValue(format.format(calculationResult));
			
			if (currentRow.getCell(6) == null)
				currentRow.createCell(6);
			if (result[0].equals(format.format(calculationResult))) {
				System.out.println("Pass");
				currentRow.getCell(6).setCellValue("Pass");
			} else {
				System.out.println("Fail");
				currentRow.getCell(6).setCellValue("Fail");
			}
			if (currentRow.getCell(7) == null)
				currentRow.createCell(7);
			LocalDateTime time = LocalDateTime.now();
			currentRow.getCell(7).setCellValue(time.toString());

		}
	}

	
	
	
	
	@AfterClass
	public void tearDown() throws IOException {
		outStream = new FileOutputStream(ConfigurationReader.getProperty("gasmileage.testdata.path"));
		workbook.write(outStream);
		outStream.close();
		inStream.close();
		workbook.close();
		driver.close();

	}

}
