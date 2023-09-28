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

public class Test156outputInSheet2 {

	public static void main(String[] args) throws Exception {
		//connect to existing file in HDD
				File f=new File("src\\test\\resources\\numdata.xlsx");
				//take read permissions on that file
				FileInputStream fis=new FileInputStream(f);
				//Consider that file as workbook file and shift into RAM
				Workbook wb=WorkbookFactory.create(fis);
				//Create object to sheet1 and get count of used rows 
				Sheet sh1=wb.getSheet("Sheet1");
				int nur=sh1.getPhysicalNumberOfRows();
				//create onject to Sheet2 and create headding in 1st row
				Sheet sh2=wb.getSheet("Sheet2");
				Row r1=sh2.createRow(0);//1st row
				r1.createCell(0).setCellValue("add");
				r1.createCell(1).setCellValue("subtract");
				r1.createCell(2).setCellValue("multiply");
				r1.createCell(3).setCellValue("division");
				
				//DDT from 2nd row(index=1) to last row (index=nur-1) in Sheet1
				for(int i=1;i<nur;i++)
				{
					DataFormatter df=new DataFormatter();
				    String x=df.formatCellValue(sh1.getRow(i).getCell(0));
				    int a=Integer.parseInt(x);
				    String y=df.formatCellValue(sh1.getRow(i).getCell(1));
				    int b=Integer.parseInt(y);
				    sh2.createRow(i).createCell(0).setCellValue(a+b);
				    sh2.getRow(i).createCell(1).setCellValue(a-b);
				    sh2.getRow(i).createCell(2).setCellValue(a*b);
				    sh2.getRow(i).createCell(3).setCellValue((float)a/b);
				    sh2.autoSizeColumn(0);
				    sh2.autoSizeColumn(1);
				    sh2.autoSizeColumn(2);
				    sh2.autoSizeColumn(3);
				    
				}
				//take write permissions and save changes
				FileOutputStream fos=new FileOutputStream(f);
				wb.write(fos);
				fos.close();
				fis.close();
				wb.close();
				System.out.println("Successfully output added in 2nd sheet");
				

	}

}
