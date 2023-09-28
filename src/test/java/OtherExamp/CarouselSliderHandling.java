package OtherExamp;

import java.util.ArrayList;

import java.util.List;
import java.util.NoSuchElementException;
import java.util.stream.Collectors;

import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.interactions.Actions;

import io.github.bonigarcia.wdm.WebDriverManager;
/*Open Chrome/Firefox
Launch app : https://www.noon.com/uae-en/


Get the carousel items from:
 Recommended For You
 Sports shoes under 199 AED
 Top picks in laptops
 Limited time offers
 Bestselling fragrances

You need to create a generic function, this will take the sectionName(String) as an input parameter and will return the collection of all the carousel items text in sorted order only.

You need to keep clicking on the next arrow icon until its disappeared and keep fetching the text of each item in carousel.

Prepare a 3-5 mins of video of your solution and explain your code and show the demo. 
Please push your source code to GIT Repo and share with me at:
naveenanimation20@gmail.com*/


public class CarouselSliderHandling {
	
	

	 static WebDriver driver;
	    static final String NEXT_BUTTON = "//div[contains(@class, 'swiper-button-next custom-navigation swiper-nav')]";

	    public static void main(String[] args) throws InterruptedException {

	        String sec_RecommendedForYou = "//h3[text()='Recommended For You']";
	        String sec_TopPicks = "//h3[text()='Top picks in electronics']";
	        //*** Hardcoded the New arrivals section xpath ***//
	        String sec_NewArrivals = "//div[7]//h3[text()='New arrivals']";
	        String sec_SaveBigOnMobile = "//h3[contains(text(),'Save big on mobiles')]";

	        WebDriverManager.chromedriver().setup();
	        driver = new ChromeDriver();
	        driver.get("https://www.noon.com/uae-en/");
	        driver.manage().window().maximize();

	        System.out.println("Section : Recommended For You");
	        getAllProductNames(sec_RecommendedForYou).forEach(System.out::println);
	        System.out.println("-----------------------------------------------------------------");

	        System.out.println("Section : Top picks in electronics");
	        getAllProductNames(sec_TopPicks).forEach(System.out::println);
	        System.out.println("-----------------------------------------------------------------");

	        System.out.println("Section : New arrivals");
	        getAllProductNames(sec_NewArrivals).forEach(System.out::println);
	        System.out.println("-----------------------------------------------------------------");

	        System.out.println("Section : Save big on mobiles & tablets");
	        getAllProductNames(sec_SaveBigOnMobile).forEach(System.out::println);
	        System.out.println("-----------------------------------------------------------------");

	        driver.quit();
	    }


	    public static void selectSection(String sectionName) throws InterruptedException {

	        Actions action = new Actions(driver);
	        JavascriptExecutor executor = (JavascriptExecutor) driver;

	        do {
	            try {
	                WebElement ele_Section = driver.findElement(By.xpath(sectionName));
	                executor.executeScript("arguments[0].scrollIntoView(true);", ele_Section);
	                break;
	            } catch (NoSuchElementException e) {
	                action.sendKeys(Keys.PAGE_DOWN).perform();
	                Thread.sleep(1000);
	            }
	        }
	        while (true);
	    }

	    public static List<String> getProductNames(String sectionName) throws InterruptedException {

	        JavascriptExecutor executor = (JavascriptExecutor) driver;
	        List<String> itemsToAdd = new ArrayList<>();

	        do {
	            List<WebElement> allItems = driver.findElements(By.xpath(sectionName + "/../../..//div[@data-qa='product-name']/div"));
	            allItems.stream().filter(WebElement::isDisplayed).forEach(element -> itemsToAdd.add(element.getText()));
	            if (driver.findElement(By.xpath(sectionName + "/../../.." + NEXT_BUTTON)).getAttribute("class").contains("disabled")) {
	                break;
	            }
	            executor.executeScript("arguments[0].click();", driver.findElement(By.xpath(sectionName + "/../../.." + NEXT_BUTTON)));
	            Thread.sleep(1000);
	        }
	        while (true);
	        System.out.println("Total items : " + itemsToAdd.stream().distinct().count());
	        return itemsToAdd.stream().distinct().sorted().collect(Collectors.toList());
	    }

	    public static List<String> getAllProductNames(String sectionName) throws InterruptedException {

	        selectSection(sectionName);
	        return getProductNames(sectionName);
	    }

}
