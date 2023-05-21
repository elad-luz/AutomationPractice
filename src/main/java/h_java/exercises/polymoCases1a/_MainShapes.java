package h_java.exercises.polymoCases1a;

import java.util.ArrayList;
import java.util.Scanner;

public class _MainShapes {
// https://selenium.teachable.com/courses/157997/lectures/2475174
	
	public static void main(String[] args) {
		System.out.println("Advance Exercise:\n=================\n");
		
		// We will need a 'List of Shapes' to be added to (this was written at the middle of code process when realized we need it)...
		ArrayList<AnyShape> shapes = new ArrayList<>(); // define the collection
		
		// create scanner to get input from users
		Scanner scan = new Scanner(System.in); // start scanner
		
	/**	the main menu we want the user to choose from => it will be flat written like this, when starting to form the code
		// because we need to reuse it within the loop as well - we'll take it into a method below
		System.out.println("Please choose from the following options (and enter the number):");
		System.out.println("1. Add new shape");
		System.out.println("2. List all shapes");
		System.out.println("3. Sum all perimeter");
		System.out.println("4. Sum all areas");
		System.out.println("5. Find biggest perimeter");
		System.out.println("6. Find biggest area");
		System.out.println("7. Exit");
		*/ // For more complexity (like in next exercise of same example, the menu could be taken out to stand-alone class) ==> SEE NEXT EEXAMPLE !
		// main menu using method to save duplication
		printMenue(); // see bellow, out of main
		
		//collect the input from user for main menu option
		int option = scan.nextInt();
		
		// the wrapping loop will allow multiple selections
		while (option >=1 && option <7) { // stating the range of options
			// using switch case condition because we have fixed cases for option chosen by user
			switch (option) { // working on main menu option choice
			case 1: // Add new shape
				System.out.println("You choose to add new shape from the following options (and enter the number):");
				// the shape menu we want the user to choose from =>
				System.out.println("\t 1. Circle"); // start by working on this object
				System.out.println("\t 2. Rectangle");
				System.out.println("\t 3. Square"); // extends Rectangle...
				System.out.println("\t 4. Triangle RightAngled");
				// re-use scanner for shapes menu
				int subOption = scan.nextInt();
				
				// choose the color => this is prior cause it is relevant to all kind of shapes
				System.out.println("Please add color of shape (enter the string):");
				String color = scan.next(); // TODO => if user didn't enter anything & clicked enter => use default value upon user skips input ?

				// now we will enter an inner switch cases for subOptions
				switch (subOption) { // working on shape menu option choice
				case 1: // Circle
					System.out.println("You choose Circle = Please add the radius (enter double):");
					double radius = scan.nextDouble();
					Circle c = new Circle(color, radius); // create the object
					shapes.add(c); // add the shape to List
					break;
				case 2: // Rectangle
					System.out.println("You choose Rectangle = Please add the width (enter double) & height (enter double):");
					double width = scan.nextDouble();
					double height = scan.nextDouble();
					Rectangle r = new Rectangle(color, width, height); // create the object
					shapes.add(r); // add the shape to List
					break;
				case 3:  // Square
					System.out.println("You choose Square = Please add the side size (enter double):");
					double side = scan.nextDouble();
					Square s = new Square(color, side); // create the object
					shapes.add(s); // add the shape to List
					break;
				case 4: // Triangle RightAngled
					System.out.println("You choose Triangle RightAngled = Please add the legA (enter double) & legB (enter double):");
					double legA = scan.nextDouble();
					double legB = scan.nextDouble();
					TriangleRA t = new TriangleRA(color, legA, legB); // create the object
					shapes.add(t); // add the shape to List
					break;
				default: System.out.println("end of shapes menu selection");
					break;
				}
				// end of inner switch --------------------------------
				break;
			case 2: // List all shapes
				System.out.println("You choose to print all shapes from List:"); // for that we need a loop
				for (AnyShape theShape : shapes) { // for each
					System.out.println(theShape); // theShape.toSting() is implemented on all level as an abstraction from parent
				}
				break;
			case 3: // Sum all perimeter
				double totalPerimeter = 0; // define & init a total var = 0 which will be added to... in loop
				for (AnyShape theShape : shapes) { // for each - I replaced cell var from anyShape to theShape
					totalPerimeter = totalPerimeter + theShape.calcPerimeter(); // same: totalArea += theShape.calcPerimeter();
				}
				System.out.println("total perimeter of all shapes: " + totalPerimeter);
				break;
			case 4: // Sum all areas
				double totalArea = 0; // define & init a total var = 0 which will be added to... in loop
				for (AnyShape theShape : shapes) { // for each - I replaced cell var from anyShape to theShape
					totalArea = totalArea + theShape.calcArea(); // same: totalArea += theShape.calcArea();
				}
				System.out.println("total area of all shapes: " + totalArea);
				break;
			case 5: // Find biggest perimeter
				double biggestPerimeter = 0; // to begin with..., compare to sizes & replace if needed
				AnyShape biggestPshape = null; // temp to put the shape with biggest Perimeter in
				for (AnyShape theShape : shapes) { // for each - I replaced cell var from anyShape to theShape
					if (theShape.calcPerimeter() > biggestPerimeter) {
						biggestPerimeter = theShape.calcPerimeter(); // putting value into biggestPerimeter variable
						biggestPshape = theShape; // putting value into biggestPshape object
					}
				}
				System.out.println("the biggest perimeter is: " + biggestPerimeter);
				System.out.println("that shape details are: " + biggestPshape);
				break;
			case 6: // Find biggest area -and- display the shape details
				double biggestArea = 0; // to begin with..., compare to sizes & replace if needed
				AnyShape biggestAshape = null; // temp to put the shape with biggest Area in
				for (AnyShape theShape : shapes) { // for each - I replaced cell var from anyShape to theShape
					if (theShape.calcArea() > biggestArea) {
						biggestArea = theShape.calcArea(); // putting value into biggestArea variable
						biggestAshape = theShape; // putting value into biggestShape object
					}
				}
				System.out.println("the biggest area is: " + biggestArea);
				System.out.println("that shape details are: " + biggestAshape);
				break;
			default: // Exit - for not meeting loop conditions !!! case 7 ...
				System.out.println("end of main menue selection");
				break;
			}	
			// Here we need to give the user the same menu to choose from - because it is a duplication, we will use a method for it
			printMenue(); // see method bellow
			
			//collect the input from user (already declared above)
			option = scan.nextInt(); // start again main menu option selection
		}
		// ---------------------------------
		// resource needs to be closed
		scan.close(); // close scanner
		// =================================
		System.out.println("\n--- end ---");
	} // end of main	
	/** METHODS (out-side of 'main'): */	
   //	the method will print out the menu:
	public static void printMenue() {
		System.out.println("Please choose from the following options (and enter the number):");
		System.out.println("1. Add new shape");
		System.out.println("2. List all shapes");
		System.out.println("3. Sum all perimeter");
		System.out.println("4. Sum all areas");
		System.out.println("5. Find biggest perimeter");
		System.out.println("6. Find biggest area");
		System.out.println("7. Exit");
	}
	// For more complexity (like in next exercise of same example, the menu could be taken out to stand-alone class) ==> SEE NEXT EEXAMPLE !
}
