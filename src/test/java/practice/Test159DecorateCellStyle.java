package practice;
import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;

import org.apache.poi.ss.usermodel.Cell;
import org.apache.poi.ss.usermodel.CellStyle;
import org.apache.poi.ss.usermodel.FillPatternType;
import org.apache.poi.ss.usermodel.IndexedColors;
import org.apache.poi.ss.usermodel.Sheet;
import org.apache.poi.xssf.usermodel.XSSFWorkbook;

public class Test159DecorateCellStyle {

	public static void main(String[] args) throws Exception {
		//Take new excel file with a sheet
		File f=new File("src/test/resources/Book1.xlsx");
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
		//Define Style to decorate cell
		CellStyle style=wb.createCellStyle();
		style.setFillBackgroundColor(IndexedColors.YELLOW.getIndex());
		style.setFillPattern(FillPatternType.LESS_DOTS);
		//Add that style to target cell
		Cell cel=sh.createRow(0).createCell(0);
		cel.setCellValue("Hello karthamma");
		cel.setCellStyle(style);
		sh.autoSizeColumn(0);
		//save file
		FileOutputStream fos=new FileOutputStream(f);
		wb.write(fos);
		fos.close();
		System.out.println("Cell ecorated sucessfully");
		

	}

}
