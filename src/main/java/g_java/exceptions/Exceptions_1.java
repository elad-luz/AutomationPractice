package g_java.exceptions;

import java.util.Scanner;

public class Exceptions_1 {

	public static void main(String[] args) {
		System.out.println("Exceptions 1:\n=============\n");
		
		System.out.println("1) using finally");
		
		// runtime exception from other method, which was not handled in method, and was caught in main
		try { // this block states what to do -> call the method
			divide100withInputint();
		}
		catch(Exception e) { // this block states what to do in case of exception
			e.printStackTrace(); // prints StackTrace
			System.out.println("ooops...");
		}
		finally { // // this block states what to do in any case of (regardless exception or not)
			System.out.println("final block will print any way");
		}
		// =================================
		System.out.println("\n--- end ---");
	}  // end of main
	/** METHODS (out-side of 'main'): */	
	// this method will: do ...:
	public static void divide100withInputint()
	{
		Scanner input = new Scanner(System.in); // define input scanner from keyboard
		System.out.print("enter an integer to devide 100 with (note - 0 will result with exception): "); // notification to console
		// initiate variable + set a value (provided by user from canner) in variable i => use 1 or 0 (0 will result with exception)
		int i = input.nextInt();
		int j = 100/i;
		System.out.println("100/" + i + " result: " + j);
		
		input.close();
	}
}
