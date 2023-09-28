package practice;

import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.remote.RemoteWebDriver;

import io.github.bonigarcia.wdm.WebDriverManager;

public class Test9 {

	public static void main(String[] args) {
		//open chrome browser
		WebDriverManager.chromedriver().setup();
		RemoteWebDriver driver=new ChromeDriver();
		//launch site
		driver.get("http://www.gmail.com");
		 String x=driver.getTitle();
		 //get title of the opened page
		 System.out.println(x);
		 //close chrome browser
		 driver.quit();
		
		

	}

}
