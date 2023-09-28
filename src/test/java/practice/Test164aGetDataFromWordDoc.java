package practice;

import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;

import org.apache.poi.xwpf.extractor.XWPFWordExtractor;
import org.apache.poi.xwpf.usermodel.XWPFDocument;

public class Test164aGetDataFromWordDoc {

	public static void main(String[] args) throws Exception {
		
		// Open word doc file in READ Mode
		File f=new File("src/test/resources/doc1.docx");
		FileInputStream fis=new FileInputStream(f);
		XWPFDocument doc=new XWPFDocument(fis);
		XWPFWordExtractor extr=new XWPFWordExtractor(doc);
		System.out.println(extr.getText());
		extr.close();
		
	}

}
