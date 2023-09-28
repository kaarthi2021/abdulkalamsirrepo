package practice;
import java.io.BufferedReader;
import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileReader;

public class Test135CountOfWordsInLine {

	public static void main(String[] args) throws Exception {
		//open existing file in read mode
		File f=new File("src\\test\\resources\\mydata.txt");
		FileReader fr=new FileReader(f);
		//Shift/load file from HDD to RAM
		BufferedReader br=new BufferedReader(fr);
		//Get and Display 1st line,3rd line and 4th line only in .text file
		String line=null;
		int ln=1;
		while((line=br.readLine())!=null)//loop terminates after last lines reading
		{
			String pieces[]=line.split(" ");//separator is blank space 
			if(ln==1)
			{
				System.out.println("1st line has "+pieces.length +" words");
			}
			else if(ln==2)
			{
				System.out.println("2st line has "+pieces.length +" words");
			}
			else if(ln==3)
			{
				System.out.println("3rd line has "+pieces.length +" words");
			}
			else 
			{
				System.out.println(ln+"th line has "+pieces.length +" words");
			}
			ln++;//goto next line
		}
		System.out.println("dispalyed count of words in each line in .text file");
		//close file permissions
		br.close();
		fr.close();
	}

}
