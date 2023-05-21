package e_java.inheritance.a;

public class PersonaTeacher extends Persona {
/** Notes
    x...
	*/
	// fields - all the properties of object
	private long parkingPlace; // unique feature for object

	// constructor - initialize the properties
	public PersonaTeacher(String name, String email, String phone, long parkingPlace) { // upon creation the constructor needs all of those
		super(name, email, phone); // those would be dealt-by the parent constructor - input data will be refereed onwards to the super !
		this.parkingPlace = parkingPlace; // this is unique per class & would be dealt-by this class constructor...
	}
	
	// getters & setters methods for wrapping the class this.variables private encapsulation (the super possess the rest)
	public long getParkingPlace() {
		return parkingPlace;
	}

	public void setParkingPlace(long parkingPlace) {
		this.parkingPlace = parkingPlace;
	}
	
	// using methods to Override super, because Teacher phone should be classified = hidden
	// to Override method & run-over super, we can use: 'right-click' > 'source' > 'Override...'
	@Override
	public String getPhone() { // same name as in parent (super) but with different behavior:
		// return super.getPhone(); // by default it is meant to fetch from super
		return "Teacher getPhone is blocked & can only be seen via toString()"; // retrieve the given string instead of phone...
	} // if accessed from teacher, this method will block data !!!

	// all-info to string
	@Override
	public String toString() {
		return "PersonaTeacher [parkingPlace=" + parkingPlace + "]" + super.toString(); // retrieves both classes data (to overcome the Override)
	}
	/** other methods wrapping methods...*/
	// end of class -------------
}
