package selenium;

import java.time.Duration;
import java.util.Arrays;
import java.util.List;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

public class Addtocart {

	public static void main(String[] args) throws InterruptedException {
		// TODO Auto-generated method stub

		
		WebDriver driver=new ChromeDriver();
		
		driver.get("https://rahulshettyacademy.com/seleniumPractise/");
		
		int j=0;
		
		String[] itemsNeeded = {"Cucumber","Brocolli","Cauliflower","Tomato"};
		
		WebDriverWait w=new WebDriverWait(driver, Duration.ofSeconds(5));
		
		
		
		w.until(ExpectedConditions.visibilityOfAllElements(driver.findElements(By.cssSelector("h4.product-name"))));
		// Thread.sleep(3000);
		
		List<WebElement> products = driver.findElements(By.cssSelector("h4.product-name"));
		
		for(int i=0;i<products.size();i++)
		{
			String[] name = products.get(i).getText().split("-");
			
			String formattedName = name[0].trim();	
			
			List<String> itemsNeededList = Arrays.asList(itemsNeeded);
			
			if(itemsNeededList.contains(formattedName))
			{
				
				j++;
				driver.findElements(By.xpath("//div[@class='product-action']/button")).get(i).click();
				
				if(j==itemsNeeded.length)
				{
					
					break;
					
				}
				
				
			}
		}
		
		
		
		
		
		
		
	}

}
