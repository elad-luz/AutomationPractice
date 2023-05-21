package c_java.encapsulation.b;

public class Pets {

	public static void main(String[] args) {
		/** example 1
		    note: this main method will be used to run the College program -
		    use the Objects' templates (Student & Teacher) to create the Object Instances for this College...
		 */
		System.out.println("Pets = Cats & Dogs Instances:\r\n" + "=============================");
		
		/* the reference class for all cats is: "Cat"
		 * any cat must have the following attributes: 'name', 'type', 'age'
		 * declare + initiate cat object...
		 */
		
		// Cat - using the public fields (before changed to private)
//		CatsTemplate cat = new CatsTemplate();
//		cat.name = "Claude"; // working directly on a field, is possible only if the fields is "public" (not "private") => Not Preferred !
//		cat.type = "Street";
//		cat.age =18;
//		
//		System.out.println("Cat is: " + cat.name + ", " + cat.type + ", " + cat.age);
		
		// Cat 1
//		Cat cat1 = new Cat(); // this way is defined after adding getters & setters BUT previous to adding constructor
//		cat1.setName("Claude");
//		cat1.setType("Street");
//		cat1.setAge(18);
//		Cat cat1 = new Cat(name, type, age); // this is how to define via constructor
//  =>	Object nameGiven = new Constructor(inputs);
		Cat cat1 = new Cat("Claude", "Street", 18);
		cat1.setAge(19); // how to set new Age to update & override the one previously defined
		
		// printing all fields values natively using getters
		cat1.printInfo(); // this is the method that print from Cat Class		
		System.out.println("Cat instance: " + cat1.getName() + ", is " + cat1.getAge() + " years old " + cat1.getType() + " cat. \n");
		
		// printing all fields values using method toString
		System.out.println("#1 "+ cat1.toString()+ "\n"); // using the toString method to print all info of that object info

		// using an added method
		System.out.println("in 5 years the cat will be: "+ cat1.futureAge(5) + "years \n");
		
		// printing a static field value relevant to all Cats (not to particular one)...
		System.out.println("Dose all Cats have a Tail ? " + Cat.haveTail +" (static) \n"); // can be only 'true', and relates to all class of Cat not a specific instance
		
		// Cat 2
		Cat cat2 = new Cat("Sam", "Siamese", 5);
		cat2.setAge(4);
		
		// printing all fields values (instance object's info) using the method from class
		cat2.printInfo();
		System.out.println("#2 "+ cat2.toString()+ "\n"); // using the toString method to print all info of that object info
		
		// Dog - Use Same fields as a Cat (but is defined by itself)...
		
		// Dog 1
		Dog dog1 = new Dog("Joe", "Stray", 5);
		dog1.setAge(6);
		// printing all fields values natively		
		System.out.println("Dog instance: " + dog1.getName() + ", is " + dog1.getAge() + " years old " + dog1.getType() + " dog. \n");
		System.out.println("#1 "+ dog1.toString()+ "\n"); // using the toString method to print all info of that object info
		
		// Dog 2
		Dog dog2 = new Dog("Max", "jack russell", 7);
		dog2.setName("Maxim");
		
		// printing all fields values (instance object's info) using the method from class
		dog2.printInfo();
		System.out.println("#2 "+ dog2.toString()+ "\n"); // using the toString method to print all info of that object info

		// now we can add methods to show Cat or Dog with max age etc...
		// we can add 'Horse' class & other Pets classes etc... (as we did for Cat).
		
		// -------------------------------------------
		System.out.println("\n" + "== cats array ==");
		
		// Create Cats ARRAY with cat instances:
		// -------------------------------------
		/** Array related:
		// declares an array of integers
    	int[] anArray;
    	// allocates memory for 10 integers
    	anArray = new int[10];
    	// initialize first element
    	anArray[0] = 100;
    	// initialize second element
    	anArray[1] = 200;
    	// and so forth...
    	// OR use the 2ed way to do at once...
	 */
		//Create an ARRAY of Cats with Cat instances, using the constructor - array name is myCats
		Cat[] myCats = new Cat[5];
		myCats[0] = new Cat("pitzzi","black",3); // populate the array with new cats
		myCats[1] = new Cat("mitzzi","white",4);
		myCats[2] = new Cat("jordi","orange",1);
		myCats[3] = cat1; // also possible to add a cat already made previously
		myCats[4] = cat2; // made previously
		
		// print all using loop
		for (int i = 0; i < myCats.length; i++) {
			System.out.println(myCats[i].toString());
		}
		
		// find & print oldest cat (this can also be part of Cat class, instead of main)
		int x = 0;
		double maxAge = myCats[0].getAge();
		for (int i = 0; i < myCats.length; i++) {
			if (myCats[i].getAge() > maxAge) {
				maxAge = myCats[i].getAge();
				x = i;
			}
		}
		System.out.println("---\nAge of oldest cat (" + myCats[x].getName() + "), is: " + maxAge);
		
	} // end of main

}
