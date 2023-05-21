package tempApp;

import java.util.Scanner;

public class MyApp {

	public static void main(String[] args) {
		// App will get from scanner your input & Print it
		Scanner scanner = new Scanner(System.in);
		System.out.println("Type the input & Enter...");
		String a = scanner.nextLine();
		System.out.println("You typed-in: " + a);
		scanner.close();
		
		System.out.println("\n--- end ---");
	}
}
/// ~~~	END ~~~ ||||||||||||||||||||||||||||||||||||||||||||||||||||||||||||||||||||||||||||||||||||||||||||||||||||||||||||||||||||||||
/**~~~~~~~~~~~~
	Notes ->
~~~~~~~~~~~~~~~
RUN via MVN from Project folder -> in this case <project> is: 'AutomationPractice':
Open CMD (C:\Windows\System32\cmd.exe) at Project root (C:\Users\USER\eclipse-workspace\<project>)
issue command:
mvn exec:java -Dexec.mainClass="tempApp.MyApp"
*/
