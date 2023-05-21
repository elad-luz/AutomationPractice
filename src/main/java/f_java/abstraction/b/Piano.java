package f_java.abstraction.b;

public class Piano extends AnyMusical {

	// fields (private) - all the properties of object
	// constructor - initialize the properties
	// getters & setters methods for wrapping the class this.variables private encapsulation
	// info
	/** other methods wrapping above methods...*/
	// implement abstract method from parent
	@Override // from parent abstract
	public void describeInstrument() {
		System.out.println("I'm a piano");  // implement and override
	}
	@Override // from parent abstract
	public void playInstrument() { //  implemented method and define it as well
		System.out.println("Playing piano...\n");
	}
	// end of class -------------
}