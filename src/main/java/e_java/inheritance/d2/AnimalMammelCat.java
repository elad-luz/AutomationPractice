package e_java.inheritance.d2;

public class AnimalMammelCat extends AnimalMammel {

	boolean isHairy;
	boolean isLikeHuman;
	int iLegs;


	public AnimalMammelCat(boolean breath, boolean move, boolean hotblood, boolean isHairy, int iLegs, boolean isLikeHuman) {
		super(breath, move, hotblood);
		this.isHairy = isHairy;
		this.iLegs = iLegs;
		this.isLikeHuman = isLikeHuman;
	}

	public int getiLegs() {
		return 4;
	}
	public void setiLegs(int iLegs) {
		this.iLegs = iLegs;
	}

	public boolean isLikeHuman() {
		return true;
	}

	public void SetisLikeHuman(boolean isLikeHuman) {
		this.isLikeHuman = true;
	}
}
