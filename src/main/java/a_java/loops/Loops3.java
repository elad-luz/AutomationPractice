package a_java.loops;

import java.util.Scanner;

public class Loops3 {

	public static void main(String[] args) {
		System.out.println("Loops 4:\n========");

		/* # 1 */ System.out.println("\n #1 ) while loop with scanner & break");
		
		Scanner input1 = new Scanner(System.in);
		int w;
		System.out.println("Enter any int (will loop only if: 0 < int < 6)"); // letting the user know he needs to insert int (+ hint)
		w = input1.nextInt(); // set variable value from scanner
		System.out.println("you chose:" + w);
		while((w > 0) && (w < 6)) { // true only for: 0 < w < 6
			System.out.println("loop #"+ w);
			w++; // increment iterator
			System.out.println(" --- if "+ w +" < 6 it will loop again, else not");
			if(w == 4) { // will break upon iterator equal 4
				System.out.println(w +" => reached loop break");
				break;
			}
		}

		/* # 2 */ System.out.println("\n #1 ) complex combined loop with scanner & conditions to get 'age' int & print its verbal 'gil status' accordingly:"); 
		
		Scanner input2 = new Scanner(System.in); // declare and initialize scanner
		int age;  // declare a variable for age
		char gil; // declare a variable for status (that would be determined by age according to conditions) 
		int r = 9; // declare & initialize with value, a variable for loop recurrences max iterations
		System.out.println("run the loop for " + r + " times:");

		for(int i = 1 ; i <= r ; i++ ) // for loop control block - to define iterator start, end loop condition - to run till iterator counter reaches 9 loop recurrences (variable r above)
		{
			if (i == 1) // several conditions according to iterator value for making decision, regarding what to print to user on each recurrence
				System.out.println("iteration #"+ i +" out of "+ r +" => Enter int for 'age' & get 'gil status' (use:  -1)"); // #1 => print in loop what you want user to input
			else if (i == 2)
				System.out.println("iteration #"+ i +" out of "+ r +" => Enter int for 'age' & get 'gil status' (use:   0)"); // 2
			else if (i == 3)
				System.out.println("iteration #"+ i +" out of "+ r +" => Enter int for 'age' & get 'gil status' (use:   1)"); // 3
			else if (i == 4)
				System.out.println("iteration #"+ i +" out of "+ r +" => Enter int for 'age' & get 'gil status' (use:  18)"); // 4
			else if (i == 5)
				System.out.println("iteration #"+ i +" out of "+ r +" => Enter int for 'age' & get 'gil status' (use:  28)"); // 5
			else if (i == 6)
				System.out.println("iteration #"+ i +" out of "+ r +" => Enter int for 'age' & get 'gil status' (use:  68)"); // 6
			else if (i == 7)
				System.out.println("iteration #"+ i +" out of "+ r +" => Enter int for 'age' & get 'gil status' (use:  88)"); // 7
			else if (i < r)
				System.out.println("iteration #"+ i +" out of "+ r +" => Enter int for 'age' & get 'gil status' (use: any)"); // 8
			else if  (i == r)
				System.out.println("iteration #"+ i +" out of "+ r +" => Enter int for 'age' & get 'gil status' (last one)"); // 9 (last iteration as defined, if more you'll see this again)


			age = input2.nextInt();  // initialize the 'age' variable value from scanner inserted input (as recommended in each printout)
			System.out.println("your 'age' input was: " + age); // show the user what he chose

			// this is the Decision-Making for initializing the 'gil' variable with value, according to given conditions (per age => set status)
			if (age < 0) // condition for making decision
				gil = 'a'; // initialize the age status variable from decision made
			else if (age < 18)
				gil = 'b';
			else if (age == 18)
				gil = 'c';			
			else if (age > 68)
				gil = 'd';
			else
				gil = 'e'; // all other: 18 to 68 (not in use - will be set by default bellow)

			System.out.println("gil status is: " + gil); // print gil status as given by Decision made above

			// in this switch you print out the 'gil status' verbal reference according to fitting case out of the following
			switch (gil) { // switch cases and do the command
			case 'a': // under 0
				System.out.println("error - no age under 0 \n");
				break;
			case 'b': // under 18
				System.out.println("minor age, under 18 \n");
				break;
			case 'c': // exactly 18
				System.out.println("boom 18 years old \n");
				break;
			case 'd': // over 67
				System.out.println("over 68 years ! \n");
				break;
			default:  // if all cases returned False, do these commands (as fit case 'e')
				System.out.println("W.D.F. 18--68 \n");
				break;	
			}
		}
		// close scanners
		input1.close();    		
		input2.close();

		// =================================
		System.out.println("\n--- end ---");

		/* comments...
		 */

	}

}
