package b_java.methods;

public class MethodsExercise1 {

	public static void main(String[] args) {
		System.out.println("Methods exersise 1:\n===================\n");

		/* # 0 */ System.out.println("=> main method\n");
		
		// simple printout not using any new method
		System.out.println("-----------");
		
		// using: printHelloWorld
		printHelloWorld();
		
		// using: printNameAge
		printNameAge("Elad Luz", 52);
		printNameAge("Luz Elad", 25);
		
		// using: add5
		System.out.println("add 5 to 6:\n"+ add5(6) +"\n-----------");
		System.out.println("add 5 to 0:\n"+ add5(0) +"\n-----------");
		
		int num = 10;
		int calcNum = add5(num); // other way of using it
		System.out.println("calculated num = "+ calcNum);
		
		// using: calcSum
		int calculated = calcSum(8,7);
		System.out.println("calculated sum of 2 numbers is: "+ calculated);
		System.out.println("calculated sum of 2 numbers is: "+ calcSum(6,9));
		
		// =================================
		System.out.println("\n--- end ---");

	} // end of main

	/** # 1) this method will: print "Hello world" (get nothing -&- return nothing = void) */
	public static void printHelloWorld() {
		System.out.println("Hello world\n-----------");
	}
	// -----
	
	/** # 2) this method will: print a given "name" and age (get String name + double age -&- return nothing) */
	public static void printNameAge(String name, double age) {
		System.out.println("given name:\n"+ name +" > age is: "+ age +"\n-----------------------");
	}
	// -----
	
	/** # 3) this method will: calculate a given int + 5 (get int num -&- return addition NumPlus5 = num+5) */
	public static int add5(int num) {
		int NumPlus5 = num + 5; // calculating the number+5
		/* you could have make use the variable in brackets & not declare new one by doing:
		   num = num + 5;
		   and returning the num... */
		return NumPlus5;
	}
	// -----
	
	/** # 4) this method will: calculate sum of 2 given int (get int num1, num2 -&- return addition num1+num2) */
	public static int calcSum(int number1, int number2) {
		return number1 + number2;// returning the calculated sum of both
	}

}
// comments: /* /** */