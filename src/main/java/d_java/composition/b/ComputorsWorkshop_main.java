package d_java.composition.b;

public class ComputorsWorkshop_main {

	public static void main(String[] args) {
		
		/** OUR Computer Workshop is made of:
		 * Computer objects - but each Computer is also composing a predefined objects of hardDisk & CPU.
		 * So to make a Computer you first need to have a hardDisk & CPU.
		 */
		// instances -> Note that if you start with a computer you will be informed you lack cpu & hardDisk
		ComputerCPU cpu1 = new ComputerCPU("Intel", 3.6, 4); // Object name = new Constructor(inputs) => Declare & initialize: Constructing CPU
		System.out.println("cpu1.toString() is: " + cpu1.toString());
		System.out.println(" => get the Speed of cpu1: " + cpu1.getSpeed()); // possible because there's a getter (reached it directly)
	
		ComputorHardDisk hd1 = new ComputorHardDisk("Corsair", true, 512); // Constructing HardDisk
		System.out.println("hd1.toString() is: " + hd1.toString());
		System.out.println(" => get the Size of hd1: " + hd1.getSize()); // possible because there's a getter (reached it directly)
		
		Computer comp1 = new Computer("Dell", 2020, "black", 3000, hd1, cpu1);
		System.out.println("comp1.toString() is: " + comp1.toString());
		System.out.println(" => get the Color of comp1: " + comp1.getColor()); // possible because there's a getter (reached it directly)
		System.out.println("\n => IS comp1 turned ON by default: " + comp1.isTurnedON()); // by default it should be 'false' !
		comp1.setTurnedON(true); // set comp1 as ON via setter
		System.out.println("IS comp1 turned ON after set ON  : " + comp1.isTurnedON()); // after turn on, it should be 'true' !
		comp1.stop(); // set comp1 as OFF via wrapping method 'stop'
		System.out.println("IS comp1 turned ON after 'stop'  : " + comp1.isTurnedON()); // after turn off, it should be 'false'
		comp1.start(); // set comp1 as OFF via wrapping method 'start'
		System.out.println("IS comp1 turned ON after 'start' : " + comp1.isTurnedON()); // after turn on, it should be 'true' !

		System.out.println(System.lineSeparator());
		// ----------------------------------------
		
		// some operations are possible, others NOT (because we havn't allowed them!!!
		System.out.println("get the Speed of cpu of comp1: " + comp1.getCpu().getSpeed()); // this is possible because there is a getter
		comp1.getCpu().setSpeed(4.8); // from a computer instance you get the cpu, then you change it to new value at cpu level => class
		System.out.println("get NEW Speed of cpu of comp1: " + comp1.getCpu().getSpeed()); // this is possible because there is a getter
		
		System.out.println("get the Model of cpu of comp1: " + comp1.getCpu().getModel()); // this is possible because there is a getter
		// comp1.getCpu().setModel("AMD"); // setter of Model in CPU class was commented out, this is NOT possible post construction !!!

	}
	// end of class -------------
}
