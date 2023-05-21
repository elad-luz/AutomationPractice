package a_java.conditions;

public class DecisionMaking1 {

	public static void main(String[] args) {
		System.out.println("DecisionMaking 1:\n=================");
	
		/* Learn conditioned code statements: if - else / nested if / switch - case, default, break
		   the Relational Operators ==,!=,>,<,>=,<= (talk about it with DecisionMaking)
		   the Logical Operators &&,||,!
		   boolean expression = true;
		   syntax for: if \ else condition with result that can be 'true' or 'fal                                                                                        se' that drives an action to do something
		 */
		
		/* # 1 */ System.out.println("\n #1 ) IF => ");

		int a=10;
		int b=20; // run once with "20" and once with "2"
		System.out.println("given: a="+a +" b="+b);

		if(a>=b) {
			System.out.println(a + " >= " + b);
		}
		else {
			System.out.println(a + " =< " + b);
		}
		System.out.println("---------------");

		System.out.println(System.lineSeparator());
		// ----------------------------------------	

		int num1=20; // declare and initialize a variable
		int num2=30;

		String name ="Gal"; // declare and initialize a variable => run once with "gal" and once with "Gal"
		String welcome = "Welcome " + name; // declare and initialize a new variable, combined of a string + initiated variable

		System.out.println("given: num1="+num1 +" num2="+num2);

		// condition
		if (num1 >= 10) {
			// if the condition result is 'true' => do something - can be one or many more code commands, also more if conditions / call for methods etc.
			System.out.println("condition: num1 >= 10 ? print num1: " + num1);
		}
		else{
			// do the following only if the condition result is 'false' => in this case, do nothing!
		}

		System.out.println(System.lineSeparator());
		// ----------------------------------------

		// condition - using '.contains'
		System.out.println("given: \"welcome\" = " + welcome);
		if (welcome.contains("gal")) {
			System.out.println("welcome conatins the word: gal");
		}
		else {
			System.out.println("welcome not conatins the word gal");
		}

		System.out.println(System.lineSeparator());
		// ----------------------------------------

		// condition  - using logical operators for comparison
		if ((num2>num1) && (num2>20)) {
			if (num2>25) {
				System.out.println("num2 bigger than 25");
			}
			else
			{
				System.out.println("num2 between 21-25");
			}
		}
		else {
			System.out.println("num2 is=" + num2);
		}

		System.out.println(System.lineSeparator());
		// ----------------------------------------

		num2=num1; // initialize a new value to variable (equal to another)
		// condition
		if (num2==num1) {
			System.out.println("condition is true");
		}

		System.out.println(System.lineSeparator());
		// ----------------------------------------

		String browser = "Safari"; // declare and initialize another variable
		// condition - using '.equals' => Case Sensitive look for exact match !!!
		// if you want flexibility use: equalsIgnoreCase
		if (browser.equals("Firefox")) {
			System.out.println("Firefox browser");
			// can include set of commands...
		}
		if (browser.equals("Chrome")) {
			System.out.println("Chrome browser");
		}
		if (browser.equals("IE")) {
			System.out.println("IE browser");
		}
		else {
			System.out.println("Safari browser");
		}
		// see bellow, using switch...
		
		// if using string.toLowerCase check whether it contains a sub-string
		String dafdefan = "Chrome"; // chrome - red, firefox - blue, edge - yellow, others - green
		if (dafdefan.toLowerCase().contains("chro")) {
			System.out.println("chrome - red");
		} else if (dafdefan.toLowerCase().contains("fire")) {
			System.out.println("firefox - blue");
		} else if (dafdefan.toLowerCase().contains("edg")) {
			System.out.println("edge - yellow");
		}
		else {
			System.out.println("others - green");
		}

		System.out.println(System.lineSeparator());
		// ----------------------------------------

		// condition - using else - if
		int time = 22;
		if (time < 10) { // (condition1) block of code to be executed if condition1 is true
		  System.out.println("Good morning.");
		} else if (time < 20) { // (condition2) block of code to be executed if the condition1 is false and condition2 is true
		  System.out.println("Good day.");
		} else {
		  System.out.println("Good evening."); // block of code to be executed if the condition1 is false and condition2 is false
		} // Output: "Good evening."
		
		System.out.println(System.lineSeparator());
		// ----------------------------------------

		// condition - using return
		// use return in condition - this keyword finish the execution of the method, and can be used to return a value from a method
        boolean t = true; // true -- false
        System.out.println("Before the return.");
     
        if (t)
            return;
 
        // Compiler will bypass every statement after return
        System.out.println("This won't execute.");

		System.out.println(System.lineSeparator());
		// ----------------------------------------
		
		
		/* # 2 */ System.out.println("\n #2 ) SWITCH => ");
		

		// conditions - Use the switch statement to select one of many code blocks to be executed.
		String useBrowser = "Safari"; // declare and initialize another variable: Firefox, Chrome, IE, Safari...
		System.out.print("You use: ");
		
		switch (useBrowser) {
		case "Firefox":
			// can include set of commands...
			System.out.println("firefox browser");
			break;
		case "Chrome":
			// commands
			System.out.println("chrome browser");
			break;
		case "IE":
			// commands
			System.out.println("ie browser");
			
			break;
		default:
			System.out.println(browser + " broswer (not: Firefox, Chrome or IE)");
			
			break;
		}
		
		System.out.println(System.lineSeparator());
		// ----------------------------------------
		
		int day = 5; // choose day number 1 to 8 => output Week-day / Week-end / Non
		switch (day) {
		  case 1: case 2: case 3: case 4: case 5:
		    System.out.println("day #"+ day +" is a Week-day");
		    break;
		  case 6: case 7:
		    System.out.println("day #"+ day +" is Week-end");
		    break;
          default: //Default case (not mandatory to have
              System.out.println("day #"+ day +" is Not a Week day");
              break;
		}

		// =================================
		System.out.println("\n--- end ---");

		/* comments...
		 */

	}

}
