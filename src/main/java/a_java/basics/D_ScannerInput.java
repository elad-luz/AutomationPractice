package a_java.basics;

import java.util.Scanner; // import the scanner method from java => don't forget to close scanner objects in use (at the end)

public class D_ScannerInput {

	public static void main(String[] args) {
		System.out.println("ScannerInput:\n=============");
		/** To declare & Init an Object of Scanner (for keyboard inputs to our program):
		Scanner scan = new Scanner(System.in);
		using methods like: .next(); /.nextInt(); /.nextLine(); /.useDelimiter(","); -- > See below...
		*/
		/* # 1 */ System.out.println("\n #1 ) Use scanner");
		
		Scanner scan = new Scanner(System.in); // declare an Object of Scanner = an interface for keyboard inputs to our program...(getting user input from KeyBoard)
		System.out.println("what is your first name? (enter string)");
		// scan.next(); // this will just give the option of input & will get the next word (non after space) till Enter button clicked but will not store it anywhere (needs an object to get it)
		String yourName = scan.next(); // here, the input user provide (type in) will be stored in a variable (as a string of one word only without spaces)
		System.out.println("yourName input is: "+yourName);
		// Note that if you use a string with a space in above scanner, the program will think its the second input 
		// Also, note that you will get an Exception if you try to enter a string instead of int to the next scanner that expect int only !!!
		System.out.println("what is your Age? (enter one string till space)");
		int yourAge = scan.nextInt(); // the input provided by user is stored in a variable (as an int)
		System.out.println("yourAge input is: " +yourAge);
		// Note that to overcome the above issue, you can set a new scanner (just make sure to close it eventually)
		Scanner input = new Scanner(System.in); // declare another Object of Scanner = an interface for keyboard inputs to our program...(getting user input from KeyBoard)
		System.out.println("what is your Adress? (enter several strings)");
		String yourAdress = input.nextLine(); // input stored in a variable (as an several words)
		System.out.println("yourAdress input is: " +yourAdress);

		System.out.println(System.lineSeparator());
		// ----------------------------------------
		
		// another way of using scanner as parser:
		String csv = "a,b,c,d,e";
	    Scanner scancsv = new Scanner(csv);
	    scancsv.useDelimiter(",");
	    while (scancsv.hasNext()) {
	      System.out.println(scancsv.next());
	    }

		System.out.println(System.lineSeparator());
		// ----------------------------------------
		
		// Do not forget to close all scanner objects at the end !!!
		scan.close(); // closing the 1st declared scanner
		input.close(); // closing the 2ed declared scanner
		
		scancsv.close();  // closing last scanner

		// =================================
		System.out.println("\n--- end ---");

		/* comments...
		 */

	}

}
