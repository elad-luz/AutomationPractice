package a_java.basics;

public class A_HelloPrint {

	public static void main(String[] args) {
		System.out.println("Hello Printout:\n==============="); // \n breaks the line
		/** Java "main" method is usually the first you learn when starting Java,
			because its the entry point for executing a Java program.
			The main method can contain code to execute or call other methods,
			and it can be placed in any class that's part of a program...
			Print to screen (syso) is the first thing top do --> "Hello world !".
			-> https://www.digitalocean.com/community/tutorials/public-static-void-main-string-args-java-main-method
			Note https://www.w3schools.com/java/default.asp
		*/
		/* # 1 */ System.out.println("\n #1 ) Print cases");
		
		/* Add your comments here:
		   The HelloWorld class implements an application that simply prints "Hello World!" to standard output.
		   Note: use // for one liner
		 */
		System.out.println("Hello world !");
		System.out.println("Lets start...");

		// type: syso + Ctrl + Space => Choose "System.out.println();"

		System.out.println(); // new line by printing nothing - not good!
		// System.out.println("\n"); // new line with another line
		System.out.println("\n line break\n============"); // using \n the breaks for line
		System.out.println("A"+ System.lineSeparator()+"B"); // line separator method
		System.out.println(System.lineSeparator()); // empty line
		// System.err.println(""); ???

		// Advanced using array (advances -> will be explained later on):
		int[] intArr = {1,2,3,4,5}; // Array
		for (int i = 0; i < intArr.length; i++) { // loop over array cells
			System.out.println(intArr[i]); // print all cells with line separator
		} // use print instead of println (not to use line separation)
		for (int i = 0; i < intArr.length; i++) { // loop over array cells
			System.out.print(intArr[i] +", "); // print all cells in same line with "," as separator
		}

		// =================================
		System.out.println("\n--- end ---");

	}

}
