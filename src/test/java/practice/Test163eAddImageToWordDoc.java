package practice;
import java.io.File;
import java.io.FileInputStream;
import java.io.FileOutputStream;
import org.apache.poi.xwpf.usermodel.*;
import org.apache.poi.util.Units;

public class Test163eAddImageToWordDoc {

	
		    public static void main(String[] args)
		    {
		    	//create word doc
		    	 XWPFDocument doc= new XWPFDocument();
		    	 // Create a paragraph
		         XWPFParagraph para = doc.createParagraph();
		         XWPFRun run = para.createRun();
		         
		        
		        try {
		        	File f=new File("src/test/resources/doc5.docx");
		            FileOutputStream out = new FileOutputStream(f);
		            // Add image //specify the path of image file
		            String imagePath = "D:\\id proofs\\aswani id proofs\\voter ID.jpg";
		            FileInputStream imageStream = new FileInputStream(imagePath);
		            run.addPicture(imageStream, XWPFDocument.PICTURE_TYPE_JPEG, imagePath, Units.toEMU(300), Units.toEMU(200));
		            imageStream.close();

		            // Save the document
		            doc.write(out);
		            out.close();

		            System.out.println("Image added to the document.");
		        } catch (Exception e) {
		            e.printStackTrace();
		        }
	

	}

}
