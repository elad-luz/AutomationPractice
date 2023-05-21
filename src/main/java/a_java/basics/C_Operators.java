package a_java.basics;

public class C_Operators {

	public static void main(String[] args) {
		System.out.println("Operators:\n==========");

		/* # 1 */ System.out.println("\n #1 ) Operators: Arithmetic & Logical");
		
		// Arithmetic
		long num; // abbreviate number
		num = 0;
		System.out.println(num);

		num = 2 * (3 + 3) + 3; // as known math order
		System.out.println(num); // will print 15 (last input)

		num = num + 5; // new value make use of previous input
		System.out.println(num); // will print 20 |=> 15+5

		num = num + 1; // spacing is only for readability
		System.out.println(num); // will print 21 |=> 20+1

		num++; // same as num = num +1; (adding 1 to num)
		System.out.println(num); // will print 22 |=> 21+1

		num = num - 1; // subtracting 1 from last input
		System.out.println(num); // will print 21 |=> 22-1

		num--; // same as num = num -1; (subtracting 1 from num)
		System.out.println(num); // will print 20 |=> 21-1

		int i1 = 2;
		int i2 = 3;
		int i3 = i1 + i2;
		System.out.println(i3); // will print 5 (2+3)
		System.out.println(i1 * i2); // will print 6 (2*3)
		System.out.println(i1 + i2); // will print 5 (2+3)
		System.out.println(i1 + " " + i2); // will print both (2 & 3)

		// Logical (returning T / F for statements)
		boolean results; // value can present T / F of given statement -> boolean b = true;
		results = 10 > 5; // is that claim true or false? -> the case will set the variable 
		System.out.println(results + " => returned true for logical claim: 10 > 5");

		results = 5 != 13; // c = 5 as stated above ^
		System.out.println(results + " => returned false for logical claim: 5 don't equal 5");

		int age = 30;
		results = age <= 31; // less then or equal
		System.out.println(results + " => returned true for logical claim: 30 <= 31");

		results = age == 30; // equals
		System.out.println(results + " => returned true for logical claim: 30 = 30");

		results = age > 20 && age < 40; // AND -> age is greater then 20 and less then 40
		System.out.println(results + " => returned true for logical claim: 20 > 30 > 40");

		results = age > 20 && age < 30; // age is greater then 20 -and- less then 30 (both conditions must be true)
		System.out.println(results + " => returned false for logical claim: 20 > 30 > 30"); // false

		results = age > 30 || age < 40; // OR -> age is greater then 30 -or- less then 40 (only one of the conditions must be true)
		System.out.println(results + " => returned true for logical claim: 30 > 30  OR  30 < 40"); // true

		System.out.println(System.lineSeparator());
		// ----------------------------------------
		
		int number = 5;
		int square = number * number;
		System.out.println("the square of " + number + " is: " + square);

		System.out.println(System.lineSeparator());
		// ----------------------------------------


		/* # 2 */ System.out.println("\n #2 ) More...");

		// declare & initiate variables
		int a = 13;
		int b = 41;
		System.out.println("a=" + a + "  |  b=" + b);

		System.out.println("arithmetic operators:");
		// arithmetic numeric operators
		int c = a + b; // addition
		System.out.println("a+b=" + c + " = c");
		System.out.println("a+b=" + (a + b));
		System.out.println("a+1=" + (a + 1)); // plus integer
		int d = b - a; // subtraction
		System.out.println("b-a=" + d + " = d");
		System.out.println("b-a=" + (b - a));
		System.out.println("b-1=" + (b - 1)); // minus integer
		int e = a * b; // multiplication
		System.out.println("a*b=" + e);
		System.out.println("a*2=" + (a * 2)); // multiple by integer
		int f = b / a; // division result of whole number
		int g = b % a; // modulo operation returns the remainder of division (result of what remains after division)
		System.out.println("a/b => division of (" + b + ") with (" + a + ") is (" + f
				+ ") with Remainder [modulus] of (" + g + ")");

		// increment & decrement
		a++; // plus one
		b--; // minus one
		int h = b - a;
		System.out.println("incemented a++ =" + a + " |" + " decremented b-- =" + b + " | now: a-b=" + h);

		// -----------------------
		System.out.println("\n");
		System.out.println("input operators:");
		// input operators (placement \ assigning of value to a variable)
		int wow = 0; // declare and initialize the variable wow
		int i = wow; // declare and initialize the variable i which gets the value of wow
		System.out.println("orig i = " + i);
		i += 10; // assign a new value to a variable, that equals original value plus 10
		System.out.println("+10 = " + i);
		i -= 1;
		System.out.println("-1 = " + i);
		i *= 2;
		System.out.println("*2 = " + i);
		i /= 4;
		System.out.println("/4 = " + i); // without the Remainder modulo (modulo operation returns the remainder)
		i++; // plus one - assign a new value to a variable, that equals original value plus one
		System.out.println(i + " plus one = " + i);
		System.out.println(i + " plus one = " + (++i) + " => i = " + i); // note the pluses are on the left side
		i--; // minus one
		System.out.println(i + " minus one = " + i);

		/* # 3 */ System.out.println("\n #3 ) Operators: Relational & Logical");
		
		// declare & initiate variables
		int a1 = 13;
		int b1 = 41;
		System.out.println("a1=" + a1 + "  |  b1=" + b1);

		System.out.println("relational operators:");
		// relational operators will always return a boolean result: true -or- false
		boolean bRes;
		bRes = (a1 == b1); // "is a equals to b?" -- returns true if a1 equals to b1 -&- false if not
		System.out.println("a  = b => " + bRes);
		bRes = (a1 != b1); // "is a different from b?" -- returns true if a1 different from b1 -&- false if not
		System.out.println("a1 != b1 => " + bRes);
		bRes = (a1 > b1); // "is a bigger than b?" -- returns true if a1 bigger than b1 -&- false if not
		System.out.println("a1  > b1 => " + bRes);
		bRes = (a1 < b1); // "is a smaller than b?" -- returns true if a1 smaller than b1 -&- false if not
		System.out.println("a1  < b1 => " + bRes);
		bRes = (a1 >= b1); // returns true if a1 bigger or equals to b1 -&- false if not
		System.out.println("a1 >= b1 => " + bRes);
		bRes = (a1 <= b1); // returns true if a1 smaller or equals to b1 -&- false if not
		System.out.println("a1 <= b1 => " + bRes);

		// -----------------------
		System.out.println("\n");
		System.out.println("extra:");
		// relational boolean operators - another example
		int x = 5;
		int y = 11;
		System.out.println("? " + x + " equall to " + y + " => " + (x == y)); // false
		System.out.println("? " + x + " bigger than " + y + " => " + (x > y)); // false
		System.out.println("? " + x + " smaller than " + y + " => " + (x < y)); // true
		System.out.println(5 > 6); // false
		System.out.println(5 > 4); // true

		// -----------------------
		System.out.println("\n");
		System.out.println("logical operators:");
		// logical operators for comparison between 2 boolean inputs and returns another boolean input
		boolean bo1 = true; // declare and initialize the variable
		boolean bo2 = false;
		boolean bo3 = true;
		boolean bo4 = false;

		boolean bRand; // declare the boolean variable bRand
		bRand = bo1 && bo3; // initialize bRand with logical comparison operator 'and' --- returns true only if both are true
		System.out.println("&& and => " + bRand); // both are true = true
		System.out.println(bo1 && bo2);
		boolean bRor = bo1 || bo2; // logical 'or' --- return true if one is true
		System.out.println("|| or => " + bRor); // at least one is true = true
		System.out.println(bo2 || bo4);
		boolean bRnot = !bo4; // logical 'not' --- return the opposite value given
		System.out.println("! not => " + bRnot + " (orig value was " + bo4 + ")"); // opposite to false = true
		System.out.println(!bo1);

		int ia = 1;
		int ib = 2;
		boolean bool;
		bool = (ia < ib); // is this statement true of false? (its true because 1<2)
		System.out.println("expected T - got: "+bool);

		// =================================
		System.out.println("\n--- end ---");

		/* comments...
		 */

	}

}
