package a_java.conditions;

import java.util.Scanner;

public class DecisionMaking5 {

	public static void main(String[] args) {
		System.out.println("DecisionMaking 5:\n=================");
		
		/* # 1 */ System.out.println("\n #1 ) Switch Case conditions");

		int i = 0; // set i, run with values: 0, 1, 2, 3
		System.out.println("i = " + i);
		switch (i)
		{
		case 0:
			System.out.println("i is zero.");
			break;
		case 1:
			System.out.println("i is one.");
			break;
		case 2:
			System.out.println("i is two.");
			break;
		default:
			System.out.println("i is not: zero, one or two...");
		}

		// ---------------
		// using scanner :
		Scanner scn = new Scanner(System.in);
		System.out.println("enter int: 0 / 5 / 10 ");
		int num = scn.nextInt(); // set num, run with values: 0, 10 & others
		System.out.println("num = " +num);
		switch(num) {
		case 0:
			System.out.println("its Zero");
			break;
		case 10:
			System.out.println("its TEN");
			break;
		default:
			System.out.println(num +" neither 0 nor 10");
			break;
		}        
		scn.close();


		System.out.println(System.lineSeparator());
		// ----------------------------------------
		
		System.out.println("\n  #2: combined conditions => set age and determine what group it belong to");  

		int age;
		age = 18; // set age, run with values: -8, 8, 18, 28, 68
		System.out.println("age: " + age);
		int ageStatus; 
		// DecisionMaking for setting variable value according to condition (if age > set status)
		if(age<0) {
			ageStatus=0;
		}
		else if(age<18) {
			ageStatus=1;
		}
		else if(age==18) {
			ageStatus=2;
		}
		else if(age>67) {
			ageStatus=3;
		}
		else{
			ageStatus=4;	
		}
		System.out.println("ageStatus: " + ageStatus);
		// switch cases... and print
		switch (ageStatus) {
		case 0:
			System.out.println("error");
			break;
		case 1:
			System.out.println("under 18");
			break;
		case 2:
			System.out.println("exactly 18");
			break;
		case 3:
			System.out.println("over 67");
			break;
		default:
			System.out.println("between 18 to 67");
			break;
		}

		// =================================
		System.out.println("\n--- end ---");

		/* comments...
		 */

	}

}
