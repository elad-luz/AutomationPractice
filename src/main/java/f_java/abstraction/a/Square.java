package f_java.abstraction.a;

public class Square extends AnyShape {

	// fields (private) - all the properties of object + Strings name & color which exist in parent "AnyShape"
	private double tsela;
	// constructor - initialize the properties
	public Square(String name, String color, double tsela) {
		super(name, color); // inherits from parent "AnyShape" and initiated here
		this.tsela = tsela;
	}
	// getters & setters methods for wrapping the class this.variables private encapsulation
	public double getTsela() {
		return tsela;
	}
	public void setTsela(double tsela) {
		this.tsela = tsela;
	}
	// info
	@Override
	public String toString() {
		return "Square [tsela=" + tsela + ", area=" + calcArea() + ", perimeter=" + calcPerimeter() + "]";
	}
	/** other methods wrapping above methods...*/ 
	// implement abstract method from parent
	@Override // from parent abstract
	public double calcArea() { // Auto-generated method
		return (tsela*tsela);  // refers to this.tsela
	}
	@Override // from parent abstract
	public double calcPerimeter() { // Auto-generated method
		return 4*tsela;
	}
	// end of class -------------
}