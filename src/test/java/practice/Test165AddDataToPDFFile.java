package practice;

import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;

import com.itextpdf.text.BaseColor;
import com.itextpdf.text.Chunk;
import com.itextpdf.text.Document;
import com.itextpdf.text.Font;
import com.itextpdf.text.FontFactory;
import com.itextpdf.text.pdf.PdfWriter;

public class Test165AddDataToPDFFile {

	public static void main(String[] args) throws Exception {
		//Add text into new pdf file
		File f=new File("src/test/resources/mypdf.pdf");
		FileOutputStream fos=new FileOutputStream(f);
		Document doc=new Document();
		PdfWriter.getInstance(doc, fos);
		doc.open();
		Font ft=FontFactory.getFont(FontFactory.COURIER,16, BaseColor.BLACK);
		Chunk ch=new Chunk("Hi Team,How are you? ",ft);
		doc.add(ch);
		doc.close();
		System.out.println("secessfully added some text to pdf file");
		

	}

}
