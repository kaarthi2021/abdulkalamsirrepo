package practice;

import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.remote.RemoteWebDriver;
import org.testng.annotations.Test;

import io.github.bonigarcia.wdm.WebDriverManager;

public class Ttdsite {
	
	RemoteWebDriver driver;

	
	
		@Test(priority=1)
		public void downloadBrowserDrivers() throws Exception
		{
		WebDriverManager.chromedriver().setup();
		 driver= new ChromeDriver();
		// driver.get("https://www.tirumala.org/");
		 Thread.sleep(5000);
		// driver.close();
		}
		@Test(priority=2)
		public void LaunchBrowser() throws InterruptedException
		{
		driver.get("https://www.tirumala.org/");
		Thread.sleep(4000);
		}
		@Test(priority=3)
		public void getScrollinglMsg()
		{
		String x=driver.findElement(By.id("cph_Home_lblNewsMarquee")).getText();
		System.out.println(x);
		System.out.println("ready to close");
		driver.close();
		}
		

	

}
