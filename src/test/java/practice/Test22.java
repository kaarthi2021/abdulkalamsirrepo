package practice;

import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.remote.RemoteWebDriver;

import io.github.bonigarcia.wdm.WebDriverManager;

public class Test22 {

	public static void main(String[] args) throws InterruptedException {
		//open chrome browser
		WebDriverManager.chromedriver().setup();
		RemoteWebDriver driver=new ChromeDriver();
		//Launch site
		driver.get("https://the-internet.herokuapp.com/iframe");
		Thread.sleep(5000);
		//get visible text
		driver.switchTo().frame(0);//frame index
		String x=driver.findElement(By.tagName("p")).getText();
		System.out.println(x);
		driver.switchTo().defaultContent();
		//close site
		driver.quit();

	}

}
