package practice;

import org.openqa.selenium.WebDriver;

import io.github.bonigarcia.wdm.WebDriverManager;

public class Test5 {

	public static void main(String[] args) throws InterruptedException {
		
		//open browser and close in one line of code
		WebDriver driver=WebDriverManager.chromedriver().create();
		Thread.sleep(5000);
		driver.get("http://www.google.co.in");
	}

}
