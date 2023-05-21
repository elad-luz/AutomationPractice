package e_java.inheritance.d1;

public class AnimalReptileLizard extends AnimalReptile {
	@Override
	public void whoAreYou() {
		System.out.println("I'm: Animal Reptile Lizard");
	}
	@Override
	public String howManyLegsYouhGot() {
		return "I got 4 Legs";
	}
}
