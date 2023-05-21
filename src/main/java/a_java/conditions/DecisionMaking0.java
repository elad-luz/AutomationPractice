package a_java.conditions;

public class DecisionMaking0 {

	public static void main(String[] args) {
		System.out.println("DecisionMaking 0:\n=================");

		/* # 1 */ System.out.println("\n #1 ) simple condition:");
		
		int age = 50;
		if (age > 10) { // only if condition in brackets is true, the code proceed to next action
			System.out.println("age "+ age +" years is more than 10 years !");
		}
		if (age > 10 && age < 60) {
			System.out.println(age +" > 10 AND "+age+" < 60");
		}
		if (age != 40) { // true, will print !
			System.out.println(age +" is not 40");
		}
		if (age == 40) { // false, won't print !
			System.out.println(age);
		}

		/* # 2 */ System.out.println("\n #2 ) boolean:");
		
		boolean res1 = age == 50; //a boolean T/F result = True (age is 50 is right)
		if (res1) { // no need for the condition, because the boolean already state true or false
			System.out.println(res1 +": age = 50");
		}

		boolean res2 = age != 50; //a boolean T/F result = False (age is not 50 is wrong)
		if (res2) { // a false condition will not proceed (because you expect true)
			System.out.println(res2 +": age != 50 ---------"); // will not print !
		}
		if (res2 == false) { // can also use a false condition to proceed if you are asking for a false
			System.out.println("print "+ res2 +": age != 50"); // will print this!
		}

		/* # 3 */ System.out.println("\n #3 ) if - else:");
		
		int height = 190; // 170 is considered NOT tall & 190 considered tall!
		if (height > 180) {
			System.out.println("height "+ height +" cm, is considered tall");
		} else {
			System.out.println("height "+ height +" cm, is considered NOT tall");
		}

		// =================================
		System.out.println("\n--- end ---");

		/* comments...
		 */

	}

}
