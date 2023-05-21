package a_java.basics;

public class C_OperatorsExercise {

	public static void main(String[] args) {
		System.out.println("Operators excersise:\n====================");

		/* Exercise 1 */ System.out.println("\n #1");
		
		String myName = "Elad";
		double myAge = 51.66;
		System.out.println("my name is: "+ myName +", and my age is: "+myAge);
		System.out.println("in 4 months I will be: "+ (myAge+0.33)+ " years old");

		boolean ageLogicalOperator = myAge < 50;
		System.out.println("are you younger then 50?  " + ageLogicalOperator);

		int i = 0;
		System.out.println("print i (currently 0)       = "+ i);
		i = i+1;
		System.out.println("print i (currently prev +1) = "+ i);
		i +=1;
		System.out.println("print i (currently prev +1) = "+ i);
		i ++;
		System.out.println("print i (currently prev +1) = "+ i);

		System.out.println("is i equall to 3? "+ (i == 3));

		System.out.println(System.lineSeparator());
		// ----------------------------------------
		
		/* Exercise 2 */ System.out.println("\n #2");

		boolean intCheck;
		intCheck = i > 0 && i < 5;
		System.out.println("i is bigger then 0 and also smaller then 5: "+ intCheck);
		intCheck = i > 0 && i > 5;
		System.out.println("i is bigger then 0 and also bigger then 5: "+ intCheck);		
		intCheck = i > 0 || i > 5;
		System.out.println("i is bigger then 0 -OR- it's bigger then 5: "+ intCheck);

		System.out.println(System.lineSeparator());
		// ----------------------------------------
		
		/* # 3 */ System.out.println("\n #3 ) Calculating Average Grade");
		
		double student1 = 88;
		double student2 = 94;
		double student3 = 74;
		double student4 = 84;
		double student5 = 90;
		
		double sum = student1+ student2+ student3+ student4+ student5;
		double avg = sum / 5;
		System.out.println(avg); // 86.0

		// =================================
		System.out.println("\n--- end ---");

		/* comments...
		 */

	}

}
