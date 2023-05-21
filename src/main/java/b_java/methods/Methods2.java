package b_java.methods;

public class Methods2 {

	public static void main(String[] args) {
		System.out.println("Methods 2:\n==========\n");

		/* # 0 */ System.out.println("=> main method \n");

		// using methods
		printName(); // 1
		printMyName("Elad", "Luz"); // 2 with variables in-side

		// initiate string variables that hold my first & last name
		String f = "first";
		String l = "last";
		// call method printName
		printMyName(f, l); // 2 with variables out-side

		int a = 3;
		System.out.println("number: " + a + " - bellow, add 5");
		printSum(a); // 3

		System.out.println("min value from: 3, 5, 1,  is: " + getMin(3, 5, 1)); // 4

		// =================================
		System.out.println("\n--- end ---");

	} // end of main

	/** METHODS (out-side of 'main'): */

	// a method that prints my name => 1
	private static void printName() {
		System.out.println("Elad Luz");
	}

	// a method printMyName, that prints first + last name from two string variables
	private static void printMyName(String myFirstName, String myFLasstName) {
		System.out.println(myFirstName + " " + myFLasstName);
	}

	// a method that prints int + 5 => 3
	private static void printSum(int j) {
		System.out.println(j + " + 5 = " + (j + 5));
	}

	// a method that gets minimal value out of 3 integers // 4
	private static int getMin(int x, int y, int z) {
		int min;
		if (x < y && x < z) {
			min = x;
		} else if (y < x && y < z) {
			min = y;
		} else {
			min = z;
		}
		return min;
	}

}
//comments: /* /** */