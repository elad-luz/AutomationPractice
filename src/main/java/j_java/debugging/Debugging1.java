package j_java.debugging;

import java.util.Scanner;

public class Debugging1 {

	public static void main(String[] args) {
		System.out.println("Debugging 1:\n============\n");
		/** DEBUG
		 *  first, add print-outs to your code, to assist your understanding of where you stand in regard.
			click on a line number next to where you want to start debugging -&- select Toggle Breakpoint!
			run the program in debug mode (you will be prompt to change view (perspective), to see results
			you will be given view to inputs of variables values etc.
			you can manually skip between perspective views (top right corner j= default java -&- bug view
			also, top bar click 'Window' button > Perspective > Open > Java | or Reset, after changes made
			use debug buttons to resume \ terminate run, to step into methods or step over to my next line
			in our code, upon reaching 'getMax' (at the end), 'step into' & see what happens within method
			during debug - if you want to see value of variable currently out of scope, mark & select them
			right-click -&- select 'Watch' => it will be added to expressions... e.g.  with array.length >
			you can hover-over variables to see their value ...
		 */
		// find if list of numbers is sorted in ascending order of size - this is a simple way that works!
		System.out.println("is list of numbers is sorted ascending ?");
		Scanner input1 = new Scanner(System.in);
		int x,y,z;
		System.out.println("enter number int");
		x = input1.nextInt();
		System.out.println("enter number int");
		y = input1.nextInt();
		System.out.println("enter number int");
		z = input1.nextInt();
		
		// add prints throughout our code during debug  to assist find problems - ALSO add state of vars to table
		System.out.println("x="+x+", y="+y+", z="+z); // break-point => drill over
		
		if (x<y && y<z ) {
			System.out.println("sorted");
			System.out.println(x+"<"+y+"<"+z); // prints will assist us to better understand where our code stand
		} else {
			System.out.println("not sorted");
		}	
		System.out.println(System.lineSeparator());
		// ----------------------------------------
		
		System.out.println(getMax(x, y, z)); // reaching this line => drill into
		
		// close resources
		input1.close();
		// =================================
		System.out.println("\n--- end ---");
	} // end of main	
	/** METHODS (out-side of 'main'): */	
   // a method that gets value of 3 integers and returns the biggest one
	private static int getMax(int x, int y, int z) {
		int max;
		if(x > y  &&  x > z){
			max = x;
		}
		else if(y > x  &&  y > z){
			max = y;
		}
		else{
			max = z;
		}
		return max;
	}
}
