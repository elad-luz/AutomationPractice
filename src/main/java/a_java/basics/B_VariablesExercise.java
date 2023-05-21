package a_java.basics;

public class B_VariablesExercise {

	public static void main(String[] args) {
		System.out.println("Variables exersise:\n===================");

		/* Exercise 1 */ System.out.println("\n #1");
		
		int myAge;
		myAge = 51;
		long mySalary;
		mySalary = 25000;
		String myAddress;
		myAddress = "Brenner 1/21 K. Ono";
		String myName;
		myName = "Elad Luz";
		double myHeight;
		myHeight = 168.50;
		System.out.println("Old ME = myName: " + myName + ", myAddress: " + myAddress + ", myAge: " + myAge
				+ ", myHeight: " + myHeight + ", mySalary: " + mySalary);

		myAge = 52;
		mySalary = 23000;
		myAddress = "Brenner 1/21 K. Ono";
		myName = "Elad Luz";
		myHeight = 167.00;
		System.out.println("New ME = myName: " + myName + ", myAddress: " + myAddress + ", myAge: " + myAge
				+ ", myHeight: " + myHeight + ", mySalary: " + mySalary);

		System.out.println(System.lineSeparator());
		// ----------------------------------------

		/* Exercise 2 */ System.out.println("\n #2");
		
		int age = 52;
		System.out.println(" age= " + age + ",\n age+5= " + (age + 5) + ",\n age-2= " + (age - 2));

		System.out.println(System.lineSeparator());
		// ----------------------------------------

		/* Exercise 3 */ System.out.println("\n #3");
		
		int childAge = 5;
		double employeeSalary = 2000.35;
		boolean questionYN = true;
		String firstName = "Avi";
		System.out.println(childAge + ", " + employeeSalary + ", " + questionYN + ", " + firstName);

		System.out.println(System.lineSeparator());
		// ----------------------------------------

		/* Exercise 4 */ System.out.println("\n #4");
		
		System.out.println(3 + 4 + 5); // will print the sum 12
		System.out.println("3+4+5"); // will print 3+4+5 as string

		System.out.println(System.lineSeparator());
		// ----------------------------------------

		/* Exercise 5 */ System.out.println("\n #5");
		
		int a = 2;
		int b = 3;
		// could be stated as both: int a=2, b=3;
		int A = a + b * 2; // should be 8
		int B = (a + b) * 2; // should be 10
		System.out.println("A: " + A + ", B: " + B);

		System.out.println(System.lineSeparator());
		// ----------------------------------------

		/* Exercise 6 */ System.out.println("\n #6");
		
		long l = 10;
		System.out.println(l + 20); // should be 30
		System.out.println(l * 4); // should be 40
		System.out.println(l / 2); // should be 5

		System.out.println(System.lineSeparator());
		// ----------------------------------------

		/* Exercise 7 */ System.out.println("\n #7");
		
		long circleRadius = 10;
		long radiusSquer = circleRadius * circleRadius; // System.out.println(radiusSquer); = 100
		double PI = 3.1415;
		// note you can result from long & double to double but not from double to long => so NOW the Area must be double !!!
		double circleArea = PI * (radiusSquer); // System.out.println(PI*100);
		int rectangLeLength = 10;
		int rectangleWidth = 5;
		int rectangArea = rectangLeLength * rectangleWidth;
		System.out.println("circleArea: " + circleArea + " rectangArea: " + rectangArea);
		System.out.println("BOTH circle and rectang Area is: " + (circleArea + rectangArea));

		// =================================
		System.out.println("\n--- end ---");

		/* comments...
		 */

	}

}
