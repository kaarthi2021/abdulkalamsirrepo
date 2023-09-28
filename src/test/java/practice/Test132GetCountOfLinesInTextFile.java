package practice;

import java.io.BufferedReader;
import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileReader;

public class Test132GetCountOfLinesInTextFile {

	public static void main(String[] args) throws Exception {
		//open existing file in read mode
		File f=new File("src\\test\\resources\\mydata.txt");
		FileReader fr=new FileReader(f);
		//Shift/load file from HDD to RAM
		BufferedReader br=new BufferedReader(fr);
		//Get Count of lines in .text file
		String line="";
		int count=0;
		while((line=br.readLine())!=null)//loop terminates after last lines reading
		{
			count++;
		}
		System.out.println("Total number of lines in that .txt file is :"+count);
		//close file permissions
		br.close();
		fr.close();
	}

}


/*
 * if you give text as like this o/p is: 13 
 //even space also considering as one line count, even you by mistekenly enter key
 * 1My name is Aswani 
 * 2India won 2011 world cup 
 * 3i am living in HYDERBAD since 18/May/2013 
 * 4My address is abc-111/1
 * 5batch264 is GREAT batch 
 * 6kdgs 
 * 7kldj 
 * 8lsnl 
 * 9mh
 * 10j
 * 11 
 * 12
 * 13
 */

