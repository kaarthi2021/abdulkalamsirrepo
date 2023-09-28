package practice;

import java.util.Scanner;

import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.edge.EdgeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.remote.RemoteWebDriver;

import io.github.bonigarcia.wdm.WebDriverManager;

public class Test6 {

	public static void main(String[] args) {
	//open any browser--->Cross browser testing
		Scanner sc=new Scanner(System.in);
		System.out.println("Enter browser name");
		String bn=sc.nextLine();
		RemoteWebDriver driver=null;//defined initially as null
		if(bn.equals("chrome"))
		{
			WebDriverManager.chromedriver().setup();
			driver=new ChromeDriver();//Define using specific constructor w.r.t browser
			driver.get("http://www.google.co.in");
		}
		else if(bn.equals("firefox"))
		{
			WebDriverManager.firefoxdriver().setup();
			driver=new FirefoxDriver();//Define using specific constructor w.r.t browser
			driver.get("http://www.facebook.com/");
		}
		else if(bn.equals("edge"))
		{
			WebDriverManager.edgedriver().setup();
			driver=new EdgeDriver();//Define using specific constructor w.r.t browser
			driver.get("https://www.flipkart.com/");
		}
		else
		{
			System.out.println("please check your given browser name");
			System.exit(0);// 0 means forcibly stop this code
		}
		
	}

}
