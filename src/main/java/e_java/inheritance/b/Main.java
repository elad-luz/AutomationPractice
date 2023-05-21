package e_java.inheritance.b;

import java.util.ArrayList;

public class Main {
/** Notes
	*/
	public static void main(String[] args) {
		System.out.println("=> main ==> Create & Operate Objects:");
		
		PersonStudent s1 = new PersonStudent("s1", "s1@g.c", 2001, "java", true);
		PersonStudent s2 = new PersonStudent("s2", "s2@g.c", 2002, "selenium", true);
		PersonStudent s3 = new PersonStudent("s3", "s3@g.c", 2003, "java", false);
		
		System.out.println(System.lineSeparator());
		// ----------------------------------------

		System.out.println("several printing methods:");
		
		System.out.println("\n1." + s1); // s1.toString()
		s1.printInfoX();
		s1.printInfo();
		System.out.println("\n2." + s2); // s2.toString()
		s2.printInfoX();
		s2.printInfo();
		System.out.println("\n3." + s3); // s3.toString()
		s3.printInfoX();
		s3.printInfo();

		System.out.println(System.lineSeparator());
		// ----------------------------------------

		System.out.println("Creating Objects ARRAY & printing:");
		
		PersonStudent[] students = new PersonStudent[5]; // create array for 4 students
		students[0] = new PersonStudent("s0", "s0@g.c", 2000, "bonsai", true); // defined a new student s0 within array
		students[1] = s1; // enter the already defined student s1 to array
		students[2] = s2; // enter the already defined student s2 to array
		students[3] = s3; // enter the already defined student s3 to array
		students[4] = new PersonStudent("s4", "s4@g.c", 2004, "automation", false); // defined a new student s4 within array
		
		// print array info:
		for (int i = 0; i < students.length; i++) {
			System.out.println(students[i]); // prints .toString() of all
			students[i].printInfoX();
			students[i].printInfo();
		}
		
		System.out.println(System.lineSeparator());
		// ----------------------------------------

		// print array info (using for each loop -- not caring of location in the array, but going over all of the array):
		for (PersonStudent personStudent : students) { // first section ask for Objects -- second section states the array
			System.out.println(personStudent);
			personStudent.printInfoX();
		}

		System.out.println(System.lineSeparator());
		// ----------------------------------------
		
		// 2ed way to do array:
		ArrayList<PersonStudent> studentList = new ArrayList<PersonStudent>();
		PersonStudent student1 = new PersonStudent("elad", "e..@g.m", 1970, "ART", true);
		PersonStudent student2 = new PersonStudent("luz", "l.e@g.m", 1111, "RAT", false);
		
		student1.printInfo();
		student2.printInfo();
		
		  System.out.println("---------------------------");
		  
		// Displaying array list elements 2ed way:
	       for(PersonStudent student : studentList) {
	            student.printInfo();
	        }

		// =================================
		System.out.println("\n--- end ---");

	} // end of main	
	/** METHODS (out-side of 'main'): */	
   /*   the method get what... do something -&- return what...   */
}
