package d_java.composition.d;

public class Car_main {
		/*  PLAESE NOTE
	   		There are various ways to implement stuff, to construct objects & to use hierarchy-driven methods.
	   		We make use of many ways to do the same thing, like getting same info from different methods within the classes hierarchy -
	   		Examples below:
	   		1. to construct arrays (station \ wheels) here or at class level (radio \ wheels)
	   		2. lexus.getRadio().isOn());					|  lexus.getRadioState());
	   		3. lexus.getRadio().getSelectedStation());		|  lexus.getCurrentStation());
	   		4. lexus.getRadio().printSelectedStationInfo();	|  lexus.getCurrentStationName();
	   		look carefully below, and within all classes to understand the diff of what was made, why & how !
		 */

	public static void main(String[] args) {
		/** No Need to declare & initialize this array because we did it upon construct radio with pre-defined values
		CarRadioStation stations[] = new CarRadioStation[6]; // declaration of array 
		stations[0] = new CarRadioStation("88FM",88.0); // initialization 
		stations[1] = new CarRadioStation("GLTZ",96.6);
		stations[2] = new CarRadioStation("GLGLTZ",91.8);
		stations[3] = new CarRadioStation("Reshet B",95.5);
		stations[4] = new CarRadioStation("Radius",100.00);
		stations[5] = new CarRadioStation("ECO",99.00);
		// OR use this {new CarRadioStation("88FM",88.0), new CarRadioStation("GLTZ",96.6), new CarRadioStation("GLGLTZ",91.8), new CarRadioStation("Reshet B",95.5), new CarRadioStation("Radius",100.00), new CarRadioStation("ECO",99.00)};
		// After creating stations we can proceed to do the radio & insert the input needed:
		-- CarRadio radioUnit = new CarRadio(stations); // and in that case, also this only param needed: the stations array name
		// REMINDER - As we pre set radio with all needed inputs pre-defined so constructor don't need anything & it looks like this:
		-- CarRadio radioUnit = new CarRadio(); 
		// But NOTE that in our case, we don't need any radio made so we can skip it all together -
		// Because we made it in a way that radio without any input will be automatically generated during car construction...!
		*/ // So no stations[] or radioUnit is needed !
		
		// Car Wheels is still needed!
		CarWheel[] wheels = new CarWheel[5]; // one spare
		wheels[0] = new CarWheel(30, "GoodYear", 30); // the spare is a small one ;)
		wheels[1] = new CarWheel(36, "GoodYear", 32); // front have lower pressure
		wheels[2] = new CarWheel(36, "GoodYear", 32);
		wheels[3] = new CarWheel(36, "GoodYear", 33); // back have higher pressure
		wheels[4] = new CarWheel(36, "GoodYear", 33);
		
		// Car lexus = new Car("Lexus", "X30", 2022, radioUnit, wheels); // we actually need no Radio so its been dropped!
		Car lexus = new Car("Lexus", "X30", 2022, wheels);
		
		
		System.out.println("\n----------------");
		System.out.println("we made a car :) =>");
		System.out.println("Car: " + lexus + "\n"); // do the same as: System.out.println(lexus.toString());
		System.out.println("Car Firm: " + lexus.getFirm() + "\n"); // print using .getMethod
		System.out.println("Car Model & Year: " + lexus.getModel() + " - " + lexus.getYear() + "\n"); // print using .getMethod

		System.out.println("\n----------------");
		// System.out.println("Radio: " + radioUnit + "\n"); // we didn't make the radioUnit, so we need to use the one made by CAR constructor:
		System.out.println("Radio: " + lexus.getRadio() + "\n"); // we get to the radio via car instance !
		// operation on methods
		lexus.changeStation(3); // try to change when radio off (fails)
		System.out.println("Radio state while OFF: " + lexus.getRadio().isOn()); // show radio state using this Car (lexus object = Car class) to get to the CarRadio Class and use its method .isOn
		System.out.println("Radio state direc way: " + lexus.getRadioState()); // SAME, show radio state, but use a dedicated method of Car instead of Radio
		
		System.out.println("Radio station default: " + lexus.getRadio().getSelectedStation()); // show selected station - default [0]
		System.out.println("Radio station direcly: " + lexus.getCurrentStation()); // SAME, show selected station, but use a dedicated method of Car instead of Radio
		lexus.getRadio().printSelectedStationInfo(); // this is a print method, so you don't need to wrap it with syso() - it prints (to string) the array cell info of the station that is currently selected
		// the above is a method of CarRadio, but we can also make it from Car class
		// the below is a method of Car taking info from CarRadio that gets it from CarRadioStation
		System.out.println("Name of selected station is: " + lexus.getCurrentStationName());
		System.out.println("\n----------------");
		
		lexus.getRadio().setOn(true); // set radio on
		System.out.println("Radio state after ON: " + lexus.getRadio().isOn()); // validate on..
		// SAME as above, show radio state, but use a dedicated method of Car instead of take the data from Radio method
		System.out.println("Radio state while ON => Use Direcly: " + lexus.getCurrentStation());

		lexus.changeStation(3); //  try to change when radio is on (succeeds)
		System.out.println("Radio state while ON & after Change: " + lexus.getRadio().getSelectedStation());
		System.out.println("Radio state while ON => Use Direcly: " + lexus.getCurrentStation()); // same as above but taken from Car instead of Radio
		
		// NOTE that you see Station in array & because first station is array[0] you need a mechanism to straight it
		lexus.getRadio().printSelectedStationInfo(); // so Station[3] is #4 in Array that starts in 0
		// change to [0] first station
		lexus.changeStation(0);
		System.out.println("\n => change station to array cell #0 (first station in radio) ==> 88FM");
		System.out.println("after Change: " + lexus.getCurrentStation());
		lexus.getRadio().printSelectedStationInfo();
		// change to [5] last station
		lexus.changeStation(5);
		System.out.println("\n => change station to array cell #5 (last station in radio) ==> ECO");
		System.out.println("after Change: " + lexus.getCurrentStation());
		// note the diff:
		lexus.getRadio().printSelectedStationInfo(); // this is a print method, so you don't need to wrap it with syso() - it prints (to string) the array cell info of the station that is currently selected
		// the above is a method of CarRadio, but we can also make it from Car class
		// the below is a method of Car taking info from CarRadio that gets it from CarRadioStation
		System.out.println("Name of CURENTLY selected station is: " + lexus.getCurrentStationName());
		//------------------------------------------
		
		System.out.println("\n----------------");
		System.out.println("printWheelsInfo:");			
		//System.out.println("Wheels: " + wheels + "\n"); // NOTE: wheels[] is per CAR-instance & will have memory indicators => to fix you should make a method for getting data from this array
		System.out.println("Wheels - spare info: " + lexus.getWheels()[0].toString()); // this gets all the data in the wheels array cell [0] using the method in CarWheels class !
		System.out.println("Wheel airPressure of spare [0]: " + lexus.getWheels()[0].getAirPressure() + "\n"); // this gets the data in array array cell [0] !
		
		System.out.println("\n----------------");
		System.out.println(" => Before wheelPuncture:");
		lexus.printWheelsInfo(); // first is the spare one
		// -----------------------------------------------
		System.out.println(" => having wheelPuncture:");
		System.out.println("wheelPuncture: see spare was switched with the 2ed wheel that got flat");
		lexus.wheelPuncture(2); // puncture in wheel 2 => use the dedicated method
		lexus.printWheelsInfo(); // print new info after puncture using a direct method of Car (instead of Wheel)...
	}
	// end of class -------------
}

/** from another solution:
	public static void main(String[] args) {
		
		int selectedStation;
		int userSelection = 0;
		int flatTire = 0;
		String actionMessage = "\nPlease select what you want to do\nEnter 1 - Turn radio on\nEnter 2 - Change Station\nEnter 3 - Get current station name\nEnter 4 - Check Radio Status"
				+ "\nEnter 5 - Turn Radio off!!\nEnter 6 - Check tires status\nEnter 7 - Simulate flat tire\nAny Other option will exit the system!";
		
		Scanner scan = new Scanner(System.in);
		Automobile myCar = new Automobile("Toyota", 2011);
		
		System.out.println("You are currently Driving a:\n");
		myCar.printData();
		myCar.printHp();
		myCar.getRadioState();
		
		System.out.println(actionMessage);
		
		userSelection = scan.nextInt();
		while (userSelection <= 7 && userSelection >= 1){
			switch (userSelection){
			case 1:
				myCar.turnRadioOn();
				System.out.println("Radio Turned ON!");
				break;
			case 2:
				if (myCar.isRadioOn()){
					System.out.println("Enter station number between 0-4: ");
					selectedStation = scan.nextInt();
					myCar.changeRadioStation(selectedStation);
					myCar.getStationName();
					}
				else
					myCar.getRadioState();
				break;
			case 3:
				myCar.getStationName();
				break;
			case 4:
				myCar.getRadioState();
				break;
			case 5:
				myCar.turnRadioOff();
				myCar.getRadioState();
				break;
			case 6:
				myCar.printTireStatus();
				break;
			case 7:
				System.out.println("Which tire is flat? Please enter numbers 1-4");
				flatTire = scan.nextInt();
				myCar.simulateFlatTire(flatTire);
				break;
			}
			System.out.println(actionMessage);
			userSelection = scan.nextInt();
		}
		System.out.println("Goodbye!!");
		scan.close();
//		System.out.println("Please select a Radio Station: Enter values between 0-4");
//		
//		myCar.changeRadioStation(scan.nextInt());
//		
//		System.out.println("Would you like to turn the radio on?\n\nEnter 1 to turn on OR 2 to leave off:");
//		turnOn = scan.nextInt();
//		while (turnOn != 1){
//			System.out.println("Radio still turned off");
//			turnOn = scan.nextInt();
//		}
//		myCar.turnRadioOn();
//		System.out.println("Radio Turned ON!");
//		myCar.getStationName();
		
		}
 */