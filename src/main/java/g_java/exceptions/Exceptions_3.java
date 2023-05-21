package g_java.exceptions;

public class Exceptions_3 {

	public static void main(String[] args) {
		System.out.println("Exceptions 3:\n=============\n");

		System.out.println("1)"); // ARRAY Exceptions

		// runtime exception
	    /* running this following code that looks for a value in a non existing array cell
			int[] arr = new int[2]; // Array defined with only 2 cells!
			arr[0] = 10;    // cell 1
			arr[1] = 11;    // cell 2
			arr[2] = 12;    // => Case 1 = cell 3 => this is out of bound
			int a = arr[4]; // => Case 2 = cell 4 => this is out of bound
		// results with exception in console: java.lang.ArrayIndexOutOfBoundsException
	   */
		
		int[] arr = new int[4];
		try {
			arr[0] = 10;
			arr[1] = 11;
			arr[2] = 12;
			arr[3] = 13;
			arr[4] = 14;
		} catch (ArrayIndexOutOfBoundsException e) {
			e.printStackTrace();
		}
		
		// the last one was not inserted (out of bound) but we can continue to loop over array...
		System.out.println("Print Array (4 cells):");
		for (int i = 0; i < arr.length; i++) {
			System.out.println(arr[i]);
		}
		System.out.println("end of section 1a");
		
		// or using for-each...
		for (int cell : arr) { // go over all cells in arr
			System.out.println(cell); // print cell
		}
		System.out.println("end of section 1b");
		
		System.out.println(System.lineSeparator());
		// ----------------------------------------

		System.out.println("2) ...");
		
		int x=4; // set index number of cell to query: 0 - 3 is OK (or 4 - for exception)
		try {
		int a = arr[x]; // display the value in cell
			System.out.println("cell value of index: " + x + " is: " + a);
		}
		catch(ArrayIndexOutOfBoundsException ex) {
			ex.printStackTrace();
			System.out.println("ooops... there is no cell index: "  + x);
		}
		System.out.println("end of section 2");
		
		// =================================
		System.out.println("\n--- end ---");
	}  // end of main
	/** METHODS (out-side of 'main'): */
}
