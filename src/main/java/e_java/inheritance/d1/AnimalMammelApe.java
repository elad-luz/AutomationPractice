package e_java.inheritance.d1;

public class AnimalMammelApe extends AnimalMammel {
	@Override
	public void whoAreYou() {
		System.out.println("I'm: Animal Mammel Ape");
	}
	@Override
	public String howManyLegsYouhGot() {
		return "I got 2 Legs";
	}
}
