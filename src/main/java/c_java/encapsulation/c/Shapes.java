package c_java.encapsulation.c;

public class Shapes {

	public static void main(String[] args) {
//		Object objName = new Constructor(inputs)
		Circle circle1 = new Circle("gray", 10);
		Rectangle rectangle1 = new Rectangle("blue", 10, 5);
		
		System.out.println("circle1 color: " + circle1.color + ", and area: " + circle1.area());
		System.out.println("rectangle1 color: "+ rectangle1.color +", and area: " + rectangle1.area());
	}

}
