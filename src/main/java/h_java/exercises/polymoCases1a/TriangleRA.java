package h_java.exercises.polymoCases1a;

public class TriangleRA extends AnyShape { // this stands for Triangle Right Angled (90)
	// if abstract method in parent is not implemented yet -> click on the class Name & choose 'Add unimplemented methods'...

	// fields (private) - all the properties of object
	private double legA;
	private double legB;
	
	// constructor - initialize the properties - get also from parent (super)
	public TriangleRA(String color, double legA, double legB) {
		super(color);
		this.legA = legA;
		this.legB = legB;
	}
	
	// getters & setters methods for wrapping the class this.variables private encapsulation
	public double getLegA() {
		return legA;
	}

	public void setLegA(double legA) {
		this.legA = legA;
	}

	public double getLegB() {
		return legB;
	}

	public void setLegB(double legB) {
		this.legB = legB;
	}
	
	// all-info toString() @Override -> you need to concatenate: ' + super.toString()'; [so super will not be run over] => Note: it can be added automatically during adding the method
	@Override
	public String toString() {
		return "Rectangle [legA=" + legA + ", legB=" + legB + super.toString() + "]";
	}


	/** other methods wrapping above methods...*/ 

	// implement abstract method from parent
	@Override
	public double calcArea() {
		return (legA * legB) * 0.5; // or use getLegA() & getLegB()
	}

	// implement abstract method from parent
	@Override
	public double calcPerimeter() { // Java Program to find Perimeter of a Right Angled Triangle Example
		double legC = Math.sqrt((legA * legA) + (legB * legB)); // using Pythagoras calculation...
		return legA + legB + legC; // the Perimeter
	}

	// implement abstract method from parent
	@Override
	public void printData() {
		System.out.println("I am a 'triangle (right angled)' and my area is: " + calcArea() + " and my perimeter is: " + calcPerimeter());
	}
	// end of class -------------
}
