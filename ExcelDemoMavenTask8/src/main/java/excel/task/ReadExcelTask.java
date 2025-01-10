package excel.task;

import java.io.FileInputStream;
import java.io.IOException;

import org.apache.poi.xssf.usermodel.XSSFCell;
import org.apache.poi.xssf.usermodel.XSSFRow;
import org.apache.poi.xssf.usermodel.XSSFSheet;
import org.apache.poi.xssf.usermodel.XSSFWorkbook;

public class ReadExcelTask {

	public static void main(String[] args) throws IOException {
		// TODO Auto-generated method stub
		String filepath=".\\resource\\EmpData1.xlsx";
		FileInputStream inputStream=new FileInputStream(filepath);
		XSSFWorkbook workbook=new XSSFWorkbook(inputStream);
		XSSFSheet sheet=workbook.getSheetAt(0);
		
		int rows=sheet.getPhysicalNumberOfRows();
		int cols=sheet.getRow(0).getLastCellNum();
		
		for(int r=0;r<rows;r++)
		{
			XSSFRow row=sheet.getRow(r);
			for(int c=0;c<cols;c++)
			{
				XSSFCell cell=row.getCell(c);
				switch(cell.getCellType())
				{
				case STRING : System.out.print(cell.getStringCellValue());break;
				case NUMERIC : System.out.print(cell.getNumericCellValue());break;
				case BOOLEAN : System.out.print(cell.getBooleanCellValue());break;
				}
				System.out.print("|");
			}
			System.out.println();
		}
	
		
	
		

	}

}

/*
 * Output: 2025-01-10T03:07:27.881Z main ERROR Log4j2 could not find a logging
 * implementation. Please add log4j-core to the classpath. Using SimpleLogger to
 * log to the console... Name|Age|Email| John Doe|30.0|john@test.com| Jane
 * Doe|28.0|john@test.com| Bob Smith|35.0|jacky@example.com|
 * Swapnil|37.0|swapnil@example.com|
 */
