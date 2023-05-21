package tempApp;

public class Params {

	public static void main(String[] args) { // the args will be the Params sent into by Run command...
		// App gets Parameters (via Run) & Print - if send args="El- Ad!" -> args[0]=El- & args[1]=Ad!)
		System.out.println("Your given Param arg was: " + args[0] + " " + args[1]);
		
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
mvn exec:java -Dexec.mainClass="tempApp.Params" -Dexec.args="El- Ad!"
*/
