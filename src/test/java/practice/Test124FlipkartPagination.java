package practice;

import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.remote.RemoteWebDriver;

import io.github.bonigarcia.wdm.WebDriverManager;

public class Test124FlipkartPagination {
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
		int pagecount=1;
		//start pagenation
		while(true)
		{
			//goto next page if exists by clicking on Next link
			try 
			{
				driver.findElement(By.xpath("//span[text()='Next']")).click();
				Thread.sleep(2000);
				pagecount++;
			}
			catch(Exception e)
			{
				System.out.println(e.getMessage());
				break;//terminate from current loop
			}
		}
		System.out.println("total pages : " +pagecount);
		
	}

}
