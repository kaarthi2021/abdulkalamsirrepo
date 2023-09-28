package practice;

import org.testng.annotations.Test;

public class TestNGTest {

	@Test(priority=1)
	public static void m1()
	{
		System.out.println("hi m");
	}
	@Test(priority=2)
	public static void a1()
	{
		System.out.println("hi a");
	}
	
}
