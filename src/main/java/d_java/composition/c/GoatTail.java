package d_java.composition.c;

public class GoatTail {
	
	// tail properties
	private String color;
	private boolean shortTail;

	// constructor - initialize the tail properties
	public GoatTail(String color, boolean shortTail) {
		this.color = color;
		this.shortTail = shortTail;
	}

	// getters & setters methods for wrapping the class this.variables private Encapsulation
	public String getColor() {
		return color;
	}

	public void setColor(String color) {
		this.color = color;
	}

	public boolean isShortTail() {
		return shortTail;
	}

	public void setShortTail(boolean shortTail) {
		this.shortTail = shortTail;
	}

	// get all info as string
	public String toString() {
		return "goatTail [ tail=" + color + ", shortTail=" + shortTail + "]";
	}
	// end of class -------------
}
