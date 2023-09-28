package practice;

import java.io.File;
import java.io.FileReader;
import java.util.Properties;
import java.util.Set;

import org.apache.commons.configuration.ConfigurationException;
import org.apache.commons.configuration.PropertiesConfiguration;

public class Test148EditPropertyValInPropertiesFile {

	public static void main(String[] args) throws Exception {
		//Open an existing file,Read Valus,Edit values and then save file
		File f=new File("src\\test\\resources\\config.properties");
		//edit values("commons-configuration" jar file is required)
		PropertiesConfiguration pc=new PropertiesConfiguration(f);
		pc.setProperty("leadmail","contact2");//new value for  existing property
		pc.save();
		//again read all properties values
		FileReader fr=new FileReader("f");
		Properties p=new Properties();
		p.load(fr);
		Set<Object>keys=p.keySet();//get all keys
		for(Object key:keys)
		{
			System.out.println(keys.toString()+"="+p.getProperty(key.toString()));
		}
		
		System.out.println("Updated property valu");

	}

}
