

package practice;

import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.util.List;

import org.apache.poi.xwpf.usermodel.XWPFDocument;
import org.apache.poi.xwpf.usermodel.XWPFParagraph;

public class Test164bGetSpecificParaInWordDoc {

	public static void main(String[] args) throws Exception {
		//File f=new File("src/test/resources/doc2.docx");
		File f=new File("D:\\DB Testing updated nag sir.docx");
		FileInputStream fis =new FileInputStream(f);
		//connect to existing doc in RAM
		XWPFDocument doc=new XWPFDocument(fis);
		int targetParagraphIndex=11;
		//get all paragraphs list in doc
		List<XWPFParagraph> totalparas=doc.getParagraphs();
		if(targetParagraphIndex>=0 && targetParagraphIndex < totalparas.size())
		{
			XWPFParagraph specificPara=totalparas.get(targetParagraphIndex);
			System.out.println(specificPara.getText());
		}
		else
		{
			System.out.println("invalid targetParagraphIndex ");
		}
		
		doc.close();
		fis.close();
		System.out.println("Sucessfully got the Specigic paragraph");
		
		
	}

}
