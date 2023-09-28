package practice;

import java.util.List;

import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.remote.RemoteWebDriver;

import io.github.bonigarcia.wdm.WebDriverManager;

public class Test125PaginationBasedOnNumber {
	//click on next if available

	public static void main(String[] args) throws Exception {
		WebDriverManager.chromedriver().setup();
		RemoteWebDriver driver=new ChromeDriver();
		driver.manage().window().maximize();
		driver.get("https://www.flipkart.com/");
		//close if banner exists
		try
		{
			//here for close button used 2 locators as one syntax(sometimes spamrole is cming and sometimes //button tag is coming)
			driver.findElement(By.xpath("//button[@class='_2KpZ6l _2doB4z'] | //span[@role='button'] ")).click();	
			//driver.findElement(By.xpath("//span[@role='button']")).click();
			Thread.sleep(4000);
			System.out.println("Close Button Clicked");
		}
		catch(Exception e)
		{
			System.out.println(e.getMessage());
			System.out.println("No banner for this time");
		}
		//click on mobiles link
		driver.findElement(By.xpath("//span[text()='Mobiles']")).click();
		Thread.sleep(5000);
		//click on real me
		WebElement e1=driver.findElement(By.xpath("//p[text()='Realme']"));
		driver.executeScript("arguments[0].scrollIntiView", e1);
		e1.click();
		Thread.sleep(2000);
		int pagecount=2;
		
		//start pagenation
		while(true)
		{
			//step1:collect results in current page
			List <WebElement> reslist= driver.findElements(By.xpath("//a[contains(@class,'ge-49M')]"));
			//step 2:count results
			//System.out.println(count=count+reslist.size());
			//go to next page if exists by clicking on page number
				try 
				{
					
					driver.findElement(By.linkText(""+pagecount)).click();
					Thread.sleep(4000);
					pagecount++;
				}
				catch(Exception e)
				{
					System.out.println(e.getMessage());
					break;//terminate from current loop
				}
			//	System.out.println("total pages : " +count);
		}
		
		
	}

}
