package b_java.arrays;

public class Arrays3 {

	public static void main(String[] args) {
		System.out.println("Arrays 3:\n=========");

		/* # 1 */ System.out.println("\n #1 ) Processing Arrays:");

		double[] myList = {1.9, 2.9, 3.4, 3.5};

		// Print all the array elements (using simple for loop)
		System.out.println("print all - way 1");
		for (int i = 0; i < myList.length; i++) {
			System.out.println(myList[i] + " ");
		}

		// Summing all elements
		double total = 0;
		for (int i = 0; i < myList.length; i++) {
			total = total + myList[i]; // (or: total += myList[i];) => adds to total current cell value and set as new total
		}
		System.out.println("Total is: " + total);

		// Finding the largest element
		double max = myList[0];
		for (int i = 1; i < myList.length; i++) {
			if (myList[i] > max)
				max = myList[i];
		}
		System.out.println("Max is: " + max);

		// Finding the smallest element	
		double min=myList[0];
		for(int m = 1 ; m < myList.length ; m++) {
			if(min > myList[m])
				min = myList[m];
		}
		System.out.println("Min is: " + min);

		System.out.println(System.lineSeparator());
		// ----------------------------------------

		/* # 2 */ System.out.println("\n #1 ) Looping over Array with 'for each':");
		
		// Print all the array elements => for each loop enables you to traverse the complete array sequentially without using an index variable
		
		int [] numbers = {10, 20, 30, 40, 50}; // declaration and initialization
		for(int x : numbers ) { // going over all array cells => x represent the cell in array that is being checked
			System.out.print( x ); // same line
			System.out.print(", ");
		}
		
		System.out.println("\n");
				
		int[] intArr = {1, 2, 3, 4};
		for (int element: intArr) {
			System.out.println(element); // line break
		}

		System.out.println("\n");
		
		String[] sArr = {"A", "B", "C", "D"};
		for (String element_X: sArr) {
			System.out.println(element_X); // line break
		}

		// =================================
		System.out.println("\n--- end ---");

		/* comments...
		 */

	}

}
