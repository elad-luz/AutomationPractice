package g_java.exceptions;

import java.util.InputMismatchException;
import java.util.Scanner;

public class Exceptions_4 {

	public static void main(String[] args) {
		System.out.println("Exceptions 4:\n=============\n");

		System.out.println("1)"); // this example is for String
		// it is the same as could have been displayed for any object which was not initialized (e..g. Dog rex = null;)
		String name = "Elad";
		String substr = null; // "el" => OK -or- null => NullPointerException... (null object = not initialized)
		try {
			if (name.toLowerCase().contains(substr)) {
				System.out.println(name + " includs: " + substr);
			}
		} catch (NullPointerException e) { // changed Exception to NullPointerException (to be precise, if I want to deal with all kind of exceptions in the same way, we can leave it it)
			e.printStackTrace();
		}
		System.out.println("end of section 1");
		
		System.out.println(System.lineSeparator());
		// ----------------------------------------

		System.out.println("2) ...");
//		Object name = new Constructor(input);
		Scanner scn = new Scanner(System.in);
		System.out.println("enter your age:");
		int age = 0;
		// age = scn.nextInt();
		// what will happen if you enter String instead of int ?
		// you will get InputMismatchException stack that point to the line of code you written & all stack of classes leading to it...
		try {
			age = scn.nextInt();
		} catch (InputMismatchException e) { // needs import
			e.printStackTrace();
			System.out.println("your input was invalid > requested number (int) only");
		} catch (Exception ex) { // all other exceptions, beside the one already stated
			ex.printStackTrace();
			System.out.println("you got exception");
		} finally { // this block is what to do at last, regardless of try-catch result
			scn.close();
		}
		System.out.println("age: " + age);

		System.out.println("end of section 2");

		// =================================
		System.out.println("\n--- end ---");
	}  // end of main
	/** METHODS (out-side of 'main'): */
	
}
