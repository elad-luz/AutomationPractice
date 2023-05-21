package a_java.loops;

import java.util.Scanner;

public class Loops0 {

	public static void main(String[] args) {
		System.out.println("Loops 0:\n========");
		
		// for loops: when you know when to start & end the loop
		
		/* # 1 */ System.out.println("\n #1 )");
		
		// loop use 'i' as iterator of loop runs => i is declared & initiated within the loop: for (int i = 0; ...) NOT out of it => do NOT declare it prepended as: int i; ==> then use in loop: for (i=0; ...) 
		for (int i = 0; i < 10; i++) { // (start with loop iterators' counter i=0, end condition to run till iterators' counter: i < 10, increment counter by one each time: i++ or i+1) => {d0: print i} loop again till end...
			System.out.println("i is: "+ i); // 1,2,3,4,5,6,7,8,9
		}
		
		/* # 2 */ System.out.println("\n #2 )");
		
		for (int i = 10; i <= 100; i = i+10) { // start with loop iterators' counter i=10, loop till i <= 100, increment i+10 => print i
			System.out.println("i is: "+ i); // 10,20,30,40,50,60,70,80,90,100
		}
		
		/* # 3 */ System.out.println("\n #3 )");
		
		for (int i = 0; i <= 10; i = i+2) { // start with loop iterators' counter i=0, loop till i <= 10, increment i+2 => print only even numbers
			System.out.println("i is: "+ i); // 0,2,4,6,8,10
		}
		
		/* # 4 */ System.out.println("\n #4 )");
		
		// combine a for loop with if condition statement...
		for (int i = 1; i < 100; i ++) { // start with loop iterators' counter i=1, loop till i < 100, increment i+1 => print only numbers that are a multiple of 9
			if (i % 9 == 0) { // i is a multiple of 9, if i/9 have no remain => modulo operation % returns the remainder of a division ! 
				System.out.println("i is: "+ i); // i is: 9,18,27,36,45,54,63,72,81,90,99
			}
		}
		
		/* # 5 */ System.out.println("\n #5 ) ");
		
		// nested loop - always use 'i' as iterator of first loop & 'j' as iterator of nested loop
		for(int i=1;i<=2;i++){ //loop of iterators' counter i start with 1 & run 2 times...
			for(int j=1;j<=2;j++){ //loop of j - do another loop starting with 1 & running 2 times
				System.out.println(i+"-"+j); // i-j  =>  1-1,1-2,2-1,2-2  [2 loops j in 2 loops i]
			}
		}
		
		/* # 6 */ System.out.println("\n #6 ) K ");
		
		// combine nested loop (prints a star pyramid)...	
		int term=5; // define when to terminate the loop iterators' counter
		for(int i=1;i<=term;i++){ // using termination variable in statement - loop will run 5 times
			for(int j=term;j>=i;j--){ // loop do another loop that printout * (term -1 times)
				System.out.print("* ");
			}
			System.out.println(); // new line
		}
		// same issue, but reverted...
		for(int i=1;i<=5;i++){ // loop iterators' counter (i) starts with 1, loop will run 5 times
			for(int j=1;j<=i;j++){ // loop do another loop that printout * (1 times) & increment i
				System.out.print("* ");
			}
			System.out.println(); // new line
		}

		/* # 7 */ System.out.println("\n #7 )");
		
		// using break condition in loops to stop the looping
        for (int i = 0; i < 10; i++) { // Initially loop is set to run from 0-9, 10 times (i = loop iterators' counter)
            // to terminate loop when i reach the value of 5, use break point condition
            if (i == 5) // if iterator reach value of 5, loop is stopped in this point -and- code continue out of the loop
                break;
            System.out.println("i: " + i); // when during loop, the action needed is print iterator i: 0,1,2,3,4, (till 5)
        } // then start loop again...
        System.out.println("Loop completed, you are out");

		/* # 8 */ System.out.println("\n #8 )");
		
		// for loop combined with a switch case condition
		for(int sw = 0; sw <= 10; sw++){ 
            switch(sw){
                case 1: case 2: case 3: case 4: // First state match 4 cases
                    System.out.println("1 - 4");
                    break;
                case 8: case 9: // Second state match 2 other cases
                    System.out.println("8 & 9");
                    break;
                default: //Default case
                    System.out.println("other");
                    break;
            }
        } // output: (0) other, (1) 1 - 4, (2) 1 - 4, (3) 1 - 4, (4) 1 - 4, (5) other, (6) other, (7) other, (8) 8 & 9, (9) 8 & 9, (10) other

		System.out.println(System.lineSeparator());
		// ----------------------------------------

		// The while loop loops through a block of code as long as a specified condition is true:
		
		/* # 9 */ System.out.println("\n #9 )");
		
		int i = 0; // start with loop iterators' counter i=0
		while (i < 5) { // run as long as 1<5
		  System.out.println(i); // do print of i
		  i++; // increment 1 by 1
		}
		
		// while loops when you don't know when to start & end the loop - it depends on the while condition so use a scanner input
		
		/* # 10 */ System.out.println("\n #10 )");
		
		Scanner scn = new Scanner (System.in);
		System.out.println("enter a number (use any int: -1, 1 -or- 0 to end loop)");
		int num = scn.nextInt();

		while (num != 0) { // or if you are not using num variable,  while (scn.hasNext() != 0) {
			System.out.println(num); // will stop the loop and not even print, only if you enter 0 !
			System.out.println("enter a number (use any int: -1, 1 -or- 0 to end loop)");
			num = scn.nextInt();
		}
		scn.close();
			
		System.out.println(System.lineSeparator());
		// ----------------------------------------	
		
		/* # 11 */ System.out.println("\n #11 ) commented out");
		
		/* Endless loop: bellow is a loop that will run indefinitely [to stop the loop run, click in the console red button]
		 * for (int e = 1; e > 0; e++) { // (start with e=1, run loop condition as long as e > 0 (always) -, increment e+1) => {d0: print e} loop again till end...
			System.out.println("e is: "+ e); // 1,2,3,...forever
		   }
		   
		 * int e = 1;
		   while(e < 2)
		   {
		   System.out.println(e);
		   }

		 * int x1 = 0;
		   while (x1 < 10) {
		   if(x1 % 2 == 0) {
		   System.out.println(x1 + " is an even number -- endless loop");
		   }
		   i1=i1+2;
		   }
		 */
		
		System.out.println("\n"); // -------
	
		// ALSO: "for-each" loop, which is used exclusively to loop through elements in an array (see later on)
		System.out.println("print cars from array:");
		String[] cars = {"Volvo", "BMW", "Ford", "Mazda"}; // array of cars
		for (String x : cars) { // loop over array & print each
		  System.out.println(x);
		}

		// =================================
		System.out.println("\n--- end ---");

		/* comments...
		 */

	}

}
