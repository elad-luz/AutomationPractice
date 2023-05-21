package b_java.arrays;

public class Arrays1 {

	public static void main(String[] args) {
		System.out.println("Arrays 1:\n=========");
		
		/* # 1 */ System.out.println("\n #1 )");
		
		// arrays: data structure, which stores a fixed-size sequential collection of elements of the same type [array elements first index is # 0 and it is incrementing one each]
		// (define) declare and initialize int & string arrays with several elements
		int[] intArr = {2, 1, 0, 4, 3};
		String[] strArr = {"luz", "elad", "or", "itamar", "ofir"};	
		// for loop that prints all elements in array => (i) will represent the currant array cell position
		for(int i = 0 ; i < intArr.length ; i++) { // start with first cell=0 and go over all cells one by one till reaching the end
			System.out.println("intArr cell: "+ i +" -- value: "+ intArr[i]); // do this for each cell in array
		}
		// for loop that go over all elements in int array and decides which is the biggest
		int max = intArr[0]; // declare and initialize a variable 'max' for reference, with the value of first element in array to be used within loop
		for(int i = 0 ; i < intArr.length ; i++) { // loop will go over all elements in array
			if(intArr[i] > max) { // checks every element reached, if it is bigger than the variable 'max'
				max = intArr[i]; // if it is true to be bigger, set this element value instead of previous into 'max'
			}
		}
		System.out.println("intArr - element with biggest value: " + max); // print the proper element
		System.out.println("---\n");

		for(int i = 0 ; i < strArr.length ; i++) {
			System.out.println("strArr cell: "+ i +" -- value: "+ strArr[i]);
		}
		// for loop that go over all elements in str array and decides which contain a certain string
		String cs = "ad"; // declare and initialize a variable 'cs' with the certain string, to be compared if found in element
		for(int i = 0 ; i < strArr.length ; i++) { // loop will go over all elements in array
			if(strArr[i].contains(cs)) { // on every element reached, use a built-in method to check if it contains the certain string
				System.out.println("strArr - element containing '" + cs + "': "+ strArr[i]); // print the proper element
			}
		}

		System.out.println(System.lineSeparator());
		// ----------------------------------------

		/* # 2 */ System.out.println("\n #2 ) another way to print all elements:");
		
		double[] myList = { 1.9, 2.9, 3.4, 3.5 }; // array
		for (double element : myList) { // print loop
			System.out.println(element);
		}
		
		System.out.println(System.lineSeparator());
		// ----------------------------------------

		/* # 3 */ System.out.println("\n #3 )2D array:"); // see: https://www.educba.com/2d-arrays-in-java/
		
		// declaring and initializing 2D array
		int arr[][] = { { 1, 2, 3 }, { 2, 4, 5 }, { 4, 4, 5 } };
		// printing 2D array
		for (int i = 0; i < 3; i++) {
			for (int j = 0; j < 3; j++) {
				System.out.print(arr[i][j] + " ");
			}
			System.out.println();
		}

		// =================================
		System.out.println("\n--- end ---");

		/* comments...
		 */

	}

}
