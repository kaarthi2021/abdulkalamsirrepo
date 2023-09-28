package practice;

import java.util.ArrayList;
import java.util.List;
import java.util.Set;

import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptException;
import org.openqa.selenium.SearchContext;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.remote.RemoteWebDriver;

import io.github.bonigarcia.wdm.WebDriverManager;

public class Test32 {

	public static void main(String[] args) throws InterruptedException {
		//Open chrome browser
				WebDriverManager.chromedriver().setup();
				RemoteWebDriver driver=new ChromeDriver();
				//Launch site
				driver.get("https://selectorshub.com/shadow-dom-in-iframe/");
				Thread.sleep(5000);
				//switch to frame
				driver.switchTo().frame("pact");
				//target Element is inside single shadow DOM
				WebElement shadowHostElement=driver.findElement(By.id("snacktime"));
				SearchContext shadowRootElement=shadowHostElement.getShadowRoot();
				WebElement targetElement=shadowRootElement.findElement(By.className("food"));
				try
		        {
		            targetElement.click();
		        }
		        catch(JavascriptException ex)
		        {
		            driver.executeScript("arguments[0].click();", targetElement);
		        }
		Thread.sleep(4000);
		Set<String> s=driver.getWindowHandles();
		List<String> l=new ArrayList<String>(s);
		Thread.sleep(4000);
		//after opened new window/tab for foodlink  go back to parent window
		driver.switchTo().window(l.get(0));
		Thread.sleep(4000);
		//then switch to again child window or 2nd window
		driver.switchTo().window(l.get(1));
		
	}

}
