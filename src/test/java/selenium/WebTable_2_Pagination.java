package selenium;

import java.util.List;
import java.util.stream.Collectors;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;

public class WebTable_2_Pagination {

	public static void main(String[] args) {
		// TODO Auto-generated method stub

        WebDriver driver=new ChromeDriver();
        
        List<String> price;
		
		driver.get("https://rahulshettyacademy.com/seleniumPractise/#/offers");
		
		driver.findElement(By.xpath("//tr/th[1]")).click();
		do
		{
		List<WebElement> rows = driver.findElements(By.xpath("//tr/td[1]"));
		
		 price = rows.stream().filter(s->s.getText().contains("Rice")).map(s->priceveggie(s)).collect(Collectors.toList());
		
		price.stream().forEach(s->System.out.println(s));
		
		if (price.size()<1)
			
		{
			
			driver.findElement(By.cssSelector("[aria-label='Next']")).click();
			
		}
		}while(price.size()<1);
		
	}

	private static String priceveggie(WebElement s) {
		// TODO Auto-generated method stub
       String priceValue = s.findElement(By.xpath("following-sibling::td[1]")).getText();
		
		return priceValue;
	}

}
