package d_java.composition.c;

public class OurGoat_main {
	// יש לנו תיש לתיש יש זקן וגם 4 רגליים וגם זקן קטן
	
	public static void main(String[] args) {
		// GoatBeard
		GoatBeard beard1 = new GoatBeard(true, 10, "white");
		// GoatLegs array
		GoatLeg legs1[] = new GoatLeg[] {new GoatLeg(50,true,true,"black"), new GoatLeg(40,true,false,"white"), new GoatLeg(50,false,true,"black"), new GoatLeg(50,false,false,"black")};
		/** Another way to do it:
		   GoatLeg[] legs1 = new GoatLeg[4];
		   legs1[0] = new GoatLeg(50, true, true, "black");
		   legs1[1] = new GoatLeg(50, true, false, "white");
		   legs1[2] = new GoatLeg(50, false, true, "black");
		   legs1[3] = new GoatLeg(50, false, false, "black");
		 */
		// GoatTail 
		GoatTail tail1 = new GoatTail("white", true);
		// BillyGoat... composed with 3 objects: beard1, legs1, tail1
		Goat goat1 = new Goat(true, beard1, legs1, tail1, "white", "billy", 10);

		// All info
		System.out.println(goat1.toString());
		// More
		System.out.println("Goat color: "+ goat1.getColor());
		System.out.println("Beard Color: " + goat1.getBeard().getColor());
		
		for (int i = 0; i < legs1.length-1; i++) {
			if (legs1[i].getLength() != legs1[i+1].getLength()) {
				System.out.println("limping");
				break;
			}
		}
		for (int i = 0; i < legs1.length-1; i++) {
			if (legs1[i].getColor() == legs1[i+1].getColor()) {
				System.out.println("legs not the same colors");
			}
		}
	}
	// end of class -------------
}
