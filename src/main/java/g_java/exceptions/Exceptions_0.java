package g_java.exceptions;

public class Exceptions_0 {

	public static void main(String[] args) {
		System.out.println("Exceptions 0:\n=============\n");

		System.out.println("1) ... 5 sec Sleep");
		// section 1 working with Sleep:
		// working with sleep (tells the program thread to stop for X milliseconds & resume)
		// class knows that there can be a common problem during run
		// so as a pre-condition, you are asked to handle this issue prior to run - so in case it happens the code will not crash!
		
		try {
			Thread.sleep(5000); // This is the java method I want to use (to make my code stop for 5 seconds) => I'm instructed to wrap it with try-catch
		} catch (InterruptedException e) { // needs import of class
			e.printStackTrace();
		}
		System.out.println("end of section 1");

		System.out.println(System.lineSeparator());
		// ----------------------------------------

		System.out.println("2) ... 5 sec Sleep");
		// section 2 working with a Method I call which is using Sleep with throw (below):

		try {
			goToSleep1(); // upon try to use this method (see below) I am told to wrap it with try-catch because of the throw
		} catch (InterruptedException e) {
			e.printStackTrace();
		}
		System.out.println("end of section 2");

		System.out.println(System.lineSeparator());
		// ----------------------------------------

		System.out.println("3) ... 5 sec Sleep");
		// section 3 working with a Method I call which is using Sleep without throw (try-catch handled by method - see below):

		goToSleep2(); // upon use this method (see below) I don't need to wrap it with try-catch because it was already handled

		// =================================
		System.out.println("\n--- end ---");
	}  // end of main
	/** METHODS (out-side of 'main'): */
	// with throw - pass the handle to whoever use it
	public static void goToSleep1() throws InterruptedException { // this is the method that just add Sleep & have throws of Exception needed to be handled by user of method
		Thread.sleep(5000); // instead of wrapping the Sleep with try-catch, I can choose to tell whoever use it - he should handle this ^ see above
	}
	// without throw - handle exception within class
	public static void goToSleep2() { // this is the method that just add Sleep without throws (so user of method don't need to handle anything
		try {
			Thread.sleep(5000);
		} catch (InterruptedException e) {
			e.printStackTrace();
		} // wrapping the Sleep with try-catch, so whoever use it - should not handle this
	}
}
