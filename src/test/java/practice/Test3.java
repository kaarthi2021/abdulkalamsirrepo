package practice;

import org.openqa.selenium.firefox.FirefoxDriver;

import io.github.bonigarcia.wdm.WebDriverManager;

public class Test3 {

	public static void main(String[] args) throws InterruptedException {
		//download gecko driver software
		WebDriverManager.firefoxdriver().setup();
		//Open browser using that browser driver software
		FirefoxDriver driver=new FirefoxDriver();
		//launch site
		driver.get("http://www.gmail.com");
		//Wait for few seconds
		Thread.sleep(4000);
		//Close the browser window
		driver.close();
		

	}

}
