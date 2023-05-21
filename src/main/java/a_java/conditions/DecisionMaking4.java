package a_java.conditions;

public class DecisionMaking4 {

	public static void main(String[] args) {
		System.out.println("DecisionMaking 4:\n=================");

		/* # 1 */ System.out.println("\n #1 ) Conditions");
		
		int i = 11; // use: 9, 10, 11, 12, 13, 14, 15, 16
		System.out.println("i = "+ i);

		// ----------------       
		System.out.println("\n  #1: if");       
		if (i < 15) // can come with or without '{ }'
			System.out.println(i +" is smaller than 15");
		System.out.println("\n=> this print is not included in the if"); // will always occur

		// ----------------
		System.out.println("\n  #2: if + else");       
		if (i < 15) {
			System.out.println(i +" is smaller than 15"); }
		else {
			System.out.println(i +" is greater than 15"); }

		// ----------------
		System.out.println("\n  #3: nested if !!!");       
		if (i > 10){
			// First if statement
			if (i == 15) {
				System.out.println(i + " equals to 15");}
			if (i < 15) {
				System.out.println(i + " is greater than 10 but smaller than 15");
				// nested if statement - will only be executed if statement above it is true
				if (i <= 12) {
					System.out.println(i + " is greater than 10 but smaller than (or qual to) 12 too");}
			}
			else if (i > 15) {
				System.out.println(i + " is greater than 15");}
		}
		else if (i <= 10){
			System.out.println(i + " is smaller or equal to 10");
		}

		// ----------------
		System.out.println("\n  #4: if-else-if ladder");   
		System.out.println("i = "+ i);
		if (i == 11)
			System.out.println("i is 11");
		else if (i == 12)
			System.out.println("i is 12");
		else if (i == 13)
			System.out.println("i is 13");
		else
			System.out.println("i is not 11, 12 or 13");

		// =================================
		System.out.println("\n--- end ---");

		/* comments...
		 */

	}

}
