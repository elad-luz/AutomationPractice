package a_java.basics;

import java.util.Scanner;

public class D_ScannerInputExercise {

	public static void main(String[] args) {
		System.out.println("ScannerInput excersise:\n=======================");

		/* Exercise 1 */ System.out.println("\n #1");
		
		Scanner scanInput1 = new Scanner(System.in); // declare & initiate a Scanner object (interface for keyboard inputs)
		int i; // declare int variable
		System.out.println("enter an int value to var i");
		i = scanInput1.nextInt();
		int j;
		System.out.println("give an int value to var j");
		j = scanInput1.nextInt();
		System.out.println(
				"j value is: " + j + " and i is: " + i + ",\nchecking whether j value bigger then i: " + (j > i));

		Scanner scanInput2 = new Scanner(System.in);
		System.out.println("Enter your Full Name: ");
		String yourFullName = scanInput2.nextLine(); // several words, with spaces...
		System.out.println("Your Full Name is " + yourFullName);

		// close scanners afterwards!

		Scanner userInput = new Scanner(System.in); // initiate scanner from keyboard and giving it any name (e.g:
		// "userInputScanner")
		System.out.println("Enter a String input:"); // letting the user know he needs to insert something in keyboard
		String name; // initiate variable
		name = userInput.nextLine(); // saving the user input as a value for String variable [-- nextLine --]
		System.out.println("your name: " + name); // printing the variable value
		System.out.println("\n"); // printing empty new line

		Scanner newInput = new Scanner(System.in); // initiate scanner from keyboard and giving it any name (e.g:
		// "newInput")
		System.out.println("Enter a Number input"); // letting the user know he needs to insert something in keyboard
		int num = newInput.nextInt(); // saving the user input as a value for integer variable [-- nextInt --]
		System.out.println("your age: " + num); // printing the variable value

		Scanner keyboard = new Scanner(System.in); // initiate another scanner
		System.out.println("enter an integer - the returned value will be +1:"); // print in console
		int myint = keyboard.nextInt();
		System.out.println(myint + 1);

		// close all scanner objects - should be closed at the end...
		/* scanInput1.close(); // closing scanInput1 scanner
		scanInput2.close(); // closing scanInput2 scanner

		userInput.close(); // closing userInput scanner
		newInput.close(); // closing newInput scanner

		keyboard.close(); // closing keyboard scanner
		 */

		System.out.println(System.lineSeparator());
		// ----------------------------------------

		/* Exercise 2 */ System.out.println("\n #2");
		
		// initiate variable after define scanner:
		Scanner input1 = new Scanner(System.in); // define input scanner from keyboard
		System.out.print("NOTE - Enter an integer - scanner1:"); // notification print on console

		//The input provided by user is stored in num1
		int num1 = input1.nextInt(); // initiate variable + set value=scanner
		System.out.println("Your age is: " + num1 + " years old");

		System.out.println(System.lineSeparator());
		// ----------------------------------------

		// initiate variable before define scanner:
		int num2; // initiate variable
		System.out.println("NOTE - Enter an integer - scanner2:"); // notification print on console

		Scanner input2 = new Scanner(System.in);
		// The input provided by user is stored in num2
		num2 = input2.nextInt(); // set value=scanner

		System.out.println("Your age is: " + num2 + " years old");

		System.out.println("\n"); // adding empty line
		// -------------------------------------------

		// combined:
		Scanner input3 = new Scanner(System.in); // define input scanner from keyboard
		System.out.print("NOTE - Enter an integer - scanner3:"); // notification print on console

		int num3; // initiate variable
		// The input (provided by user) will be stored in num3 variable !
		num3 = input3.nextInt(); // initiate variable + set value=scanner
		System.out.println("Your age is: " + num3 + " years old");

		System.out.println("\n-end-"); // adding empty line + string...
		// ------------------------------------------------------------

		// close all scanner objects

		scanInput1.close(); // closing scanInput1 scanner
		scanInput2.close(); // closing scanInput2 scanner

		userInput.close(); // closing userInput scanner
		newInput.close(); // closing newInput scanner

		keyboard.close(); // closing keyboard scanner

		input1.close();
		input2.close();
		input3.close();

		// =================================
		System.out.println("\n--- end ---");

		/* comments...
		 */

	}

}
