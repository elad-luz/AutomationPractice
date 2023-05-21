package f_java.abstraction.a;

public class _MainShapes {

	public static void main(String[] args) {
		/** Polymorphism using a common denominator:
	 		the name of the OOP ability to reach a method common to several objects, each with a slightly different way of implementation, via the common parent abstraction 
		 */
		
		System.out.println("CIRCLE");
		Circle circle = new Circle("circus", "white", 4.5);
		System.out.println("Name: " + circle.getName());		
//		String ShapeColor = circle.getColor();
//		System.out.println(ShapeColor);
		System.out.println("Color: " + circle.getColor());
		System.out.println("Radius: " + circle.getRadius());	
		System.out.println("Circle area: " + circle.calcArea());
		System.out.println("Circle perimeter: " + circle.calcPerimeter());

		System.out.println("\n");
		
		System.out.println("SQUARE");
		Square square = new Square("squad", "black", 4);
		System.out.println("Name: " + square.getName());		
		System.out.println("Color: " + square. getColor());
		System.out.println("Tsela: " + square.getTsela());
		System.out.println("Square area: " + square.calcArea());
		System.out.println("Square perimeter: " + square.calcPerimeter());

		System.out.println("\n");
		
		System.out.println("SQUARE");
		Rectangle rectangle = new Rectangle("rectus", "brown", 8, 5);
		System.out.println("Name: " + rectangle.getName());		
		System.out.println("Color: " + rectangle. getColor());
		System.out.println("Tsela: " + rectangle.getLength());
		System.out.println("Tsela: " + rectangle.getWhidth());
		System.out.println("Square area: " + rectangle.calcArea());
		System.out.println("Square perimeter: " + rectangle.calcPerimeter());

		System.out.println(System.lineSeparator()); // ----------------------
		
		System.out.println("Shapes within ARRAY:");
		// using the polymorphism
		AnyShape[] shapes = new AnyShape [6];
		shapes[0] = circle;
		shapes[1] = square;
		shapes[2] = rectangle;
		shapes[3] = new Circle("citrus", "bleu", 3.5);
		shapes[4] = new Square("squid", "green", 6);
		shapes[5] = new Rectangle("rectum", "nutty", 8, 3);
				
		for (int i = 0; i < shapes.length; i++) {
			System.out.println(shapes[i].toString());
		}
		
		System.out.println(System.lineSeparator()); // ----------------------
		// its possible to ask for shape[i].calcX because we added it to shape as abstract !
		
		double sumTotalShapesPerimeter = 0;
		for (int i = 0; i < shapes.length; i++) {
			sumTotalShapesPerimeter = sumTotalShapesPerimeter + shapes[i].calcPerimeter();
		}
		System.out.println("total sum of perimeters is: " + sumTotalShapesPerimeter);
		
		// --------------
		
		double sumAreas=0;
		//loop on array using 2ed way:
		for (AnyShape s:shapes) {
			sumAreas = sumAreas + s.calcArea(); // adding all shape area to sum
		}
		System.out.println("total sum of areas is: " + sumAreas);					

		// =================================
		System.out.println("\n--- end ---");
	} // end of main	
}
