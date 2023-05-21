package d_java.composition.c;

public class GoatLeg {
	// leg properties
	private double length;
	private boolean front; // front=true | back=false
	private boolean right; // right=true | left=false
	private String color;
	
	// constructor - initialize the tail properties
	public GoatLeg(double length, boolean front, boolean right, String color) {
		super();
		this.length = length;
		this.front = front;
		this.right = right;
		this.color = color;
	}
	// getters & setters methods for wrapping the class this.variables private Encapsulation
	public double getLength() {
		return length;
	}

	public void setLength(double length) {
		this.length = length;
	}
	public boolean isFront() {
		return front;
	}
	public void setFront(boolean front) {
		this.front = front;
	}
	public boolean isRight() {
		return right;
	}
	public void setRight(boolean right) {
		this.right = right;
	}
	
	public String getColor() {
		return color;
	}
	public void setColor(String color) {
		this.color = color;
	}
	// get all info as string
	public String toString() {
		return "GoatLeg [length=" + length + ", front=" + front + ", right=" + right + ", color=" + color + "]";
	}
	// end of class -------------
}
