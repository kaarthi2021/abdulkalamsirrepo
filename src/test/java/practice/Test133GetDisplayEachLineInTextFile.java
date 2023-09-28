package practice;

import java.io.BufferedReader;
import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileReader;

public class Test133GetDisplayEachLineInTextFile {

	public static void main(String[] args) throws Exception {
		//open existing file in read mode
		File f=new File("src\\test\\resources\\mydata.txt");
		FileReader fr=new FileReader(f);
		//Shift/load file from HDD to RAM
		BufferedReader br=new BufferedReader(fr);
		//Get Count of lines in .text file
		String line="";
		
		while((line=br.readLine())!=null)//loop terminates after last lines reading
		{
			System.out.println(line);
		}
		System.out.println("dispalyed each line in .text file");
		//close file permissions
		br.close();
		fr.close();
	}

}
