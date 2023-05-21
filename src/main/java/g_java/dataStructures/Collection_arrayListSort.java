package g_java.dataStructures;

import java.util.*;

public class Collection_arrayListSort {

	public static void main(String[] args) {
		System.out.println("DataStructure 3:\n================\n");
		
		/** How to Sort ArrayList in Java in ascending and descending order - https://www.javatpoint.com/how-to-sort-arraylist-in-java
			in Java, Collection is a framework that provides interfaces (Set, List, Queue, etc.)
			and classes (ArrayList, LinkedList, etc.) to store the group of objects. these classes store data in an unordered manner.
			sometimes we need to arrange data in an ordered manner which is known as sorting.
			the sorting can be performed in two ways either in ascending or descending order.

			in Java, ArrayList is a class of Collections framework that is defined in the java.util package.
			it inherits the AbstractList class. it dynamically stores the elements.
			the advantage of ArrayList is that it has no size limit. it is more flexible than the traditional array.
			it may have duplicate elements. we can also use all the methods of List interface because it implements the List interface.

			we can sort an ArrayList in two ways ascending and descending order.
			the Collections class provides two methods to sort an ArrayList in Java:
			-	sort()
			-	reverseOrder()
		 */// -------------------------------------------
		System.out.println("List #1 - INIT & ADD ");
		
		// https://www.geeksforgeeks.org/initializing-a-list-in-java/
		// For ArrayList:
        List<Integer> listInt1 = new ArrayList<Integer>();
        // Instantiating list using Collections.addAll() is also an option:
        // Collections.addAll(list, 1, 2, 3); // to add at once instead of one at a time...
        listInt1.add(1);
        listInt1.add(2);
        listInt1.add(3);
        System.out.println("listInt1 all: " + listInt1.toString());
        System.out.println("listInt1 gt0: " + listInt1.get(0).toString()); // 0 is the first limb
        
        // Instantiating List using Arrays.asList()
        List<Integer> listInt2 = Arrays.asList(1, 2, 3);
        System.out.println("listInt2 all: " + listInt2.toString());
        System.out.println("listInt2 gt1: " + listInt2.get(1).toString());
        
        // Instantiating List another way using Arrays.asList()
        List<Integer> listInt3 = new ArrayList<>(
                Arrays.asList(1, 2, 3));
        System.out.println("listInt2 all: " + listInt3.toString());
        System.out.println("listInt2 gt2: " + listInt2.get(2).toString());
        listInt3.add(4);
        System.out.println("listInt2 all: " + listInt3.toString());

        // ----------------------------------------
     	System.out.println(System.lineSeparator());
     	// ----------------------------------------
		System.out.println("List #2 - SORT String");
		
		// creating object of ArrayList class for Strings
		ArrayList<String> listS = new ArrayList<String>(); // import java.util.*;
		
		// adding elements to the ArrayList
		listS.add("KIA");
		listS.add("Toyota");
		listS.add("Audi");
		listS.add("BMW");
		
		// printing the unsorted ArrayList
		System.out.println("ArrayList S Before Sorting: "+ listS); // Before Sorting: [KIA, Toyota, Audi, BMW]
		
		// Sorting ArrayList in ascending Order
		Collections.sort(listS);
		
		// printing the sorted ArrayList
		System.out.println("ArrayList S After Sorting ASC: "+ listS); // After Sorting (by A to Z): [Audi, BMW, KIA, Toyota]
		
		// using Collection.sort() method
		Collections.sort(listS, Collections.reverseOrder());   
		// Print the sorted ArrayList   
		System.out.println("ArrayList S After Sorting DECE: "+ listS); // After Sorting (by Z to A): [Toyota, KIA, BMW, Audi] 
		
		// ----------------------------------------
		System.out.println(System.lineSeparator());
		// ----------------------------------------
		System.out.println("List #3 - SORT Number");
		
		//creating an object of ArrayList class for Ints
		ArrayList<Integer> listI = new ArrayList<Integer>();
		listI.add(55);
		listI.add(34);
		listI.add(98);
		listI.add(67);
		listI.add(39);
		listI.add(76);
		listI.add(81);
		
		//printing ArrayList before sorting
		System.out.println("ArrayList I Before Sorting:");
		for(int num: listI)
		{
			System.out.println(num);
		}
		
		//sorting ArrayList in ascending order  
		Collections.sort(listS);
		
		//printing ArrayList after sorting
		System.out.println("ArrayList I After Sorting ASC:");
		for(int num: listI)
		{
			System.out.println(num);
		}
		
		//sorting ArrayList in descending order
		 Collections.sort(listI, Collections.reverseOrder());
		 
		//printing ArrayList after sorting
		System.out.println("ArrayList I After Sorting DECE:");
		for(int num: listI)
		{
		System.out.println(num);
		}
		
		// ----------------------------------------
		System.out.println(System.lineSeparator());
		// ----------------------------------------
		System.out.println("List #4 - COMPARE");
		
		//creating 2 objects of ArrayList class, for compare
		ArrayList<String> list = new ArrayList<>(Arrays.asList("a", "b", "c"));
		ArrayList<String> equalList = new ArrayList<>(Arrays.asList("c", "b", "a"));
		ArrayList<String> diffList = new ArrayList<>(Arrays.asList("a", "b", "d")); //c and d are changed

		Collections.sort(list);
		Collections.sort(equalList);
		System.out.println(list.equals(equalList)); // true -> after sorting both, they match !!!

		Collections.sort(diffList);
		System.out.println(list.equals(diffList));// false -> after sorting both, they don't match !!!
		
		ArrayList<String> listOne = new ArrayList<>(Arrays.asList("a", "b", "c", "d"));
		ArrayList<String> listTwo = new ArrayList<>(Arrays.asList("a", "b", "e", "f"));
		
		// find additional items in listOne
		listOne.removeAll(listTwo);
		System.out.println(listOne);  // [c, d]
		/*
		// find missing items in listOne
		listTwo.removeAll(listOne);
		System.out.println(listTwo);  // [e, f]
		 */
		
		// =================================
		System.out.println("\n--- end ---");
	} // end of main
	/** METHODS (out-side of 'main'): */
}

/// ~~~	END ~~~ ||||||||||||||||||||||||||||||||||||||||||||||||||||||||||||||||||||||||||||||||||||||||||||||||||||||||||||||||||||||||
/**~~~~~~~~~~~~
	Notes ->
~~~~~~~~~~~~~~~
More links relevant to sort Collection:
https://www.baeldung.com/java-sort-list-alphabetically
https://stackoverflow.com/questions/708698/how-can-i-sort-a-list-alphabetically
https://www.delftstack.com/howto/java/sort-a-list-alphabetically-in-java/
geeksforgeeks.org/java-program-to-sort-names-in-an-alphabetical-order/
https://www.tutorialspoint.com/how-to-sort-a-string-in-java-alphabetically-in-java
https://www.javatpoint.com/how-to-sort-a-list-in-java

https://howtodoinjava.com/java/collections/arraylist/compare-two-arraylists/

https://stackoverflow.com/questions/9602579/how-to-compare-two-liststring-to-each-other
    /// <summary>
    /// Compares two string lists using LINQ's SequenceEqual.
    /// </summary>
    public bool CompareLists1(List<string> list1, List<string> list2)
    {
        return list1.SequenceEqual(list2);
    }

    /// <summary>
    /// Compares two string lists using a loop.
    /// </summary>
    public bool CompareLists2(List<string> list1, List<string> list2)
    {
        if (list1.Count != list2.Count)
            return false;

        for (int i = 0; i < list1.Count; i++)
        {
            if (list1[i] != list2[i])
                return false;
        }

        return true;
    }
*/

