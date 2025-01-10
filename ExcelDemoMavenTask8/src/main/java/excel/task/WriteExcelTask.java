package excel.task;

import java.io.FileOutputStream;
import java.io.IOException;

import org.apache.poi.xssf.usermodel.*;

public class WriteExcelTask {

	public static void main(String[] args) throws IOException {
		// TODO Auto-generated method stub
		
		XSSFWorkbook workbook =new XSSFWorkbook();
		XSSFSheet sheet = workbook.createSheet("Sheet1");
		
		Object obj[][]= {{"Name", "Age", "Email"},{"John Doe", 30, "john@test.com"}, {"Jane Doe", 28, "john@test.com"}, {"Bob Smith", 35, "jacky@example.com"},{"Swapnil", 37, "swapnil@example.com"}};
		
		int rows=obj.length;
		int cols=obj[0].length;
		
		for(int r=0;r<rows;r++)
		{
			XSSFRow row=sheet.createRow(r);
			for(int c=0; c<cols;c++)
			{
				XSSFCell cell=row.createCell(c);
				Object value=obj[r][c];
				if(value instanceof String)
				cell.setCellValue((String)value);
				if(value instanceof Integer)
					cell.setCellValue((Integer)value);
				if(value instanceof Boolean)
					cell.setCellValue((Boolean)value);
				
				String filePath= ".\\resource\\EmpData1.xlsx";
				FileOutputStream outputStream =new FileOutputStream(filePath);
				workbook.write(outputStream);
				outputStream.close();
			}
		}
		System.out.println("File Written Successfully");
		
	
	}

	}


