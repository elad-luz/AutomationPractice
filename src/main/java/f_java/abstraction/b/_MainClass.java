package f_java.abstraction.b;

public class _MainClass {

	public static void main(String[] args) {
		// inheritance (child from parent class)
		Violin v = new Violin(); // instance of child object initialization by referring to the child class
		v.describeInstrument(); // approaching relevant object method
		v.playInstrument();
		
		Piano p = new Piano();
		p.describeInstrument();
		p.playInstrument();
		
		System.out.println("\n"); //-----------------------------------
		
		System.out.println("polymorphism:");
		/* POLYMORPHISM : 
		polymorphism is the ability of an object to take on many forms, thus the child is a varied form of its' parent
		this use occurs when a parent class reference is used to refer to a child class object
		although parent might be 'abstract' (and can't be created as an instance, the child object is created by referring to the "top common denominator" (the parent)
		because now, all sort of various forms of parent appearances, all could be put into one array, and its possible to work on them 
		*/
//		AnyMusical am =  new AnyMusical(); // this can't be done because parent class is abstract and can't stand-alone
		AnyMusical m1 =  new Violin(); // instance of child object initialization by referring to the parent class
		m1.describeInstrument();
		m1.playInstrument();
		
		AnyMusical m2 =  new Piano();
		m2.describeInstrument();
		m2.playInstrument();
		
		System.out.println("\n"); //-----------------------------------
		
		System.out.println("polymorphic array:");		
		// using the polymorphism for array
		AnyMusical[] musical = new AnyMusical[2];
		musical[0] = m1;
		musical[1] = m2;
				
		for (AnyMusical m:musical) {
			m.describeInstrument();
			m.playInstrument();
		}

		// =================================
		System.out.println("\n--- end ---");
	} // end of main	
}
