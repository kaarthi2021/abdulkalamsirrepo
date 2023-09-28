package practice;

import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.remote.RemoteWebDriver;

import io.github.bonigarcia.wdm.WebDriverManager;

public class PaginationForGivenWordInGooglle {

	public static void main(String[] args) throws InterruptedException {
		String x="magnitia";
		//open chrome browser
		WebDriverManager.chromedriver().setup();
		RemoteWebDriver driver=new ChromeDriver();
		driver.manage().window().maximize();
		//open site
		driver.get("http://www.google.com");
		driver.findElement(By.name("q")).sendKeys(x,Keys.ENTER);
		Thread.sleep(4000);
		int pn=1;
		//pagination
		while(true)
		{
			//goto next page
		try {
			System.out.println("clicked");
			WebElement e=driver.findElement(By.xpath("//a[@aria-label='More results' or @id='pnnext']"));
			driver.executeScript("arguments[0].scrollIntoView()", e);
			e.click();
			//driver.findElement(By.xpath("//a[@aria-label='More results' or @id='pnnext']")).click();
			pn++;
			System.out.println("clicked1");
			Thread.sleep(4000);
			System.out.println("clicked");
			}
		catch(Exception e)
			{
			System.out.println("Not found More result");
			System.out.println(e.getMessage());
			break;//to terminate from the current loop 
			}
		}
		System.out.println("total pages count "+pn);
		//driver.quit();
	}
	

}
