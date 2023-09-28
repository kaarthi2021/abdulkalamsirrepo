package practice;

import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.remote.RemoteWebDriver;

import io.github.bonigarcia.wdm.WebDriverManager;

public class Test12 {

	public static void main(String[] args) throws InterruptedException {
		//open chrome browser
		WebDriverManager.chromedriver().setup();
		RemoteWebDriver driver=new ChromeDriver();
		//Launch site
		driver.get("http://www.facebook.com");//base URL
		Thread.sleep(5000);
		//get source code of the page
		String x=driver.getPageSource();
		System.out.println(x);
		//close sites
		driver.quit();
	}

}
