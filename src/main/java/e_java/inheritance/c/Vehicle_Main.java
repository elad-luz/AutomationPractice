package e_java.inheritance.c;

public class Vehicle_Main {
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
		
		Vehicle vehicleV = new Vehicle(2000, 0, "NA"); // it is possible to create a Vehicle object because it is not Abstract (although it has no point to it)!
		vehicleV.printInfo();
		
		VehicleCar carX = new VehicleCar(2001, 20001, "blue", 4);
		VehicleTruck truckY = new VehicleTruck(2002, 200002, "black", 3);
		VehicleMotorcycle motorcycleZ = new VehicleMotorcycle(2003, 2001, "green", true);
		
		System.out.println(System.lineSeparator());
		// ----------------------------------------

		System.out.println(carX);
		carX.printInfo();
		
		System.out.println(truckY);
		truckY.printInfo();
		
		System.out.println(motorcycleZ);
		motorcycleZ.printInfo();
	
		// =================================
		System.out.println("\n--- end ---");

	} // end of main	
	/** METHODS (out-side of 'main'): */	
   /*   the method get what... do something -&- return what...   */
}
