package e_java.inheritance.b;

public class PersonStudent extends Person {
/** Notes
	*/
	// fields - all the properties of object
	String courseName;
	boolean active;
	// constructor - initialize the properties
	public PersonStudent(String name, String email, long birthYear, String courseName, boolean active) {
		super(name, email, birthYear);
		this.courseName = courseName;
		this.active = active;
	}
	// getters & setters methods for wrapping the class this.variables private encapsulation
	public String getCourseName() {
		return courseName;
	}
	public void setCourseName(String courseName) {
		this.courseName = courseName;
	}
	public boolean isActive() {
		return active;
	}
	public void setActive(boolean active) {
		this.active = active;
	}
	// all-info toString() @Override -> you need to concatenate: + super.toString(); [so super will not be run over]
	@Override // you need to add super, so it will not be run over by this toString() @Override
	public String toString() {
		return "PersonStudent [courseName=" + courseName + ", active=" + active + "]" + super.toString(); // returning the string of info of child + the string of info of parent
	}
	//
	public void printInfoX() {
		System.out.println("--------------> |courseName:" + courseName + " |active:" + active + " |       name:" + name + " |email:" + email + " |birthYear:" + birthYear);
	}
	@Override // you need to add super, so it will not be run over by this printInfo()
	public void printInfo() { // print info with super
		if (active) {
			System.out.println("I study: " + courseName);
		} else {
			System.out.println("I register to study: " + courseName + ", but hadn't yet started");
		} super.printInfo(); // print also parent info
		
	}
	/** other methods wrapping above methods...*/
	// end of class -------------
}
