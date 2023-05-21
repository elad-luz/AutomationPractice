package b_java.methods;

import java.util.Scanner;

public class Methods0 {

	public static void main(String[] args) {
		System.out.println("Methods 0:\n==========\n");
		
		/* # 0 */ System.out.println("=> main method: can make use an other outer methods \n");

		System.out.print("------------"); // a regular printout
		
		printHW(); // the method prints the 'Hello World' block
		
		// Reuse of the following method save the effort of writing it twice:
		menuChoice(true);  // print menu for Adult = true	
		menuChoice(false); // print menu for Kids = false
		
		printStudentInfo("elad", "luz", 52, 95); // give method (string) F & L name (int) age & grade to print nicely
		
		sumP(2, 3); // give method 2 numbers to Print the sum
	
		printStudentInfo("niv", "levi", 22, 90); // re-using method
		
		// using scanner in that method to make dynamic...
		Scanner s = new Scanner(System.in);
		System.out.println("please enter first name (q):");
		String NameF = s.next(); // not correlative to the orig methods' (in use) naming of variables - here the variables are for the input
		System.out.println("please enter last name (a):");
		String NameL = s.next();
		System.out.println("please enter age (1):");
		int sAge = s.nextInt();
		System.out.println("please enter grade (2):");
		int grade = s.nextInt(); // this "grade" is not related to the grade variable in method - each variable effect only the block method it is in
		printStudentInfo(NameF, NameL, sAge, grade);
		//
		s.close();
		
		sumP(3, 4); // re-using method P
		
		sumR(3, 4); // using method R - give method 2 numbers to get the sum back (we got it but did not do anything with it)
		
		// how to use a method that return something
		int total;
		total = sumR(3, 4);
		System.out.println("print out of the total as was returned by method: "+ total);
		
		total = sumR(sumR(10, 20), sumR(20, 40)); // nested use of that R method => 10+20=30, 20+40=60 ==> 30+60=90 !
		System.out.println("print out of the total as was returned by method: "+ total);
		
		// complex use of methods
		double radius = 10;
		double CircleArea = calcCircleArea(radius);
		System.out.println("\n=> the area of circle with radius="+ radius +" is: "+ CircleArea);
		// using the method within the print
		System.out.println("=> the area of circle with radius=10.0 is: "+ calcCircleArea(10));
		
		// min of function:
		System.out.println("smaller between 10 & 4 is: "+ minOf(10, 4));
		// same function name with different parameters
		int a = 11;
		int b = 6;
		double c = 7.3;
		double d = 9.4;
		int result1 = minOf(a, b); // int
		double result2 = minOf(c, d); // double
		System.out.println("Minimum Value = " + result1);
		System.out.println("Minimum Value = " + result2);
		
		// =================================
		System.out.println("\n--- end ---");

	} // end of main

	/* This section is out of the main method (still the program must run from main) -
	   its possible to add here, many different methods, and make use of them at MAIM,
	   we can use them as many times as we like -- as long as we use them properly !!!
	   it will be easier to maintain them in this way, than if it would be in MAIM !!!
     */
	
	/** # 0) this method (out of main) will get nothing & return nothing (void = not returning back any parameter) - it just print "Hello world!" */
	public static void printHW() {
		System.out.println("\nHello world!\n------------");
	}
	// -----

	/** # 1) this method (out of main) will get boolean T or F -and will not return a thing back, it will only print the menu choice for Adult & Kid accordingly*/
	public static void menuChoice(boolean isAdult) {
		System.out.println("\n- Please choose from mune -");
		System.out.println("1. Salad");
		System.out.println("2. Pasta");
		System.out.println("3. Pizza");
		System.out.println("4. Water");
		if (isAdult) { // same as: isAdult == true (because the boolean is true to begin with)
			System.out.println("5. Wine!");
		}
 /* could have also been written like this:		
	public static void menuChpoice(boolean isChildren) { // if you switch them it can be like:
		System.out.println("Please choose from mune:");
		System.out.println("1. Salad");
		System.out.println("2. Pasta");
		System.out.println("3. Pizza");
		System.out.println("4. Water");
		if (!isChildren) { // same as: isChildren == false (because the boolean is true to begin with)
			System.out.println("5. Wine!");
		}*/
	}
	// -----
	
	/** # 2) this method (out of main) will print the given Info nicely */
	public static void printStudentInfo(String firstName, String lastName, int age, int grade) {
		System.out.println("\nStudent info\n------------");
		System.out.println("Name: "+ firstName +" "+ lastName);
		System.out.println("Age: "+ age);
		System.out.println("Grade: "+ grade);
		System.out.println("------------");
	}
	// -----

	/** # 3) this method (out of main) will get ints -and- it will NOT return anything BUT it only print the sum of both given integers */
	public static void sumP(int a, int b) {
		int sumTotal = a + b;
		System.out.println("\n"+ a +" + "+ b +" = "+sumTotal);
	}
	// -----
	
	/** # 4) this method (out of main) will get ints -and- it will return the sum of 2 given integers */
	public static int sumR(int a, int b) { // instead of void (returning nothing) - we will get an int back
		int sumTotal = a + b;
		return sumTotal;
	}
	// -----
	
	/** # 5a) the following method will not get a thing, BUT just return PI value */
	public static double getPI() { // instead of void (returning nothing) - method (getting nothing) returning PI value (using a predefined math method)
		return Math.PI; // (of course we could have just used the Math.PI - but this is just an example)
	}
	/** # 5b) the following methods will get a radius -and- will return the area of circle (by given radius using PI from prev method) */	
	public static double calcCircleArea(double radius) { // method getting radius returning circle area
		double CircleArea = radius * radius * getPI(); // getPI() was the prev method
		return CircleArea; // just returning (without any print)
	}
	// -----

	/** # 6) the following snippet will get 2 numbers -and- will return the minimum between those two numbers - implementing parallel options for both int & double */
	// for integer
	public static int minOf(int n1, int n2) {
		int min;
		if (n1 > n2)
			min = n2;
		else
			min = n1;
		return min; 
	}
	// for double
	public static double minOf(double n1, double n2) {
		double min;
		if (n1 > n2)
			min = n2;
		else
			min = n1;
		return min; 
	}

}
/* comments:
 * Method is a collection of statements that perform some specific task and return result to the caller
	- method can perform some specific task without returning anything
	- method allow us to reuse the code without retyping the code
 * this code is out-side main method & can be re-used within main to modulate the code
 * method can be 'accessed'  from:
	- "public"=> any-ware in code
	- "private"=> only the class in which it was defined
	- "null" [if not mentioned]=> it is reachable from anywhere in package containing the class in which it was defined in
 * method can be static => related to all class, or -other- related to all specific object
 * method can 'return' a variable value (by type: int, String etc.), or void (no variable returned)
 * method name usually written in camelCase (e.g. methodName)
 * method gets parameters (like local variables within method)

 	Method Declaration - has six components:
	----------------------------------------
 * Modifier-: Defines access type of the method i.e. from where it can be accessed in your application. In Java, there 4 type of the access specifiers.
	- public: accessible in all class in your application.
	- protected: accessible within the class in which it is defined and in its subclass(es)
	- private: accessible only within the class in which it is defined.
	- default (declared/defined without using any modifier) : accessible within same class and package within which its class is defined.
 * The return type : The data type of the value returned by the the method or void if does not return a value.
 * Method Name : the rules for field names apply to method names as well, but the convention is a little different.
 * Parameter list : Comma separated list of the input parameters are defined, preceded with their data type, within the enclosed parenthesis. If there are no parameters, you must use empty parentheses ().
 * Exception list : The exceptions you expect by the method can throw, you can specify these exception(s).
 * Method body : it is enclosed between braces. The code you need to be executed to perform your intended operations.
	_______
	STATIC:
	static method in Java (or static function) is a method that is part of a class rather than an instance of that class ->
	it defined as a member of an object but is accessible directly from an API object's constructor (from anywhere in src),
	rather than from an object instance created via the constructor.
	Static methods have access to class variables (static variables) without using the class's object (instance).
	Only static data may be accessed by a static method !
*/	