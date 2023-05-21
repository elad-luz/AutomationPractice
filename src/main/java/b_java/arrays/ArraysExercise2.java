package b_java.arrays;

public class ArraysExercise2 {

	public static void main(String[] args) {
		System.out.println("Test exersise:\n==============");
		
		/* # 1 */ System.out.println("\n #1 ) print names from array");
		
		String[] namesArr = {"elad", "or", "itamar", "ofir", "aviv"};
		for (int i = 0; i < namesArr.length; i++) {
			System.out.println("- "+ namesArr[i]);
		}

		System.out.println(System.lineSeparator());
		// ----------------------------------------

		/* # 2 */ System.out.println("\n #2 ) print array, change values of specific cells & print only them, then switch them & reprint array");
		
		int[] intArr = {1,2,3,4,5}; // Array
		for (int i = 0; i < intArr.length; i++) { // loop over
			System.out.println(intArr[i]); // print all cells
		}
		intArr[0] = 10; // change value of specific cell
		intArr[intArr.length -1] = 50; // can use cell specific [4] -or- last cell is Array cells (= length-1, cause it starts with 0 not 1)
		System.out.println("changed first & last to: "+ intArr[0] +", "+ intArr[intArr.length -1]); // print the cells to see the got newly changed value
		// switch the first & last using a temp variable
		int temp = intArr[0]; // temp gets first value
		intArr[0] = intArr[intArr.length -1]; // first value gets last one
		intArr[intArr.length -1] = temp; // last value gets first one that was stored in temp
		
		System.out.println("reprint array after switchinf first & last cells value:");
		for (int i = 0; i < intArr.length; i++) { // loop over
			System.out.println(intArr[i]); // print all cells
		}
		
		System.out.println(System.lineSeparator());
		// ----------------------------------------

		/* # 3 */ System.out.println("\n #3 ) print specific array cell if its vaue is 80 -and- print array sum & avg");
		
		int[] numbers = {40, 80, 60, 70, 50};
		double sum = 0;
		for (int i = 0; i < numbers.length; i++) {
			if (numbers[i] == 80) {
				System.out.println("80 was found in Array cell # "+ i);
			}
			sum = sum + numbers[i];
		}
		System.out.println("SUM:"+ sum);
		System.out.println("AVD:"+ (sum / numbers.length));

		System.out.println(System.lineSeparator());
		// ----------------------------------------

		/* # 4 */ System.out.println("\n #4 ) print array cells from last to first");
		
		int[] newArr = {40, 80, 60, 70, 50};
		for (int i = 0; i < newArr.length; i++) { // going from first to last
			System.out.println(newArr[(newArr.length)-(i+1)]); // print back to forth
		}
		/* Gal made it a little differently:
		 * for (int i = (newArr.length - 1); i >=0 ; i--) { // going from last to first
			System.out.print(newArr[i] +", ");} // print each cell as found (in same line) !
		 */

		System.out.println(System.lineSeparator());
		// ----------------------------------------

		/* # 5 */ System.out.println("\n #5 ) print name & grade of student with best grade");

		int[] gradeArr = {80, 81, 82, 83, 84}; // Array of 5 numbers of grades
		String[] studentArr = {"elad", "or", "itamar", "ofir", "aviv"}; // Array of 5 students (correlative to grades)
		int bestGrade = gradeArr[0]; // initiating best grade variable with first grade cell value
		int bestGradeCellPosition = 0; // initiating best grade cell variable with first cell
		for (int i = 0; i < gradeArr.length; i++) { // loop over all grades cells
			if (gradeArr[i] > bestGrade) { // check if any cell value is better then current bestGrade variable value
				bestGrade = gradeArr[i]; // change the value of bestGrade to that of the cell value just found as greater
				bestGradeCellPosition = i; // keep the i position value of the best grade found for later use...
			}
		}
		System.out.println("student: "+ studentArr[bestGradeCellPosition] +" => have best grade: "+ gradeArr[bestGradeCellPosition]);
		// TODO: need to add treatment for case all students have the same grade !

		// =================================
		System.out.println("\n--- end ---");

		/* comments...
		 */

	}

}
