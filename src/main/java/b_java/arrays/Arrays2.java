package b_java.arrays;

public class Arrays2 {

	public static void main(String[] args) {
		System.out.println("Arrays 2:\n=========");
		
		/* # 1 */ System.out.println("\n #1 ): Array stuff");

		int a[]=new int[5];//declaration and instantiation  
		a[0]=10;//initialization  
		a[1]=20;  
		a[2]=70;  
		a[3]=40;  
		a[4]=50;

		System.out.println("first cell of a[] is: " + a[0]);
		
		//-----------------------
		System.out.println("\n");

		// 1st ways to declare & initialize
		int[] studentAges = new int[3];
		studentAges[0] = 20;
		studentAges[1] = 21;
		studentAges[2] = 22;
		for (int i = 0; i < studentAges.length; i++) { // print
			System.out.println(studentAges[i]);
		}

		// 2ed way
		int[] studentAgesX = {22,24,25}; //insert value & determine initial size
		System.out.println("value of studentAge[] first cell is: " + studentAgesX[0]); // print value of cell #0 (cell starting at #0, so this refers to the first)
		
		//-----------------------
		System.out.println("\n");	

		int[] studentGrades = new int[3]; // initiate array with name & determine initial size
		// enter values to cells
		studentGrades[0] = 92;
		studentGrades[1] = 87;
		studentGrades[2] = 78;

		System.out.println("value of studentGrades array second cell is: " + studentGrades[1]); // print value of cell #1 (cell starting at #0, so this refers to the second)
		//printing array 		
		for (int x = 0; x < studentGrades.length; x++) // length is the property of array -- loop over all cells and print value of each one
			System.out.println("studentGrades: " + studentGrades[x]);

		System.out.println(System.lineSeparator());
		// ----------------------------------------

		/* # 2 */ System.out.println("\n #2 )");
		
		// More...
		int [] myInt = {111, 222, 333, 123}; // declaration, instantiation and initialization => initiate array with name & insert value
		int biggest = myInt[0]; // initiated var which represent the biggest value, with the value of first cell in array
		for(int i=0 ; i < myInt.length ; i++) // i will represent the index for cell in array
		{
			if(myInt[i] > biggest) // loop will compare the next cell value to the biggest, if bigger - it will set its value as biggest
				biggest = myInt[i];
		}
		System.out.println("the biggest is: " + biggest);
		
		
		
		System.out.println("\n");
		System.out.println("Print all the array elements ---------------------------");
		System.out.println("\n");
		
		int [] nInt = {111, 222, 333, 123};
		// 
		for (int cellValue:nInt) { // cellValue could be replaced with any other var name (e.g. "i")
			System.out.println(cellValue);
		}
		
		System.out.println("\n");

		double[] nDoub = {1.9, 2.9, 3.4, 3.5};
		// Print all the array elements
		for (double element: nDoub) { // element could be replaced with any other var name (e.g. "i")
			System.out.println(element);
		}

		System.out.println(System.lineSeparator());
		// ----------------------------------------

		/* # 3 */ System.out.println("\n #3 ) PRINT ARRAY examples:");
		
		// arrayName.length = the number of cells in array - first cell is called "0"

		String [] myString = {"aaa", "bbb", "ccc", "xyz"};
		for(int i=0 ; i < myString.length ; i++) // i will represent the index for cell in array
		{
			System.out.println("string array: " + myString[i]);
		}
		System.out.println("\n");

		// Print all the array elements - another 2 examples (for each):		
		int [] myI = {111, 222, 333, 123}; // initiate array myI with cells value as stated
		for (int i:myI) { // for each & every cell (note - 'int i' can be replaced with any other variable name) in array myI => give it the value of cell
			System.out.println(i); // print cell's the variable (value of cell)
		}
		System.out.println("\n");

		double[] myL = {11.1, 22.2, 33.3, 44.4};
		for (double element: myL) { // go over all array
			System.out.println(element);
		}

		// =================================
		System.out.println("\n--- end ---");

		/* comments...
		 */

	}

}
