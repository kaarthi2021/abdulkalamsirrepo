package practice;

import java.awt.AWTException;
import java.awt.Robot;
import java.awt.Toolkit;
import java.awt.datatransfer.StringSelection;
import java.awt.event.KeyEvent;
import java.util.ArrayList;
import java.util.List;
import java.util.Set;

import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.WindowType;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.remote.RemoteWebDriver;

import io.github.bonigarcia.wdm.WebDriverManager;

public class Test42 {

	public static void main(String[] args) throws InterruptedException, AWTException {
		WebDriverManager.chromedriver().setup();
		RemoteWebDriver driver = new ChromeDriver();
		driver.get("https://app.fastmail.com/login/");
		System.out.println("hi");
		Thread.sleep(5000);
		driver.findElement(By.id("v18-input")).sendKeys("aswanimunagala@fastmail.com");
		Thread.sleep(3000);
		driver.findElement(By.id("v19-input")).sendKeys("Rkaarthi@2021");
		Thread.sleep(3000);
		driver.findElement(By.xpath("(//span[@class='label'])[2]")).click();
		Thread.sleep(3000);
		// driver.findElement(By.xpath("(//*[name()='svg'])[3]/following-sibling::span")).click();
		// driver.findElement(By.id("v137")).click();
		// driver.findElement(By.xpath("(//*[local-name()='svg'])[3]/following-sibling::span[1]")).sendKeys(Keys.ENTER);
		// driver.findElement(By.xpath("//span[contains(text(),'Compose')]")).click();
		driver.findElement(By.xpath("//a[contains(@class,'s-new-message v-Button')]")).click();
		Thread.sleep(5000);
		driver.findElement(By.xpath("(//textarea[@class='v-EmailInput-input'])[1]")).sendKeys("aswanimunagala@yahoo.com");
		// driver.findElement(By.xpath("(//div[contains(@class,'v-TextInput--standard')])[4]")).sendKeys("testmail
		// subject");
		Thread.sleep(4000);
		driver.findElement(By.id("v280-subject-input")).sendKeys("testmail subject");
		driver.findElement(By.xpath("//div[@aria-label='Body']")).sendKeys("hi\n testing textbody \n In fastmail");
		driver.findElement(By.id("v296")).click();
		Thread.sleep(3000);
		List<WebElement> l = driver.findElements(By.xpath("//div[@class='v-Menu']/descendant::ul"));
		int x = l.size();
		System.out.println(x);
		l.get(0).click();
		Thread.sleep(3000);
		//Automate file upload window(Java Robot)
		StringSelection ss=new StringSelection("D:\\brand identity bagpack 2.png");
		Thread.sleep(4000);
		Toolkit.getDefaultToolkit().getSystemClipboard().setContents(ss,null);
		System.out.println("ss");
		Thread.sleep(3000);
		Robot r=new Robot();
		if(System.getProperty("os.name").contains("Windows"))
		{
		r.keyPress(KeyEvent.VK_CONTROL);
		r.keyPress(KeyEvent.VK_V);
		r.keyRelease(KeyEvent.VK_V);
		r.keyRelease(KeyEvent.VK_CONTROL);
		Thread.sleep(10000);
		r.keyPress(KeyEvent.VK_ENTER);
		r.keyRelease(KeyEvent.VK_ENTER);
		Thread.sleep(5000);
		}
		driver.findElement(By.xpath("//button[contains(@class,'v-Button s-send v-Button')]")).click();	
		driver.switchTo().newWindow(WindowType.WINDOW);
		Set<String> s=driver.getWindowHandles();
		List<String> a=new ArrayList<String>(s);
		System.out.println(a.size());
		driver.switchTo().window(a.get(1));
		driver.get("http://www.yahoomail.com");
		driver.findElement(By.xpath("//a[text()='Sign in']")).click();
		driver.findElement(By.id("login-username")).sendKeys("aswanimunagala@yahoo.com");
		driver.findElement(By.id("login-signin")).click();
		driver.findElement(By.id("login-passwd")).sendKeys("@swani548");
		driver.findElement(By.id("login-signin")).click();

	}

}
