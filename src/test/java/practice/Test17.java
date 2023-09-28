package practice;

import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.remote.RemoteWebDriver;

import io.github.bonigarcia.wdm.WebDriverManager;

public class Test17 {

	public static void main(String[] args) throws InterruptedException {
		WebDriverManager.chromedriver().setup();
		RemoteWebDriver driver=new ChromeDriver();
		driver.get("http://www.gmail.com");
		driver.findElement(By.id("identifierId")).sendKeys("dsjknuhgzhsj");
		driver.findElement(By.xpath("//span[text()='Next']/parent::button")).click();
		Thread.sleep(5000);
		String x=driver.findElement(By.xpath("//span[@class='jibhHc']/parent::div")).getText();
	//String e=driver.findElement(By.xpath("//div[text()=\"Couldn’t find your Google Account\"]")).getText();
		System.out.println(x+"+");
		Thread.sleep(5000);
		
		driver.quit();

	}

}
