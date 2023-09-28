package practice;

import org.openqa.selenium.By;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.remote.RemoteWebDriver;

import io.github.bonigarcia.wdm.WebDriverManager;

public class ttestt {

	public static void main(String[] args) throws Exception {
		WebDriverManager.chromedriver().setup();
		RemoteWebDriver driver=new ChromeDriver();
		driver.get("https://www.flipkart.com/offers-list/beauty-food-toys-more?screen=dynamic&pk=themeViews%3DDT-OMU-2%3ADeal-DT~widgetType%3DdealCard~contentType%3Dneo&wid=7.dealCard.OMU_5&otracker=hp_omu_Beauty%252C%2BFood%252C%2BToys%2B%2526%2Bmore_5&otracker1=hp_omu_PINNED_neo%2Fmerchandising_Beauty%252C%2BFood%252C%2BToys%2B%2526%2Bmore_NA_wc_view-all_5");
		Thread.sleep(10000);
		driver.findElement(By.xpath("//span[contains(text(),'Baby')]")).click();
	}

}
