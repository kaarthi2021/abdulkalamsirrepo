package practice;

import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;

import org.apache.poi.xssf.usermodel.XSSFCell;
import org.apache.poi.xssf.usermodel.XSSFRow;
import org.apache.poi.xssf.usermodel.XSSFSheet;
import org.apache.poi.xssf.usermodel.XSSFWorkbook;

public class Test150WriteXLSXFile {

	public static void main(String[] args) throws Exception {
		//Create one excel file
		XSSFWorkbook wb=new XSSFWorkbook();
		//create worksheet
		XSSFSheet sh=wb.createSheet("Mysheet");
		//create row in sheet
		XSSFRow r=sh.createRow(0);
		//create cell in row
		XSSFCell c=r.createCell(0);
		//set value
		c.setCellValue("Entered data in xlsx file");
		sh.autoSizeColumn(0);
		//Save the workbook to a file
		File f=new File("D:\\batch264\\org.magnitia.abdulkalamsir\\src\\test\\resources\\Writexlsx.xlsx");
		FileOutputStream fos=new FileOutputStream(f);
		wb.write(fos);
		//close permissions
		wb.close();
		fos.close();
		System.out.println(".xlsx file has been created sucessfully ");

	}

}
