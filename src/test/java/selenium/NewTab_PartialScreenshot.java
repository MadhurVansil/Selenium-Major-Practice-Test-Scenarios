package selenium;

import java.io.File;
import java.io.IOException;
import java.util.Iterator;
import java.util.Set;

import org.apache.commons.io.FileUtils;
import org.openqa.selenium.By;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.WindowType;
import org.openqa.selenium.chrome.ChromeDriver;

public class NewTab_PartialScreenshot {

	public static void main(String[] args) throws IOException {
		// TODO Auto-generated method stub

		
		WebDriver driver=new ChromeDriver();
		
		driver.get("https://rahulshettyacademy.com/angularpractice/");
		
		driver.switchTo().newWindow(WindowType.TAB);
		
		Set<String> windows = driver.getWindowHandles();
		
		Iterator<String> it = windows.iterator();
		
		String parentID = it.next();
		
		String childID = it.next();
		
		driver.switchTo().window(childID);
		
		driver.get("https://rahulshettyacademy.com/");
		
		String courseName = driver.findElements(By.cssSelector("div[class*='grid sm:grid-cols-2 lg:grid-cols-3 xl:grid-cols-5 gap-6 md:gap-4 mb-12'] div div:nth-child(2) h3")).get(1).getText();
		
		driver.switchTo().window(parentID);
		
		WebElement nameEditBox = driver.findElement(By.cssSelector("input[name='name']"));
	    driver.findElement(By.cssSelector("input[name='name']")).sendKeys(courseName);
	    
	    File src = nameEditBox.getScreenshotAs(OutputType.FILE);
	    
	    // FileUtils.copyFile(src, new File ("C:\\Users\\Admin\\Downloads\\Selenium Screenshots\\partial_screenshot.png"));
	    
	    FileUtils.copyFile(src, new File ("partial_screenshot.png"));
		
		
		
	}

}
