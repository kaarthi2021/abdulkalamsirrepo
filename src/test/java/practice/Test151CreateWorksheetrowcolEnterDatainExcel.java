package practice;

import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;

import org.apache.poi.ss.usermodel.Sheet;
import org.apache.poi.ss.usermodel.Workbook;
import org.apache.poi.ss.usermodel.WorkbookFactory;

public class Test151CreateWorksheetrowcolEnterDatainExcel {
	
//how to write data into excel

	public static void main(String[] args) throws Exception {
		//connect to existing file(.xls/.xlsx) in HDD
		File f=new File("src\\test\\resources\\sample.xlsx");
		//Take read permissions on that file
		FileInputStream fis=new FileInputStream(f);
		//Consider that file as excel file(Workbook) And shift into RAM
		Workbook wb=WorkbookFactory.create(fis);
		//1.create new sheet and set values into that created sheet
		Sheet sh=wb.createSheet("MySheet");
		sh.createRow(0).createCell(0).setCellValue("Abdul kalam");
		sh.getRow(0).createCell(1).setCellValue("Indian");
		sh.createRow(1).createCell(0).setCellValue("Nageswararao sir");
		sh.getRow(1).createCell(1).setCellValue("Indian");
		sh.createRow(2).createCell(0).setCellValue("Thomas Kutty");
		sh.getRow(2).createCell(1).setCellValue("Indian");
		sh.autoSizeColumn(0);
		sh.autoSizeColumn(1);
		//Take write persion on the file
		FileOutputStream fos=new FileOutputStream(f);
		wb.write(fos);
		//close all permisions
		fis.close();
		fos.close();
		wb.close();
		System.out.println("Sheet created and added some data ");
	}

}
