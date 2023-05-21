package h_java.exercises.polymoCases1b;

import java.util.ArrayList;
import java.util.Scanner;

public class _MainClass {
//	public static void main(String[] args) { // Note that the main method is described below  v

	static Scanner scanner = new Scanner(System.in);

	
	public static Square addSquare()
	{
		System.out.println("Type in the side of the square: ");
		int r = scanner.nextInt();
		if(r > 0)
		{
			Square sq = new Square(r);
			return sq;
		}
		else{
			return null;
		} 
	}
	
	public static Circle addCircle()
	{
		System.out.println("Type in the radius of the circle: ");
		int r = scanner.nextInt();
		if(r > 0)
		{
			Circle c = new Circle(r);
			return c;
		}
		else{
			return null;
		} 
	}
	
	public static Rectangle addRectangle()
	{
		System.out.println("Type in the height of the rectange: ");
		int h = scanner.nextInt();
		System.out.println("Type in the width of the rectange: ");
		int w = scanner.nextInt();
		if(h > 0 && w > 0)
		{
			Rectangle r = new Rectangle(w, h);
			return r;
		}
		else{
			return null;
		} 
	}
	
	public static void printShapes(ArrayList<AnyShape> shapes) {
		for(AnyShape s : shapes)
		{
			s.printData();
		}
		System.out.println("================================ ");
	}

	public static void main(String[] args) {
		ArrayList<AnyShape> listOfShapes = new ArrayList<AnyShape>();
		
		boolean doQuit = false;

		while(doQuit == false){
			//Main menu
			int choiceMenu = TheMenu.showMainMenu();
			//System.out.println("User selected " + choiceMenu);
			switch(choiceMenu)
			{
			case 11:
				//Add a Square
				Square s = addSquare();
				if( s != null){
					listOfShapes.add(s);
				}
				break;
			case 12:
				//Add a circle	
				Circle c = addCircle();
				if( c != null){
					listOfShapes.add(c);
				}
				break;
			case 13:
				//Add a rectangle	
				Rectangle r = addRectangle();
				if( r != null){
					listOfShapes.add(r);
				}
				break;
			case 2:
				//print all shapes 
				printShapes(listOfShapes);
				break;
			case 3:
				doQuit = true;
				break;				
			}
		}
		// =================================
		System.out.println("\n--- end ---");
	} // end of main	
}
