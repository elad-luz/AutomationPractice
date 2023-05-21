package b_java.methods;

import java.util.Scanner;

public class MethodsExercise3 {

	public static void main(String[] args) {
		System.out.println("Methods exersise 3:\n===================\n");

		/* # 0 */ System.out.println("=> main method\n");
		
		System.out.println("isEqualArrs"); // using: isEqualArrs
		int[] arrA = {00, 10, 20, 30, 40, 50, 60, 70, 80, 90};
		int[] arrB = {00, 10, 20, 30, 40, 50, 60, 70, 80, 90};
		
		System.out.println("bothe arrays equal? => "+ isEqualArrs(arrA, arrB));

		System.out.println(System.lineSeparator());
		// ----------------------------------------
		
		System.out.println("input numbers to array + work on it");
		
		// using: inputArr
		System.out.println("for ease use: 1,2,3,4,5 -or- 2,3,4,5,6");
		int[] arrTested = inputArr(); // this fill array with the inputs

		// using: maxOfArr
		System.out.println("\n> max int in Array is: "+ maxOfArr(arrTested));

		 // using: minOfArr
		System.out.println("\n> min int in Array is: "+ minOfArr(arrTested));

		// using: sumOfArr
		System.out.println("\n> sum int in Array is: "+ sumOfArr(arrTested));

		// using: avgOfArr
		System.out.println("\n> sum int in Array is: "+ avgOfArr(arrTested));

		// =================================
		System.out.println("\n--- end ---");

	} // end of main

	/** # 1) this method will: find the minimal of given 3 int numbers (get 3 int num1,2,3 -&- return the minimal) */
	public static boolean isEqualArrs(int[] array1, int[] array2) { // no need for a boolean variable, cause it is embedded in the method
		if (array1.length == array2.length) { // first, compare the size of both array
			for (int i = 0; i < array1.length; i++) { // loop over array
				if (array1[i] != array2[i]) { // compare each cell to see if there is a diff
					return false; // if there is a diff -> method return false 
				}
			} // if loop finished and all cells match, no diff was found -> method return true
			return true;
		} else { // this is for case the first if is false & size don't match (so you don't enter the loop)
			return false;
		}
	}
	// -----
	
	/** # 2) this method will: use scanner to fill int array of 5 (get nothing -&- return the array filled by input) */
	public static int[] inputArr() {
	Scanner input = new Scanner(System.in);
	int[] intArr = new int[5];
	for (int i = 0; i < 5; i++) {
		System.out.println("please enter int input:");
		intArr[i] = input.nextInt();
	}
	// print the array, to test inputArr method worked:
	System.out.print("input array is: ");
	for (int i = 0; i < intArr.length; i++) {
		System.out.print(intArr[i] +", ");
	}
	input.close();
	return intArr;
	}
	// -----
	
	/** # 2a) this method will: find max int in array of 5 (get array -&- return the max int) */
	public static int maxOfArr(int[] intArr) {
		int maxOfArr = intArr[0];
		for (int i = 0; i < intArr.length; i++) {
			if (intArr[i] > maxOfArr) {
				maxOfArr = intArr[i];
			}
		}
		return maxOfArr;
	}
	// -----
	
	/** # 2b) this method will: find min int in array of 5 (get array -&- return the min int) */
	public static int minOfArr(int[] intArr) {
		int minOfArr = intArr[0];
		for (int i = 0; i < intArr.length; i++) {
			if (intArr[i] < minOfArr) {
				minOfArr = intArr[i];
			}
		}
		return minOfArr;
	}
	// -----
	
	/** # 2c) this method will: find sum of cell values of array (get array -&- return the sum int) */
	public static int sumOfArr(int[] intArr) {
		int sumOfArr = 0;
		for (int i = 0; i < intArr.length; i++) {
			sumOfArr = sumOfArr+intArr[i]; // can use: sumOfArr += intArr[i];
		}
		return sumOfArr;
	}
	// -----
	
	/** # 2d) this method will: find avg of cell values of array (get array -&- return the avg int) */
	/* this is in many parts a duplicate of sum (written previously:
	public static double avgOfArr(int[] intArr) {
		int sumOfArr = 0;
		double avgOfArr;
		for (int i = 0; i < intArr.length; i++) {
			sumOfArr = sumOfArr+intArr[i];
		}
		avgOfArr = sumOfArr / intArr.length; 
		return avgOfArr;
	}
	*/ // SO, this could be reduced by reusing...
	public static double avgOfArr(int[] intArr) {
		int sum = sumOfArr(intArr); // use prev method to calculate the sum
		return sum / intArr.length; // return the calculated avg.
	}
}
// comments: /* /** */