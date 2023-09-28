package practice;

import java.io.File;
import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.util.zip.ZipEntry;
import java.util.zip.ZipOutputStream;

import org.testng.annotations.Test;

public class Test128ZipFile {

	
		@Test
		public void method1() throws Exception
		{
			//convert original file into zip file
			File fileToZip=new File("D:\\aswani resume MT.doc");
	        FileInputStream fis=new FileInputStream(fileToZip);
			File zipfile=new File("D:\\aswani resume MT.zip");
			FileOutputStream fos=new FileOutputStream(zipfile);
	        ZipOutputStream zipOut=new ZipOutputStream(fos);
	        ZipEntry zipEntry=new ZipEntry(fileToZip.getName());
	        zipOut.putNextEntry(zipEntry);
	        byte[] bytes=new byte[1024];
	        int length;
	        while((length=fis.read(bytes))>=0) 
	        {
	            zipOut.write(bytes, 0, length);
	        }
	        zipOut.close();
	        fis.close();
	        fos.close();
	        System.out.println("Zip complete.");

	}

}
