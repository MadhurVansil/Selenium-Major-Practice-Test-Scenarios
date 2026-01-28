package selenium;

import org.openqa.selenium.chrome.ChromeDriver;

import java.util.Iterator;
import java.util.Set;

import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

public class Scope {

	public static void main(String[] args) {
		// TODO Auto-generated method stub

		
		WebDriver driver=new ChromeDriver();
		
		driver.get("https://rahulshettyacademy.com/AutomationPractice/");
		
		// 1. Give me the count of links on the page.
		
		System.out.println(driver.findElements(By.tagName("a")).size());
		
		// 2. Count of footer section-
		
		WebElement footerDriver = driver.findElement(By.id("gf-BIG"));
		
		System.out.println(footerDriver.findElements(By.tagName("a")).size());
		
		// 3. Count footer links in first column 
		
		WebElement columnDriver = footerDriver.findElement(By.xpath("//table/tbody/tr/td[1]/ul"));
		
		System.out.println(columnDriver.findElements(By.tagName("a")).size());
		
		// 4.  click on each link in the coloumn and check if the pages are opening-
		
       String clickonLinks = Keys.chord(Keys.CONTROL,Keys.ENTER);
       
       
		for(int i=0;i<columnDriver.findElements(By.tagName("a")).size();i++)
		{
			
			columnDriver.findElements(By.tagName("a")).get(i).sendKeys(clickonLinks);
		
		}
		
		    Set<String> abc = driver.getWindowHandles();
		    
		    Iterator<String> it = abc.iterator();
		    
		    while (it.hasNext())
		    
		    {
		    	
		    	driver.switchTo().window(it.next());
		    	
		    	System.out.println(driver.getTitle());
		    	
		    }
	}

}
