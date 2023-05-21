package c_java.encapsulation.c;

public class Rectangle {
	// 1
	String color;
	double height;
	double width;
	// 2
	public Rectangle(String color, double height, double width) {
		this.color = color;
		this.height = height;
		this.width = width;
	}
	// 3
	public String getColor() {
		return color;
	}
	public void setColor(String color) {
		this.color = color;
	}
	public double getHeight() {
		return height;
	}
	public void setHeight(double height) {
		this.height = height;
	}
	public double getWidth() {
		return width;
	}
	public void setWidth(double width) {
		this.width = width;
	}
	// 4
	public String toString() {
		return "Rectangle [color=" + color + ", height=" + height + ", width=" + width + "]";
	}
	// 5
	public double area() { // note that this only return the area calculated (not print it)
		return (this.height * this.width);
	}
}
