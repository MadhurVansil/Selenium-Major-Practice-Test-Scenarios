package selenium;

import java.io.FileInputStream;
import java.io.IOException;

import org.apache.poi.ss.usermodel.DataFormatter;
import org.apache.poi.xssf.usermodel.XSSFCell;
import org.apache.poi.xssf.usermodel.XSSFRow;
import org.apache.poi.xssf.usermodel.XSSFSheet;
import org.apache.poi.xssf.usermodel.XSSFWorkbook;
import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;

public class ExcelDrivenTest {

	DataFormatter formatter=new DataFormatter();
	
	
	
	@Test (dataProvider="getData")
	public void testSampleDatatoTestCase(String data1,String data2,String data3,String data4)
	{
		
		
		System.out.println(data1 + data2 + data3 + data4);
		
		
	}
	
	
	
	
	
	@DataProvider 
    public Object[][] getData() throws IOException
    {
		
		FileInputStream fis=new FileInputStream("C:\\Users\\Admin\\Downloads\\TestExcel.xlsx");
		XSSFWorkbook workbook=new XSSFWorkbook(fis);
		
		XSSFSheet sheet = workbook.getSheetAt(0);
		
		int rowsCount = sheet.getPhysicalNumberOfRows();
		
		XSSFRow row = sheet.getRow(0);
		
		int colCount = row.getLastCellNum();
		
		Object[][] data=new Object[rowsCount-1][colCount];
		
		for(int i=0;i<rowsCount-1;i++)
		{
			
			row=sheet.getRow(i+1);
			
			for(int j=0;j<colCount;j++)
			{
				
				
				XSSFCell cell = row.getCell(j);
				
				data[i][j] = formatter.formatCellValue(cell);
				
				
			}
			
			
			
			
		}
		
		
		return data;
		
		
		
		
    }
}
