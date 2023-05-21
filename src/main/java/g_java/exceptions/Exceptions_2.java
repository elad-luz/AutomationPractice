package g_java.exceptions;

import java.util.Scanner;

public class Exceptions_2 {

	public static void main(String[] args) {
		System.out.println("Exceptions 2:\n=============\n");
		
		System.out.println("1)"); // divide by zero
		int a = 20;
		int b = 0; // if b = 10 its OK -BUT- if = 0 there can be a problem !
		// double c = a/b;
		// if b = 0 this will return an ArithmeticException (can't divide with zero) & will crash the program
		/**	so we can wrap it with try-catch - we can use try-catch where ever we suspect there can be a crash of our code
			select the code + click: 'Source button' > 'Surround with...' > 'Try-Catch' => it allows the ease of adding...
			or select the code + right-click > 'Surround with...' > 'Try-Catch' => same...
		 */
		double c;
		try {
			c = a/b;
			System.out.println("a/b = " + c); // if b=10 => a/b = 2.0
		} catch (Exception ex) {  // if b=0 => a/b = ERROR
			ex.printStackTrace();
			System.out.println("can't divide with zero");
		}
		
		System.out.println("end of section 1");

		System.out.println(System.lineSeparator());
		// ----------------------------------------

		System.out.println("2)");  // divide by zero + scanner

		// runtime exceptions - how to handle errors
		// when running a java program don't operate in a proper & expected channel
		// runtime exceptions can be dealt with by the jvm and continue to operate accordingly instead of letting the program crash
		// if exception occurs and is not dealt with, it it thrown up the ladder to the method which called the method it was caught on
		// if it will not be dealt with eventually it will reach 'main' and crash the program
		
		// this is how to prevent or show an error in the most basic form:
 		// ---------------------------------------------------------------
/*		Scanner scanner = new Scanner(System.in);
		System.out.println("type in first number:");
		int i = scanner.nextInt();
		System.out.println("type in second number:");
		int j = scanner.nextInt();
		
		if (j != 0) {
			System.out.println(i+"/"+j+" = " +(i/j)+" (with reminder, if exists)...");
		}
		else {
			System.out.println("can't divide by 0 => ERROR !!!");
		}
*/		
		// this is how to catch an exception using a 'try' block syntax: {circle the code we suspect might cause a problem}
 		// -------------------------------------------------------------
		Scanner scanner = new Scanner(System.in);
		System.out.println("type in first number: (4)");
		int i = scanner.nextInt();
		System.out.println("type in second number: (2 -or- 0 which will result with an error)");
		int j = scanner.nextInt();
		
		try {
			System.out.println(i+"/"+j+" = " +(i/j)+" (with reminder, if exists)...");
		}
		catch (ArithmeticException e){ // when an arithmetic exception is caught by java, afterwards do the following:
			System.out.println("can't divide by 0 => ERROR !!!");
		}
		
		System.out.println("...\ncontinue even after try block caught exception");
		
		scanner.close();
		
		// =================================
		System.out.println("\n--- end ---");
	}  // end of main
	/** METHODS (out-side of 'main'): */	
}
