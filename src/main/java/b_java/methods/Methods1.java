package b_java.methods;

public class Methods1 {

	public static void main(String[] args) {
		System.out.println("Methods 1:\n==========\n");
		
		/* # 0 */ System.out.println("=> main can make use of methods written out-side main to modulate the code \n");

		// code section:
		
		// methods over-writing input (always return 1 or String)
		System.out.println("methodName1 (0): " + methodName1(0));
		System.out.println("methodNameS (0): " + methodNameS(0));
		int mn = 10;
		System.out.println("methodName1 (mn): " + methodName1(mn));
		System.out.println("methodNameS (mn): " + methodNameS(mn));
		
		// vars to be used in methods
		int n = 20;
		int m = 30;
		int o = 40;
		// returnSum(num1,num2,num3)
		System.out.println(returnSum(n,m,o) + " ==> is the sum of: " + n + ", " + m + ", " + o);		
		// printSum(num1,num2)
		printSum(n,m);
		
		// getMax out of 3 ints
		int g = getMax(n, m, o);
		System.out.println("the biggest out of: " + n + ", " + m + ", " + o + " ==> " + g);
		
		// give other value to variables & re-use the same methods
		n = 25;
		m = 30;
		o = 15;
		g = getMax(n, m, o);
		
		System.out.println(returnSum(n,m,o) + " ==> is the sum of: " + n + ", " + m + ", " + o);
		printSum(n,m);
		System.out.println("the biggest out of: " + n + ", " + m + ", " + o + " ==> " + g);
		// or just print it:
		System.out.println(getMax(n, m, o));
		
		// printBigger out of 2 ints
		int n1 = 1;
		int n2 = 3;
		System.out.println("who is bigger between: " + n1 + " and " + n2 + " ?");
		printBigger(n1,n2);
		printBigger(1,3);
		// you can't use this: System.out.println(printBigger(n1,n2)); because the method is void !!!
		
		// =================================
		System.out.println("\n--- end ---");

	} // end of main

	/** METHODS (out-side of 'main'): can reside out-side of 'main' method {} BUT must be run from main */
	
	// this method will: do what.. (get what... -&- return what...) */
	public static void printHW() {
		System.out.println("\nHello world!\n------------");
	}
	// ----- MORE below:
	
	// a method that gets value of one integer, and always return integer value of 1
	public static int methodName1(int a) { 
		return 1;
	}
	
	// a method that gets value of one integer, and always return string: "string"
	public static String methodNameS(int a) { 
		return "string";
	}
	
	// this method gets value of 3 integer 'local variables', and returns their sum
	public static int returnSum(int a, int b, int c) {
		int sum = a+b+c;
		return sum;
	}
	
	// a method that gets value of 2 integers and prints their sum
	public static void printSum(int a, int b) {
		int sum = a+b;
		System.out.println("\n" + "-- calculate 2 integers --");
		System.out.println("sum of: " + a + " and " + b + " is: " + sum + "\n");
	}
	
	// a method that gets value of 3 integers and returns the biggest one
	private static int getMax(int x, int y, int z) {
		int max;
		if(x > y  &&  x > z){
			max = x;
		}
		else if(y > x  &&  y > z){
			max = y;
		}
		else{
			max = z;
		}
		return max;
	}
	
	// a void method that gets value of two integers and print the bigger one
	private static void printBigger(int n1, int n2) {
		int bigger;
		if(n1 > n2)
			bigger = n1;
		else
			bigger = n2;
		System.out.println("bigger: " + bigger); ;
	}

}
//comments: /* /** */