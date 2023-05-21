package i_java.interfaces;

public class _Main {

	public static void main(String[] args) {
		System.out.println("Interface1 1:\n=============\n");
		/** INTERFACE (can be looked at like inheritance of an abstract method on a way)
			we use inheritance in OOP to re-use code efficiently, to save time & effort!
    		a parent class will pass on (propagate) properties to all related children -
			super should be build first, child class will extend -&- use it as reference
    		child can inherit from only 1 parent > BUT what if it need to inherit from 2
    		if class needs to extend 2 classes, 1st would be the super, and for the 2ed,
			we can use INTERFACE -> any object in java can implement several interfaces,
			it's a bit like inheritance, but INTERFACE: have NO data and NO methods body
			there is ONLY methods Names & signatures, which will be implement as needed!
			INTERFACE creates a common denominator between objects which are not sibling
			in this example, Dog (which extend Animal) needs implementation of a License
			and BMW (which extend Automobile) also need to implement its own License ...
			we previously described 'composition' as: "has-a" relationship (e.g. where >
			one class is composed of objects defined in another class) -- and -- we also 
			described 'inheritance' as: "type-of" relationship (e.g. somewhat like super
			having properties passed onto children from parent) -- SO -- we can consider
			description of 'interface' as: "acts like some-times" relationship (e.g. the
			Car acts like something needing License only upon certain occasion (renewal)
			rest of all other time, it is just regular automobile regardless of license.
		 */
		// polymorphism = the ability to create array of several kind of related objects
		Animal [] animalArray = { // Animal is parent of both Dog & Cat (they extend it)
			new Dog(), new Cat(), new Dog(), new Cat() // Animal is abstract (can't S.A)
		};
		for (Animal a : animalArray) {
			System.out.println(a.whoAmI()); // will print: I'm a Dog, I'm a Cat etc. ...
		}
		

		System.out.println(System.lineSeparator());
		// ----------------------------------------

		LicenseInterface [] LicenseInterface = { // only objects implementing interface!
				new BMW(), new Dog() // both relate to interface, Cat don't implement it
		};
		for (LicenseInterface l : LicenseInterface) {
			l.renewLicense(); // will print: CAR License..., Dog License... no need syso
			// although both objects: BMW  &  Dog have an implementation of: whoAmI() =>
			// it can't be here because it didn't come from the interface but from super
			// it can only be presented from object itself !!!
		}

		// =================================
		System.out.println("\n--- end ---");
	} // end of main	
	/** METHODS (out-side of 'main'): */	
   // a method that do...
}
