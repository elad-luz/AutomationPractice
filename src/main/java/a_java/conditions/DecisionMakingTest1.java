package a_java.conditions;

public class DecisionMakingTest1 {

	public static void main(String[] args) {
		System.out.println("Test exersise:\n==============");
		
		/* # 1 */ System.out.println("\n #1 ) print double if > 5");
		
		double number = 5.1; // use 5.1 & 0.1
		if (number > 5) {
			System.out.println("number met condition: "+ (number) +" is bigger then 5");
		} // could add: else {System.out.println("number smaller then 5: "+ (number));}

		System.out.println(System.lineSeparator());
		// ----------------------------------------

		/* # 2 */ System.out.println("\n #2 ) print name & age if older then 30");
		
		String name = "elad";
		int age = 52; // use 22 & 52
		
		if (age > 30) {
			System.out.println("you are older then 30 - name: "+ (name) +" & age: "+ age);
		} else {
			System.out.println("age =< 30: "+ (age));
		}

		System.out.println(System.lineSeparator());
		// ----------------------------------------

		/* # 3 */ System.out.println("\n #3 ) find minimal out of 3 numbers (using comparison)");
		
		int num1 = 20;
		int num2 = 30;
		int num3 = 10;
		// the code works, but I'm not sure I wrote the best !
		if ((num1 < num2) && (num2 < num3) && (num1 < num3)) {
			System.out.println("the minimal number is "+ num1);
		} else if ((num2 < num3)) {
			System.out.println("the minimal number is "+ num2);
		} else {
			System.out.println("the minimal number is "+ num3);
		}

		System.out.println(System.lineSeparator());
		// ----------------------------------------

		/* # 4 */ System.out.println("\n #4 ) print student wth max grade");
		
		String sName1 = "elad";
		String sName2 = "liad";
		int s1Grade = 90;
		int s2Grade = 80;
		// the code works, but I'm not sure I wrote the best !
		if (s1Grade > s2Grade) {
			System.out.println("student wth max grade: "+sName1);
		} else if (s1Grade < s2Grade) {
			System.out.println("student wth max grade: "+sName2);
		} else {
			System.out.println("both students got same grade");
		}

		// =================================
		System.out.println("\n--- end ---");

		/* comments...
		 */

	}

}
