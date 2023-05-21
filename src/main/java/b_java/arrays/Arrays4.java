package b_java.arrays;

public class Arrays4 {

	public static void main(String[] args) {
		System.out.println("Test exersise:\n==============");
		
		/* # 1 */ System.out.println("\n #1 ) swich cells in array");
		
		long[] numbers = {10, 20, 30, 40, 50}; // declare & init at once in one line
		System.out.print("array {");		  // print nicely...
		for (int i = 0; i < numbers.length; i++) {
			if (i != numbers.length -1 ) { // if not last
				System.out.print(numbers[i]+", ");
			} else { // upon last
				System.out.print(numbers[i]+"}");
			}
		}

		System.out.println(System.lineSeparator());
		System.out.println("switched cells in array (first to last etc.)");

		for (int i = 0; i < numbers.length /2; i++) { // note that you need to stop at the middle unless the revert would be reverted back to orig state !
			long tempL = numbers[i]; // temp var
			numbers[i] = numbers[numbers.length-1-i]; // for example 2ed would be swapped with one before last (length start with 1 & array starts with 0)
			numbers[numbers.length-1-i] = tempL;
		}
		System.out.print("array {");		  // print nicely...
		for (int i = 0; i < numbers.length; i++) {
			if (i != numbers.length -1 ) { // if not last
				System.out.print(numbers[i]+", ");
			} else { // upon last
				System.out.print(numbers[i]+"}");
			}
		}
		
		System.out.println(System.lineSeparator());
		// ----------------------------------------

		/* # 2 */ System.out.println("\n #2 ) 2 arrays: students & grades - find max");
		int[] grades = {93, 91, 87, 89, 99, 90};
		String[] students = {"St.1","St.2","St.3","St.4","St.5","St.6"};
		int max = grades[0];
		String name = students[0];
		for (int i = 0; i < students.length; i++) {
			if (grades[i] > max) {
				max = grades[i];
				name = students[i];
			}
		}
		System.out.println(name+ " => is the student with max grade of: " + max);
			
		// =================================
		System.out.println("\n--- end ---");

		/* comments...
		 */

	}

}
