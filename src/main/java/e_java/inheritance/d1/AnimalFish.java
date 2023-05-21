package e_java.inheritance.d1;

public class AnimalFish extends Animal {
	@Override
	public void whatDoYouBreath() {
		System.out.println("I breath the oxigen in water");
	}
	@Override
	public void whoAreYou() {
		System.out.println("I'm: Animal Fish");
	}
	@Override
	public String howManyLegsYouhGot() {
		return "I got NO Legs, I got Fins";
	}
}
