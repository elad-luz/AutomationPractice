package e_java.inheritance.d1;

public class Animal_Main {
/** Notes
	ObjectClass instanceName = new ObjectClass(inputs);
	System.out.println(instanceName); // instanceName.toString()
	instanceName.printInfo();
	
	ObjectClass[] instanceArrayName = new ObjectClass[?]; // create array for ? instances
	instanceArrayName[0] = new ObjectClass(inputs);
	// print array info:
	for (int i = 0; i < instanceArrayName.length; i++) {
		System.out.println(instanceArrayName[i]); // prints .toString() of i => All
		instanceArrayName[i].printInfo(); // printInfo of i => All
	}
	for (ObjectClass object : instanceArrayName) { // first section ask for Objects -- second section states the array
		System.out.println(object); // prints .toString() of All
		object.printInfo(); // printInfo of All
	}
	*/
	public static void main(String[] args) {
		System.out.println("=> main ==> Create & Operate Objects:");		
		// NOTE that if in the entire class hierarchy there is no construction needed because no fields defined at all, 
		// and if just printouts method are involved you don't need to give any input during the creation of object
		
		Animal animal = new Animal();  // it is possible to create a Vehicle object because it is not Abstract (although it has no point to it) !
		AnimalFish fish = new AnimalFish();
		AnimalFishShark shark = new AnimalFishShark();
		AnimalMammel mammel = new AnimalMammel();
		AnimalMammelCat cat = new AnimalMammelCat();
		AnimalMammelDolphin dolphin = new AnimalMammelDolphin();
		AnimalMammelApe ape = new AnimalMammelApe();
		AnimalMammelApeGorilla gorilla = new AnimalMammelApeGorilla();
		AnimalReptile reptile = new AnimalReptile();
		AnimalReptileLizard lizard = new AnimalReptileLizard();
		AnimalReptileSnake snake = new AnimalReptileSnake();
		AnimalReptileSnakeAnaconda anaconda = new AnimalReptileSnakeAnaconda();
		
		System.out.println(System.lineSeparator());

		animal.whoAreYou();
		animal.whatDoYouBreath();
		System.out.println(animal.howManyLegsYouhGot() + "\n");

		fish.whoAreYou();
		fish.whatDoYouBreath();
		System.out.println(fish.howManyLegsYouhGot() + "\n");

		shark.whoAreYou();
		shark.whatDoYouBreath();
		System.out.println(shark.howManyLegsYouhGot() + "\n");

		mammel.whoAreYou();
		mammel.whatDoYouBreath();
		System.out.println(mammel.howManyLegsYouhGot() + "\n");

		cat.whoAreYou();
		cat.whatDoYouBreath();
		System.out.println(cat.howManyLegsYouhGot() + "\n");

		dolphin.whoAreYou();
		dolphin.whatDoYouBreath();
		System.out.println(dolphin.howManyLegsYouhGot() + "\n");

		ape.whoAreYou();
		ape.whatDoYouBreath();
		System.out.println(ape.howManyLegsYouhGot() + "\n");

		gorilla.whoAreYou();
		gorilla.whatDoYouBreath();
		System.out.println(gorilla.howManyLegsYouhGot() + "\n");

		reptile.whoAreYou();
		reptile.whatDoYouBreath();
		System.out.println(reptile.howManyLegsYouhGot() + "\n");

		lizard.whoAreYou();
		lizard.whatDoYouBreath();
		System.out.println(lizard.howManyLegsYouhGot() + "\n");

		snake.whoAreYou();
		snake.whatDoYouBreath();
		System.out.println(snake.howManyLegsYouhGot() + "\n");

		anaconda.whoAreYou();
		anaconda.whatDoYouBreath();
		System.out.println(anaconda.howManyLegsYouhGot() + "\n");
		
		// =================================
		System.out.println("\n--- end ---");
	} // end of main	
}
