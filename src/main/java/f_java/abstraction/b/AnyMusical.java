package f_java.abstraction.b;

public abstract class AnyMusical { // parent instance all children inherits from
/** Notes about ABSTRACT:
 * abstract = consist of abstract method -also- user will not be able to initiate this parent instance by itself
   */
	// fields (private) - all the properties of object
	// constructor - initialize the properties
	// getters & setters methods for wrapping the class this.variables private encapsulation
	/** other methods wrapping methods...*/
	// abstract methods in parent
	public void describeInstrument() { // if you'll turn to abstract you will see compile error till remove the method content = implementation
		System.out.println("I'm a general instrument"); // method content = implementation
	}
	public abstract void playInstrument(); // abstract = all that inherits must implement this method - which is currently not defined

	// end of class -------------
}
