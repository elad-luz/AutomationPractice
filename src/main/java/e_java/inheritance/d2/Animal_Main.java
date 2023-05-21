package e_java.inheritance.d2;

public class Animal_Main {
/** Notes
	*/
	public static void main(String[] args) {
		System.out.println("=> main ==> Create & Operate Objects:");		
		// I turned Animal to be Abstract so object of this class can't be created !!!

	/** Animal animal = new Animal(true, true); // it is NOT possible to create a Vehicle object because it is Abstract (although it has no point to it)!
		System.out.println("animal is breath: " + animal.isBreath()+ ", animal is move: " + animal.isMove());
		// output: animal is breath: true, animal is move: true
		// output: I breath oxygen
		//animal.howDoYouLive();
		*/

		AnimalMammel mammel = new AnimalMammel(true,true,true);
		System.out.print("How Mammel live - " );
		mammel.howDoYouLive();

		AnimalReptileSnakeAnaconda anaconda = new AnimalReptileSnakeAnaconda(true, true, false, false, true);
		System.out.print("How Anaconda live - " );
		anaconda.howDoYouLive();
		System.out.print("How many legs for Anaconda - " );
		anaconda.howManyLegs();

		AnimalMammelApeGorilla gorilla = new AnimalMammelApeGorilla(true, true, true, true, 2, true);
		System.out.print("How many legs for gorilla - " );
		gorilla.howManyLegs();

		AnimalMammelCatDomestic homecats = new AnimalMammelCatDomestic(true, true, true, true, 4, true, true);
		System.out.print("How many legs for home cats - " );
		homecats.howManyLegs();

		// =================================
		System.out.println("\n--- end ---");
	} // end of main	
}
