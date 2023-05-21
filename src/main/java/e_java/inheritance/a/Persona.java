package e_java.inheritance.a;

public class Persona {
/** Notes:
    we use inheritance in OOP to re-use code efficiently - this save time & effort!
    because this parent class will pass on (propagate) properties to his children -
	the super should be build first, other class will extend & use it as reference.
    a persona possess common features that are relevant to several other objects ->
    it is considered as parent (super) - the classes that inherits from it are like its' children.
	For Examples everybody in our college is a persona that will get 'name' + 'email' + 'phone' =>
	We talk about 3 different unique figures that have reference to personas:
	   	1. Student	(all data exposed)
	   	2. Teacher	(the phone will be classified = hidden => using Override method to run-over super)
	   	3. Admin	(all data exposed)
	the constructor of the parent (super) would be propagated to the children classes extending it
	but the children will not construct it themselves (only use it)
	regarding methods like getters\setters > they can be used by children classes or be overridden
	regarding .toString() method which exist with same name in both parent & child and lower Override upper
	to retrieve both classes' data (to overcome the Override), we must use + super.toString();
	also other methods can use Override, so lower method actually run-over the upper one (maybe, in some cases, prevent get or set)
	to do so, we have predefined Override methods we can use ('right-click' > 'source' > 'Override...')
	so we can add methods of parent (super) to child having the same name, with annotation Override -->
	create automatically, click: 'Source button' + 'Override...' - it allows to override super.methods (see teacher - get phone)...
	*/
	// fields - all the properties of object 'Persona' that would be inherited by all classes extending it
	private String name;
	private String email;
	private String phone;
	
	// constructor - initialize the properties
	public Persona(String name, String email, String phone) {
		super();
		this.name = name;
		this.email = email;
		this.phone = phone;
	}
	
	// getters & setters methods for wrapping the class this.variables private encapsulation
	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}
	public String getEmail() {
		return email;
	}
	public void setEmail(String email) {
		this.email = email;
	}
	public String getPhone() {
		return phone;
	}
	public void setPhone(String phone) {
		this.phone = phone;
	}
	
	// all-info to string
	public String toString() {
		return "persona [name=" + name + ", email=" + email + ", phone=" + phone + "]";
	}
	/** other methods wrapping methods...*/
	// end of class -------------
}
