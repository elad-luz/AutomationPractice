package a_java.loops;

public class Loops1 {

	public static void main(String[] args) {
		System.out.println("Loops 1:\n========");
		
		// The Java for loop is used to iterate a part of the program several times.
		// If the number of iteration is fixed, it is recommended to use for loop...

		/* # 1 */ System.out.println("\n #1 ) 'for' loop");
		
		// 'for' loop - use when you know in advance how many time to run the loop before 'break'= Exit !!!
		// for(<loop control block>) | loop control block: <declare  and initialize variable with value> ; <stop condition - to run till only if true> ; <incr/decr loop iterator counter>
		// note that you can initiate the variable before the loop (e.g. "int f;") - or from within the for loop...	
		for(int f = 1 ; f <= 5 ; f++ ) // can replace i with f ;)
		{
			System.out.println(f); // do this code block: print 1,2,3,4,5
		}

		/* # 2 */ System.out.println("\n #2 )'while' loop + break condition ");
		
		// 'while' loop - use when you don't know in advance how many times to run the loop (which will be decided upon each loop run) !!!
		// note that you must initiate the variable before the loop structure (e.g. "int w;)...	
		int w = 1;
		while(w <= 10) // condition to run till - loop will run as long as this while condition returns 'true'
		{
			System.out.println(w); // do this code block: print 1,2,3,4,5
			w++; // update loop iterator counter
			if(w == 6) // break point condition to exit loop if 'true' regardless of anything: stop the loop when i = 6 !!!
			{
				break;
			}
		}

		/* # 3 */ System.out.println("\n #3 ) 'do while' loop");
		
		// 'do while' - must run loop at-least once before first decision is made
		int d = 1;
		do {
			System.out.println(d); // code block to be executed:  print 1,2,3,4,5
			d++;
		}
		while(d < 6); // while (condition);

		System.out.println(System.lineSeparator());
		// ----------------------------------------
		
		/* # 4 */ System.out.println("\n #4 )");
		
		for (int i2 = 10 ; i2 <= 20 ; i2 = i2+2){
			System.out.println(i2 + " is an even number"); // print: 10,12,14,16,18,20
		}

		/* # 5 */ System.out.println("\n #5 )");
		
		for (int x2 = 10 ; x2 <= 20 ; x2 = x2+2){
			System.out.println(x2-1 + " is an un-even number"); // print: 9,11,13,15,17,19
		}
		
		/* # 6 */ System.out.println("\n #6 )");
		
		int iw = 0;
		while (iw < 10) {
			if(iw % 2 == 0) {
				System.out.println(iw + " is an even number"); // print: 0,2,4,6,8
			}
			iw=iw+2;
		}

		/* comments...
		boolean bb = true;
		do{
		}while(bb == true);
		 */
		// =================================
		System.out.println("\n--- end ---");

	}

}
