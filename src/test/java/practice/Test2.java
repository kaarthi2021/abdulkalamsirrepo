package practice;

import org.openqa.selenium.edge.EdgeDriver;

import io.github.bonigarcia.wdm.WebDriverManager;
import io.opentelemetry.exporter.logging.SystemOutLogRecordExporter;

public class Test2 {

	public static void main(String[] args) throws InterruptedException {
		//download msedge driver software
		WebDriverManager.edgedriver().setup();
		//Open msedge browser using that browser driver software
		EdgeDriver driver=new EdgeDriver();
		//launch site
		driver.get("http://www.facebook.com");
		System.out.println("Waiting for few seconds");
		//Wait for few seconds
		Thread.sleep(5000);
		//Close the browser window
		driver.close();
		System.out.println("Program Execution Completed");

	}

}
