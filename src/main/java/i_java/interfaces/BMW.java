package i_java.interfaces;

public class BMW extends Automobile implements LicenseInterface {
	@Override // this comes from parent
	public String whoAmI() {
		return "I'm a BMW car";
	}
	@Override // this comes from interface - personal implementation
	public void renewLicense() {
		System.out.println("CAR License...");
	}
}
