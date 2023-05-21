package f_java.abstraction.c;

public class Animal_Main {
/** Notes
 		// example for low-level inputs:
		Cat cat0 = new Cat(); // declare an object instance (to be initialized)
		// initialize while attributes 'public' - directly
		cat0.name = "kitty";
		cat0.color = "pink";
		cat0.age = 10.5;
		// System.out.println("name: " + cat0.name + " | color: " + cat0.color + " | age: "+ cat0.age + " years old"); // print from direct (if public)

		// initialize while attributes 'private' - to setters (not via constructor)
		cat0.setName("kitty");
		cat0.setColor("pink");
		cat0.setAge(10.5);
		// System.out.println("cat name: " + cat0.getName() + " | color: " + cat0.getColor() + "  | age: "+ cat0.getAge() + " years old  | tail: " + Cat.hasTail); // print from getters (if private) + get the static
	*/
	
	public static void main(String[] args) {
		System.out.println("=> main ==> Create & Operate Objects:");		

		// instances
		System.out.println("animal instance:\n");
		//--------------------------------------
		// initialize parent instance as stand alone, before changing parent class to 'abstract' !!!
		// AnyAnimal any = new AnyAnimal("black", 13.0);
		// any.printAnimalInfo(); // printAnimalInfo from parent => console out-put is: "Animal instance: color = black -&- weight = 13.0"
		// any.whoAmI(); // print method with console out-put: I'm an animal
		
		// initialize while attributes 'private' -  via constructor of parent & child
		AnimalCat cat1 = new AnimalCat("black", 13.0, "kiton", 10.0);
		System.out.println("cat name: " + cat1.getName() + " | color: " + cat1.getColor() + " | age: "+ cat1.getAge() + " years old | tail: " + AnimalCat.hasTail + "\n");
		cat1.printAge(); // printAge from child - that was an abstract class of Animal
		double fa = 5;
		System.out.println("cat age in " + fa + " years will be: " + cat1.futureAge(fa) + " years\n");
		cat1.whoAmI(); // print method with console out-put: "I'm an animal" (from parent) + "Animal type: cat" (from child)
		cat1.printAnimalInfo();	// printAnimalInfo from parent
		cat1.printInfo(); // printInfo from child
		
		AnimalCat cat2 = new AnimalCat("gray", 12.0, "kotos");
		cat2.printInfo();
		cat2.printAge(); // printAge from child - that was an abstract class of Animal
		
		System.out.println("====================");
		AnimalCatStreet cat3 = new AnimalCatStreet("olive", 12.2, "klaude", 18.2, "Brenner 1 - K. Ono", true);
		cat3.printInfo();
		cat3.printStreetCatInfo();
		
		System.out.println("====================");
		System.out.println("\n"); //--------------------------

		AnimalDog dog1 = new AnimalDog("white", 11.0, "doggi", 11.5);
		dog1.printInfo();
		dog1.printAge(); // printAge from child - that was an abstract class of Animal
		
		AnimalDog dog2 = new AnimalDog("pink", 10.0, "dingo");
		dog2.printInfo();
		System.out.println(dog2.getName() + " age in " + fa + " years will be: " + dog2.futureAge(fa) + " years\n");
		
		// =================================
		System.out.println("\n--- end ---");
	} // end of main	

}
