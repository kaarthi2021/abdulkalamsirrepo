package practice;

import org.openqa.selenium.By;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.remote.RemoteWebDriver;

import io.github.bonigarcia.wdm.WebDriverManager;

public class Test28 {

	public static void main(String[] args) throws Exception {
		//Open chrome browser
		WebDriverManager.chromedriver().setup();
		RemoteWebDriver driver=new ChromeDriver();
		//Launch site
		driver.get("https://chercher.tech/practice/frames");
		Thread.sleep(5000);
		//fill text box
		driver.switchTo().frame("frame1");  //1st frame in page
		driver.findElement(By.xpath("//b[@id='topic']/following-sibling::input[1]"))
		.sendKeys("Rayidi Kaarthika");
		Thread.sleep(3000);
		driver.switchTo().defaultContent();
		driver.close();
		
		

	}

}
