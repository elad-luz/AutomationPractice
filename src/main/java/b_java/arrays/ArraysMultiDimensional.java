package b_java.arrays;

public class ArraysMultiDimensional {

	public static void main(String[] args) {
		System.out.println("Arrays 2D:\n==========");
		/** see:
			Syntax to Declare an Array in Java
				dataType[] arr; 
				dataType []arr;
				dataType arr[];  

			Instantiation \ Initialize of an Array in Java
				arrayRefVar=new dataType[size];
 
			You can create a 2D array using new as follows:
			-----------------------------------------------
			Declaration – Syntax:
		      data_type[][] array_name = new data_type[x][y]; // [x = row_size][y = column_size];
				int[][] x = new int[4][2]; // 2D integer array name = x  -->  with 4 rows and 2 columns
				String[][] y = new String[3][3]; // 2D String array with 3 rows and 3 columns
				String[][] z = new String[3][]; // Also OK ???

			Initialization – Syntax:
			- array_name[row_index][column_index] = value;
				int[][] n = new int[2][2];
    				n[0][0] = 1;
    				n[1][1] = 1;
    				
			as table: Column 1 | Column 2 | Column 3 |
		 		ROW	| -------- | -------- | ---------|
	 	 	 	 0	| ar[0][0] | ar[0][1] | ar[0][2] |
		 	 	 1	| ar[1][0] | ar[1][1] | ar[1][2] |
		 	 	 2	| ar[2][0] | ar[2][1] | ar[2][2] |
		 	 
    		- data_type[1st dimension][2nd dimension][]..[Nth dimension] array_name = new data_type[size1][size2]….[sizeN];
		*/
		System.out.println("Part #1) \n--------");
		int a[] = new int[5];//declaration and instantiation  
		a[0]=10; // initialization  
		a[1]=20;  
		a[2]=70;  
		a[3]=40;  
		a[4]=50;  
		//traversing array  
		for (int i = 0; i < a.length; i++) { // length is property of array 
			System.out.print(a[i]);
			if (a[i] <= 45) {
				System.out.print(" < 45 ; ");
			} else {
				System.out.print(" > 45 ; ");
			} // Output (in same line): 10 < 45 ; 20 < 45 ; 70 > 45 ; 40 < 45 ; 50 > 45 ;
		}
		System.out.println(System.lineSeparator());
		// ----------------------------------------

		String arrSt[]={"A","B","C","5"};
		//printing array using for-each loop
		for(String i:arrSt) { 
			System.out.print(i + ", ");
			// Output (in same line): A, B, C, 5,
		}
		
		System.out.println(System.lineSeparator());
		// ----------------------------------------
		
		System.out.println("Part #2) \n--------");
		// declaring and initializing 2D array
		int ar[][] = { { 1, 2, 3 }, { 2, 4, 5 }, { 4, 4, 5 } };
		// printing 2D array
		for (int i = 0; i < 3; i++) {
			for (int j = 0; j < 3; j++) {
				// System.out.print(ar[i][j] + " "); // Print arrays -> 1 2 3  ->  2 4 5 (each in a line)
				System.out.println("arr[" + i + "][" + j + "]=" + ar[i][j]); // print one value each time & how to get it: ar[0][0]=1
			}
			System.out.println();
		}
		System.out.println(System.lineSeparator());
		// ----------------------------------------
		
		System.out.println("Part #3) \n--------");
		String[][] nameTitle = {
				{"Mr. ", "Mrs. "}, // #0. Title --> 0=Mr. -&- 1=Mrs.
				{"Elad ", "Or ", "Zohar ", "Yael ", "Jim "}, // #1 = F name --> 0=Elad -&- 1=Or ...
				{"Luz ", "Berg ","Walls "} // #2. L name --> 0=Luz -&- 1=Berg
			};
		
		// Print partial
		System.out.println(nameTitle[0][0]); // Mr.		(1st Array - 1st Element)
		System.out.println(nameTitle[0][1]); // Mrs.	(1st Array - 2ed Element)
		
		System.out.println(nameTitle[1][0]); // Elad	(2ed Array - 1st Element)
		System.out.println(nameTitle[1][1]); // Or		(2ed Array - 2ed Element)
		System.out.println(nameTitle[1][2]); // Zohar	(2ed Array - 3ed Element)
		System.out.println(nameTitle[1][3]); // Yael	(2ed Array - 4th Element)
		System.out.println(nameTitle[1][4]); // Jim		(2ed Array - 5th Element)
		 
		System.out.println(nameTitle[2][0]); // Luz		(3ed Array - 1st Element)
		System.out.println(nameTitle[2][1]); // Berg	(3ed Array - 2ed Element)
		System.out.println(nameTitle[2][2]); // Walls	(3ed Array - 3ed Element)

		// Printing Combo
		System.out.println(nameTitle[0][0] + nameTitle[2][0]); // Mr. Luz
		System.out.println(nameTitle[0][1] + nameTitle[2][1]); // Mrs. Berg
		System.out.println(nameTitle[0][0] + nameTitle[1][0] + nameTitle[2][0]); // Mr. Elad Luz
		System.out.println(nameTitle[0][1] + nameTitle[1][1] + nameTitle[2][0]); // Mrs. Or Luz 
		System.out.println(nameTitle[1][2] + nameTitle[2][1]); // Zohar Berg
		System.out.println(nameTitle[1][4] + nameTitle[2][2]); // Jim Walls
		System.out.println(nameTitle[0][1] + nameTitle[1][4] + nameTitle[2][2]); // Mrs. Jim Walls 
		
		// changing a value in array
		nameTitle[0][0] = " > mister ";
		System.out.println(nameTitle[0][0] + nameTitle[2][0]); // > mister Luz (prev: Mr. Luz)
		nameTitle[2][0] = " > monster ";
		System.out.println(nameTitle[0][0] + nameTitle[2][0]); // > mister  > monster (prev: Mister Luz)
		
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
