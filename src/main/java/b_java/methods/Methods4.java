package b_java.methods;

import java.util.Scanner;

public class Methods4 {

	public static void main(String[] args) {
		System.out.println("Methods 2:\n==========\n");
		
		/* # 0 */ System.out.println("=> main method \n");

		// method with scanner
		Scanner kb = new Scanner(System.in); // initiate scanner
		System.out.println("Enter int input 1:"); // letting the user know he needs to insert something in keyboard
		int s1 = kb.nextInt(); // initiate integer variable that hold value from scanner
		System.out.println("Enter int input 2:");
		int s2 = kb.nextInt();
		
		System.out.println("\n"+"sum #1: direct sum calculation");
		System.out.println((s1 + s2) + " is the sum of: " + s1 + " and " + s2);
		
		System.out.println("\n"+"sum #2: sum calculated by using method");
		System.out.println(returnSum(s1, s2) + " is the sum of: " + s1 + " and " + s2);

		// -------------------------------------------------------------		
		// close all scanner objects			
		kb.close();
		
		// =================================
		System.out.println("\n--- end ---");

	} // end of main
	
	/** METHODS (out-side of 'main'): */
	// a method that gets value of 2 integers and returns their sum
	public static int returnSum(int a, int b) {
		int sum = a+b;
		return sum;
	}

}
//comments: /* /** */