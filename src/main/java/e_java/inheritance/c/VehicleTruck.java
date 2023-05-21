package e_java.inheritance.c;

public class VehicleTruck extends Vehicle {
/** Notes
	if you need to initialize a field in constructor (also array):
	// fields
	private boolean booleanName;
	private int intName;
	private ObjectClass instanceArrayName[]; // just declare the array of objects... => IF I use this without predefined input (see comment below) I must define & initiate the stations array via MAIN upon creation of CAR !
	// constructor - initialize the properties - not all features are needed to be given (some can be predefined) ---
	public ClassName() { // in our case the constructor con't require array input, because it is pre-set in advance !
		this.booleanName = false; // predefined as false
		this.intName = 0; // predefined as 0
		// this.instanceArrayName = instanceArrayName; // if you won't use the pre-set init of array value, you'll have to use this & do it from MAIM !!!
		// using the following way, you can initialize via constructor the pre-set the already declared array (above), so each radio will have it upon creation
		this.instanceArrayName = new ObjectClass[?]; // initialization array with predefined values
		instanceArrayName[0] = new ObjectClass(inputs);
	}
	*/
	// fields (private) - all the properties of object
	private int numberOfAxlesa;
	// constructor - initialize the properties
	public VehicleTruck(int year, double price, String color, int numberOfAxlesa) {
		super(year, price, color);
		this.numberOfAxlesa = numberOfAxlesa;
	}
	// getters & setters methods for wrapping the class this.variables private encapsulation
	public int getNumberOfAxlesa() {
		return numberOfAxlesa;
	}
	public void setNumberOfAxlesa(int numberOfAxlesa) {
		this.numberOfAxlesa = numberOfAxlesa;
	}
	// all-info toString() @Override -> you need to concatenate: + super.toString(); [so super will not be run over] => Note: it can be added automatically during adding the method
	@Override
	public String toString() {
		return "VehicleTruck [numberOfAxlesa=" + numberOfAxlesa + "]" + super.toString();
	}
	/** other methods wrapping above methods...*/
	// print info
	@Override
	public void printInfo() {
		System.out.println(toString()); // print the toString as is, with the added super
		// System.out.println("VehicleTruck [numberOfAxlesa=" + numberOfAxlesa + "]");
		// super.printInfo(); // print also parent info
	}
	// end of class -------------
}
