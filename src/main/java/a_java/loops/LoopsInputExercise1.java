package a_java.loops;

public class LoopsInputExercise1 {

	public static void main(String[] args) {
		System.out.println("Loops Exercise 1:\n=================");
		
		/* # 1 */ System.out.println("\n #1 ) Exercise: Print All Primal Numbers from 0 to 100 [solution by Gal]");
		
		// Primal can be only divided by 1 & itself with Modulo = 0 (no remainder)
		for (int i = 0; i <= 100; i++) { // go over on all numbers 0 to 100, increment iterator with 1 (i1 = i+1)
			int number = i; // declare the number checked and initiate it with correlative loop iterators' counter...
			boolean primalNumber = true; // assuming that a number is Primal, BUT then - lets check if it is (below)
			for (int j = 2; j < number; j++) { // no need to check 1 or the number itself, so those are loop bounds
				if (number % j == 0) { // check if rot any other number within boundaries - the actual number checked, can be properly divided with ?
					primalNumber = false; // if true, and any such is found=> set the actual checked number as Primal = false
					break; // as soon as one case found, its enough - the inner loop can stop (no need to go over the rest)
				}
			}
			if (primalNumber) { // still in outer loop - and if its true & inner loop did not state otherwise (false), the primalNumber is still 'true'
				System.out.println(number); // so print that number !
			} // and continue the outer loop till done !
		}

		// =================================
		System.out.println("\n--- end ---");

		/* comments...
		 */

	}

}
