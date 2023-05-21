package a_java.conditions;

import java.util.Scanner;

public class DecisionMaking3 {

	public static void main(String[] args) {
		System.out.println("DecisionMaking 3:\n=================");

		/* # 1 */ System.out.println("\n #1 ) Conditions");
		
		// The following statement will always be executed
		System.out.println("No Decision Made Here !\n"); // print always 

		System.out.println("--------------\n");

		// If statement - consider something
		int a = 20; // use 10 or 20
		if (a < 15)
			System.out.println(a + " is less than 15"); // print only if statement true
		if (a > 15)
			System.out.println(a + " is more than 15"); // print only if statement true

		System.out.println(System.lineSeparator());
		// ----------------------------------------

		// If statement - using scanner
		int i;
		Scanner input1 = new Scanner(System.in); // initiate scanner
		System.out.println("Enter a Number input here (choose from: -1 / 0 / 1) =>"); // letting the user know he needs to insert something in keyboard
		i = input1.nextInt(); // set variable value from scanner

		if (i==0){	
			System.out.println("upon i = 0 |=> your number is 0");
		}
		else{
			System.out.println("upon i != 0 |=> your number isn't 0");
		}

		System.out.println("--------------\n");
		System.out.println("the number inserted above was: " + i);

		if (i < 0){
			System.out.println(i +" < 0");
		}
		if (i > 0){
			System.out.println(i +" > 0");
		}
		if (i == 0){	
			System.out.println(i +" = 0");
		}
		else{ // do nothing !
		}	

		System.out.println("--------------\n");
		System.out.println("the number inserted above was: " + i);
		switch(i){
		case 0:
			System.out.println("your number is zero");
			break;
		case 1:
			System.out.println("your number is one");
			break;
		default:
			System.out.println("default");
			break;

		}

		System.out.println(System.lineSeparator());
		// ----------------------------------------

		String sx;
		Scanner input2 = new Scanner(System.in);
		System.out.println("Enter a String input here (choose: 'elduz', 'elad luz', 'luz elad', jo -or- other string) =>");
		sx = input2.nextLine();
		System.out.println("the input was: " + sx);

		switch(sx){
		// 3 consecutive cases resulting with the same commands to do
		case "elduz": case "elad luz": case "luz elad":
			System.out.println("you are elad luz");
			break;
		case "jo":
			System.out.println("you are jo");
			break;
		default:
			System.out.println("you are neither elad luz nor jo ");
			break;

		}

		// closing input scanners
		input1.close();
		input2.close();

		System.out.println(System.lineSeparator());
		// ----------------------------------------

		// several cases with same to do...
		int ix = 0; // 0,1,3,4,7,8,9
		switch(ix){
		case 1: case 2: case 4: // First case (fit 3 options)
			System.out.println(ix +" fits First case"); // 1,4
			break;
		case 8: case 9: //Second case
			System.out.println(ix +" fits Second case"); // 8,9
			break;
		default: //Default case
			System.out.println(ix +" fits Default case"); // 0,3,7
			break;
		}

		// =================================
		System.out.println("\n--- end ---");

		/* comments...
		 */

	}

}
