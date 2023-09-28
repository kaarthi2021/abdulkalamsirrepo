package practice;

import org.openqa.selenium.By;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.remote.RemoteWebDriver;

import io.github.bonigarcia.wdm.WebDriverManager;

public class Test25 {

	public static void main(String[] args) throws Exception {
		//Launch site , http://www.maths.surrey.ac.uk/explore/nigelspages/frame2.htm
		//Click on "Background" link in1st frame
		//Click on Close button in 2nd frame
		//Click on "TRY CODING" link in 3rd frame
		WebDriverManager.chromedriver().setup();
		RemoteWebDriver driver=new ChromeDriver();
		driver.get("http://www.maths.surrey.ac.uk/explore/nigelspages/frame2.htm");
		driver.switchTo().frame(0);
		Thread.sleep(5000);
		driver.findElement(By.partialLinkText("Background")).click();
		driver.switchTo().defaultContent();
		driver.switchTo().frame(1);
		driver.findElement(By.xpath("//input[@value='Close']")).click();
		Thread.sleep(5000);
		driver.switchTo().defaultContent();
		driver.switchTo().frame(2);
		driver.findElement(By.xpath("(//a[normalize-space()='TRY CODING'])[1]")).click();
		Thread.sleep(3000);
		driver.quit();

	}

}
