package k_java.findLongestSubString;

public class _MainProblem2 {

	public static void main(String[] args) {
		System.out.println("Problem 2:\n==========\n");
		/** problem: finding the longest sub-string of the same char, within string of chars:
			given String 'atddueeebbgg' - what's the sub-string of char & where does it start
			in this case 'eee' is the answer  it starts at place #6
			so we would like to put this String into collection or Array =>
			search google for: "convert string to char array java example".
			then we will put on our logic onto that array - what is that logic & how to do it
			we'll have variables to assist, and we will compare each char to the next in line
			- if it is the same > the sub-string counter must grow in one => continue to next
			- if it is NOT the same > check if current sub-string's the largest and set it as
			  my maxCounter, Keep start place, Reset & Continue on to the next char in line !
			what logic will happen in code:
			index i = 0 => index running over array in loop...
			int counter = 1; // counts the appearances of a given char
			int maxCounter = 1; // keep record of the max counter counted
			int position = 0; // the first char in array is in position 0
			when comparing 1st to 2ed, because they are not the same, only i will change to 1
			2ed to 3ed => only i changed to 2
			3ed to 4th > they are the same => i =3, Counter =2
			4th to 5th > not the same => i =4, Counter reset =1, maxCounter =2, position =2 !
		 */
		// code
		String s ="atddueeebbgg";
		char[] c = s.toCharArray(); // turning the String into an array of chars
		
		int counter = 1;
		int maxCounter = 1;
		int position = 0;
		/** logic
			check if the current char is equal to the next
			> Yes => increase counter by 1
			> No! => check if the counter is bigger then maxCounter (set position, maxCounter, reset counter)
		 */
		
		for (int i = 0; i < c.length-1; i++) { // run till 1 before last (because the last one can't be compared to none)
			if (c[i] == c[i+1]) {
				counter++; // counter = counter +1 ;
			}
			else {
				if (counter > maxCounter) {
					maxCounter = counter;
					position = i -counter +1; // (to set the start position of sub-string, take i (last arrival in sub-string) and deduct from it the counter (length of sub-string) plus one (because we start with zero)
					counter = 1; // reset counter
				}
			}
		}
		System.out.println("char: " + c[position]);
		System.out.println("position = " + position);
		System.out.println("maxCounter = " + maxCounter);

		// =================================
		System.out.println("\n--- end ---");
	} // end of main	
	/** METHODS (out-side of 'main'): */	
   // a method that do...
}
