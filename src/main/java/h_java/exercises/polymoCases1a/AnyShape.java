package h_java.exercises.polymoCases1a;

public abstract class AnyShape { // parent instance all children inherits from - because it have abstract methods it must also be abstract class!
/** notes: the bellow would be propagated by inhabitance to all shape children
	*/
	// fields (private) - all the properties of object
	private String color;
	// constructor - initialize the properties (no need for super() in top parent)
	public AnyShape(String color) {
		this.color = color;
	}
	// getters & setters methods for wrapping the class this.variables private encapsulation
	public String getColor() {
		return color;
	}
	public void setColor(String color) {
		this.color = color;
	}
	// all-info toString() - parent don't need @Override
	public String toString() {
		return ", shape color=" + color;
	}
	/** other methods wrapping methods...*/
	// the following 2 abstract methods => all children of AnyShape must contain implementation of it, with the same name:
	// if the abstract method of parent are still not implemented in child class -> click on the child class Name & choose 'Add unimplemented methods'...
	public abstract double calcArea(); // abstract method will never be implemented (and will always be part of an abstract class) => the implementation is at the child level!
	public abstract double calcPerimeter(); // abstract method will never be implemented (and will always be part of an abstract class) => the implementation is at the child level!
	public abstract void printData(); //  ^  same as above...
	
	// end of class -------------
}
