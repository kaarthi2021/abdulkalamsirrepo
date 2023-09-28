package practice;

import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.remote.RemoteWebDriver;

import io.github.bonigarcia.wdm.WebDriverManager;

public class Test24 {

	public static void main(String[] args) throws Exception {
		WebDriverManager.chromedriver().setup();
		RemoteWebDriver driver=new ChromeDriver();
		driver.get("https://www.w3schools.com/html/tryit.asp?filename=tryhtml_form_submit");
		Thread.sleep(5000);
		//switch to frame using name
		driver.switchTo().frame("jdsbkbdkjzb");
		//"NoSuchFrameException" for wrong index/id/name/xpath
		//Exception in thread "main" org.openqa.selenium.NoSuchFrameException:
         //No frame element found by name or id jdsbkbdkjzb;

	}

}
