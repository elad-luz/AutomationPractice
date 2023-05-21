package e_java.inheritance.d1;

public class AnimalMammelCat extends AnimalMammel {
	@Override
	public void whoAreYou() {
		System.out.println("I'm: Animal Mammel Cat");
	}
	@Override
	public String howManyLegsYouhGot() {
		return "I got 4 Legs";
	}
}
