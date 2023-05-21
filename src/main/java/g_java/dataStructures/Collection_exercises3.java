package g_java.dataStructures;

import java.util.ArrayList;
import java.util.Collections;

public class Collection_exercises3 {

	public static void main(String[] args) {
		System.out.println("DataStructure collections:\n==========================\n");
		
		/** notes*/
		// put Array into ArrayList collection

		long[] numbers = {10,30,5,6,8,29};
		for (long lArray : numbers) {
			System.out.println(lArray);
		}

		System.out.println("print sorted collection:");
		ArrayList<Long> list = arrayToCollection(numbers); // use method to put array to collection
		for (Long lCollection : list) {
			System.out.println(lCollection);
		}
		// =================================
		System.out.println("\n--- end ---");
	} // end of main
	/** METHODS (out-side of 'main'): */
	// Array To Collection which is sorted
	public static ArrayList<Long> arrayToCollection(long[] numbers) { // gets an array number of long type (as defined above -- don't mix up ArrayList class with array - its not the same)
		ArrayList<Long> list = new ArrayList<Long>(); // creating collection Type: ArrayList of objects: <Long>  note: don't mix up <Long> objects with 'long' permeative variables =>  it is a class of long wrapped up in methods!
		for (Long num : numbers) { // for each cell in numbers array, take its value into temp num variable
			list.add(num); // add the num value to the ArrayList
		}
		Collections.sort(list);
		return list; // ArrayList<Long>
	}

}
