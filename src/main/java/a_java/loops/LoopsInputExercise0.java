package a_java.loops;

import java.util.Scanner;

public class LoopsInputExercise0 {

	public static void main(String[] args) {
		System.out.println("Loops Exercise 0:\n=================");

		/* # 0 */ System.out.println("\n #0 ) for loop printing iterator < 10 starting by scanner & using break if input=5"); // from Gal...
		
		Scanner kb = new Scanner(System.in);
		int inti;
		System.out.println("enter int from kb: 1, 5=break, 8 ==> loop will start with the given input, and will continue only till 10, adding one at a time:");
		inti = kb.nextInt(); // note the diff between input (=inti) & iterator (=i)
		for (int i=inti; i<=10; i++){ // loop will start with the given input as the iterators' counter, and will continue only till 10, adding one at a time
			if (inti == 5){ // if input value (=inti) is 5 it will break out of loop at once, but note that all other inputs will not break it !
				System.out.println("your input was 5, so loop is stopped!");
				break; // Break leaves the loop completely and executes the statements after the loop. Whereas Continue leaves the current iteration and executes with the next value in the loop
			}
			System.out.println(i); // will print the iterator =i (not the input =inti) - command out of loop
		}
		// closing kb scanner at the end of class!

		System.out.println(System.lineSeparator());
		// ----------------------------------------

		/* # 1 */ System.out.println("\n #1 )  for / while loops to print 1 -> 10");
		
		for (int ia = 1; ia <= 10; ia++) { // start loop iterators' counter with 1, stop at 10, increment by 1
			System.out.println(ia); // print the current iterators' counter
		}
		System.out.println("");
		
		int wa = 1; // wa will act as our "counter"!
		while (wa <= 10) {
			System.out.println(wa); // print iterator
			wa++; // afterwards increment iterator with 1 (w1 = w1+1)
		}
		
		/* # 2 */ System.out.println("\n #2 ) for loop to print 2 -> 12 even numbers");
		
		for (int ib = 2; ib <= 12; ib=ib+2) { // this case is simple to do by jumping the loop iterators' counter by 2 each time... [better to use "<=12" than "< 13" because it is more clear]
			System.out.println(ib);
		}
		System.out.println("");
		
		for (int ic = 1; ic <= 12; ic++) { // same as above but with "if" instead of hacking the loop iterators' counter...
			if (ic % 2 == 0) { // even number
			System.out.println(ic);
			}
		}

		/* # 3 */ System.out.println("\n #3 ) while loop to print 2 -> 12 even numbers");
		
		int wb = 2;
		while (wb <= 12) {
			System.out.println(wb);
			wb = wb+2; // this case is simple to do by jumping the loop iterators' counter by 2 each time...
		}
		System.out.println("");
		
		int wc = 1; // same as above but with "if" instead of hacking the loop iterators' counter...
		while (wc <= 12) {
			if (wc % 2 == 0) { // even number
				System.out.println(wc);
			}
			wc++; // +1
		}
		
		/* # 4 */ System.out.println("\n #4 ) for & while loops to print 11 -> 21 odd numbers (using if)");
		
		for (int id = 11; id <= 21; id++) { // same as above but for odd numbers (not even)
			if (id % 2 != 0) { // odd number
			System.out.println(id);
			}
		}
		System.out.println("");
		
		int wd = 10; // same as above but with while
		while (wd <= 21) {
			if (wd % 2 != 0) { // odd number
				System.out.println(wd);
			}
			wd++; // +1
		}

		System.out.println(System.lineSeparator());
		// ----------------------------------------

		/* # 5 */ System.out.println("\n #5 ) Complex AGE Exercise:");
		
		Scanner inputA = new Scanner(System.in);
		int iAge;
		System.out.println("please enter any int to iAge [note that negative int (e.g. -1), will stop the loop]:");
		iAge = inputA.nextInt();
		System.out.println("=> iAge was given the value: " + iAge);

		while (iAge >= 0) { // we look for positive age
			System.out.println(iAge + " is not negative so loop continues...");
			if (iAge == 0) {
				System.out.println(iAge + " (is 0) Born Now!!");
			}
			else if (iAge < 18) {
				System.out.println(iAge + " (under 18) is Katin!");
			}
			else if (iAge > 68) {
				System.out.println(iAge + " (over 68) is Pensioner!");
			}
			else {
				System.out.println(iAge + " (18 - 68) not Katin or Pensioner");
			}
			// this incrementation section happens 'within the loop', but not as part of the 'decision making' section, because regardless of print we need it for next iteration
			System.out.println("please enter another int to iAge [note that negative int (e.g. -1), will stop the loop]:");
			iAge = inputA.nextInt();
			System.out.println("=> iAge was given the value: " + iAge);
		}
		// upon iAge < 0  (e.g. -1) loop is not entered (as the while condition result is false) -- this printout is out of the loop, to print also in case of negative input !
			System.out.println(iAge + " is negative => loop stopped");

		System.out.println(System.lineSeparator());
		// ----------------------------------------

		/* # 6 */ System.out.println("\n #6 ) Complex Even-Odd Exercise:");
		
		Scanner inputB = new Scanner(System.in);
		System.out.println("please enter any int value to x [note: -1 will close the loop]:");
		int x = inputB.nextInt(); // declare & initiate at once...
		System.out.println("value given: "+ x);

		while (x != -1) {
			if (x % 2 == 0) { // if its an even number, print it
				System.out.println(x +" is an even number");
			}
			else { // if its NOT an even number, print it's odd
				System.out.println(x +" is an odd number");
			}
			// this incrementation section happens 'within the loop', but not as part of the 'decision making' section, because regardless of print we need it for next iteration
			System.out.println("please enter another int value to x [note: -1 will close the loop]:");
			x = inputB.nextInt();
			System.out.println("value given: "+ x);
		}
		System.out.println("-1 => loop stopped");  // this printout happens 'outside the loop', as while condition is false & you don't enter loop!

		System.out.println(System.lineSeparator());
		// ----------------------------------------

		/* # 7 */ System.out.println("\n #7 ) Complex multiply Exercise:");
		
		Scanner inputC = new Scanner (System.in);
		int y;
		System.out.println("please enter any int value to y [note: 0 will close the loop] to see its' multiply result:");
		y = inputC.nextInt();
		System.out.println("value given: "+ y);
		while (y != 0 ) {
			int z =y*y;		
			if (z >= 4) {
				System.out.println(y +" X "+ y +" = "+ z);
			}
			else {
				System.out.println("both -1 and 1 are not playing this multiply game!");
			}
			// this incrementation section happens 'within the loop', but not as part of the 'decision making' section, because regardless of print we need it for next iteration
			System.out.println("please enter aother int value to y [note: 0 will close the loop] to see its' multiply result:");
			y = inputC.nextInt();
			System.out.println("value given: "+ y);			
		}
		System.out.println("0 => loop stopped");
		
		/* Gal did it in a more simple way:
		-----------------------------------
		Scanner inputC = new Scanner (System.in);
		System.out.println("please insert a number [note: 0 will close the loop] to see its' multiplicity result:");
		int y = inputC.nextInt();
		while (y != 0 ) {
			System.out.println(y +" was selected - multiplicity will be printed if it is >= 4 (not for -1 or 1)");
			y = y*y;		
			if (y >= 4) {
				System.out.println("multiplicity result is: "+ y);
			}
			System.out.println("please enter another int value to y [note: 0 will close the loop] to see its' multiplicity result");
			y = inputC.nextInt();
		}
		System.out.println("0 => loop stopped => The End !");
		inputC.close();
		 */

		System.out.println(System.lineSeparator());
		// ----------------------------------------

		/* # 8 */ System.out.println("\n #8 ) using 'else if' in DecisionMaking to state if number is below 8 or above it");
		
		Scanner inputD = new Scanner(System.in);
		System.out.println("\n => enter int for variable numberS (0 is a loop breaker) & output will be if it is 8, below 8 or above it");
		int numberS = inputD.nextInt();
		
		while (numberS != 0) {
			System.out.println("number is "+ numberS);
			if (numberS == 8) {
				System.out.println("exact 8");
			} else if (numberS < 8) { // else if, because both conditions can't exist together
				System.out.println("below 8");
			} else if (numberS > 8) {
				System.out.println("above 8");
			}
			System.out.println("\n => enter int for variable numberS (0 is a loop breaker) & output will be if it is 8, below 8 or above it");
			numberS = inputD.nextInt(); // new input needed
			
		}
		System.out.println("0 is a loop breaker"); // print upon break out of loop

		// closing scanners
		kb.close(); 
		inputA.close();
		inputB.close();
		inputC.close();
		inputD.close();

		// =================================
		System.out.println("\n--- end ---");

		/* comments...
		 */

	}

}
