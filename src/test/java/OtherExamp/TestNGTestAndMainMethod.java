package OtherExamp;

import org.testng.annotations.Test;

public class TestNGTestAndMainMethod {

	public static void main(String[] args) {
		System.out.println("main method");
	}

	@Test
	public void m1()
	{
		System.out.println("test ng annotated method m1");
	}
}
