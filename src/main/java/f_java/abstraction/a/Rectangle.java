package f_java.abstraction.a;

public class Rectangle extends AnyShape {

	// fields (private) - all the properties of object + Strings name & color which exist in parent "AnyShape"
	private double length;
	private double whidth;
	// constructor - initialize the properties
	public Rectangle(String name, String color, double length, double whidth) {
		super(name, color); // inherits from parent "AnyShape" and initiated here
		this.length = length;
		this.whidth = whidth;
	}
	// getters & setters methods for wrapping the class this.variables private encapsulation
	public double getLength() {
		return length;
	}
	public void setLength(double length) {
		this.length = length;
	}
	public double getWhidth() {
		return whidth;
	}
	public void setWhidth(double whidth) {
		this.whidth = whidth;
	}
	// info
	@Override
	public String toString() {
		return "Rectangle [length=" + length + ", whidt=" + whidth + ", area=" + calcArea() + ", perimeter=" + calcPerimeter() + "]";
	}
	/** other methods wrapping above methods...*/
	// implement abstract method from parent
	@Override
	public double calcArea() { // Auto-generated method stub
		return length*whidth;  // refers to this.length & this.whidth
	}
	@Override
	public double calcPerimeter() { // Auto-generated method stub
		return 2*(length+whidth);
	}
	// end of class -------------
}
