package e_java.inheritance.d1;

public class AnimalMammelDolphin extends AnimalMammel {
	@Override
	public void whatDoYouBreath() {
		System.out.print("although I live in water ==> ");
		super.whatDoYouBreath();
	}
	@Override
	public void whoAreYou() {
		System.out.println("I'm: Animal Mammel Dolphin");
	}
	@Override
	public String howManyLegsYouhGot() {
		return "I got No Legs, its hard to explain...";
	}
}
