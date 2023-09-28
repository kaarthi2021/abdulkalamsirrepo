package practice;

import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.FileReader;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.Properties;

import org.apache.poi.ss.usermodel.Cell;
import org.apache.poi.ss.usermodel.CellStyle;
import org.apache.poi.ss.usermodel.DataFormatter;
import org.apache.poi.ss.usermodel.Font;
import org.apache.poi.ss.usermodel.IndexedColors;
import org.apache.poi.ss.usermodel.Sheet;
import org.apache.poi.ss.usermodel.Workbook;
import org.apache.poi.ss.usermodel.WorkbookFactory;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.edge.EdgeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.remote.RemoteWebDriver;
import org.openqa.selenium.support.ui.Select;
import org.testng.Reporter;
import org.testng.annotations.Test;

import io.github.bonigarcia.wdm.WebDriverManager;

public class Test158RegFormFillingByGetDataFrmPropertiesAndXLSXFiles {
	
	File f1;
	FileReader fr;
	Properties p;
	File f2;
	FileInputStream fis;
	Workbook wb;
	Sheet sh;
	int nor;
	int noc;
	FileOutputStream fos;
	RemoteWebDriver driver;
	
	@Test(priority=1)
	public void readPropertiesFile() throws Exception
	{
	
	f1=new File("src\\test\\resources\\register.properties");
	fr=new FileReader(f1);
	p=new Properties();
	p.load(fr);
	System.out.println("Properties File loaded");
	Reporter.log("Properties File loaded");
	}
	
	@Test(priority=2)
	public void readXLSXFile() throws Exception
	{
		f2=new File("src\\test\\resources\\registerdata.xlsx");
		//f2=new File(p.getProperty("testdatafilepath"));
		fis=new FileInputStream(f2);
		wb=WorkbookFactory.create(fis);
		sh=wb.getSheet("Sheet1");
		//get no f used rows
		nor=sh.getPhysicalNumberOfRows();
		//get no of col
		noc=sh.getRow(0).getLastCellNum();
		System.out.println(noc);
		System.out.println("xl File loaded");
		Reporter.log("xl File loaded");
	}
	
	@Test(priority=3)
	public void openBrowser() throws Exception
	{
		String bn=p.getProperty("browser");
			if(bn.equalsIgnoreCase("chrome"))
			{
				WebDriverManager.chromedriver().setup();
				driver=new ChromeDriver();
			}
			else if(bn.equalsIgnoreCase("firefox"))
			{
				WebDriverManager.firefoxdriver().setup();
				driver=new FirefoxDriver();
			}
			else if(bn.equalsIgnoreCase("edge"))
			{
				WebDriverManager.edgedriver().setup();
				driver=new EdgeDriver();
			}
			else
			{
				//System.out.println("Given Wrong browser name");
				Reporter.log("Given Wrong browser name");
				//close smoothly,all propeties and xl file permissions
				fr.close();
				fis.close();
				wb.close();
				System.exit(0);//stop execution forcibly
			}
			
		
		}
	@Test(priority=4)
	public void launchSite() throws Exception
	{
		driver.get(p.getProperty("url"));
		driver.manage().window().maximize();
		Thread.sleep(Long.parseLong(p.getProperty("waittime")));
		
	}
	//Data driven testing 
	@Test(priority=5)
	public void RegisterFormFill() throws Exception
	{
		System.out.println("register form started");
		SimpleDateFormat sf=new SimpleDateFormat("dd-MMM-yyyy-hh-mm-ss");
		Date dt=new Date();
		//creating font and style object
		Font font=wb.createFont();
		font.setFontHeightInPoints((short)11);
		font.setFontName("Arial");
		font.setItalic(true);
		font.setColor(IndexedColors.RED.getIndex());
		CellStyle style=wb.createCellStyle();
		style.setFont(font);
		//Applying  Style to the cell
		Cell cel=sh.getRow(0).createCell(noc);
		cel.setCellValue("Result on"+sf.format(dt));
		cel.setCellStyle(style);
		sh.autoSizeColumn(0);
		//loop work from 2nd row becoz 1st row is headding
		for(int i=1;i<nor;i++)
		{
			//get existing test from xl 
			DataFormatter df=new DataFormatter();
			String a=df.formatCellValue(sh.getRow(i).getCell(0));
			String b=df.formatCellValue(sh.getRow(i).getCell(1));
			String c=df.formatCellValue(sh.getRow(i).getCell(2));
			String d=df.formatCellValue(sh.getRow(i).getCell(3));
			String e=df.formatCellValue(sh.getRow(i).getCell(4));
			
			//apply on site
			driver.switchTo().frame("iframewrapper");
			driver.findElement(By.id("register_name")).sendKeys(a);
			driver.findElement(By.id("register_password")).sendKeys(b);
			driver.findElement(By.id("register_email")).sendKeys(c);
			if(d.equalsIgnoreCase("male"))
			{
				driver.findElement(By.id("register_gendermale")).click();
			}
			else
			{
				driver.findElement(By.id("register_genderfemale")).click();
			}
			
			WebElement ele=driver.findElement(By.id("register_country"));
			Select s=new Select(ele);
			if(e.equalsIgnoreCase("India"))
			{
				s.selectByIndex(0);
			}
			else if(e.equalsIgnoreCase("pakistan"))
			{
				s.selectByIndex(1);
			}
			else if(e.equalsIgnoreCase("africa"))
			{
				s.selectByIndex(2);
			}
			
			else if(e.equalsIgnoreCase("Chaina"))
			{
				s.selectByIndex(3);
			}
			else
			{
				s.selectByIndex(4);
			}
			//wait
			Thread.sleep(Long.parseLong(p.getProperty("waittime")));
			//click on register button
			driver.findElement(By.id("register_0")).click();
			Thread.sleep(Long.parseLong(p.getProperty("waittime")));
			//get output message and write into last column as test result
			String z=driver.findElement(By.tagName("h1")).getText();
			System.out.println(z);
			Reporter.log(z);
			System.out.println(noc);
			sh.getRow(i).createCell(noc).setCellValue(z);
			sh.autoSizeColumn(noc);
			//back to page and refresh
			driver.switchTo().defaultContent();
			//for next itteration
			driver.navigate().refresh();
			Thread.sleep(5000);
		}
	
	}
	
	@Test(priority=6)
	public void saveXLFile() throws Exception
	{
	 fos=new FileOutputStream(f2);
	 wb.write(fos);
	 wb.close();
	 fis.close();
	 fos.close();
	}
	
	@Test(priority=7)
	public void closeBrowser() throws Exception
	{
		driver.close();
	}
	
	@Test(priority=8)
	public void zipresultFile() throws Exception
	{
		//zip file
		Reporter.log("xl file zipped");
		
	}
	@Test(priority=7)
	public void sentMai9() throws Exception
	{
		//sent email to manager
		Reporter.log("email sent to manager");
	}
	
	
	
	
	

}
