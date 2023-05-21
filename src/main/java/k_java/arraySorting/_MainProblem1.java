package k_java.arraySorting;

public class _MainProblem1 {

	public static void main(String[] args) {
		System.out.println("Problem 1:\n==========\n");
		/** Sorting Bubbles method on int Array
		 */
		// array of integers un-sorted
		int [] intAarr = {4,2,6,8,9,3,1,7,0,5,11};
		
		// array before sorting
		System.out.println("array before sorting:");
		for (int i : intAarr) {
			System.out.println(i); // this show the order as inserted - not sorted
		}

		System.out.println(System.lineSeparator());
		// ----------------------------------------
		
		// use Ascending sort array method
		intAarr = SortFunction.sortArrayAscending(intAarr); // function input arrIn will get intAarr
		
		// after Ascending sorting method on array
		System.out.println("array after sorting Ascending:");
		for (int i : intAarr) {
			System.out.println(i); // this show the order as inserted - not sorted
		}
		
		System.out.println(System.lineSeparator());
		// ----------------------------------------

		// use Descending sort array method
		intAarr = SortFunction.sortArrayDescending(intAarr); // function input arrIn will get intAarr
		
		// after Ascending sorting method on array
		System.out.println("array after sorting Ascending:");
		for (int i : intAarr) {
			System.out.println(i); // this show the order as inserted - not sorted
		}

		// =================================
		System.out.println("\n--- end ---");
	} // end of main	
	/** METHODS (out-side of 'main'): */	
   // a method that do...
}
