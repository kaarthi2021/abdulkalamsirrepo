package practice;

import java.io.File;
import java.io.FileInputStream;
//import java.io.FileNotFoundException;
import java.io.FileOutputStream;

import org.apache.poi.ss.usermodel.Row;
import org.apache.poi.ss.usermodel.Sheet;
import org.apache.poi.ss.usermodel.Workbook;
import org.apache.poi.ss.usermodel.WorkbookFactory;

public class Test153CreatenewSheetAndEnterValue {

	public static void main(String[] args) throws Exception {
		//already existing file ,add one more sheet and enter some data
		File f=new File("src\\test\\resources\\sample.xlsx");
		FileInputStream fis=new FileInputStream(f);
		Workbook wb=WorkbookFactory.create(fis);
		//1,create a new sheet 
		Sheet sh=wb.createSheet("data");
		//2.create 1st new row in that sheet and set values
		Row r1=sh.createRow(0);//create 1st row
		r1.createCell(0).setCellValue("Abdul kalam");
		r1.createCell(1).setCellValue("India");
		//create 2nd row in that sheet and set values
		Row r2=sh.createRow(1);//create 2nd row
		r2.createCell(0).setCellValue("Ravikumar");
		r2.createCell(1).setCellValue("India");
		//create 3rd row in that sheet and set values
		Row r3=sh.createRow(2);//create 3rd row
		r3.createCell(0).setCellValue("Karthika");
		r3.createCell(1).setCellValue("India");
		//Auto fit 
		sh.autoSizeColumn(0);
		sh.autoSizeColumn(1);
		FileOutputStream fos=new FileOutputStream(f);
		wb.write(fos);
		//close permissions
		fos.close();
		fis.close();
		wb.close();
		
		System.out.println("Data sucessfully entered in excel file with 2 col");
	}

}
