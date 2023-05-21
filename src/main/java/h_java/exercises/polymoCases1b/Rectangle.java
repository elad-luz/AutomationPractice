package h_java.exercises.polymoCases1b;

public class Rectangle extends AnyShape {

	// fields (private) - all the properties of object
	private double width, length; // define 2 vars at once (having the same types)

	// constructor - initialize the properties
	public Rectangle(double w, double l) {
		length = l;
		width = w;
	}

	// getters & setters methods for wrapping the class this.variables private encapsulation
	public double getWidth() {
		return width;
	}

	public void setWidth(double w) {
		width = w;
	}

	public double getLength() {
		return length;
	}

	public void setLength(double l) {
		length = l;
	}

	// all-info toString() @Override -> you need to concatenate: ' + super.toString()'; [so super will not be run over] => Note: it can be added automatically during adding the method

	/** other methods wrapping above methods...*/ 

	//implement abstract method from parent
	public double calcArea() {
		return length * width ;
	}

	//implement abstract method from parent
	public void printData() {
		System.out.println("I am a rectangle and my area is: " + calcArea());
	}

	// end of class -------------
}
