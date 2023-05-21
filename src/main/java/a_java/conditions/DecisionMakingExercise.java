package a_java.conditions;

import java.util.Scanner;

public class DecisionMakingExercise {

	public static void main(String[] args) {
		System.out.println("DecisionMaking exersise:\n========================");

		/* Exercise 1 */ System.out.println("\n #1");
		
		// int age = 8; // make this method dynamic with scanner input.
		int age;
		Scanner input1 = new Scanner(System.in);
		System.out.println("give new int value to age: 8, 18, 38, 68");
		age = input1.nextInt();

		if (age < 18) {
			System.out.println(age + " years is considered minor !");
		}
		if (age > 66) {
			System.out.println(age + " years is considered retired");
		}
		if (age == 18) {
			System.out.println(age + " years is considered perfect");
		}
		if (age > 18 && age < 66) {
			System.out.println(age + " years is considered what da ??");
		}

		System.out.println(System.lineSeparator());
		// ----------------------------------------

		/* Exercise 2 */ System.out.println("\n #2");		

		/* int num = 3;
	    make this method dynamic with scanner input.
		 */
		int num;
		Scanner input2 = new Scanner(System.in);
		System.out.println("give new int value to num - and see if it is even or odd");
		num = input2.nextInt();

		int mod = num % 2; // modulo - result of what remain after division by 2
		System.out.println("upon divide a number (for example: " +num+") by 2 ==> checking if that division has any Remainder [modulo operation returns the remainder] will state if it is an even number, or odd !" );
		if (mod == 0) { // without "mod" variable it could also be written: if (num % 2 == 0)
			System.out.println(num +" is an even number");
		} else {
			System.out.println(num +" is an odd number");
		}

		System.out.println(System.lineSeparator());
		// ----------------------------------------

		/* Exercise 3 */ System.out.println("\n #3");

		int a, b; // declare both at once !
		a = 10; // change int = 9 / 10 / 11
		b = 10;

		/* if (a > b) {
			System.out.println(a +" is larger than "+ b);
		}
		if (a < b) {
			System.out.println(b +" is larger than "+ a);
		}
		if (a == b) {
			System.out.println(a +" & "+ b +" are the same");
		}
		 */
		// condense the code properly.
		if (a > b) {
			System.out.println(a +" is larger than "+ b);
		} else {
			if (a < b) {
				System.out.println(b +" is larger than "+ a);
			} else {
				System.out.println(a +" & "+ b +" are the same");
			}}


		System.out.println(System.lineSeparator());
		// ----------------------------------------

		/* Exercise 4 */ System.out.println("\n #4");

		int yourAge;
		Scanner input3 = new Scanner(System.in);
		System.out.println("give new int value to yourAge");
		yourAge = input3.nextInt();
		System.out.println("Your age is: "+ yourAge +" years old");


		System.out.println(System.lineSeparator());
		// ----------------------------------------

		/* Exercise 5 */ System.out.println("\n #5");

		/* this was not dynamic - so I changed it & added a scanner for user input...
		   int a = 11;
		   int b = 10;
		 */
		int numA;
		int numB;
		Scanner input4 = new Scanner(System.in);
		System.out.println("enter int for numA");
		numA = input4.nextInt();
		System.out.println("enter int for numB");
		numB = input4.nextInt();
		System.out.println("Youve entered 2 numbers :"+ numA +" & "+ numB);

		/* if (numA > numB) {
			System.out.println(numA +" is larger than "+ numB);
		}
		if (numA < numB) {
			System.out.println(numB +" is larger than "+ numA);
		}
		if (numA == numB) {
			System.out.println(numA +" & "+ numB +" are the same");
		}
		 */
		// condense the code properly.
		if (numA > numB) {
			System.out.println(numA +" is larger than "+ numB);
		} else {
			if (numA < numB) {
				System.out.println(numB +" is larger than "+ numA);
			} else {
				System.out.println(numA +" & "+ numB +" are the same");
			}
		}
		// close scanners
		input1.close();
		input2.close();
		input3.close();
		input4.close();

		// =================================
		System.out.println("\n--- end ---");

		/* comments...
		 */

	}

}
