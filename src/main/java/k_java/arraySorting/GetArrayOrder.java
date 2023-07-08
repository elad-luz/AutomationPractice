package k_java.arraySorting;

public class GetArrayOrder {
	//	Basic Java class print Hello world !
	public static void main(String[] args) {
		System.out.println("Hello World !");
		//----------------------------------
		
		String[] arrayAsc = {"apple", "banana", "cherry", "date"};
		String orderTypeA = getOrderType(arrayAsc);
		
		String[] arrayDes = {"date", "cherry", "banana", "apple"};
		String orderTypeB = getOrderType(arrayDes);
		
		String[] arrayNot = {"banana", "date", "apple", "cherry"};
		String orderTypeC = getOrderType(arrayNot);
		
		System.out.println("Arrays ordering types: " + orderTypeA +", "+ orderTypeB +", " + orderTypeC );
		
		//----------------------------------
		System.out.println("\n--- end ---");
	}
	
	public static String getOrderType(String[] array) {
		    boolean isAsc = true;
		    boolean isDesc = true;

		    // Check if array is in ascending order
		    for (int i = 1; i < array.length; i++) {
		        if (array[i].compareTo(array[i - 1]) < 0) {
		            isAsc = false;
		            break;
		        }
		    }

		    // Check if array is in descending order
		    for (int i = 1; i < array.length; i++) {
		        if (array[i].compareTo(array[i - 1]) > 0) {
		            isDesc = false;
		            break;
		        }
		    }

		    if (isAsc) {
		        return "Ascending";
		    } else if (isDesc) {
		        return "Descending";
		    } else {
		        return "Not sorted";
		    }
		}
}
/**
 * Notes: RUN via MVN from Project folder -> in this case <project> is:
 * 'TestAutomationSauceDemo': Open CMD (C:\Windows\System32\cmd.exe) at Project
 * root (C:\Users\USER\eclipse-workspace\<project>) issue command: mvn exec:java
 * -Dexec.mainClass="tempTBD.TestingQuickly"
 */