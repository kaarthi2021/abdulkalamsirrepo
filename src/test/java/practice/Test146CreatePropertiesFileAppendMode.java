package practice;

import java.io.File;
import java.io.FileWriter;
import java.io.IOException;
import java.util.Properties;

public class Test146CreatePropertiesFileAppendMode {

	public static void main(String[] args) throws Exception {
		//create an object to Properties class
		Properties p=new Properties();
		//define key-value as pairs
		p.setProperty("leademail", "contact2aswani@gmail.com");
		p.setProperty("gmailurl", "http://www.gmail.com");
		//Save a new properties file as key and value pairs
		File f=new File("src\\test\\resources\\config1.properties");
		FileWriter fw=new FileWriter(f,true);//Append mode
		p.store(fw,"My Results properties file");
	}

}
