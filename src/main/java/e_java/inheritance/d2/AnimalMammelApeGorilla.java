package e_java.inheritance.d2;

public class AnimalMammelApeGorilla extends AnimalMammelApe {

	boolean isCliming;

	public AnimalMammelApeGorilla(boolean breath, boolean move, boolean hotblood, boolean isHairy, int iLegs, boolean isCliming) {
		super(breath, move, hotblood, isHairy, iLegs);
		this.isCliming = isCliming;
	}

	public boolean isCliming() {
		return true;
	}

	public void setCliming(boolean isCliming) {
		this.isCliming = isCliming;
	}
}
