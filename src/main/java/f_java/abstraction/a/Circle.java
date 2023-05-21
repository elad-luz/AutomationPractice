package f_java.abstraction.a;

public class Circle extends AnyShape {

	// fields (private) - all the properties of object + Strings name & color which exist in parent "AnyShape"
	private double radius;
	// constructor - initialize the properties
	public Circle(String name, String color, double radius) {
		super(name, color); // inherits from parent "AnyShape" and initiated here
		this.radius = radius;
	}
	// getters & setters methods for wrapping the class this.variables private encapsulation
	public double getRadius() {
		return radius;
	}
	public void setRadius(double radius) {
		this.radius = radius;
	}
	// info
	@Override
	public String toString() {
		return "Circle [radius=" + radius + ", area=" + calcArea() + ", perimeter=" + calcPerimeter() + "]";
	}	
	/** other methods wrapping above methods...*/
	// implement abstract method from parent
	@Override // from parent abstract
	public double calcArea() { // Auto-generated method
		return Math.PI*(radius*radius); // refers to this.radius
	}
	@Override // from parent abstract
	public double calcPerimeter() { // Auto-generated method
		return 2*Math.PI*radius;
	}
	// end of class -------------
}
