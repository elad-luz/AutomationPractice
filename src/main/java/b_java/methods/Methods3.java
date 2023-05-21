package b_java.methods;

import java.util.Scanner;

public class Methods3 {

	public static void main(String[] args) {
		System.out.println("Methods 2:\n==========\n");
		
		/* # 0 */ System.out.println("=> main method \n");

		// array in a method    
		printArray(new int[]{3, 1, 2, 6, 4, 2});
		System.out.println("\n");
		sumArray(new int[]{3, 1, 2, 6, 4, 2});
		System.out.println("\n");
		maxArray(new int[]{3, 1, 2, 6, 4, 2});
		System.out.println("\n");
		
		// or		
		int[] myArray = {3, 1, 2, 6, 4, 2};
		printArray(myArray);
		System.out.println("\n");
		sumArray(myArray);
		System.out.println("\n");
		maxArray(myArray);
		
		// PRIME or not ?
		int numP = 1;
		System.out.println("\n? is "+ numP +" a Prime number => "+ isPrime(numP));
		
		// isPrime using scanner:
		Scanner s = new Scanner(System.in);
		System.out.print("Enter a number : ");
		int n = s.nextInt();
		if (isPrime(n)) {
			System.out.println(n + " is a prime number");
		} else {
			System.out.println(n + " is not a prime number");
		}
		s.close();

		// isPrime using while using array:
		System.out.println("print only prime numbers from array of numbers:");
		int[] numberArray = {23,1,2,3,4,5,6,8,9,0,11,342,27,17,25,61,62,71,72,82,83,89};
		for(int i = 0 ; i < numberArray.length ; i++)
		{
			if (isPrime(numberArray[i]) == true ){
				System.out.print(numberArray[i]+", ");
			}
		}
		// =================================
		System.out.println("\n--- end ---");

	} // end of main
	
	/** METHODS (out-side of 'main'): */
	
	// print all the array elements
	public static void printArray(int[] array) {
		System.out.print("all array cells values: " + "\n");
		for (int i = 0; i < array.length; i++) {
			System.out.print(array[i] + ", ");
		}
	}

	// print summing of all elements in array
	public static void sumArray(int[] array) {
		int total = 0;
		for (int i = 0; i < array.length; i++) {
			total = total + array[i]; // or: total += array[i];
		}
		System.out.println("summing all cells in array gives: " + total);
	}

	// find and print the largest element in an array
	public static void maxArray(int[] array) {
		int max = array[0];
		for (int i = 1; i < array.length; i++) {
			if (array[i] > max) max = array[i];
		}
		System.out.println("Biggest cell value in array is: " + max);
	}

	// this method (out-side of 'main') will get int -and- will return if prime or not
	public static boolean isPrime(int n) {
		if (n<= 1) {
			return false;
		}
		for (int i = 2; i< n; i++) {
			if (n % i == 0) {
				return false;
			}
		}
		return true;
	}
	
	/* this is another way a method can check if given integer is a prime number:
	public static boolean isPrime(int number){
		int top = (int)(Math.sqrt(number))+1; // <= this do...?
		for (int i=2;i<top;i+=2){
			 if(number%i == 0)
				 return false;
		}
		return true;
		}
	*/
}
