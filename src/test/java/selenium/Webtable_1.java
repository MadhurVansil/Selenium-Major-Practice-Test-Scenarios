package selenium;

import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.Assert;

import java.util.List;
import java.util.stream.Collectors;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

public class Webtable_1 {

	public static void main(String[] args) {
		// TODO Auto-generated method stub

		
		WebDriver driver=new ChromeDriver();
		
		driver.get("https://rahulshettyacademy.com/seleniumPractise/#/offers");
		
		driver.findElement(By.xpath("//tr/th[1]")).click();
		
		// capture all webelements into list
		
		
		List<WebElement> elementsList = driver.findElements(By.xpath("//tr/td[1]"));
		
		
		List<String> originalList = elementsList.stream().map(s->s.getText()).collect(Collectors.toList());
		
		List<String> filteredList = originalList.stream().sorted().collect(Collectors.toList());
		
		Assert.assertTrue(originalList.equals(filteredList));
		
		// scan the name column with getText ->Beans->print the price of the Beans
		
		List<String> priceList = elementsList.stream().filter(s->s.getText().contains("Beans")).map(s->priceveggie(s)).collect(Collectors.toList());
		
		priceList.forEach(s->System.out.println(s));
	}

	private static String priceveggie(WebElement s) {
		// TODO Auto-generated method stub
		String priceValue = s.findElement(By.xpath("following-sibling::td[1]")).getText();
		
		return priceValue;
	}

}
