package b_java.arrays;

public class Arrays0 {

	public static void main(String[] args) {
		System.out.println("Arrays 0:\n=========");
		
		/** General:
			// declares an array of integers
        	int[] anArray;
        	// allocates memory for 10 integers
        	anArray = new int[10];
        	// initialize first element
        	anArray[0] = 100;
        	// initialize second element
        	anArray[1] = 200;
        	// and so forth...
        	// OR use the 2ed way to do at once...
		 */
		
		/* # 1 */ System.out.println("\n #1 )");
		
		// ints Array - 2 ways to declare & initiate:
		int[] ages1 = new int[3]; // declare & predetermine the size (amount of cells)
		ages1[0] = 11;            // initiate values for each cell - note that cell one id is 0 -&- cell n id is n-1 !!!
		ages1[1] = 12;
		ages1[2] = 13;
		System.out.println("first value, in ages1 Array is: "+ ages1[0] +"\n"); // print out a specific cell valve (by cell id)
		// 2ed type:
		int[] ages2 = {11, 12, 13}; // declare & initiate values for cell at one without predetermine the size
		for (int i = 0; i < ages2.length; i++) {
			System.out.println("cell #"+ i +" value, in ages2 Array is: "+ ages2[i]); // print out of each cell valve the loop passes over
		}
		System.out.println("--------------");
		
		// strings Array - 2 ways to declare & initiate:
		String[] names1 = new String[3];
		names1[0] = "itamar";
		names1[1] = "ofir";
		names1[2] = "aviv";
		System.out.println("first value, in names1 Array is: "+ names1[0] +"\n");
		// 2ed type:
		String[] names2 = {"itamar", "ofir", "aviv"};
		for (int i = 0; i < names2.length; i++) {
			System.out.println("cell #"+ i +" value, in ages2 Array is: "+ names2[i]);
		}
		System.out.println("--------------");	
		

		System.out.println(System.lineSeparator());
		// ----------------------------------------

		/* # 2 */ System.out.println("\n #2 ) Calculating Average Grade");
		
		/* in this way its Not easy to Add \ Remove student's grades:
		   double student1 = 88;
		   double student2 = 90;
		   double student3 = 92;
		   double student3 = 90;
		   double sum = student1+ student2+ student3;
		   double avg = sum / 4;
		   System.out.println(avg); // 90.0
		 */
		// USE ARRAY:
		double[] grades = {88, 90, 92, 90}; // Array of 3 cells
		System.out.println("the amount of cells in array is: "+ grades.length); // <array>.length show the amount of cells in array
		double sum = 0; // starting with no grade
		for (int i = 0; i < grades.length; i++) { // looping over all Array cells [grades.length = 4 cells in Array]
			System.out.println("cell #"+ i +" value, in grades Array is: "+ grades[i]);
			sum = sum + grades[i]; // adding to current total sum, the grade value in each cell (by loop order) till we have them all !
		}
		System.out.println("Grades Average is: "+ sum / grades.length); // Avg. is the sum of all cells values, divided by the number of cells
		
		System.out.println(System.lineSeparator());
		// ----------------------------------------
		
		/* # 3 */ System.out.println("\n #3 ) loop over array, using 'for each':");
		
		// Print all the array elements
		
		double[] doubArr = {1.1, 2.2, 3.3, 4.4};
		for (double element: doubArr) { // element could be replaced with any other var name (e.g. "i")
			System.out.println(element); // with line break between elements
		}

		int[] intArr = {1, 2, 3, 4};
		for (int x: intArr) {
			System.out.print(x +", "); // without line break between elements
		}

		System.out.println(System.lineSeparator());
		// ----------------------------------------
		
		/* # 4 */ System.out.println("\n #4 ) Extra: 3 arrays & loop examples:");
		
		System.out.println("--- A ---"); // ----------------------------
		
		String namesA[] = new String[3];
		namesA[0]="Yossi"; //namesA[first cell=0] = new String value (e.g. "Yossi");
		namesA[1]="Mosh";
		namesA[2]="Avi";

		// Print all the array elements
		System.out.println("print all cells from: 1");
		for (int i = 0; i < namesA.length; i++) {
			System.out.println(namesA[i] + " ");
		}

		System.out.println("--- B ---"); // ----------------------------
		
		String namesB[] = {
				"Yossi",
				"Mosh",
				"Avi"
				};
		
		// Print all the array elements
		for (int i = 0; i < namesB.length; i++) {
			System.out.println(namesB[i] + " ");
		}

		System.out.println("--- C ---"); // ----------------------------
		
		String [] namesC= {"Yossi", "Mosh", "Avi"};

		// Print all the array elements
		System.out.println("1. line separated:");
		for( String name : namesC ) {
			System.out.print( name );
			System.out.print("\n"); // new line separator
		}
		System.out.print("2. comma separated in same line:\n"); 
		for( String name : namesC ) {
			System.out.print( name );
			System.out.print(", "); // comma separator
		}
		
		System.out.println("\n"); // ----------------------------
		
		// ALSO: "for-each" loop, which is used exclusively to loop through elements in an array (see later on)
		System.out.println("print cars from array:");
		String[] cars = {"Volvo", "BMW", "Ford", "Mazda"}; // array of cars
		for (String x : cars) { // loop over array & print each
		  System.out.println(x);
		}

		System.out.println("\n"); // ----------------------------
		
		// another example of simple array:
		int [] numbers;
		numbers = new int[3];
		numbers[0] = 10;
		numbers[1] = 11;
		numbers[2] = 12;
		
		int x = numbers[1];
		int y = 11;
		if (x==y) {
			System.out.println("TRUE");
		} else System.out.println("FALSE");

		// =================================
		System.out.println("\n--- end ---");

		/* comments...
		 */

	}

}
