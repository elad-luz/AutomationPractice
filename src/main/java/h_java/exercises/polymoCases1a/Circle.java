package h_java.exercises.polymoCases1a;

public class Circle extends AnyShape {
	// if abstract method in parent is not implemented yet -> click on the class Name & choose 'Add unimplemented methods'...

	// fields (private) - all the properties of object
	private double radius;

	// constructor - initialize the properties - get also from parent (super)
	public Circle(String color, double radius) {
		super(color);
		this.radius = radius;
	}

	// getters & setters methods for wrapping the class this.variables private encapsulation
	public double getRadius() {
		return radius;
	}

	public void setRadius(double r) {
		radius = r;
	}

	// all-info toString() @Override -> you need to concatenate: ' + super.toString()'; [so super will not be run over] => Note: it can be added automatically during adding the method
	@Override
	public String toString() {
		return "Circle [radius=" + radius + super.toString() + "]";
	}

	/** other methods wrapping above methods...*/ 

	// implement abstract method from parent
	@Override
	public double calcArea() {
		return radius * radius * Math.PI;  // or use getRadius()
	}

	// implement abstract method from parent
	@Override
	public double calcPerimeter() {
		return radius * 2 * Math.PI;  // or use getRadius()
	}

	// implement abstract method from parent
	@Override
	public void printData() {
		System.out.println("I am a 'circle' and my area is: " + calcArea() + " and my perimeter is: " + calcPerimeter());
	}
	// end of class -------------
}
