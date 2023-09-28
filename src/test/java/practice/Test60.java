package practice;

import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.remote.RemoteWebDriver;

import Utilities.CarouselSliderUtility;
import io.github.bonigarcia.wdm.WebDriverManager;

public class Test60 {

	
		public static void main(String[] args) throws Exception
		{
			//Open browser
			WebDriverManager.chromedriver().setup();
			RemoteWebDriver driver=new ChromeDriver(); 
			driver.manage().window().maximize();
			//Launch site(amazon.in)
			driver.get("https://www.ebay.com");
			Thread.sleep(5000); 
			//Locate carousel slider
			WebElement slider=driver.findElement(By.className("carousel__list"));
			//apply test cases
			CarouselSliderUtility obj=new CarouselSliderUtility();
			System.out.println(obj.getCountOfSlides(slider));
			System.out.println(obj.getTypeOfSlider(slider));
			if(obj.areSlidesMovingAutomaticallyInSlider(slider))
			{
				System.out.println(obj.getMovingDirectionOfSlidesInSlider(slider));
			}
			else
			{
				System.out.println("Slides are not moving");
			}
			System.out.println("Each slide moving duration is "+obj.getSlideMoveDuration(slider));
			System.out.println(obj.getslideMovingStyle(slider));
			System.out.println("Delay between slides is "+obj.getDelayBetweenSlidesMove(slider));
			//close site
			driver.close();
		

	}

}
