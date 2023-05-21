package g_java.dataStructures;

import java.util.ArrayList;
import java.util.Collections;

public class Collection_exercises2 {

	public static void main(String[] args) {
		System.out.println("DataStructure collections:\n==========================\n");
		
		/** COLLECTIONS
			using a collection of numbers - you must specify <Integer> (class of objects), because the collection works on objects -
			note: don't mix up <Integer> objects with 'int' permeative variables => Integer is a class of int wrapped up in methods!
		*/
		// creating collection Type: ArrayList of objects: <Integer> (don't mix up ArrayList class with array - its not the same)
		ArrayList<Integer> listNum = new ArrayList<Integer>();
		// adding elements to the ArrayList 
		listNum.add(1);
		listNum.add(9);
		listNum.add(4);
		listNum.add(7);
		listNum.add(0);
		
		// print using 'for each' loop
		System.out.println("print array elements as added:");
		for (Integer i : listNum) { // going over all cells in collection & print it
				System.out.println(i);
		}
		// printing the unsorted ArrayList
		System.out.println("ArrayList values : " + listNum);
		
		// Sorting Collection in ascending Order
		Collections.sort(listNum); // this sorts the array using a dedicated class (needs import)
		
		// printing the sorted ArrayList
		System.out.println("ArrayList values Sorted : "+ listNum);
		// using a getMax method written bellow to fetch the max v
		
		System.out.println("get Max : " + getMax(listNum));
		// calling max() method of Collection
		Integer max = Collections.max(listNum);
		System.out.println("ArrayList max value : " + max);
		
		// calling min() method of Collection
		Integer min = Collections.min(listNum);
		System.out.println("ArrayList min value : " + min);

		// using a getMin method written bellow to fetch the min v
		System.out.println("get Min : " + getMin(listNum));

		// =================================
		System.out.println("\n--- end ---");
	} // end of main
	/** METHODS (out-side of 'main'): */

	// find largest element value in an array
	public static int getMax(ArrayList<Integer> listNum) {
		Collections.sort(listNum); // using predefined sort
		return listNum.get(listNum.size()-1); // get the last cell in array after sorting it => the size is the total number of cells -&- the -1 is because we start at zero !
	}
	
	// find minimal element value in an array
	public static int getMin(ArrayList<Integer> listNum) { 
		int min = listNum.get(0); // defined temp variable 'min' & give it the value of first cell (for later use & compare
		for (Integer num : listNum) { // go over all Integer cells in List => take each value (here refereed to as num)
			if (num < min) { // compare & if current cell is smaller then previous minimum
				min = num; // give the min its new value just found
			}
		}
		return min;
	}
	
}
