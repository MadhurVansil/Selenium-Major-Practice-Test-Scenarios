package selenium;

import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;

public class Dataprovider {

	
	
	@Test (dataProvider="getData")
	public void testCase(String Username,String password)
	{
		
		System.out.println("Test Case execute");
		
		System.out.println(Username);
		System.out.println(password);
		
		
	}
	
	
	@DataProvider
	public Object[][] getData()
	{
		
		Object[][]  data=new Object[3][2];
		
		data[0][0]="username 1";
		data[0][1]="password user 1";
		
		data[1][0]="username 2";
		data[1][1]="password user 2";
		
		data[2][0]="username 3";
		data[2][1]="password user 3";
		
		
		return data;
		
				
		
		
		
		
	}
}
