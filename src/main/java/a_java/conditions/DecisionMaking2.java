package a_java.conditions;

public class DecisionMaking2 {

	public static void main(String[] args) {
		System.out.println("DecisionMaking 2:\n=================");

		/* # 1 */ System.out.println("\n #1 ) Conditions");
		
		// Conditions lesson:
		System.out.println("if conditions:");		
		// initiating variables for part #1
		int num = 20; // run once with 2 & once with 20
		System.out.println("num: " + num);


		// syntax for "if" (if > then > else)
		if (num > 10) { // the condition we set is to check if num is greater than 10
			// do this only if the condition returns True =?
			System.out.println(num +" > 10"); // print
		}
		else{
			// otherwise, do this if the condition returns False
			System.out.println(num +" < 10"); // print
		}

		System.out.println("--------------");		
		System.out.println("switch sintax:");
		// syntax for "switch"
		switch (num) { // defined earlier
		case 10: // if this case is true: num=10, do as commands
			System.out.println("Number is 10");
			break;
		case 20: // if this case is true: num=20, do as commands
			System.out.println("Number is 20");
			break;
		default:  // if all cases returned False, do these commands
			System.out.println("number is Nither 10 or 20");
			break;
		}

		System.out.println(System.lineSeparator());
		// ----------------------------------------

		String status="on"; // run with on, off, any...
		switch (status) {
		case "on": // if true for status=on, do as commands
			System.out.println("status - on");
			break;
		case "off": // if true for status=off, do as commands
			System.out.println("status - off");
			break;
		default:  // if all cases returned False, do these commands
			System.out.println("status - unknown");
			break;
		}	

		System.out.println(System.lineSeparator());
		// ----------------------------------------

		// initiating variables for part #2		
		int age = 23; // run with value = 23, 8, 18, 58, 68
		System.out.println("age: " + age);		
		int gil;

		if (age < 18) {
			gil = 1;
		}
		else if (age == 18) {
			gil = 2;
		}
		else if (age > 66) {
			gil = 3;
		}
		else {
			gil = 0;
		}

		System.out.println("--------------");	

		switch (gil) {
		case 1: // under 18
			System.out.println("Katin");
			break;
		case 2: // is 18
			System.out.println("18 years old");
			break;
		case 3: // over 66
			System.out.println("Pensioner");
			break;
		default:  // if all cases returned False, do these commands
			System.out.println("He is older than 18 yet not a Pensioner");
			break;	
		}

		System.out.println(System.lineSeparator());
		// ----------------------------------------

		// combinations + using "CONTAINS":
		System.out.println("-Good Vibes-");

		int num1=10;
		int num2=5;
		int sum;
		sum = num1+num2;
		System.out.println("sum = "+sum);

		String name = "BOB"; // change XXX to BOB
		String welcome = "Welcome " + name;

		if (welcome.contains("BOB")) {
			System.out.println("welcome BOB");
		}
		else {
			System.out.println("welcome not BOB");
		}	
		if (num1==num2) {
			System.out.println("==");
		}
		else System.out.println("=!");

		System.out.println(System.lineSeparator());
		// ----------------------------------------

		// CODE...
		String str = "xyz"; // declare the variable and initialize with value - USE: xxx / sss / xyz
		switch (str) { // "switch" decision making
		case "xxx": // if returned 'True', in case that sting is "xxx", do as command...
			System.out.println("xxx"); // print
			break; // terminate this case and go on to next
		case "sss":
			System.out.println("sss");
			break;
		default:  // if all cases returned 'False', do these commands...
			System.out.println(str +" is neither 'xxx' nor 'sss'");
			break;	
		} 

		// =================================
		System.out.println("\n--- end ---");

		/* comments...
		 */

	}

}
