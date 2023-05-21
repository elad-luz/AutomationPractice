package h_java.exercises.polymoCases1a;

public class Rectangle extends AnyShape { // this class will serve also as parent to Square !
	// if abstract method in parent is not implemented yet -> click on the class Name & choose 'Add unimplemented methods'...

	// fields (private) - all the properties of object
	private double width;
	private double height;
	
	// constructor - initialize the properties - get also from parent (super)
	public Rectangle(String color, double width, double height) {
		super(color);
		this.width = width;
		this.height = height;
	}
	
	// getters & setters methods for wrapping the class this.variables private encapsulation
	public double getWidth() {
		return width;
	}

	public void setWidth(double width) {
		this.width = width;
	}

	public double getHeight() {
		return height;
	}

	public void setHeight(double height) {
		this.height = height;
	}
	
	// all-info toString() @Override -> you need to concatenate: ' + super.toString()'; [so super will not be run over] => Note: it can be added automatically during adding the method
	@Override
	public String toString() {
		return "Rectangle [width=" + width + ", height=" + height + super.toString() + "]";
	}

	/** other methods wrapping above methods...*/ 

	// implement abstract method from parent
	@Override
	public double calcArea() {
		return width * height; // or use getWidth() & getHeight()
	}

	// implement abstract method from parent
	@Override
	public double calcPerimeter() {
		return (2 * width) + (2 * height); // or use getWidth() & getHeight()
	}

	// implement abstract method from parent
	@Override
	public void printData() {
		System.out.println("I am a 'rectangle' and my area is: " + calcArea() + " and my perimeter is: " + calcPerimeter());
	}
	// end of class -------------
}
