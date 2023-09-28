package practice;

import java.io.File;
import java.io.FileInputStream;

import org.apache.poi.ss.usermodel.Sheet;
import org.apache.poi.ss.usermodel.Workbook;
import org.apache.poi.ss.usermodel.WorkbookFactory;
//import java.io.FileNotFoundException;

public class Test150GetNoOfSheetsRowsColms {

	public static void main(String[] args) throws Exception {
		//Get No of sheets,no of rows And colouns in Given Excel File
		File f=new File("src\\test\\resources\\sample.xlsx");
		//Take read Permissions on that file
		FileInputStream fis=new FileInputStream(f);
		//Consider that file as Excel File (Workbook) And shft it into RAM
		Workbook wb=WorkbookFactory.create(fis);
		//Collet all spread sheets(sheets) in that workbook
		int nos=wb.getNumberOfSheets();
		System.out.println(nos);
		//Get each sheet
		for(int i=0;i<nos;i++)//from 1st sheet to last sheet
		{
			Sheet sh=wb.getSheetAt(i);
			String shn=sh.getSheetName();
			try 
			{
				int nur=sh.getPhysicalNumberOfRows();
				int nuc=sh.getRow(0).getLastCellNum();
				System.out.println(shn+":"+" has "+nur+" rows "+nuc +" columns");
			}
			catch(Exception e)
			{
				System.out.println(shn+":" +" is Empty sheet");
			}
		}
		
		
		
	}

}
