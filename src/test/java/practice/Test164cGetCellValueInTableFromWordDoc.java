package practice;

import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.util.List;

import org.apache.poi.xwpf.usermodel.XWPFDocument;
import org.apache.poi.xwpf.usermodel.XWPFTable;
import org.apache.poi.xwpf.usermodel.XWPFTableCell;
import org.apache.poi.xwpf.usermodel.XWPFTableRow;

public class Test164cGetCellValueInTableFromWordDoc {

	public static void main(String[] args) throws Exception {
		File f=new File("src\\test\\resources\\WordTable.docx");
		FileInputStream fis=new FileInputStream(f);
		XWPFDocument doc=new XWPFDocument(fis);
		int targetTableNum=0;
		int targetRowNum=2;//3rd row
		int targetColuNum=1;//2nd col
		List<XWPFTable> totalTables=doc.getTables();
		if(targetTableNum>=0 && targetTableNum<totalTables.size())
		{
			XWPFTable targetTable=totalTables.get(targetTableNum);
			List<XWPFTableRow> totalRows=targetTable.getRows();
			if(targetRowNum >=0 && targetRowNum<totalRows.size())
			{
				XWPFTableRow targetRow=totalRows.get(targetRowNum);
				List<XWPFTableCell> totalCells=targetRow.getTableCells();
				System.out.println(totalCells.get(targetColuNum).getText());
			}
			else
			{
				System.out.println("Invalid Row Index");
			}
		}
		else
		{
			System.out.println("Invalid Table Index");
		}
		
		System.out.println("Sucessfully got the given cel Text");
	}

}
