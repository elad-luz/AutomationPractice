package e_java.inheritance.b;

public class Person {
/** Notes
	*/
	// fields - all the properties of object
	String name;
	String email;
	long birthYear;
	// constructor - initialize the properties
	public Person(String name, String email, long birthYear) {
		this.name = name;
		this.email = email;
		this.birthYear = birthYear;
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
	public long getBirthYear() {
		return birthYear;
	}
	public void setBirthYear(long birthYear) {
		this.birthYear = birthYear;
	}
	// all-info to string
	public String toString() {
		return "Person [name=" + name + ", email=" + email + ", birthYear=" + birthYear + "]";
	}
	/** other methods wrapping methods...*/
	// print info
	public void printInfo() {
		System.out.println("name: "+ name + " email: " + email + " birthYear: " + birthYear);
	}
	// end of class -------------
}
