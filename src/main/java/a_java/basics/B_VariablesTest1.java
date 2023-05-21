package a_java.basics;

public class B_VariablesTest1 {

	public static void main(String[] args) {
		System.out.println("Test exersise:\n==============");
		
		/* # 1 */ System.out.println("\n #1 ) print int variable");
		
		int number = 11;
		System.out.println("number: "+ number);
		


		System.out.println(System.lineSeparator());
		// ----------------------------------------

		/* # 2 */ System.out.println("\n #2 ) print sum of 2 numbers");
		
		double numberA = 0.1;
		double numberB = 10.9;
		System.out.println("SUM: "+ (numberA+numberB));
		
		/* comments: could be also
		   double sumAB = numberA+numberB;
		   System.out.println("SUM: "+ sumAB);
		 */

		// =================================
		System.out.println("\n--- end ---");

	}

}
