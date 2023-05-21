package g_java.dataStructures;

import java.util.*;

public class Collection_arrayList2Array {

	public static void main(String[] args) {
		System.out.println("DataStructure 2:\n================\n");
		
		/** How to Sort ArrayList in Java in ascending and descending order -
			https://www.geeksforgeeks.org/convert-list-to-array-in-java/
		 */// -------------------------------------
		/// Conversion of List to Array -> Using: toArray() -OR- get() method in a loop -OR- STREAM !
		// Creating an empty LinkedList of string type - by declaring object of List
        List<String> list = new LinkedList<String>();
 
        // Adding custom element to LinkedList - using add() method
        list.add("AA");
        list.add("BB");
        list.add("CC");
        list.add("DD");

        /// Converting List to array - using toArray()     <----- quicker !
        String[] arr = list.toArray(new String[0]);
        
        /// Converting ArrayList to Array - using get() method     <-----
//        int ls = list.size(); // Storing size of List if needed
//        String[] arr = new String[ls]; // new String[list.size()]; -> Storing it inside array of strings
//        for (int i = 0; i < list.size(); i++)
//           arr[i] = list.get(i);

        /// Converting List to array - using stream     <-----
//        String[] arr = list.stream().toArray(String[] ::new);

        
        // Printing elements of array - using for-each loop
        for (String x : arr)
            System.out.print(x + ", "); // Out-Put: AA, BB, CC, DD,

		// ----------------------------------------
		System.out.println(System.lineSeparator());
		// ----------------------------------------
		// ArrayList to Array Conversion -> Using: toArray() Methods
        List<Integer> al = new ArrayList<Integer>();
        al.add(11);
        al.add(22);
        al.add(33);
        al.add(44);
        
        /// Converting List to Object array     <-----
//        Object[] objects = al.toArray();
        /// Printing array of objects
//        for (Object obj : objects)
//            System.out.print(obj + ", "); // Out-Put: 11, 22, 33, 44,
        
        /// Converting List to Integer array     <-----
        Integer[] arrI = new Integer[al.size()];
        
        /// 1st. option - using toArray()
        arrI = al.toArray(arrI);

        /// 2ed. option - using get() in loop
//        for (int i = 0; i < al.size(); i++)
//            arrI[i] = al.get(i);
        
        // Printing elements of array - using for-each loop  
        for (Integer x : arrI)
            System.out.print(x + ", "); // Out-Put: 11, 22, 33, 44,

		// =================================
		System.out.println("\n--- end ---");
	} // end of main
	/** METHODS (out-side of 'main'): */
	
}

/// ~~~	END ~~~ ||||||||||||||||||||||||||||||||||||||||||||||||||||||||||||||||||||||||||||||||||||||||||||||||||||||||||||||||||||||||
/**~~~~~~~~~~~~
	Notes ->
~~~~~~~~~~~~~~~
*/

