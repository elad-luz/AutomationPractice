package e_java.inheritance.a;

public class Collage_main {
	
	public static void main(String[] args) {
		/** Notes
		    when defining an object, we most likely to do so from child (instead of from parent) -
		    there is no point in defining a parent object as stand alone (it's a rule of thumb)...
		 */
		/* # 0 */ System.out.println("=> main method: Create & Operate the Objects \n");
		// code section 1...
		
		PersonaStudent elad = new PersonaStudent("elad", "e.l@g.c", "058-7731", 94.5); // first 3 inputs are passed from class constructor to super
		System.out.println(elad.getName()); // we can get like this, the extended data in super
		
		PersonaTeacher gal = new PersonaTeacher("gal", "gal@g.c", "054-6760", 1); // first 3 inputs are passed from class constructor to super
		System.out.println(gal.getEmail()); // we can get like this, the extended data in super
		
		PersonaAdmins tali = new PersonaAdmins("tali", "tali@g.c", "03-76033", "secretary"); // first 3 inputs are passed from class constructor to super
		System.out.println(tali.getPhone()); // we can get like this, the extended data in super

		System.out.println("--------");

		tali.setPhone("03-76000"); // we can set like this, the extended data to super
		System.out.println(tali.getPhone()); // see the change...
		
		System.out.println(System.lineSeparator());
		// ----------------------------------------
		/** if only parent (super) have .toString() class, the data shown would be only the data in parent class (without the unique data of extended child class)
			if we have .toString() as "out of the box" in both parent & child, the data shown would be only the data in child class (without the data of parent)
			the data shown would always be in the lowest level class, because we use the same 'method name' with Override annotation(@) -
			so the lower method actually run-over the upper one (both have same name & lower Override upper)...
			to fix it we need to add + super.methodName => e.g. + super.toString();
		 */
		
		System.out.println(elad); // prints elad.toString() => as we added "+ super...", we get all data...
		System.out.println(gal); // prints elad.toString() => as we added "+ super...", we get all data, because phone is not blocked in that method !!!
		System.out.println(gal.getPhone()); // if accessed from teacher, the getPhone method will block data
		System.out.println(tali); // prints elad.toString() => as we added "+ super...", we get all data...

		// =================================
		System.out.println("\n--- end ---");
	}
	// end of class -------------
	/** METHODS (out-side of 'main'): */
	// this method will: do what.. (get what... -&- return what...):
	/* public static void printHW() {
	   System.out.println("\nHello world!\n------------");
	}*/
	// -----
}
//comments: /* /** */
