package practice;

import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.util.Properties;

public class Test147GetPropNamesInPropFiles {

	public static void main(String[] args) throws Exception {
		/*
		 * if you try to get property value, but the typed property is not exists in
		 * that properties file then what will be the o/p:null
		 */
		//connect to file
		File f=new File("src\\test\\resources\\config.properties");
		FileReader fr=new FileReader(f);
		//load file into RAM as properties file,Dont use BufferedReader here use properties class
		Properties p=new Properties();
		p.load(fr);
		System.out.println("count of total properties in file is: "+p.keySet().size());
		//Get properties values from that file
		System.out.println(p.getProperty("browser"));
		System.out.println(p.getProperty("stageurl"));
		

	}

}
