package practice;

import java.io.File;
import java.io.FileOutputStream;

import org.apache.poi.xwpf.usermodel.XWPFDocument;
import org.apache.poi.xwpf.usermodel.XWPFParagraph;
import org.apache.poi.xwpf.usermodel.XWPFRun;
import org.apache.poi.xwpf.usermodel.XWPFTable;
import org.apache.poi.xwpf.usermodel.XWPFTableCell;
import org.apache.poi.xwpf.usermodel.XWPFTableRow;

public class Test163dCreateTableInWordDoc {

	public static void main(String[] args) {
		//Create word doc
		XWPFDocument doc=new XWPFDocument();
		//Create table with 3 rows and 3 col in word doc
		int numRows=3;
		int numCols=3;
		XWPFTable table=doc.createTable(numRows, numCols);
		//set table width(optional)
		table.setWidth("100%");
		//Interate over the rows and columns to set cell content
		for(int row=0;row<numRows;row++)
		{
			XWPFTableRow tablerow=table.getRow(row);
			for(int col=0;col<numCols;col++)
			{
				XWPFTableCell cell=tablerow.getCell(col);
				XWPFParagraph para=cell.addParagraph();
				XWPFRun run=para.createRun();
				run.setText("Rows "+(row+1) +", cols "+(col+1));
			}
		}
		//save file
		File f=new File("src/test/resources/doc4.docx");
		try {
			FileOutputStream fos=new FileOutputStream(f);
			doc.write(fos);
			doc.close();
			fos.close();
		}
		catch(Exception e)
		{
			System.out.println(e.getMessage());
		}
		
		System.out.println("Table sucessfully created in Word doc");
	}

}
