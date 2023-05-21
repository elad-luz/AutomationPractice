package h_java.exercises.polymoCases1b;

public class Square extends AnyShape {

	// fields (private) - all the properties of object
	private double side;

	// constructor - initialize the properties
	public Square(double s) {
		side = s;
	}

	// getters & setters methods for wrapping the class this.variables private encapsulation
	public double getSide() {
		return side;
	}

	public void setSide(double s) {
		side = s;
	}

	// all-info toString() @Override -> you need to concatenate: ' + super.toString()'; [so super will not be run over] => Note: it can be added automatically during adding the method

	/** other methods wrapping above methods...*/ 

	//implement abstract method from parent
	public double calcArea() {
		return side * side;
	}

	//implement abstract method from parent
	public void printData() {
		System.out.println("I am a 'square' and my area is: " + calcArea());
	}
	// end of class -------------
}
