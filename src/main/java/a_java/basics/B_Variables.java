package a_java.basics;

public class B_Variables {

	public static void main(String[] args) {
		System.out.println("Variables:\n==========");
	/** https://www.w3schools.com/java/java_variables.asp
	 	To create a variable, you must declare it (specify type and give name) & initiate it (assign a value):
	 	*/
		/* # 1 */ System.out.println("\n #1 ) Variables types:");
		
		int age; // declare >
		age = 50; // initiate
		System.out.println("my Age is not: "+age);

		double salary = 26500.58; // declare & initiate at once
		System.out.println(salary);
		salary = 28000.00; // then set upon flight, a new value
		System.out.println(salary);

		age = 52;
		System.out.println(age);

		boolean flag;
		flag = true;
		System.out.println(flag);

		// NOTE: Sting is not a variable but a CLASS by itself, with Methods operations you can make use of more powerful capabilities, like  .length()  !
		String name = "elad"; // String - see it start with Capital (not lower-case)
		System.out.println(name);
		System.out.println(name.length() +" letters in the name: "+ name); // this example show the use one of String Methods (calculate length of string)
		System.out.println(name.concat(" luz")); // adding another string on the flight
	/** Note: 
		because String is a Class, it was actually needed to be stated as such (see below) and it works OK!
		String newName = new String ("pood");
		System.out.println(newName);		
		but because is is so commonly use it was also made to support the short declaration version (shown previously)
	*/
		System.out.println(System.lineSeparator());
		// ----------------------------------------

		/* # 2 */ System.out.println("\n #2 )");
		
		// print complex
		System.out.println("My name is " + name + " and I am " + age + " years old.");

		/* comments for code:
		 * Note: Local Variables have a life-span only during their use in main function of current class
		 */

		System.out.println("\nVariables (declare, initialize & print) \n" + "=======================================");
		int a; // declare a variable
		a=1; // initialize a variable
		double db = 215.42; // declare and initialize a variable
		System.out.println("int: " + a + "   |  double: " + db); // print variable

		char ch = 'c'; // wrap chars with: '
		String str = "STRING"; // wrap strings with: "
		System.out.println("char: " + ch + "  |  string: " + str); // print variable

		System.out.println(System.lineSeparator());
		// ----------------------------------------

		/* # 3 */ System.out.println("\n #3 ) Examples:");

		// int myAge; // declaring variable
		// myAge = 47; // initializing variable (give a value)
		int myAge = 47; // declare and initialize a variable
		String myAdress = "K. Ono";
		String myName= "Elad";
		Float myHeight = 1.68f;
		System.out.println("myAge is " + myAge);
		System.out.println(myAdress);
		System.out.println(myName);
		System.out.println(myHeight);

		// using math...
		int xAge = 23;
		System.out.println("Age is:  ???");
		System.out.println(xAge + 5); // 23+5 = 28
		System.out.println(xAge +" + 5 => "+ (xAge + 5)); // to use it with a string you'll need brackets - if not, you will print 235 = 23 & 5
		System.out.println(xAge * 3);
		int yAge = xAge*3;
		System.out.println("yAge = xAge*3 => "+yAge);

		System.out.println(System.lineSeparator());
		// ----------------------------------------

		// declare & initiate variable with value, print it, change value and re-print...
		int i = 45;
		System.out.println("int = " + i);
		i = 50;
		System.out.println("int = " + i);

		String s = "elad";
		System.out.println("string s = " + s);
		s = "luz";
		System.out.println("string s = " + s);
		
		// another example of running over vars' values
		int X = 1;
		String S = "S1";
		System.out.println(" - 1st: "+ X +", "+ S);
		
		X = 2;
		S = "S2";
		System.out.println(" - 2ed: "+ X +", "+ S);
		
		// USING "final" on variable means in can be assign a value only once -> cannot run-over vars' given value !!!
		final int f = 1;
		System.out.println("using final = "+ f);
		// f = 2; <- if we try to re-assign value to final variable, we get Compiler Error: The final local variable f cannot be assigned!
		
		// =================================
		
		/**   CONVERT STRING TO NUMBER INT \ DOUBLE   **/
		
		System.out.println(
		"------------------------\nCONVERT STRING TO NUMBER");
        // declare and initialize a string of text & number (stn)
        String stn = "A 32.10";
        System.out.println(stn); // 'A 32.10'
        // declare and initialize a string using previous and remove from it, the textual part (with space), to be left with only a number
        String sn = stn.replace("A ", ""); // note you could have used the previous var & run it over: String stn = stn.replace("A ", "");
        System.out.println(sn); // '32.10'
        // Converting the above string into Double using: parseDouble() Method
        double dou = Double.parseDouble(sn); 
        // double dou = Double.valueOf(sn); // same as above!
        System.out.println(dou); // '32.1' (printing string as Double type)
        
        System.out.println(System.lineSeparator());
		// ----------------------------------------

        // declare and initialize a string of text & number with sign to integer (s2n)
        String price = "25$"; // same as above - convert textual string of number to integer (s2i)
        String s2i = price.replace("$", ""); // remove $ sign
        int numb = Integer.parseInt(s2i); // parse to int
        System.out.println(numb); // ->  output = 25
        
        System.out.println(System.lineSeparator());
		// ----------------------------------------

/**     // declare and initialize a variable using var
        System.out.println("using var:");
        var x = 100; // int
        var y = 1.90; // double
        var z = 'a'; // char
        var p = "tau"; // string
        var q = false; // boolean

        // type inference is used in var keyword in which it
        // automatically detects the datatype of a variable
        System.out.println(x);
        System.out.println(y);
        System.out.println(z);
        System.out.println(p);
        System.out.println(q);
*/
        // =================================
		System.out.println("\n--- end ---");

		/* comments...:
		   https://www.geeksforgeeks.org/var-keyword-in-java/ ->
		   Starting with Java SE 10, you can use the var type identifier to declare a local variable.
		   In doing so, you let the compiler decide what is the real type of the variable you create.
		   Once created, this type cannot be changed.
		   var can be used in a local variable declaration instead of the variable's type.
		   With var , the Java compiler infers the type of the variable at compile time,
		   using type information obtained from the variable's initializer.
		   The inferred type is then used as the static type of the variable.
		 */

	}

}
