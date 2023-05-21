package e_java.inheritance.d2;

public class AnimalReptileSnake extends AnimalReptile {

	boolean bHaveLegs;

	public AnimalReptileSnake(boolean breath, boolean move, boolean hotblood, boolean bHaveLegs) {
		super(breath, move, hotblood);
		this.bHaveLegs = bHaveLegs;
	}

	public boolean isbHaveLegs() {
		return false;
	}

	public void setbHaveLegs(boolean bHaveLegs) {
		this.bHaveLegs = bHaveLegs;
	}
}
