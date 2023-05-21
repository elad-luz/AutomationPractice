package h_java.exercises.polymoCases1b;

public class Circle extends AnyShape {

	// fields (private) - all the properties of object
	private double radius;

	// constructor - initialize the properties
	public Circle(double r) {
		super();
		radius = r;
	}

	// getters & setters methods for wrapping the class this.variables private encapsulation
	public double getRadius() {
		return radius;
	}

	public void setRadius(double r) {
		radius = r;
	}

	// all-info toString() @Override -> you need to concatenate: ' + super.toString()'; [so super will not be run over] => Note: it can be added automatically during adding the method

	/** other methods wrapping above methods...*/ 

	//implement abstract method from parent
	public double calcArea() {
		return radius * radius * 3.14;
	}

	//implement abstract method from parent
	public void printData() {
		System.out.println("I am a 'circle' and my area is: " + calcArea());
	}
	// end of class -------------
}
