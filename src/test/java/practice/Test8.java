package practice;

import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.remote.RemoteWebDriver;

public class Test8 {

	public static void main(String[] args) {
		//primitive datatype(byte,short,int,long,float,double,char,boolean,)
		int x=10;
		//double	z=300.00;
		System.out.println(x);//x behaves like variable only
		// derived data type(String,Arrays)
		String y="kalam";
		System.out.println(y);//y behaves like variable
		System.out.println(y.length());//y behaves like object by calling length method

		int z[]= {10,20};
		System.out.println(z);// z behaves like variable
		System.out.println(z.length);//z behaves like an object by calling length property
		//user defined data type(any class)
		RemoteWebDriver driver=new ChromeDriver();
		driver.get("http://www.yahoo.com"); //driver behaves like object only
		


	}

}
