package employePack;

import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.remote.RemoteWebDriver;
import org.testng.annotations.Test;

import io.github.bonigarcia.wdm.WebDriverManager;

public class Test1 {
	
	@Test
	public void launchBrowser() throws Exception
	{
		System.out.println("om gam ganapathi");
		//download browser driver software
		WebDriverManager.chromedriver().setup();
		//Open browser using that browser driver software
		RemoteWebDriver driver=new ChromeDriver();
		//launch site
		driver.get("http://www.google.co.in");
		//Wait for few seconds
		Thread.sleep(4000);
		System.out.println("running");
		//close the browser window
		driver.close();
	}

}
