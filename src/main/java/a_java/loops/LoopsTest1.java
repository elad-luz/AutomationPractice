package a_java.loops;

import java.util.Scanner;

public class LoopsTest1 {

	public static void main(String[] args) {
		System.out.println("Test exersise:\n==============");
		
		/* # 1 */ System.out.println("\n #1 ) print all numbers from 1 to 80 (including)");
		
		for (int i = 1; i <= 80; i++) {
			System.out.println(i);
		}

		System.out.println(System.lineSeparator());
		// ----------------------------------------

		/* # 2 */ System.out.println("\n #2 ) print every second number from 5 to 25 (including)");
		
		for (int i = 5; i <= 25; i = i+2) {
			System.out.println(i);
		}
		
		System.out.println(System.lineSeparator());
		// ----------------------------------------

		/* # 3 */ System.out.println("\n #3 ) check if input number is under 55 (print Failed) OR over 90 (print Exceled");
		Scanner input = new Scanner(System.in);
		System.out.println("please enter ONE Grade for user");
		int userGrade = input.nextInt();

		if (userGrade < 55) {
			System.out.println("user Failed grade: "+ userGrade);
		}
		else if (userGrade > 90) {
			System.out.println("user Exceled grade: "+ userGrade);
		}
		else {
			System.out.println("user neither Failed nor Exceled grade: "+ userGrade);
		}

		
		System.out.println(System.lineSeparator());
		// ----------------------------------------

		/* # 4 */ System.out.println("\n #4 ) same as above with loop that breaks on: 0 < input > 100");
		
		Scanner inputL = new Scanner(System.in);
		System.out.println("please enter a valid Grade for user (0 to 100)");
		int userGradeL = inputL.nextInt();

		while ((userGradeL >= 0) && (userGradeL <= 100)) {
			if (userGradeL < 55) {
				System.out.println(userGradeL +" : Failed");
			}
			else if (userGradeL > 90) {
				System.out.println(userGradeL +" : Exceled !!!");
			}
			else {
				System.out.println(userGradeL +" : neither F nor E");
			}
			System.out.println("\n=> please enter a NEW valid Grade for user (0 to 100)");
			userGradeL = inputL.nextInt();
		}
		System.out.println("you've entered an invalid value as grade (below 0 -or- above 100) so program closed !");

		// close scanners
		input.close();
		inputL.close();

		// =================================
		System.out.println("\n--- end ---");

		/* comments...
		 */

	}

}
