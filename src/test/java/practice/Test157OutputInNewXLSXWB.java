package practice;
import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;

import org.apache.poi.ss.usermodel.DataFormatter;
import org.apache.poi.ss.usermodel.Row;
import org.apache.poi.ss.usermodel.Sheet;
import org.apache.poi.ss.usermodel.Workbook;
import org.apache.poi.ss.usermodel.WorkbookFactory;
import org.apache.poi.xssf.usermodel.XSSFWorkbook;

public class Test157OutputInNewXLSXWB {

	public static void main(String[] args) throws Exception {
		//Connect to existing file iN hdd
		File f1=new File("src\\test\\resources\\numdata.xlsx");
		//tahe read permissions
		FileInputStream fis=new FileInputStream(f1);
		//consider that file as Workbook file  And shift it into RAM
		Workbook ewb=WorkbookFactory.create(fis);
		Sheet esh=ewb.getSheet("Sheet1");
		int nur=esh.getPhysicalNumberOfRows();
		//create new xlsx workbook for output
		File f2=new File("src\\test\\resources\\resultdata.xlsx");
		FileOutputStream fos=new FileOutputStream(f2);
		XSSFWorkbook nwb=new XSSFWorkbook();
		Sheet nsh=nwb.createSheet("Result");
		Row r1=nsh.createRow(0);
		r1.createCell(0).setCellValue("add");
		r1.createCell(1).setCellValue("subtract");
		r1.createCell(2).setCellValue("multiply");
		r1.createCell(3).setCellValue("division");
		for(int i=1;i<nur;i++)
		{
			DataFormatter df=new DataFormatter();
			String x=df.formatCellValue(esh.getRow(i).getCell(0));
			int a=Integer.parseInt(x);
			String y=df.formatCellValue(esh.getRow(i).getCell(1));
			int b=Integer.parseInt(y);
			Row r2=nsh.createRow(i);
			r2.createCell(0).setCellValue(a+b);
			r2.createCell(1).setCellValue(a-b);
			r2.createCell(2).setCellValue(a*b);
			r2.createCell(3).setCellValue((float)a/b);
			
			
		}
		//save file
		nwb.write(fos);
		fis.close();
		fos.close();
		ewb.close();
		nwb.close();
		
		System.out.println("output successfully added in new file in new sheet");
		
	}

}
