package g_java.dataStructures;

import java.util.ArrayList;

public class Collection_arrayList {

	public static void main(String[] args) {
		System.out.println("DataStructure 1:\n================\n");
		
		/** COLLECTION
			is framework that provide an architecture to store and manipulate a group of objects:
			array-list = a bit different from regular array, its more flexible, easier to operate
			using collection you don't need to define size - you create the object & add \ remove
			the list itself is an object and uses predefined methods, imported as a class of util
			when operating a loop on the List, use size instead of length & use: .get(i) for cell
			------
			import java.util.ArrayList; // import the ArrayList class
			ArrayList<data-type> cars = new ArrayList<data-type>(); // Create an ArrayList object
			List<data-type> cars = new ArrayList<data-type>(); // List - almost same as ArrayList
		*/
		// set collection Type: ArrayList of objects: <String>
		ArrayList<String> aList = new ArrayList<String>();
		// add to collection using .add
		aList.add("eladi");
		aList.add("eldad");
		aList.add("gilad");
		
		// print cell using .get
		System.out.println("first cell (0) is: " + aList.get(0));
		
		// print all list
		System.out.println("ArrayList values : " + aList);
		
		// print using loop going over all cells
		for (int i = 0; i < aList.size(); i++) {
			System.out.println(aList.get(i));
		}
		
		System.out.println("\n"); //-----------------------------------
	
		// add more to collection
		aList.add("ginad");
		aList.add("ligad");
		
		for (int i = 0; i < aList.size(); i++) {
			System.out.println(aList.get(i));
		}
		
		System.out.println("\n"); //-----------------------------------
		// remove from collection
		aList.add("elad");
		aList.remove("ligad");
		
		for (int i = 0; i < aList.size(); i++) {
			System.out.println(aList.get(i));
		}

		System.out.println(System.lineSeparator());
		// ----------------------------------------
		
		// 2 Examples of loop over the collection:
		// a) using for
		String stringToCheck = "lad";
		for (int i = 0; i < aList.size() ; i++) { // oppose to using .length in simple Array
			if (aList.get(i).contains(stringToCheck)) {
				System.out.println(aList.get(i) + " contains: " + stringToCheck);
			} else {
				System.out.println(aList.get(i) + " NOT contains: " + stringToCheck);
			}
		}
		
		// b) using for each
		String s="luz";
		for (String string : aList) { // going over all cells in collection: 'aList' & fetch me each cell value of Type: 'String' into: 'string' temp variable
			if (string.contains("elad")) { // if something
				System.out.println("\n" + string + " " + s); // do something
			}
		}

		// =================================
		System.out.println("\n--- end ---");
	} // end of main
	/** METHODS (out-side of 'main'): */
}
