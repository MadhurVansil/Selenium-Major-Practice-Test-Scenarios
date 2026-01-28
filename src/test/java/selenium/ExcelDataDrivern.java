package selenium;

import java.io.FileInputStream;
import java.io.IOException;
import java.util.ArrayList;
import java.util.Iterator;

import org.apache.poi.ss.usermodel.Cell;
import org.apache.poi.ss.usermodel.CellType;
import org.apache.poi.ss.usermodel.Row;
import org.apache.poi.ss.util.NumberToTextConverter;
import org.apache.poi.xssf.usermodel.XSSFSheet;
import org.apache.poi.xssf.usermodel.XSSFWorkbook;

public class ExcelDataDrivern {

	
	public ArrayList<String> getData() throws IOException
	{
		
		
		FileInputStream fis=new FileInputStream("C:\\Users\\Admin\\Downloads\\TestExcel.xlsx");
		XSSFWorkbook workbook=new XSSFWorkbook(fis);
		
		ArrayList<String> a=new ArrayList<String>();
		
		int count=workbook.getNumberOfSheets();
		
		for(int i=0;i<count;i++)
		{
			
			
			if(workbook.getSheetName(i).equalsIgnoreCase("testpractice"))
			{
				
				
				XSSFSheet sheet = workbook.getSheetAt(i);
				
				Iterator<Row> rows = sheet.iterator();
				
				Row firstRow = rows.next();
				
				Iterator<Cell> ce = firstRow.cellIterator();
				
				int k=0;
				int column=0;
				
				while(ce.hasNext())
					
				{
					
					
					Cell value = ce.next();
					if(value.getStringCellValue().equalsIgnoreCase("TestData"))
					{
						
						column=k;
						
					}
					k++;
					
					
				}
				
				while(rows.hasNext())
				{
					
					Row r = rows.next();
					
					
					
					
					
					if(r.getCell(column).getStringCellValue().equalsIgnoreCase("Purchase"))
					{
						
						Iterator<Cell> cv = r.cellIterator();
						
						while (cv.hasNext())
						{
							
							Cell c = cv.next();
							
							
							if(c.getCellType()==CellType.STRING)
							{
							
							a.add(c.getStringCellValue());
							
							
							
							}
							
							else
								
							{
								
								
								
							a.add(NumberToTextConverter.toText(c.getNumericCellValue()));
							
							}
						}
						
					}
					
				}
				
				
				
				
			}
			
			
		}
		return a;
		
	
		
		
		
		
		
		
	}
	
	
	
	
	
	public static void main(String[] args) throws IOException {
		// TODO Auto-generated method stub

		ExcelDataDrivern dd=new ExcelDataDrivern();
		
		ArrayList<String> data = dd.getData();
		
		System.out.println(data.get(0));
		
		System.out.println(data.get(1));
		
		System.out.println(data.get(2));

		// well done Madhur Vansil
		
	}

}
