package practice;

import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.remote.RemoteWebDriver;

import io.github.bonigarcia.wdm.WebDriverManager;

public class Test10 {

	public static void main(String[] args) throws InterruptedException {

		//download latest chrome driver and launch chrome browser 
		WebDriverManager.chromedriver().setup();
		RemoteWebDriver driver=new ChromeDriver();
		//launch base URL
		driver.get("http://www.amazon.com");
		Thread.sleep(5000);
		//get current URL of the page
		String x=driver.getCurrentUrl();
		System.out.println(x);
		if(x.startsWith("https"))
		{
			System.out.println("site is Secured");
		
		}
		else
		{
			System.out.println("site is not secured");
		}
		//close browser
		driver.close();
	}

}
