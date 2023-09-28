package practice;

import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;

import org.apache.poi.ss.usermodel.DataFormatter;
import org.apache.poi.ss.usermodel.Sheet;
import org.apache.poi.ss.usermodel.Workbook;
import org.apache.poi.ss.usermodel.WorkbookFactory;

public class Test152HowToReadDataFromExcel {

	public static void main(String[] args) throws Exception {
		//connect to existing file in HDD
		File f=new File("src\\test\\resources\\sample.xlsx");
		//Take read permissions on that file
		FileInputStream fis=new FileInputStream(f);
		//Consider that file as Excel file(Workbook) and shift inti RAM
		Workbook wb=WorkbookFactory.create(fis);
		Sheet sh=wb.getSheet("MySheet");
		int nor=sh.getPhysicalNumberOfRows();
		for(int i=0;i<nor;i++)
		{
			DataFormatter df=new DataFormatter();
			String x=df.formatCellValue(sh.getRow(i).getCell(0));
			String y=df.formatCellValue(sh.getRow(i).getCell(1));
			System.out.println(x+" "+y);
		}
		//close permissions
		fis.close();
		wb.close();
	}

}
