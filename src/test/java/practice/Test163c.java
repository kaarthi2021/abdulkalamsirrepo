package practice;

import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;

import org.apache.poi.xwpf.usermodel.BreakType;
import org.apache.poi.xwpf.usermodel.ParagraphAlignment;
import org.apache.poi.xwpf.usermodel.XWPFDocument;
import org.apache.poi.xwpf.usermodel.XWPFParagraph;
import org.apache.poi.xwpf.usermodel.XWPFRun;

public class Test163c {

	public static void main(String[] args) throws Exception {
		XWPFDocument doc=new XWPFDocument();
		XWPFParagraph para=doc.createParagraph();
		para.setAlignment(ParagraphAlignment.LEFT);
		XWPFRun run=para.createRun();
		run.setText("\u2764 Item1 ");
		run.addBreak(BreakType.TEXT_WRAPPING);
		run=para.createRun();
		run.setText("\u221A Item2 ");
		run.addBreak(BreakType.TEXT_WRAPPING);
		run=para.createRun();
		run.setText("\u263A Item3 ");
		//save file
		File f=new File("src/test/resources/doc3.docx");
		FileOutputStream fos=new FileOutputStream(f);
		doc.write(fos);
		doc.close();
		fos.close();
		System.out.println("added bullets sucessfully");
		
	}

}
