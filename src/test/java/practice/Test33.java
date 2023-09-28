package practice;

import org.openqa.selenium.Alert;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.remote.RemoteWebDriver;

import io.github.bonigarcia.wdm.WebDriverManager;

public class Test33 {
	

	public static void main(String[] args) throws Exception
	{
		/*
		 * WebDriverManager.chromedriver().setup(); RemoteWebDriver driver=new
		 * ChromeDriver(); driver.get(
		 * "https://www.javatpoint.com/oprweb/test.jsp?filename=javascript-alert1");
		 * Thread.sleep(4000); driver.switchTo().frame("iframewrapper");
		 * driver.findElement(By.xpath("//input[@value='Click me']"));
		 * Thread.sleep(4000); String e=driver.switchTo().alert().getText();
		 * Thread.sleep(4000); System.out.println(e);
		 * driver.switchTo().alert().accept();
		 */

		//open "chrome" browser "chromedriver" software
				WebDriverManager.chromedriver().setup();
				RemoteWebDriver	driver=new ChromeDriver();
				//Launch site using URL
				driver.get(
				 "https://www.javatpoint.com/oprweb/test.jsp?filename=javascript-alert1");
				Thread.sleep(5000);
				//switch to frame
				driver.switchTo().frame("iframewrapper"); 
				//Click on a button to get a web alert
				driver.findElement(By.xpath("//input[@value='Click me']")).click();
				Thread.sleep(10000);
				//switch to alert
				Alert al=driver.switchTo().alert();
				String x=al.getText();
				System.out.println(x);
				al.dismiss();
				//back to page
				driver.switchTo().defaultContent(); 
				//close site
				driver.close();
	}

}
