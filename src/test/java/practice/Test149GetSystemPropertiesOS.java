package practice;

import java.util.Properties;
import java.util.Set;

public class Test149GetSystemPropertiesOS {

	public static void main(String[] args) {
		//Get in-built properties related to our OS 
		Properties p=System.getProperties();//Key And Values as Pairs
		Set<Object> keys=p.keySet();//get all keys into object array
		for(Object key:keys)
		{
			System.out.println(key.toString()+"="+p.getProperty(key.toString()));
		}
		

	}

}
