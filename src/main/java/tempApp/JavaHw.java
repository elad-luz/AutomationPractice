package tempApp;
/**
 * Basic Java: Hello world !
 */
public class JavaHw {

	public static void main(String[] args) {
		// The app will Print: Hello World !
		System.out.println("Hello World !");

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
mvn exec:java -Dexec.mainClass="tempApp.JavaHw"
*/
