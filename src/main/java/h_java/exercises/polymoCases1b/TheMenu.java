package h_java.exercises.polymoCases1b;

import java.util.Scanner;

public class TheMenu {
	
	// MAIN menu operation
	public static int showMainMenu() {
		Scanner scanner = new Scanner(System.in); // declare scanner before the loop starts -and- close it when exit loop
		while(true) // as you enter the while loop, it is set to true and start looping through the block of code as long as a specified condition is true, or till break!
		{   // printout for user what you want him to do
			System.out.println("Type 1 to add a shape");
			System.out.println("Type 2 to print all shapes");
			System.out.println("Type 3 to quit");
			System.out.println("=====================");
			int choice = scanner.nextInt(); // the users' input fill this var
			switch(choice){ // this switch (condition decision making), process the choice according to case conditions stated
			case 1: // add a shape -and- process sub menu selection for the requested shape
				int subMenuChoice = showShapesMenu(); // this step actually triggers the following method for choice
				switch(subMenuChoice){
				case 1:
					return 11;
				case 2:
					return 12;
				case 3:
					return 13;
				}
				break;
			case 2:
				return 2;
			case 3:
				return 3;
			}
			scanner.close();
		}
	}

	// SUB menu operation
	public static int showShapesMenu() {
		Scanner scanner = new Scanner(System.in);
		while(true)
		{
			System.out.println("\tType 1 to add a square");
			System.out.println("\tType 2 to add a circle");
			System.out.println("\tType 3 to add a rectangle");
			System.out.println("\tType 4 to return to main menu");
			int choice = scanner.nextInt();
			if(choice >= 1 && choice <= 4)
				return choice;
			// Note that there is no break, so if user typed something out of range as requested (other than: 1,2,3,4), this shapes menu will be re-printed again and again... because loop is not closing

			// CLOSS SCAN:
			scanner.close();

			System.out.println("\t=====================");
		}
	}
}
