package g_java.dataStructures;

import java.util.ArrayList;
import java.util.Collections;

public class Collection_exercises1 {

	public static void main(String[] args) {
		System.out.println("DataStructure collections:\n==========================\n");
		
		/** COLLECTIONS
		*/
		// creating collection Type: ArrayList of objects: <String> (don't mix up ArrayList class with array - its not the same)
		ArrayList<String> listOfCountries = new ArrayList<String>();
		// adding elements to the ArrayList 
		listOfCountries.add("israel");
		listOfCountries.add("usa");
		listOfCountries.add("japan");
		listOfCountries.add("mexico");
		listOfCountries.add("australia");
		
		// print using 'for' loop (note: it can also be done using for each - see below)
		System.out.println("print array elements as added:");
		for (int i = 0; i < listOfCountries.size(); i++) { // going over all cells in collection & print it
			System.out.println("- " + listOfCountries.get(i));
		}
		// printing the unsorted ArrayList
		System.out.println("Before Sorting (pre .sort): "+ listOfCountries); 
		// Sorting Collection in ascending Order
		Collections.sort(listOfCountries); // this sorts the array using a dedicated class (needs import)
		// printing the sorted ArrayList
		System.out.println("After Sorting (post .sort): "+ listOfCountries); 
	
		System.out.println(System.lineSeparator());
		// ----------------------------------------
		
		// 2 Examples of loop over the collection:
		System.out.println("==> looping A over the collection:");
		// a) using for
		String stringToCheck = "us";
		for (int i = 0; i < listOfCountries.size() ; i++) { // oppose to using .length in simple Array
			if (listOfCountries.get(i).contains(stringToCheck)) {
				System.out.println(listOfCountries.get(i) + " contains: " + stringToCheck);
			} else {
				System.out.println(listOfCountries.get(i) + " NOT contains: " + stringToCheck);
			}
		}
		System.out.println("\n==> looping B over the collection:");
		// b) using for each
		for (String string : listOfCountries) { // going over all cells in collection: 'aList' & fetch me each cell value of Type: 'String' into: 'string' temp variable
			if (string.contains("us")) { // if something
				System.out.println(string + " contains 'us'"); // do something
			}
		}
		// =================================
		System.out.println("\n--- end ---");
	} // end of main
	/** METHODS (out-side of 'main'): */	
}
