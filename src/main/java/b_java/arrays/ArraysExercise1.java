package b_java.arrays;

public class ArraysExercise1 {

	public static void main(String[] args) {
		System.out.println("Arrays Exercise 1:\n==================");
		
		/* # 1 */ System.out.println("\n #1 ) Simple Array program");
		
		// int[] type #1
		int[] numbers1 = new int[5];
		numbers1[0] = 10;
		numbers1[1] = 20;
		numbers1[2] = 30;
		numbers1[3] = 40;
		numbers1[4] = 50;
		for (int i = 0; i < numbers1.length; i++) {
			System.out.println("cell #"+ i +" value in numbers1 Array is: "+ numbers1[i]);
		}
		
		System.out.println("----");
		
		// int[] type #1
		int[] numbers2 = {11, 12, 13, 14, 15};
		for (int i = 0; i < numbers2.length; i++) {
			System.out.println("cell #"+ i +" value in numbers2 Array is: "+ numbers2[i]);
		}

		System.out.println(System.lineSeparator());
		// ----------------------------------------
		
		// string[] type #1
		String[] names1 = new String[5];
		names1[0] = "name10";
		names1[1] = "name20";
		names1[2] = "name30";
		names1[3] = "name40";
		names1[4] = "name50";
		for (int i = 0; i < names1.length; i++) {
			System.out.println("cell #"+ i +" value in numbers1 Array is: "+ names1[i]);
		}
		
		System.out.println("----");
		
		// string[] type #1
		String[] names2 = {"name01", "name02", "name03", "name04", "name05"};
		for (int i = 0; i < names2.length; i++) {
			System.out.println("cell #"+ i +" value in numbers2 Array is: "+ names2[i]);
		}

		System.out.println(System.lineSeparator());
		// ----------------------------------------

		/* # 2 */ System.out.println("\n #2 ) SUM & AVG of Array cells' values");
		
		// SUM
		double[] ArrSum = {1, 2, 3, 4, 5};
		double sum = 0;
		for (int i = 0; i < ArrSum.length; i++) {
			sum = sum + ArrSum[i];
		}
		System.out.println("SUM of Array cells' values: "+ sum +"\n"); // 15.0

		// AVG
		double[] ArrAvg = new double[5]; // {10, 12, 8, 9, 11}
		ArrAvg[0] = 10;
		ArrAvg[1] = 12;
		ArrAvg[2] = 8;
		ArrAvg[3] = 9;
		ArrAvg[4] = 11;
		
		double sumA = 0;
		for (int i = 0; i < ArrAvg.length; i++) {
			sumA = sumA + ArrAvg[i]; // note: can also be written as: sumA += ArrAvg[i]
		}
		System.out.println("AVG of Array cells' values: "+ sumA /  ArrAvg.length +"\n"); // 15.0

		System.out.println(System.lineSeparator());
		// ----------------------------------------

		/* # 3 */ System.out.println("\n #3 )  Smallest of Array cells' values");
		
		// Smallest (minimum)
		double[] ArrSm = {10, 12, 8, 9, 11}; // Array of 5 numbers
		double smallest = ArrSm[0]; // initiating smallest variable with first cell value
		for (int i = 0; i < ArrSm.length; i++) { // loop over all cells
			if (ArrSm[i] < smallest) { // if checked cell value is smaller then current smallest variable value
				smallest = ArrSm[i]; // change the value of smallest variable to the cell value just found as smaller
			}
		}
		System.out.println("Smallest of Array cells' values: "+ smallest +"\n"); // 8.0

		// =================================
		System.out.println("\n--- end ---");

		/* comments...
		 */

	}

}
