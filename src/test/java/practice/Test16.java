package practice;

import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.remote.RemoteWebDriver;

import io.github.bonigarcia.wdm.WebDriverManager;

public class Test16 {

	public static void main(String[] args) throws InterruptedException {
		
		//ElementNotInteractableException because element found in source code page but not visible in webpage
		//open chrome browser
				WebDriverManager.chromedriver().setup();
				RemoteWebDriver driver=new ChromeDriver();
				//Launch site
				driver.get("http://www.gmail.com"); //base url
				Thread.sleep(5000);
				/*
				 * WebElement ee=driver.findElement(By.xpath("//span[text()='Next']"));
				 * if(ee.isDisplayed()) { //3.Operate that element ee.click();
				 * System.out.println("ee element is clicked"); } else {
				 * System.out.println("ee element found in page source but not visible in page"
				 * ); }
				 */
				
				//1. locate an element in page source
				By b=By.name("hiddenPassword");
				WebElement e=driver.findElement(b);
				//2. Identify that element's visibility on page
				if(e.isDisplayed())
				{
					//3.Operate that element
					e.click();
				}
				else
				{
					System.out.println("element found in page source but not visible in page");
				}
				

	}

}
