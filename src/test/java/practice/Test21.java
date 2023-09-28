package practice;

import org.openqa.selenium.By;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.remote.RemoteWebDriver;

import io.github.bonigarcia.wdm.WebDriverManager;

public class Test21 {

	public static void main(String[] args) throws InterruptedException {
		//Open chrome browser
		WebDriverManager.chromedriver().setup();
		RemoteWebDriver driver=new ChromeDriver();
		//Launch site
		driver.get("https://www.w3schools.com/html/tryit.asp?filename=tryhtml_form_submit");
		//switch to frame by using frame id/name
		driver.switchTo().frame("iframeResult");
		//fill fields
		driver.findElement(By.name("fname")).clear();//to remove existing valu
		driver.findElement(By.name("fname")).sendKeys("Kaarthika");
		driver.findElement(By.name("lname")).clear();
		driver.findElement(By.name("lname")).sendKeys("Rayidi");
		driver.findElement(By.xpath("//input[@type='submit']")).click();
		Thread.sleep(3000);
		driver.switchTo().defaultContent(); //back to page
		//Close site
		driver.close();
	}

}
