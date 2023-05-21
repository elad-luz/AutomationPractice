package i_java.interfaces;

public class Dog extends Animal implements LicenseInterface {
	@Override // this comes from parent
	public String whoAmI() {
		return "I'm a Dog";
	}
	@Override // this comes from interface - personal implementation
	public void renewLicense() {
		System.out.println("Dog License...");
	}
}
