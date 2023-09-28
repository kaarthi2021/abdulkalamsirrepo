package practice;

import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;

import org.apache.poi.xwpf.usermodel.ParagraphAlignment;
import org.apache.poi.xwpf.usermodel.XWPFDocument;
import org.apache.poi.xwpf.usermodel.XWPFParagraph;
import org.apache.poi.xwpf.usermodel.XWPFRun;

public class Test163b {

	public static void main(String[] args) throws Exception {
		//create word doc
		XWPFDocument doc=new XWPFDocument();
		//create a heading in center 
		XWPFParagraph title=doc.createParagraph();
		title.setAlignment(ParagraphAlignment.CENTER);
		XWPFRun titlerun=title.createRun();
		titlerun.setText("Selenium Web Driver-JAVA");
		titlerun.setItalic(true);
		titlerun.setFontSize(16);
		titlerun.setBold(true);
		//create paragraph
		XWPFParagraph para=doc.createParagraph();
		XWPFRun run=para.createRun();
		run.setText("Selenium Web Driver-JAVA is set of libraries");
		run.setFontSize(11);
		run.setItalic(true);
		//save file
		File f=new File("src/test/resources/doc2.docx");
		FileOutputStream fos=new FileOutputStream(f);
		doc.write(fos);
		doc.close();
		fos.close();
		System.out.println("Word doc created sucessfully with heading and paragraph");
	}

}
