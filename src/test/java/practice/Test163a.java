package practice;

import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;

import org.apache.poi.xwpf.usermodel.XWPFDocument;
import org.apache.poi.xwpf.usermodel.XWPFParagraph;
import org.apache.poi.xwpf.usermodel.XWPFRun;

public class Test163a {

	public static void main(String[] args) throws Exception {
		//tahe a new word documet in write mode
		XWPFDocument doc=new XWPFDocument();
		XWPFParagraph para=doc.createParagraph();
		XWPFRun run=para.createRun();
		run.setText("Hello Team");
		//save file 
		File f=new File("src/test/resources/doc1.docx");
		FileOutputStream fos=new FileOutputStream(f);
		doc.write(fos);
		doc.close();
		fos.close();
		System.out.println("a new document sucessfully created and added one paragraph");

	}

}
