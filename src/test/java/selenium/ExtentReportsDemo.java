package selenium;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

import com.aventstack.extentreports.ExtentReports;
import com.aventstack.extentreports.ExtentTest;
import com.aventstack.extentreports.reporter.ExtentSparkReporter;



public class ExtentReportsDemo {

	ExtentReports extent;
	
	
	@BeforeMethod
	public void InitialDemo()
	{
		
		// Extent Reports , ExtentSparkReporter
		
		String path = System.getProperty("user.dir")+ "//reports//index.html";
		
		ExtentSparkReporter reporter=new ExtentSparkReporter(path);
		
		reporter.config().setReportName("Madhur Automation Results");
		
		reporter.config().setDocumentTitle("Future Automation Reports");
		
		 extent = new ExtentReports();
		
		extent.attachReporter(reporter);
		
		extent.setSystemInfo("Tester", "Madhur Vansil QA SDET Lead");
		
			
	}
	
	@Test
	public void testCase()
	{
		
		
		ExtentTest test = extent.createTest("Test Case 1 Report Demo");
		
		WebDriver driver=new ChromeDriver();
		
		driver.get("https://rahulshettyacademy.com/");
		
		System.out.println(driver.getTitle());
		
		extent.flush();
		
		
		
		
	}
	
	@Test
	public void testCase2()
	{
		
		
		ExtentTest test = extent.createTest("Test Case 1 Report Demo");
		
		WebDriver driver=new ChromeDriver();
		
		driver.get("https://rahulshettyacademy.com/");
		
		System.out.println(driver.getTitle());
		
		test.fail("Result is not correct ");
		
		extent.flush();
		
		
		
		
	}
}
