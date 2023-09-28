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

public class Test155OutputInSameSheet {

	public static void main(String[] args) throws Exception {
		//connect to existing file in HDD
		File f=new File("src\\test\\resources\\numdata.xlsx");
		//take read permissions on that file
		FileInputStream fis=new FileInputStream(f);
		//Consider that file as workbook file and shift into RAM
		Workbook wb=WorkbookFactory.create(fis);
		//connect to sheet
		Sheet sh=wb.getSheet("Sheet1");
		//get no.of rows
		int nor=sh.getPhysicalNumberOfRows();
		//1st row(index=0) has names of columns
		for(int i=1;i<nor;i++)//from 2nd row(index=1) to last row(index=nur-1)
		{
			DataFormatter df=new DataFormatter();
			//row is already created,so get row
			Row r=sh.getRow(i);
			String x=df.formatCellValue(r.getCell(0));
			int a=Integer.parseInt(x);
			String y=df.formatCellValue(r.getCell(1));
			int b=Integer.parseInt(y);
			r.createCell(2).setCellValue(a+b);
			r.createCell(3).setCellValue(a-b);
			r.createCell(4).setCellValue(a*b);
			r.createCell(5).setCellValue((float)(a/b));
			
		}
		//take write permissions and save changes
		FileOutputStream fos=new FileOutputStream(f);
		wb.write(fos);//save changes
		fos.close();
		wb.close();
		fis.close();
        System.out.println("done");
	}

}
