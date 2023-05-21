package e_java.inheritance.a;

public class PersonaStudent extends Persona {
/** Notes
    this class extends the parent (super) = inherits all its methods & refer to it...
	*/
	// fields - all the properties of object
	private double avgGrade; // unique feature for object

	// constructor - initialize the properties
	public PersonaStudent(String name, String email, String phone, double avgGrade) { // upon creation the constructor needs all of those
		super(name, email, phone); // those would be dealt-by the parent constructor - input data will be refereed onwards to the super !
		this.avgGrade = avgGrade; // this is unique per class & would be dealt-by this class constructor...
	}

	// getters & setters methods for wrapping the class this.variables private encapsulation (the super possess the rest)
	public double getAvgGrade() {
		return avgGrade;
	}

	public void setAvgGrade(double avgGrade) {
		this.avgGrade = avgGrade;
	}
	
	// all-info to string
	@Override
	public String toString() {
		return "PersonaStudent [avgGrade=" + avgGrade + "]" + super.toString(); // retrieves both classes data (to overcome the Override)
	}
	/** other methods wrapping methods...*/
	// end of class -------------
}
