package practice;

import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.remote.RemoteWebDriver;

import Utilities.CarouselSliderUtility;
import io.github.bonigarcia.wdm.WebDriverManager;

public class ToyotaCar {

	public static void main(String[] args) throws Exception {
		
		//open browser
		WebDriverManager.chromedriver().setup();
		RemoteWebDriver driver=new ChromeDriver();
		//maximize window
		driver.manage().window().maximize();
		//launch site
		driver.get("https://www.toyota.com.br/");
		Thread.sleep(5000);
		//(//div[@style='transition:all 500ms ease-in-out;opacity:1']//div[contains(@class,'styles_carousel')])[1]
		WebElement slider=driver.findElement(
				By.xpath("(//div[@class='slick-track'])[1]"));
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
