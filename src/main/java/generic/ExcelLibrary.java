package generic;

import java.io.File;
import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.IOException;
import org.apache.poi.xssf.usermodel.*;

public class ExcelLibrary {
	/**
	 * Description : Get the data from Excel sheet using the passed parameters
	 * Author : Nandhini Mani
	 * Date Created : 21st July 2024
	 * @param sheetName
	 * @param rowNum
	 * @param cellNum
	 * @return
	 * @throws IOException
	 */
	public static String getExcelData(String sheetName, int rowNum, int cellNum) throws IOException {
		//Get the Test data file location
		File filepath = new File(Constants.testDataSheetLocation);
		FileInputStream fis = new FileInputStream(filepath);
		//Fetch the workbook using File input Stream
		XSSFWorkbook workbook = new XSSFWorkbook(fis);
		//Fetch the sheet using workbook
		XSSFSheet sheet = workbook.getSheet(sheetName);
		//Fetch the required row
		XSSFRow row = sheet.getRow(rowNum);
		//Fetch the required cell using row
		String data =row.getCell(cellNum).getStringCellValue();
		//Close the workbook
		workbook.close();
		return data;
		
	}
	
	/**
	 * Description : Set the data into Excel sheet using the cellNumber provided
	 * Author : Nandhini Mani
	 * Date Created : 21st July 2024
	 * @param sheetName
	 * @param rowNum
	 * @param cellNum
	 * @param data
	 * @throws IOException
	 */
	public static void setExcellData(String sheetName,int rowNum,int cellNum,String data)throws IOException{
		//Get the Test data file location
		File filepath = new File(Constants.testDataSheetLocation);
		FileInputStream fis = new FileInputStream(filepath);
		//Fetch the workbook using File input Stream
		XSSFWorkbook workbook = new XSSFWorkbook(fis);
		//Fetch the sheet using workbook
		XSSFSheet sheet = workbook.getSheet(sheetName);
		//Fetch the required row
		XSSFRow row = sheet.getRow(rowNum);
		//Create the cell or set the cell value
		XSSFCell cell = row.createCell(cellNum);
		cell.setCellValue(data);
		//Write in the Excell file
		FileOutputStream fos = new FileOutputStream(filepath);
		workbook.write(fos);
		
		//close the workbook
		workbook.close();
		
	}

}
