package e_java.inheritance.a;

public class PersonaAdmins extends Persona {
/** Notes
    x...
	*/
	// fields - all the properties of object
	private String title; // unique feature for object

	// constructor - initialize the properties
	public PersonaAdmins(String name, String email, String phone, String title) { // upon creation the constructor needs all of those
		super(name, email, phone); // those would be dealt-by the parent constructor - input data will be refereed onwards to the super !
		this.title = title; // this is unique per class & would be dealt-by this class constructor...
	}

	// getters & setters methods for wrapping the class this.variables private encapsulation (the super possess the rest)
	public String getTitle() {
		return title;
	}

	public void setTitle(String title) {
		this.title = title;
	}

	// all-info to string
	@Override
	public String toString() {
		return "PersonaAdmins [title=" + title + "]" + super.toString(); // retrieves both classes data (to overcome the Override)
	}
	/** other methods wrapping methods...*/
	// end of class -------------
}
