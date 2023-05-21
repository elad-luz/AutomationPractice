package a_java.loops;

import java.util.Scanner;

public class Loops2 {

	public static void main(String[] args) {
		System.out.println("Loops 2:\n========");
		System.out.println("Loops  for & while, with scanner and decision making => Good Luck :-)");
		
		/* # 1 */ System.out.println("\n #1 ) for loop nested within a condition:");
		
		Scanner input1 = new Scanner(System.in); // initiate scanner from keyboard and giving it any name (e.g: "input1")
		int i;
		System.out.println("you are about to loop...");
		System.out.println("Enter a Number input here [choose: 0 (to loop) -or- other int (to stop)]:"); // letting the user know he needs to insert something in keyboard
		i = input1.nextInt();// set variable value from scanner
		System.out.println("you chose:" + i);

		System.out.println("for loop conditioned");{
			if (i == 0) { // only if input is 0 - do the loop is within...
				System.out.println("=> start"); // do this only if the above condition returns True!
				for(int f=1; f < 10 ; f=f+2 ){ // start with = 1, stop with > 10, jump every second
					System.out.println("print: " + f); // print: 1,3,5,7,9
				}
			}
			else{
				// otherwise, do this if the condition returns False
				System.out.println(i + " is 'else' (not zero), so loop is stopping");
			}
		}
		
		/* # 2 */ System.out.println("\n #2 ) another combination:");
		
		Scanner input2 = new Scanner(System.in);
		System.out.println("Enter int input (enter 2 for best view):"); // 2 will show all conditions
		int x = input2.nextInt(); // input will be used as loop iterator counter...
		System.out.println("your ninput was: " + x);
		System.out.println("\n");
		
		for (int z=x; z<=20; z=z+4) // start this loop with int (as entered by input), do loop till int <=10, each time increment counter by 4)
			{
				System.out.println("on #" + z);
		    if(z < 10) { // the if is within the loop
		        System.out.println(z + " < 10");
		    }
		    else if(z > 10) {
		        System.out.println(z + " > 10");
		    }
		    else
	        System.out.println(z + " = 10");
		    } // output for selecting 2: on #2 < 10, on #6 < 10, on #10 = 10, on #14 > 10, on #18 > 10

		System.out.println(System.lineSeparator());
		// ----------------------------------------
		
		/* # 3 */ System.out.println("\n #3 ) while loop with a condition:");
		
		Scanner input3 = new Scanner(System.in); // initiate scanner from keyboard and giving it any name (e.g: "input")
		int w;
		System.out.println("you are about to loop...");

		System.out.println("Enter a Number input here [choose: 0 (not to loop) or 1-9 (10 & up would result with an endless loop]:"); // letting the user know he needs to insert something in keyboard
		w = input3.nextInt(); // set variable value from scanner
		System.out.println("you chose:" + w);


		System.out.println("while loop will start only if input is greater then 0");
		while(w > 0) {
			System.out.println(w); // will print chosen int,+1,+1 till 9
			w++;
			if(w == 10) { // upon reaching 10 => break condition
				System.out.println("reached break");
				break;
			}
		}
		// closing input scanners
		input1.close();
		input2.close();
		input3.close();

		// =================================
		System.out.println("\n--- end ---");

		/* comments...
		 */

	}

}
