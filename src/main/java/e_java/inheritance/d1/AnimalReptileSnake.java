package e_java.inheritance.d1;

public class AnimalReptileSnake extends AnimalReptile {
	@Override
	public void whoAreYou() {
		System.out.println("I'm: Animal Reptile Snake");
	}
	@Override
	public String howManyLegsYouhGot() {
		return "I got NO Legs";
	}
}
