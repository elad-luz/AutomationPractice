package b_java.methods;

public class MethodsExercise2 {

	public static void main(String[] args) {
		System.out.println("Methods exersise 2:\n===================\n");

		/* # 0 */ System.out.println("=> main method\n");
		
		System.out.println("minOf3"); // using: minOf3
		int n1 = 3;
		int n2 = 2;
		int n3 = 1;
		int min = minOf3(n1, n2, n3);
		System.out.println("the minimal of three numbers: "+ n1 +", "+ n2 +", "+ n3 +" is: "+ min);
		// using that method directly:
		System.out.println("minimal of (44,24,34) is: "+ minOf3(44,24,34));
		
		System.out.println(System.lineSeparator());
		// ----------------------------------------
		
		System.out.println("minOfArr"); // using: minOfArr
		int[] nums = {10,11,12,13,14,15,16,17,18,19}; // nums is the array we are going to check
		System.out.println("the minimal number from array is: "+minOfArr(nums));
		int minimal = minOfArr(nums);
		System.out.println("the minimal+1 = "+ (minimal+1));
		
		System.out.println(System.lineSeparator());
		// ----------------------------------------
		
		System.out.println("isValueExist"); // using: isValueExist
		int[] numsArray = {0, 12, 43, 24, 51, 26, 71, 38, 69, 80}; // given array
		int x = 52; // given number to check if exist in array
		System.out.println("is number exist in array: "+ isValueExist(x, numsArray));

		
		// =================================
		System.out.println("\n--- end ---");

	} // end of main

	/** # 1) this method will: find the minimal of given 3 int numbers (get 3 int num1,2,3 -&- return the minimal) */
	public static int minOf3(int a, int b, int c) {
		int min; // declare min without initiating...
		if (a < b && a < c) { // this checks if a is the minimal
			min = a; // initiating min with value of a
			// return a // you can do that if you think this case (checking all) is good enough...
		} else if (b < c) { // a is not minimal, so we check if b is
			min = b; // initiating min with value of b
		} else { // if b is also not minimal, then c is !
			min = c; // initiating min with value of c
		}
		return min;
	}
	// -----
	
	/** # 2) this method will: find the minimal of given int array (get int array -&- return the minimal int in array) */
	public static int minOfArr(int[] numbersArray) { // getting array - see bellow
		// int[] nums = {0,1,2,3,4,5,6,7,8,9}; you will get while using any such array
		int min = numbersArray[0]; // declare & initiate a min variable to find the smallest in array
		for (int i = 0; i < numbersArray.length; i++) { // looping over array
			if (numbersArray[i] < min) { // each found value that is smaller then min,
				min = numbersArray[i]; // will update the min to that smaller number !
			}
		}
		return min;
	}
	// -----
	
	/** # 3) this method will: find if a given  Value to check, exist in array of given 10 int numbers (get 1 int + array -&- return boolean) */
	public static boolean isValueExist(int checkNumber, int[] numbersArray) {
		boolean numExist = false; // Gal did it without boolean variable - see below
		for (int i = 0; i < numbersArray.length; i++) {
			if (numbersArray[i] == checkNumber) {
				numExist = true;
			}
		}
		return numExist;
	}
	/*  Gal did it without the boolean variable - because it is defined by method itself & not needed:
	 * 
/* 	public static boolean isValueExist(int checkNumber, int[] numbersArray) {
		for (int i = 0; i < numbersArray.length; i++) {
			if (numbersArray[i] == checkNumber) {
				return = true; // if found a match -> method will return true
			}
		}
		return false; // if no match was found -> method will return false
	}  
*/

}
// comments: /* /** */