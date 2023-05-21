package b_java.methods;

import java.util.Scanner;

public class Methods5 {

	public static void main(String[] args) {
		System.out.println("Methods 2:\n==========\n");
		
		/* # 0 */ System.out.println("=> main method \n");

		// call method printName
		printName();
		
		// initiate string variables that hold my first & last name
		String myFirstName = "John";
		String myLastName = "Doe";
		printMyName(myFirstName, myLastName); // call method printName that print name from variables given
		
		//  initiate int variable that hold value
		int i;
		i=5;
		printSum(i); // call method printSum that print int (from given variable value) + 5
		
		// initiate scanner
		Scanner kb = new Scanner(System.in);
		System.out.println("enter int:"); // call method printSum that print int (from scanner input) + 5
		int s = kb.nextInt();
		printSum(s);
		
		// initiate 3 integers
		int a = 1;
		int b = 2;
		int c = 3;
		System.out.println("min value of:" + a + ", " + b + " and " + c + " is: " + getMin(a,b,c)); // print the returned minimal value found using getMin method
		kb.close();
		
		// =================================
		System.out.println("\n--- end ---");
		
	} // end of main
	
	/** METHODS (out-side of 'main'): */

	// a method that prints my name
	private static void printName() {
		System.out.println("Elad Luz");
	}
	
	
	// a method that prints first + last name from args
	private static void printMyName(String myFirstName, String myFLasstName) {
		System.out.println(myFirstName + " " + myFLasstName);
	}

	// a method that prints int + 5
	private static void printSum(int j) {
		System.out.println(j + " + 5 = " + (j+5));
	}

	// a method that gets minimal value out of 3 integers
	private static int getMin(int x, int y, int z) {
		int min;
		if(x<y && x<z){
		    min = x;
		}
		else if(y<x && y<z){
		    min = y;
		}
		else{
		    min = z;
		}
		return min;
	}

}
//comments: /* /** */