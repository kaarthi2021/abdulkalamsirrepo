package practice;

import org.openqa.selenium.By;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.remote.RemoteWebDriver;

import io.github.bonigarcia.wdm.WebDriverManager;

public class Test19 {
	/*
	 * shadow element-->if the element is in shadow tag xpath does not support to
	 * locate an element we should use other static locators with getShadowRoot()
	 */

	public static void main(String[] args) throws InterruptedException {
		WebDriverManager.chromedriver().setup();
		RemoteWebDriver driver=new ChromeDriver();
		driver.get("chrome://settings/");
		driver.findElement(By.tagName("settings-ui")).getShadowRoot()
		.findElement(By.id("toolbar")).getShadowRoot()
		.findElement(By.id("search")).getShadowRoot()
		.findElement(By.id("searchInput")).sendKeys("nageswar");
		Thread.sleep(5000);
		driver.quit();
		
	}

}
