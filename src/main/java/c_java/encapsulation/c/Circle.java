package c_java.encapsulation.c;

public class Circle {
	// 1
	String color;
	double radius;
	// 2
	public Circle(String color, double radius) {
		this.color = color;
		this.radius = radius;
	}
	// 3
	public String getColor() {
		return color;
	}
	public void setColor(String color) {
		this.color = color;
	}
	public double getRadius() {
		return radius;
	}
	public void setRadius(double radius) {
		this.radius = radius;
	}
	// 4
	public String toString() {
		return "Circle [color=" + color + ", radius=" + radius + "]";
	}
	// 5
	public double area() { // note that this only return the area calculated (not print it)
		double calcArea = (this.radius * this.radius) * (Math.PI);
		return calcArea;
		// return (this.radius * this.radius) * (Math.PI); // also possible to do abbreviated

	}
}
