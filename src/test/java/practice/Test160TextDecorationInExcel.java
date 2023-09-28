package practice;

import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;

import org.apache.poi.ss.usermodel.Cell;
import org.apache.poi.ss.usermodel.CellStyle;
import org.apache.poi.ss.usermodel.FillPatternType;
import org.apache.poi.ss.usermodel.Font;
import org.apache.poi.ss.usermodel.IndexedColors;
import org.apache.poi.ss.usermodel.Sheet;
import org.apache.poi.xssf.usermodel.XSSFWorkbook;

public class Test160TextDecorationInExcel {

	public static void main(String[] args) throws Exception {
		//Take new excel file with a sheet
		File f=new File("src/test/resources/Book2.xlsx");
		//Create new Workbook
		XSSFWorkbook wb=new XSSFWorkbook();
		//create sheet
		Sheet sh;
		try {
		sh=wb.createSheet("Sheet1");
		}
		catch(Exception e)//if already exists
		{
		sh=wb.getSheet("Sheet1");
		}
		//creating Font And style objects
		Font font=wb.createFont();
		font.setFontHeightInPoints((short)60);
		font.setFontName("Arial");
		font.setItalic(true);
		font.setColor(IndexedColors.BROWN.getIndex());
		CellStyle style=wb.createCellStyle();
		style.setFont(font);
		//Applying  Style to the cell
		Cell cell=sh.createRow(0).createCell(0);
		cell.setCellValue("Hello,Team");
		cell.setCellStyle(style);
		sh.autoSizeColumn(0);
		//save file
		FileOutputStream fos=new FileOutputStream(f);
		wb.write(fos);
		fos.close();
		System.out.println("Text Font Increased sucessfully");
	}

}
