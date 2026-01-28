package selenium;

import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.IOException;
import java.time.Duration;
import java.util.Iterator;

import org.apache.poi.ss.usermodel.Cell;
import org.apache.poi.ss.usermodel.CellType;
import org.apache.poi.xssf.usermodel.XSSFCell;
import org.apache.poi.xssf.usermodel.XSSFRow;
import org.apache.poi.xssf.usermodel.XSSFSheet;
import org.apache.poi.xssf.usermodel.XSSFWorkbook;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.Assert;

public class UploadDownloadExcel {

	public static void main(String[] args) throws IOException {
		// TODO Auto-generated method stub

		String fruitName="Apple";
		
		String fileName="C:\\Users\\Admin\\Downloads\\download (15).xlsx";
		
		String updatedValue = "603";
		WebDriver driver=new ChromeDriver();
		driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(10));
		
		driver.get("https://rahulshettyacademy.com/upload-download-test/");
		
		//download excel
		
		driver.findElement(By.cssSelector("#downloadButton")).click();
		
	
		
		//Edit excel - getColumnNumber of Price -getRownumber of APple-> update excel with row,col
		int col =getColumnNumber(fileName,"price");
		int row = getRowNumber(fileName,"Apple");
		Assert.assertTrue(updateCell(fileName,row,col,updatedValue));

		
		
		
		//upload excel
		
		WebElement upload = driver.findElement(By.xpath("//input[@type='file']"));
		
		upload.sendKeys("C:\\Users\\Admin\\Downloads\\download (15).xlsx");
		
		//wait for message to appear
		
		WebDriverWait wait=new WebDriverWait(driver,Duration.ofSeconds(10));
		
		By toastMessage = By.cssSelector(".Toastify__toast-body div:nth-child(2)");
		
		wait.until(ExpectedConditions.visibilityOfAllElementsLocatedBy(toastMessage));
		
		String toastText = driver.findElement(toastMessage).getText();
		
		System.out.println(toastText);
		
		Assert.assertEquals(toastText, "Updated Excel Data Successfully.");
		
		//Assert.assertEquals("Updated Excel Data Successfully.", toastText);
		
		wait.until(ExpectedConditions.invisibilityOfElementLocated(toastMessage));
		
		
		//verify updated excel data showing in the web table 
		
		//div[text()='Apple']/parent::div/parent::div/div[@id='cell-4-undefined']
		
		
		String priceColumn = driver.findElement(By.xpath("//div[text()='Price']")).getAttribute("data-column-id");
		
		// ("//div[text()='"+fruitName+"']/parent::div/parent::div/div[@id='cell-"+priceColumn+"-undefined']"
		
		String actualPrice = driver.findElement(By.xpath("//div[text()='"+fruitName+"']/parent::div/parent::div/div[@id='cell-"+priceColumn+"-undefined']")).getText();
		
		System.out.println(actualPrice);
		
		Assert.assertEquals(updatedValue,actualPrice );
		
		
		
		
		
		
		
		
	}

	private static boolean updateCell(String fileName, int row, int col, String updatedValue) throws IOException {
		// TODO Auto-generated method stub
		
		FileInputStream fis=new FileInputStream(fileName);
        XSSFWorkbook workbook=new XSSFWorkbook(fis);
		
		XSSFSheet sheet = workbook.getSheetAt(0);
		XSSFRow rowField = sheet.getRow(row-1);
		
		XSSFCell cellField = rowField.getCell(col-1);
		
		cellField.setCellValue(updatedValue);
		FileOutputStream fos=new FileOutputStream(fileName);
		workbook.write(fos);
		workbook.close();
		fis.close();
		
		return true;
	
		
		
		
		
		
		
		
		
	}                    

	private static int getRowNumber(String fileName, String string) throws IOException {
		
		FileInputStream fis=new FileInputStream(fileName);
        XSSFWorkbook workbook=new XSSFWorkbook(fis);
		
		XSSFSheet sheet = workbook.getSheetAt(0);
		
	   int rows = sheet.getPhysicalNumberOfRows();
	   
	   int k=1;
	   int rowIndex=-1;
	   for(int i=0;i<rows;i++)
	   {
		   
		   XSSFRow rowc = sheet.getRow(i);
		   
		  Iterator<Cell> cr = rowc.cellIterator();
		  
		  
		  
		  while(cr.hasNext())
			  
		  {
			  
			 Cell cv = cr.next();
			 
			
			 
			 if(cv.getCellType()== CellType.STRING && cv.getStringCellValue().equalsIgnoreCase(string))
			 {
				 
				 rowIndex=k;
				 
				 
			 }
			 
			 
			 
			 
			 
			  
		  }
		   
		   k++;
		   
		   
	   }
	   
	   
	   
		
		
	   System.out.println(rowIndex);
		return rowIndex;
		
		
		
		
	}

	private static int getColumnNumber(String fileName, String colName) throws IOException {

		
		FileInputStream fis=new FileInputStream(fileName);
		
		XSSFWorkbook workbook=new XSSFWorkbook(fis);
		
		XSSFSheet sheet = workbook.getSheetAt(0);
		
		XSSFRow firstRow = sheet.getRow(0);
		
		Iterator<Cell> ce = firstRow.cellIterator();
		
		int k=1;
		int col=0;
		
		while(ce.hasNext())
		{
			
			Cell cellValue = ce.next();
			
			if(cellValue.getStringCellValue().equalsIgnoreCase(colName))
			{
				
				col=k;
				
			}
			
			k++;
			
		}
		
		System.out.println(col);
		
		return col;
		
	}

}
