package e_java.inheritance.d2;

public class AnimalMammelCatDomestic extends AnimalMammelCat {

	boolean isLiveInHomes;

	public AnimalMammelCatDomestic(boolean breath, boolean move, boolean hotblood, boolean isHairy, int iLegs, boolean isLikeHuman,
			boolean isLiveInHomes) {
		super(breath, move, hotblood, isHairy, iLegs, isLikeHuman);
		this.isLiveInHomes = isLiveInHomes;
	}

	public boolean isLiveInHomes() {
		return true;
	}

	public void setLiveInHomes(boolean isLiveInHomes) {
		this.isLiveInHomes = isLiveInHomes;
	}
}
