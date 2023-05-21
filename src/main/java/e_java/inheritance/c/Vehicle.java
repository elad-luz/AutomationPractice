package e_java.inheritance.c;

public class Vehicle {
/** Notes
	The class is NOT Abstract (so you will be able to create an object of this class)
	*/
	// fields (private) - all the properties of object
	private int year;
	private double price;
	private String color;
	// constructor - initialize the properties
	public Vehicle(int year, double price, String color) {
		this.year = year;
		this.price = price;
		this.color = color;
	}
	// getters & setters methods for wrapping the class this.variables private encapsulation
	public int getYear() {
		return year;
	}
	public void setYear(int year) {
		this.year = year;
	}
	public double getPrice() {
		return price;
	}
	public void setPrice(double price) {
		this.price = price;
	}
	public String getColor() {
		return color;
	}
	public void setColor(String color) {
		this.color = color;
	}
	// all-info toString()
	public String toString() {
		return "Vehicle [year=" + year + ", price=" + price + ", color=" + color + "]";
	}
	/** other methods wrapping methods...*/
	// print info
	public void printInfo() {
		System.out.println(toString()); // print the toString as is
		// System.out.println("Vehicle [year=" + year + ", price=" + price + ", color=" + color + "]");
	}
	// end of class -------------
}
