package k_java.arraySorting;

public class SortFunction {

	public static int[] sortArrayAscending (int[] arrIn) { // gets int array input => return it in Ascending order (small to big)
		int[] arrOut; // declare for the return, the array output
		//SORT
		boolean swap = true; // declare & init a boolean var for tracking if swapping was made
		while(swap) { // while swap=true (swap was made) => cont.
			swap = false; // set it to false (to revert before continue)
			// for loop to check & sort array
			for (int i = 0; i < arrIn.length-1; i++) { // note: length-1 => because our last pair starts before array ends
				// check if need swap
				if (arrIn[i] > arrIn[i+1]) { // check & if not ordered ascending (need a swap) do the for loop
					int temp = 0; // temp var for swapping
					temp = arrIn[i]; // set first as temp int for swapping
					arrIn[i] = arrIn[i+1]; // swap a - give first the second value
					arrIn[i+1] = temp; // swap b - give the second, the temp value (possessing the first)
					swap = true; // set it to true (because swap was made) and continue to loop
				}
			}
		}
		arrOut = arrIn; // init the out array
		return arrOut;
	}
	
	public static int[] sortArrayDescending (int[] arrIn) { // gets int array input => return it in Descending order
		int[] arrOut; // declare for the return, the array output
		//SORT
		boolean swap = true; // declare & init a boolean var for tracking if swapping was made
		while(swap) { // while swap=true (swap was made) => cont.
			swap = false; // set it to false (to revert before continue)
			// for loop to check & sort array
			for (int i = 0; i < arrIn.length-1; i++) { // note: length-1 => because our last pair starts before array ends (big to small)
				// check if need swap
				if (arrIn[i] < arrIn[i+1]) { // check & if not ordered descending (need a swap) do the for loop
					int temp = 0; // temp var for swapping
					temp = arrIn[i]; // set first as temp int for swapping
					arrIn[i] = arrIn[i+1]; // swap a - give first the second value
					arrIn[i+1] = temp; // swap b - give the second, the temp value (possessing the first)
					swap = true; // set it to true (because swap was made) and continue to loop
				}
			}
		}
		arrOut = arrIn; // init the out array
		return arrOut;
	}
}
/* More links relevant to sort Collection:
https://www.baeldung.com/java-sort-list-alphabetically
https://stackoverflow.com/questions/708698/how-can-i-sort-a-list-alphabetically
https://www.delftstack.com/howto/java/sort-a-list-alphabetically-in-java/
geeksforgeeks.org/java-program-to-sort-names-in-an-alphabetical-order/
https://www.tutorialspoint.com/how-to-sort-a-string-in-java-alphabetically-in-java
https://www.javatpoint.com/how-to-sort-a-list-in-java
*/
