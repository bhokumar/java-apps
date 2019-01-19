import static org.junit.Assert.*;

import org.junit.Test;


public class TestJunit {
	//@Test
	  // public void testAdd() {
	  //    String str= "Junit is working fine";
	  //    assertEquals("Junit is working fine",str);
	//   }
	
	String message = "Hello World";
	MessageUtil messageUtil = new MessageUtil(message);
	
	@Test(timeout=200)
	public void  testPrintmessage(){
		
		message = "Hello World";
		System.out.println("Inside testPrintMessage");
		assertEquals(message, messageUtil.printMessage());
	}
	@Test
	public void testSalutationMessage(){
		System.out.println("Inside testSalutationMessage()");
		message = "HI! "+"Hello World";
		assertEquals(message, messageUtil.salutationMessage());
	}
	
	@Test(expected = ArithmeticException.class)
	public void testArithmeticSalutionMessage(){
		System.out.println("Inside ArithmeticSalutionMessage");
		messageUtil.arithmeticSalutionMessage();
	}
}
