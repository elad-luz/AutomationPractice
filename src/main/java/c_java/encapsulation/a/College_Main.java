package c_java.encapsulation.a;

public class College_Main {

	public static void main(String[] args) {
		/** class example 0
		    note: this main method will be used to run the College program -
		    use the Objects' templates (Student & Teacher) to create the Object Instances for this College...
		 */
	/*  Students first phase...
		Student elad = new Student(); // => Object nameGiven = new Constructor(inputs)
		// the above, declares & assigns a place in memory for a Student object -
		// thats an instance of a Student entity with predefined properties (see Student class).
		// the bellow, initiate the Object & set value to its properties....
		elad.fName = "Elad"; 
		elad.lName = "Luz";
		elad.age = 51;
		// now the Student object instance got First & last name & age -and- we can use them (e.g. print):
		System.out.println("Student "+ elad.fName +" "+ elad.lName +" age is: "+ elad.age);
		elad.age = 52; // set new value to the student age
		System.out.println("Student 1. "+ elad.fName +" "+ elad.lName +" age is: "+ elad.age);
		// we can fill all its property fields -and- do the same for many more Student instances
		Student gilad = new Student();
		gilad.fName = "Gil"; 
		gilad.lName = "Meitar";
		System.out.println("Student 2. "+ gilad.fName +" "+ gilad.lName);
		// but that is not working well because we can miss-use the properties' variables (like giving a negative age)
		// so we protect them from improper value setting - we do it in the Student class, by turning them to Private...
		// if turned to private in Student class they will not be accessible (you will see an error: "field not visible")
	*/ // AFTER fixing the Student class we can better use it from main...
		
		// Student #1 declare & initiate => Object nameGiven = new Constructor(inputs):
		Student elad = new Student("Elad", "Luz", "elad.luz@gmail.com", "0587731958", 52, 90, true); // declare + initialize via constructor method (while attributes are private)
		System.out.println("#1 "+ elad.toString()+ "\n"); // using the toString method to print all info of the Student object
		System.out.println("#1 Student full name is: "+ elad.getfName() +" "+ elad.getlName()+ "\n"); // of use that to get specific data
		
		// Student #2 declare & initiate:
		Student gil = new Student("Gil", "Meitar", "gil.meitar@gmail.com", "0587731921", 50, 80, false);
		System.out.println("#2 "+ gil.toString()+ "\n");
		System.out.println("#2 Student full name is: "+ gil.getfName() +" "+ gil.getlName()+ "\n");

		// now we can add methods to show Student with max gradeAvg etc...
		// we can add 'Teacher' class & also 'Course' class etc... (as we did for Students).
		
		if (elad.geteMail().contains("gmail")) {
			System.out.println("Student "+ elad.getfName() +" is Gmail complient...");
		}

	} // end of main

}
