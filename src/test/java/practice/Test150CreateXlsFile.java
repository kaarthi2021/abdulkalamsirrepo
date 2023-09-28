package practice;

import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;

import org.apache.poi.hssf.usermodel.HSSFCell;
import org.apache.poi.hssf.usermodel.HSSFRow;
import org.apache.poi.hssf.usermodel.HSSFSheet;
import org.apache.poi.hssf.usermodel.HSSFWorkbook;

public class Test150CreateXlsFile {

	public static void main(String[] args) throws Exception {
		//Create one excel file
		HSSFWorkbook wb=new HSSFWorkbook();
		//create worksheet
		HSSFSheet sh=wb.createSheet("Sheet1");
		//create row in sheet
		HSSFRow r=sh.createRow(0);
		//create cell in row
		HSSFCell c=r.createCell(0);
		c.setCellValue("Hello team");
		//Save the workbook to a file
		File f=new File("D:\\batch264\\org.magnitia.abdulkalamsir\\src\\test\\resources\\Writexls.xls");
		FileOutputStream fos=new FileOutputStream(f);
		wb.write(fos);//save workbook(excel file)
		//close permissions
		wb.close();
		fos.close();
		System.out.println("Excel file created successfully");
	}

}
