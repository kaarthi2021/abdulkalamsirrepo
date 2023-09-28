package practice;

import org.openqa.selenium.By;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.remote.RemoteWebDriver;
import org.testng.annotations.Test;

import io.github.bonigarcia.wdm.WebDriverManager;

public class Test20 {
	RemoteWebDriver driver;
	@Test
	public void m11() throws Exception
	{
		WebDriverManager.chromedriver().setup();
		driver=new ChromeDriver();
		driver.get("https://www.facebook.com/");
		driver.findElement(By.id("email")).sendKeys("asdjkkvx");
		driver.findElement(By.id("pass")).sendKeys("bsfjbkjhsfbj");
		Thread.sleep(3000);
		
		//driver.findElement(By.xpath("//*[@id='u_0_5_8A']")).click();
		driver.close();
	//	driver.findElement(By.name("login")).click();
	}	
	

//public static void main(String[] args) {
//}

}
